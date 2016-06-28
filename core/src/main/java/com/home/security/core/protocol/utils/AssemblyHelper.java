package com.home.security.core.protocol.utils;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.comm.assembly.*;
import com.home.security.core.protocol.annotation.ServiceMethod;
import com.home.security.core.protocol.annotation.ServiceMethodParam;
import com.home.security.core.protocol.exception.AssemblyParseException;
import com.home.security.core.protocol.message.Param;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import com.home.security.core.service.ServiceStub;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static com.home.security.core.protocol.utils.MessageHelper.*;

/**
 * Created by john on 2014-12-12.
 */
public class AssemblyHelper {

    private final static Logger logger = LogManager.getLogger(AssemblyHelper.class.getName());

    public static Assembly parseAssembly(CommunicationManager communicationManager, InputStream xmlStream) throws IOException, SAXException, ParserConfigurationException, AssemblyParseException, TransformerException {
        Document document = readXml(xmlStream);

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream schemaStream = classloader.getResourceAsStream("schema/assembly.xsd");
//        validateXML(schemaStream, document);

        ServiceId serviceId = new ServiceId(getAssemblyId(document));
        String name = getAssemblyName(document);
        String version = getAssemblyVersion(document);

        HashMap<Service, ArrayList<Service>> serviceAlternativeMap = getServices(document);
        HashMap<UUID, ArrayList<Service>> serviceAlternatives = new HashMap<UUID, ArrayList<Service>>();
        ArrayList<Service> serviceList = new ArrayList<Service>();
        for (Service service : serviceAlternativeMap.keySet()) {
            serviceAlternatives.put(service.getServiceId().id, serviceAlternativeMap.get(service));
            serviceList.add(service);
        }

        Node node = document.getDocumentElement();

        print(document);

        Init init = parseInit(serviceList, findNode(node, "init"));
        ArrayList<Trigger> triggerList = parseTriggers(serviceList, findNode(node, "triggers"));
        ArrayList<Repeat> repeatList = parseRepeats(serviceList, findNode(node, "repeats"));

        return new Assembly(version, name, communicationManager, serviceId, serviceList, init, triggerList, repeatList, serviceAlternatives);
    }

    private static Init parseInit(ArrayList<Service> services, Node initNode) throws AssemblyParseException {
        if (initNode == null) {
            return null;
        }
        ArrayList<AssemblyAction> assemblyActions = new ArrayList<AssemblyAction>();
        NodeList sendNodes = initNode.getChildNodes();
        for (int i = 0; i < sendNodes.getLength(); i++) {
            Node sendNode = sendNodes.item(i);
            if (!sendNode.getNodeName().equals("send")) {
                continue;
            }
            assemblyActions.add(parseAssemblyAction(services, sendNode));
        }
        return new Init(assemblyActions.toArray(new AssemblyAction[assemblyActions.size()]));
    }

    private static AssemblyAction parseAssemblyAction(ArrayList<Service> services, Node sendNode) throws AssemblyParseException {
        String serviceIdStr = getAttributeValue(sendNode, AssemblyAction.ATTRIBUTE_SERVICE_ID);
        String requestName = getAttributeValue(sendNode, AssemblyAction.ATTRIBUTE_REQUEST_NAME);
        ArrayList<Param> paramList = parseParams(findNode(sendNode, "params"));
        Service service = findService(services, serviceIdStr);
        if (service == null) {
            throw new AssemblyParseException("Could not find service with id: " + serviceIdStr);
        }
        return new AssemblyAction(service, requestName, paramList == null ? null : paramList.toArray(new Param[paramList.size()]));
    }

    private static Service findService(ArrayList<Service> services, String serviceIdStr) {
        for (Service service : services) {
            if (service.getServiceId().id.toString().equals(serviceIdStr)) {
                return service;
            }
        }
        return null;
    }

    private static ArrayList<Repeat> parseRepeats(ArrayList<Service> services, Node repeatsNode) throws AssemblyParseException {
        if (repeatsNode == null) {
            return null;
        }
        ArrayList<Repeat> repeatList = new ArrayList<Repeat>();
        NodeList repeatNodes = repeatsNode.getChildNodes();
        for (int i = 0; i < repeatNodes.getLength(); i++) {
            Node repeatNode = repeatNodes.item(i);
            if (!repeatNode.getNodeName().equals("repeat")) {
                continue;
            }
            String intervalStr = getAttributeValue(repeatNode, Repeat.ATTRIBUTE_INTERVAL);
            Node sendNode = findNode(repeatNode, "send");
            AssemblyAction assemblyAction = parseAssemblyAction(services, sendNode);
            Repeat repeat = new Repeat(Long.parseLong(intervalStr), assemblyAction);
            repeatList.add(repeat);
        }
        return repeatList;
    }

    private static ArrayList<Trigger> parseTriggers(ArrayList<Service> services, Node triggersNode) throws AssemblyParseException {
        if (triggersNode == null) {
            return null;
        }
        ArrayList<Trigger> triggerList = new ArrayList<Trigger>();
        NodeList triggerNodes = triggersNode.getChildNodes();
        for (int i = 0; i < triggerNodes.getLength(); i++) {
            Node triggerNode = triggerNodes.item(i);
            if (!triggerNode.getNodeName().equals("trigger")) {
                continue;
            }
            String triggerServiceId = getAttributeValue(triggerNode, Trigger.ATTRIBUTE_SERVICE_ID);
            String triggerRequestName = getAttributeValue(triggerNode, Trigger.ATTRIBUTE_REQUEST_NAME);
            Service triggerService = findService(services, triggerServiceId);
            if (triggerService == null) {
                throw new AssemblyParseException("Could not find service with id: " + triggerServiceId);
            }
            ArrayList<AssemblyAction> targetActionList = new ArrayList<AssemblyAction>();

            NodeList sendNodes = triggerNode.getChildNodes();
            for (int j = 0; j < sendNodes.getLength(); j++) {
                Node sendNode = sendNodes.item(j);
                if (!sendNode.getNodeName().equals("send")) {
                    continue;
                }
                String targetServiceId = getAttributeValue(sendNode, AssemblyAction.ATTRIBUTE_SERVICE_ID);
                Service targetService = findService(services, targetServiceId);
                if (triggerService == null) {
                    throw new AssemblyParseException("Could not find service with id: " + targetServiceId);
                }
                String targetRequestName = getAttributeValue(sendNode, AssemblyAction.ATTRIBUTE_REQUEST_NAME);
                Node triggerParamsNode = findNode(sendNode, "triggerParams");
                ArrayList<Param> paramList = null;
                if (triggerParamsNode != null) {
                    paramList = new ArrayList<Param>();
                    NodeList paramNodes = triggerParamsNode.getChildNodes();
                    for (int k = 0; k < paramNodes.getLength(); k++) {
                        Node paramNode = paramNodes.item(k);
                        if (paramNode.getNodeName().equals("param")) {
                            Param param = parseParam(paramNode);
                            paramList.add(param);
                        } else if (paramNode.getNodeName().equals("triggerParam")) {
                            String name = getAttributeValue(paramNode, TriggerParam.ATTRIBUTE_NAME);
                            String paramRefName = getAttributeValue(paramNode, TriggerParam.ATTRIBUTE_PARAM_REF_NAME);
                            TriggerParam param = new TriggerParam(name, paramRefName);
                            paramList.add(param);
                        }
                    }
                }

                AssemblyAction targetAction = new AssemblyAction(targetService, targetRequestName, paramList == null ? null : paramList.toArray(new Param[paramList.size()]));
                targetActionList.add(targetAction);
            }
            Trigger trigger = new Trigger(triggerService, triggerRequestName, targetActionList.toArray(new AssemblyAction[targetActionList.size()]));
            triggerList.add(trigger);
        }
        return triggerList;
    }

    private static HashMap<Service, ArrayList<Service>> getServices(Document document) throws AssemblyParseException {
        HashMap<Service, ArrayList<Service>> servicesAndAlternatives = new HashMap<Service, ArrayList<Service>>();
        Node servicesNode = findNode(document, "services");
        NodeList serviceNodeList = servicesNode.getChildNodes();
        for (int i = 0; i < serviceNodeList.getLength(); i++) {
            Node serviceNode = serviceNodeList.item(i);
            if (serviceNode.getNodeName().equals("service")) {
                ArrayList<Service> alternativeList = new ArrayList<Service>();
                Service service;
                try {
                    service = parseService(serviceNode);
                    Node alternativeServicesNode = findNode(serviceNode, "alternatives");
                    if (alternativeServicesNode != null) {
                        NodeList alternativeServiceNodeList = alternativeServicesNode.getChildNodes();
                        for (int j = 0; j < alternativeServiceNodeList.getLength(); j++) {
                            Node alternativeServiceNode = alternativeServiceNodeList.item(j);
                            if (alternativeServiceNode.getNodeName().equals("service")) {
                                Service alterntive = parseService(alternativeServiceNode);
                                alternativeList.add(alterntive);
                            }
                        }
                    }
                    servicesAndAlternatives.put(service, alternativeList);
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return servicesAndAlternatives;
    }

    private static Service parseService(Node serviceNode) throws UnknownHostException {
        String name = getAttributeValue(serviceNode, Service.ATTRIBUTE_NAME);
        String version = getAttributeValue(serviceNode, Service.ATTRIBUTE_VERSION);
        String serviceIdStr = getAttributeValue(serviceNode, Service.ATTRIBUTE_SERVICE_ID);
        ServiceId serviceId = new ServiceId(UUID.fromString(serviceIdStr));
        String ipAddressStr = getAttributeValue(serviceNode, Service.ATTRIBUTE_IP_ADDRESS);
        InetAddress ipAddress = InetAddress.getByName(ipAddressStr);
        return new ServiceStub(serviceId, name, version, ipAddress);
    }


    public static UUID getAssemblyId(Node node) {
        String idStr = getAttributeValue(findNode(node, "assembly"), "id");
        return UUID.fromString(idStr);
    }

    public static String getAssemblyName(Node node) {
        return getAttributeValue(findNode(node, "assembly"), "name");
    }

    public static String getAssemblyVersion(Node node) {
        return getAttributeValue(findNode(node, "assembly"), "version");
    }

    public static String toXMLString(Assembly assembly) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document document = build.newDocument();
        Element assemblyNode = document.createElement("assembly");
        assemblyNode.setAttribute(Assembly.ATTRIBUTE_ID, assembly.getServiceId().id.toString());
        assemblyNode.setAttribute(Assembly.ATTRIBUTE_NAME, assembly.getName());
        assemblyNode.setAttribute(Assembly.ATTRIBUTE_VERSION, Assembly.VERSION);

        Element servicesNode = document.createElement("services");
        for (Service service : assembly.getServiceList()) {
            Element serviceNode = document.createElement("service");
            serviceNode.setAttribute(Service.ATTRIBUTE_NAME, service.getName());
            serviceNode.setAttribute(Service.ATTRIBUTE_SERVICE_ID, service.getServiceId().id.toString());
            serviceNode.setAttribute(Service.ATTRIBUTE_VERSION, service.getVersion());
            HashMap<UUID, ArrayList<Service>> serviceAlternativesMap = assembly.getServiceAlternatives();
            if (serviceAlternativesMap != null) {
                ArrayList<Service> alternativList = serviceAlternativesMap.get(service.getServiceId());
                if (alternativList != null && alternativList.size() > 0) {
                    Element alternativesNode = document.createElement("alternatives");
                    for (Service alternative : alternativList) {
                        Element alternativeNode = document.createElement("service");
                        alternativeNode.setAttribute(Service.ATTRIBUTE_NAME, alternative.getName());
                        alternativeNode.setAttribute(Service.ATTRIBUTE_SERVICE_ID, alternative.getServiceId().id.toString());
                        alternativeNode.setAttribute(Service.ATTRIBUTE_VERSION, alternative.getVersion());
                        alternativesNode.appendChild(alternativeNode);
                    }
                    serviceNode.appendChild(alternativesNode);
                }
            }
            servicesNode.appendChild(serviceNode);
        }
        assemblyNode.appendChild(servicesNode);

        Init init = assembly.getInit();
        if (init != null) {
            Element initNode = document.createElement("init");
            for (AssemblyAction assemblyAction : init.getInitActions()) {
                Element sendNode = document.createElement("send");
                sendNode.setAttribute(AssemblyAction.ATTRIBUTE_SERVICE_ID, assemblyAction.getService().getServiceId().id.toString());
                sendNode.setAttribute(AssemblyAction.ATTRIBUTE_REQUEST_NAME, assemblyAction.getRequestName());
                if (assemblyAction.getParams() != null) {
                    Element paramsNode = document.createElement("params");
                    for (Param param : assemblyAction.getParams()) {
                        Element paramNode = document.createElement("param");
                        paramNode.setAttribute(Param.ATTRIBUTE_NAME, param.getName());
                        paramNode.setAttribute(Param.ATTRIBUTE_TYPE, getParamAttributeType(param.getValue()));
                        Element valueNode = document.createElement("value");
                        valueNode.appendChild(document.createTextNode(getParamValueAsString(param.getValue())));
                        paramNode.appendChild(valueNode);
                        paramsNode.appendChild(paramNode);
                    }
                    sendNode.appendChild(paramsNode);
                }
                initNode.appendChild(sendNode);
            }
            assemblyNode.appendChild(initNode);
        }

        if (assembly.getTriggerList() != null) {
            Element triggersNode = document.createElement("triggers");
            for (Trigger trigger : assembly.getTriggerList()) {
                Element triggerNode = document.createElement("trigger");
                triggerNode.setAttribute(Trigger.ATTRIBUTE_SERVICE_ID, trigger.getTriggerService().getServiceId().id.toString());
                triggerNode.setAttribute(Trigger.ATTRIBUTE_REQUEST_NAME, trigger.getTriggerRequestName());
                for (AssemblyAction targetAction : trigger.getTargetActions()) {
                    Element sendNode = document.createElement("send");
                    sendNode.setAttribute(AssemblyAction.ATTRIBUTE_SERVICE_ID, targetAction.getService().getServiceId().id.toString());
                    sendNode.setAttribute(AssemblyAction.ATTRIBUTE_REQUEST_NAME, targetAction.getRequestName());
                    if (targetAction.getParams() != null) {
                        Element triggerParamsNode = document.createElement("triggerParams");
                        for (Param param : targetAction.getParams()) {
                            Element paramNode;
                            if (param instanceof TriggerParam) {
                                TriggerParam triggerParam = (TriggerParam) param;
                                paramNode = document.createElement("triggerParam");
                                paramNode.setAttribute(TriggerParam.ATTRIBUTE_NAME, triggerParam.getName());
                                paramNode.setAttribute(TriggerParam.ATTRIBUTE_PARAM_REF_NAME, triggerParam.getParamRefName());
                            } else {
                                paramNode = document.createElement("param");
                                paramNode.setAttribute(Param.ATTRIBUTE_NAME, param.getName());
                                paramNode.setAttribute(Param.ATTRIBUTE_TYPE, getParamAttributeType(param.getValue()));
                                Element valueNode = document.createElement("value");
                                valueNode.appendChild(document.createTextNode(getParamValueAsString(param.getValue())));
                                paramNode.appendChild(valueNode);
                            }
                            triggerParamsNode.appendChild(paramNode);
                        }
                        sendNode.appendChild(triggerParamsNode);
                    }
                    triggerNode.appendChild(sendNode);
                }
                triggersNode.appendChild(triggerNode);
            }
            assemblyNode.appendChild(triggersNode);
        }

        if (assembly.getRepeatList() != null) {
            Element repeatsNode = document.createElement("repeats");
            for (Repeat repeat : assembly.getRepeatList()) {
                Element repeatNode = document.createElement("repeat");
                repeatNode.setAttribute(Repeat.ATTRIBUTE_INTERVAL, String.valueOf(repeat.getInterval()));
                AssemblyAction assemblyAction = repeat.getTargetAction();
                Element sendNode = document.createElement("send");
                sendNode.setAttribute(AssemblyAction.ATTRIBUTE_SERVICE_ID, assemblyAction.getService().getServiceId().id.toString());
                sendNode.setAttribute(AssemblyAction.ATTRIBUTE_REQUEST_NAME, assemblyAction.getRequestName());
                if (assemblyAction.getParams() != null) {
                    Element paramsNode = document.createElement("params");
                    for (Param param : assemblyAction.getParams()) {
                        Element paramNode = document.createElement("param");
                        paramNode.setAttribute(Param.ATTRIBUTE_NAME, param.getName());
                        paramNode.setAttribute(Param.ATTRIBUTE_TYPE, getParamAttributeType(param.getValue()));
                        Element valueNode = document.createElement("value");
                        valueNode.appendChild(document.createTextNode(getParamValueAsString(param.getValue())));
                        paramNode.appendChild(valueNode);
                        paramsNode.appendChild(paramNode);
                    }
                    sendNode.appendChild(paramsNode);
                }
                repeatNode.appendChild(sendNode);
                repeatsNode.appendChild(repeatNode);
            }
            assemblyNode.appendChild(repeatsNode);
        }

        document.appendChild(assemblyNode);

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream schemaStream = classloader.getResourceAsStream("schema/assembly.xsd");
//        validateXML(schemaStream, document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 4);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();

        logger.trace(xmlString);

        return xmlString;
    }

    private static ArrayList<ServiceMethodContainer> getServiceMethods(AbstractService service) {
        ArrayList<ServiceMethodContainer> serviceMethodList = new ArrayList<ServiceMethodContainer>();
        Method[] methods = service.getClass().getDeclaredMethods();
        for (Method method : methods) {
            ServiceMethodContainer container = null;
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof ServiceMethod) {
                    container = new ServiceMethodContainer();
                    container.setMethod(method);
                    container.setServiceMethod((ServiceMethod) annotation);
                }
            }
            if (container == null) {
                continue;
            }
            ArrayList<ServiceMethodParamContainer> serviceMethodParamContainers = new ArrayList<ServiceMethodParamContainer>();
            Annotation[][] paramAnnotationMatrix = method.getParameterAnnotations();
            Class[] classes = method.getParameterTypes();
            for (int i = 0; i < paramAnnotationMatrix.length; i++) {
                Annotation[] paramAnnotations = paramAnnotationMatrix[i];
                for (Annotation annotation : paramAnnotations) {
                    if (annotation instanceof ServiceMethodParam) {
                        ServiceMethodParamContainer paramContainer = new ServiceMethodParamContainer();
                        paramContainer.setServiceMethodParam((ServiceMethodParam) annotation);
                        paramContainer.setParamClass(classes[i]);
                        serviceMethodParamContainers.add(paramContainer);
                        break;
                    }
                }
            }
            container.setServiceMethodParamContainers(serviceMethodParamContainers);
        }
        return serviceMethodList;
    }
}
