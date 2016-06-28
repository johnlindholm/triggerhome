package com.home.security.core.protocol.utils;

import com.home.security.core.protocol.annotation.ServiceMethod;
import com.home.security.core.protocol.annotation.ServiceMethodParam;
import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.exception.ServiceMethodAnnotationException;
import com.home.security.core.protocol.message.*;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import com.home.security.core.service.ServiceStub;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by john on 2014-11-23.
 */
public class MessageHelper {

    private final static Logger logger = LogManager.getLogger(MessageHelper.class.getName());

    public static String toXMLString(Message message) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = dFact.newDocumentBuilder();
        Document document = build.newDocument();
        Element messageNode = document.createElement("message");
        messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_ID, message.getMessageId().toString());
        messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DESTINATION_IP, message.getDestIp().getHostAddress());
        messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_SOURCE_IP, message.getSourceIp().getHostAddress());
        messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_VERSION, Message.VERSION);
        messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_SOURCE_SERVICE_ID, message.getSourceServiceId().id.toString());
        Element timestamp = document.createElement("timestamp");
        timestamp.appendChild(document.createTextNode(String.valueOf(message.getTimestamp())));
        messageNode.appendChild(timestamp);
        if (message instanceof Request) {
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID, message.getDestServiceId().id.toString());
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_TYPE, Message.TYPE_REQUEST);
            Request request = (Request) message;
            Element requestNode = document.createElement(Message.TYPE_REQUEST);
            requestNode.setAttribute(Request.ATTRIBUTE_REQUEST_NAME, request.getName());
            ArrayList<Param> paramList = request.getParamList();
            if (paramList != null && paramList.size() > 0) {
                Element paramsNode = document.createElement("params");
                for (Param param : paramList) {
                    Element paramNode = document.createElement("param");
                    paramNode.setAttribute(Param.ATTRIBUTE_NAME, param.getName());
                    paramNode.setAttribute(Param.ATTRIBUTE_TYPE, getParamAttributeType(param.getValue()));
                    Element valueNode = document.createElement("value");
                    valueNode.appendChild(document.createTextNode(getParamValueAsString(param.getValue())));

                    paramNode.appendChild(valueNode);
                    paramsNode.appendChild(paramNode);
                }
                requestNode.appendChild(paramsNode);
            }
            messageNode.appendChild(requestNode);
        } else if (message instanceof Response) {
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID, message.getDestServiceId().id.toString());
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_TYPE, Message.TYPE_RESPONSE);
            Response response = (Response) message;

            Element requestMessageId = document.createElement("requestMessageId");
            requestMessageId.appendChild(document.createTextNode(response.getRequestMessageId().toString()));
            messageNode.appendChild(requestMessageId);

            Element responseNode = document.createElement(Message.TYPE_RESPONSE);
            ArrayList<Param> paramList = response.getParamList();
            if (paramList != null && paramList.size() > 0) {
                Element paramsNode = document.createElement("params");
                for (Param param : paramList) {
                    Element paramNode = document.createElement("param");
                    paramNode.setAttribute(Param.ATTRIBUTE_NAME, param.getName());
                    paramNode.setAttribute(Param.ATTRIBUTE_TYPE, getParamAttributeType(param.getValue()));
                    Element valueNode = document.createElement("value");
                    valueNode.appendChild(document.createTextNode(getParamValueAsString(param.getValue())));
                    paramNode.appendChild(valueNode);
                    paramsNode.appendChild(paramNode);
                }
                responseNode.appendChild(paramsNode);
            }
            messageNode.appendChild(responseNode);
        } else if (message instanceof HeartAttack) {
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID, "");
            HeartAttack heartAttack = (HeartAttack) message;
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_TYPE, Message.TYPE_HEARTATTACK);
            Element servicesNode = document.createElement("services");
            for (Service service : heartAttack.getServices()) {
                Element serviceNode = document.createElement("service");
                serviceNode.setAttribute(Service.ATTRIBUTE_NAME, service.getName());
                serviceNode.setAttribute(Service.ATTRIBUTE_IP_ADDRESS, service.getIpAddress().getHostAddress());
                serviceNode.setAttribute(Service.ATTRIBUTE_SERVICE_ID, service.getServiceId().id.toString());
                serviceNode.setAttribute(Service.ATTRIBUTE_VERSION, service.getVersion());
                servicesNode.appendChild(serviceNode);
            }
            messageNode.appendChild(servicesNode);
        } else if (message instanceof HeartBeat) {
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID, "");
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_TYPE, Message.TYPE_HEARTBEAT);
            HeartBeat heartBeat = (HeartBeat) message;
            Element servicesNode = document.createElement("services");
            for (Service service : heartBeat.getServices()) {
                Element serviceNode = document.createElement("service");
                serviceNode.setAttribute(Service.ATTRIBUTE_NAME, service.getName());
                serviceNode.setAttribute(Service.ATTRIBUTE_IP_ADDRESS, service.getIpAddress().getHostAddress());
                serviceNode.setAttribute(Service.ATTRIBUTE_SERVICE_ID, service.getServiceId().id.toString());
                serviceNode.setAttribute(Service.ATTRIBUTE_VERSION, service.getVersion());
                servicesNode.appendChild(serviceNode);
            }
            messageNode.appendChild(servicesNode);
        } else if (message instanceof Ping) {
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID, message.getDestServiceId().id.toString());
            messageNode.setAttribute(Message.ATTRIBUTE_MESSAGE_TYPE, Message.TYPE_PING);
        }
        document.appendChild(messageNode);

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream schemaStream = classloader.getResourceAsStream("schema/message.xsd");
//        validateXML(schemaStream, document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 4);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(document);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();
        return xmlString;
    }

    public static Message parseMessage(InputStream xmlStream) throws IOException, SAXException, ParserConfigurationException, MessageParseException, TransformerException, PropertyException {
        return parseMessage(xmlStream, null);
    }

    public static Message parseMessage(InputStream xmlStream, String printTitle) throws IOException, SAXException, ParserConfigurationException, MessageParseException, TransformerException, PropertyException {
        Document document = readXml(xmlStream);

//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream schemaStream = classloader.getResourceAsStream("schema/message.xsd");
//        validateXML(schemaStream, document);

        InetAddress sourceIp = getSourceIp(document);
        InetAddress destIp = getDestIp(document);
        ServiceId sourceServiceId = getSourceServiceId(document);
        UUID messageId = getMessageId(document);

        Node node = document.getDocumentElement();

        if (printTitle != null) {
            logger.trace(printTitle);
            print(document);
        }

        if (!node.getNodeName().equals("message")) {
            throw new MessageParseException("Not a message xml!, nodeName: " + node.getNodeName());
        }
        String messageType = getMessageType(node);
        long timestamp = getMessageTimestamp(node);
        if (messageType.equals(Message.TYPE_HEARTBEAT)) {
            //ServiceId for DiscoveryManagerService is created using local ip, ie destIp
            ServiceId destServiceId = new ServiceId(UUID.nameUUIDFromBytes(destIp.getAddress()));
            Service[] services = parseHeartServices(node);
            return new HeartBeat(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, services);
        } else if (messageType.equals(Message.TYPE_HEARTATTACK)) {
            //ServiceId for DiscoveryManagerService is created using local ip, ie destIp
            ServiceId destServiceId = new ServiceId(UUID.nameUUIDFromBytes(destIp.getAddress()));
            Service[] services = parseHeartServices(node);
            return new HeartAttack(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, services);
        } else if (messageType.equals(Message.TYPE_REQUEST)) {
            ServiceId destServiceId = getDestServiceId(document);
            Node requestNode = findNode(node, Message.TYPE_REQUEST);
            String requestName = getAttributeValue(requestNode, Request.ATTRIBUTE_REQUEST_NAME);
            ArrayList<Param> paramList = parseParams(document);
            return new Request(messageId, timestamp, requestName, sourceIp, sourceServiceId, destIp, destServiceId, paramList == null ? null : paramList.toArray(new Param[paramList.size()]));
        } else if (messageType.equals(Message.TYPE_RESPONSE)) {
            ServiceId destServiceId = getDestServiceId(document);
            ArrayList<Param> paramList = parseParams(document);
            UUID requestMessageId = getRequestMessageId(node);
            return new Response(messageId, requestMessageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, paramList == null ? null : paramList.toArray(new Param[paramList.size()]));
        } else if (messageType.equals(Message.TYPE_PING)) {
            ServiceId destServiceId = getDestServiceId(document);
            return new Ping(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
        }
        return null;
    }

    private static Service[] parseHeartServices(Node node) throws UnknownHostException {
        Node servicesNode = findNode(node, "services");
        NodeList nodeList = servicesNode.getChildNodes();
        ArrayList<Service> services = new ArrayList<Service>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node serviceNode = nodeList.item(i);
            if (serviceNode.getNodeName().equals("service")) {
                String name = getAttributeValue(serviceNode, Service.ATTRIBUTE_NAME);
                String version = getAttributeValue(serviceNode, Service.ATTRIBUTE_VERSION);
                String serviceIdStr = getAttributeValue(serviceNode, Service.ATTRIBUTE_SERVICE_ID);
                ServiceId serviceId = new ServiceId(UUID.fromString(serviceIdStr));
                String ipAddressStr = getAttributeValue(serviceNode, Service.ATTRIBUTE_IP_ADDRESS);
                InetAddress ipAddress = InetAddress.getByName(ipAddressStr);
                ServiceStub service = new ServiceStub(serviceId, name, version, ipAddress);
                services.add(service);
            }
        }
        return services.toArray(new Service[services.size()]);
    }

    public static String getParamValueAsString(Object value) {
        if (value instanceof Integer) {
            return Integer.toString((Integer) value);
        } else if (value instanceof Double) {
            return Double.toString((Double) value);
        } else if (value instanceof Long) {
            return Long.toString((Long) value);
        } else if (value instanceof Boolean) {
            return Boolean.toString((Boolean) value);
        } else if (value instanceof byte[]) {
            return Arrays.toString((byte[]) value);
        } else if (value instanceof String) {
            return (String) value;
        }
        return null;
    }

    public static String getParamAttributeType(Object value) {
        if (value instanceof Integer) {
            return Param.PARAM_TYPE_INT;
        } else if (value instanceof Double) {
            return Param.PARAM_TYPE_DOUBLE;
        } else if (value instanceof Long) {
            return Param.PARAM_TYPE_LONG;
        } else if (value instanceof Boolean) {
            return Param.PARAM_TYPE_BOOLEAN;
        } else if (value instanceof byte[]) {
            return Param.PARAM_TYPE_BYTES;
        } else if (value instanceof String) {
            return Param.PARAM_TYPE_STRING;
        }
        return null;
    }

    private static long getMessageTimestamp(Node node) {
        Node tsNode = findNode(node, "timestamp");
        return parseLong(tsNode.getTextContent());
    }

    private static UUID getRequestMessageId(Node node) {
        Node rqIdNode = findNode(node, "requestMessageId");
        return UUID.fromString(rqIdNode.getTextContent());
    }

    private static String getMessageType(Node messageNode) throws MessageParseException {
        return getAttributeValue(messageNode, Message.ATTRIBUTE_MESSAGE_TYPE);
    }

    public static ArrayList<Param> parseParams(Node node) {
        if (node == null) {
            return null;
        }
        ArrayList<Param> paramList = null;
        Node paramsNode = findNode(node, "params");
        if (paramsNode != null) {
            paramList = new ArrayList<Param>();
            NodeList nodeList = paramsNode.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node paramNode = nodeList.item(i);
                if (paramNode.getNodeName().equals("param")) {
                    Param param = parseParam(paramNode);
                    paramList.add(param);
                }
            }
        }
        return paramList;
    }

    public static Param parseParam(Node paramNode) {
        Object value = parseParamValue(paramNode);
        return new Param(getAttributeValue(paramNode, "name"), value);
    }

    private static Object parseParamValue(Node paramNode) {
        String paramType = getAttributeValue(paramNode, "type");
        Node valueNode = findNode(paramNode, "value");
        String value = valueNode.getTextContent();
        if (paramType.equals(Param.PARAM_TYPE_BYTES)) {
            return parseBinary(value);
        } else if (paramType.equals(Param.PARAM_TYPE_BOOLEAN)) {
            return parseBoolean(value);
        } else if (paramType.equals(Param.PARAM_TYPE_INT)) {
            return parseInteger(value);
        } else if (paramType.equals(Param.PARAM_TYPE_STRING)) {
            return value;
        } else if (paramType.equals(Param.PARAM_TYPE_LONG)) {
            return parseLong(value);
        } else if (paramType.equals(Param.PARAM_TYPE_DOUBLE)) {
            return parseDouble(value);
        }
        return null;
    }

    private static double parseDouble(String value) {
        return Double.parseDouble(value);
    }

    private static byte[] parseBinary(String value) {
        String[] byteValues = value.substring(1, value.length() - 1).split(",");
        byte[] bytes = new byte[byteValues.length];
        for (int i = 0, len = bytes.length; i < len; i++) {
            bytes[i] = Byte.parseByte(byteValues[i].trim());
        }
        return bytes;
    }

    private static boolean parseBoolean(String value) {
        return value.equals("true");
    }

    private static int parseInteger(String value) {
        return Integer.parseInt(value);
    }

    private static long parseLong(String value) {
        return Long.parseLong(value);
    }

    private static InetAddress getSourceIp(Document document) throws UnknownHostException {
        Node messageNode = findNode(document, "message");
        return InetAddress.getByName(getAttributeValue(messageNode, Message.ATTRIBUTE_MESSAGE_SOURCE_IP));
    }

    private static ServiceId getSourceServiceId(Document document) throws UnknownHostException {
        Node messageNode = findNode(document, "message");
        String uuidStr = getAttributeValue(messageNode, Message.ATTRIBUTE_MESSAGE_SOURCE_SERVICE_ID);
        return new ServiceId(UUID.fromString(uuidStr));
    }

    private static ServiceId getDestServiceId(Document document) throws UnknownHostException {
        Node messageNode = findNode(document, "message");
        String destServiceIdStr = getAttributeValue(messageNode, Message.ATTRIBUTE_MESSAGE_DEST_SERVICE_ID);
        try {
            UUID uuid = UUID.fromString(destServiceIdStr);
            return new ServiceId(uuid);
        } catch (Exception e) {
            //Ignore, dest_service_id is not specified for broadcast messages
        }
        return null;
    }

    private static UUID getMessageId(Document document) throws UnknownHostException {
        Node messageNode = findNode(document, "message");
        return UUID.fromString(getAttributeValue(messageNode, "message_id"));
    }

    private static InetAddress getDestIp(Document document) throws UnknownHostException {
        Node messageNode = findNode(document, "message");
        return InetAddress.getByName(getAttributeValue(messageNode, "dest_ip"));
    }

    public static String getAttributeValue(Node node, String attributeName) {
        NamedNodeMap namedNodeMap = node.getAttributes();
        for (int i = 0; i < namedNodeMap.getLength(); i++) {
            Node n = namedNodeMap.item(i);
            if (n.getNodeName().equals(attributeName)) {
                return n.getNodeValue();
            }
        }
        return null;
    }

    private static Node findNode(Document document, String nodeName) {
        return findNode(document.getDocumentElement(), nodeName);
    }

    public static Node findNode(Node node, String nodeName) {
        if (node.getNodeName().equals(nodeName)) {
            return node;
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = findNode(nodeList.item(i), nodeName);
            if (n != null) {
                return n;
            }
        }
        return null;
    }

    public static Document readXml(InputStream is) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(is);
    }

    public static void print(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", 4);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        String xmlString = result.getWriter().toString();
        logger.trace(xmlString);
    }

 /*   public static void validateXML(InputStream schemaStream, Document xmlDocument) throws SAXException, IOException {
        Source xmlSource = new DOMSource(xmlDocument);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        schemaFactory.setResourceResolver(new ResourceResolver());

        Schema schema = schemaFactory.newSchema(new StreamSource(schemaStream));
        Validator validator = schema.newValidator();
        validator.validate(xmlSource);
    }*/

    private static Response createResponse(ServiceId serviceId, Request request, Method method, Object returnObject) throws ServiceMethodAnnotationException {
        if (returnObject == null) {
            return new VoidResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), serviceId, request.getSourceIp(), request.getSourceServiceId());
        }
        List<Param> paramList = new ArrayList<Param>();
        ServiceMethod serviceMethod = getServiceMethod(method);
        String[] paramNames = serviceMethod.returnParamNames();
        if (returnObject.getClass().isArray()) {
            paramList.addAll(createParams(method, paramNames, returnObject));
        } else {
            paramList.add(createParam(method, paramNames, returnObject));
        }
        return new Response(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), serviceId, request.getSourceIp(), request.getSourceServiceId(), paramList.toArray(new Param[paramList.size()]));
    }

    public static Param createParam(Method method, String[] paramNames, Object returnObject) throws ServiceMethodAnnotationException {
        if (paramNames.length != 1) {
            throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
        }
        return new Param(paramNames[0], returnObject);
    }

    public static List<Param> createParams(Method method, String[] paramNames, Object returnObject) throws ServiceMethodAnnotationException {

        List<Param> paramList = new ArrayList<Param>();
        if (returnObject instanceof byte[] || returnObject instanceof Byte[]) {
            if (paramNames.length != 1) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            paramList.add(new Param(paramNames[0], returnObject));
        } else if (returnObject instanceof int[]) {
            int[] values = (int[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], new Integer(values[i])));
            }
        } else if (returnObject instanceof long[]) {
            long[] values = (long[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], new Long(values[i])));
            }
        } else if (returnObject instanceof double[]) {
            double[] values = (double[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], new Double(values[i])));
            }
        } else if (returnObject instanceof String[]) {
            String[] values = (String[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], values[i]));
            }
        } else if (returnObject instanceof boolean[]) {
            boolean[] values = (boolean[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], new Boolean(values[i])));
            }
        } else if (returnObject instanceof Integer[]) {
            Integer[] values = (Integer[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], values[i]));
            }
        } else if (returnObject instanceof Long[]) {
            Long[] values = (Long[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], values[i]));
            }
        } else if (returnObject instanceof Double[]) {
            Double[] values = (Double[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], values[i]));
            }
        } else if (returnObject instanceof Boolean[]) {
            Boolean[] values = (Boolean[]) returnObject;
            if (paramNames.length != values.length) {
                throw new ServiceMethodAnnotationException("Incorrect number of returnParamNames for method: " + method.getClass().getName() + "::" + method.getName());
            }
            for (int i = 0; i < values.length; i++) {
                paramList.add(new Param(paramNames[i], values[i]));
            }
        }
        return paramList;
    }

    public static List<Object> getMethodParams(Method method, Request request) throws ServiceMethodAnnotationException {
        List<Object> methodParams = new ArrayList<Object>();
        Annotation[][] annotationMatrix = method.getParameterAnnotations();
        for (Annotation[] annotations : annotationMatrix) {
            ServiceMethodParam serviceMethodParam = getServiceMethodParam(annotations);
            if (serviceMethodParam != null) {
                Param param = getRequestParam(request, serviceMethodParam.name());
                methodParams.add(param != null ? param.getValue() : null);
            } else {
                methodParams.add(null);
            }
        }
        return methodParams;
    }

    public static Param getRequestParam(Request request, String name) {
        for (Param param : request.getParamList()) {
            if (param.getName().equals(name)) {
                return param;
            }
        }
        return null;
    }

    public static ServiceMethodParam getServiceMethodParam(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof ServiceMethodParam) {
                return (ServiceMethodParam) annotation;
            }
        }
        return null;
    }

    public static ServiceMethod getServiceMethod(Method method) {
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ServiceMethod) {
                return (ServiceMethod) annotation;
            }
        }
        return null;
    }

    public static Response executeRequest(AbstractService abstractService, Request request) {
        Method[] methods = abstractService.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ServiceMethod.class) && method.getName().equals(request.getName())) {
                try {
                    List<Object> params = getMethodParams(method, request);
                    String paramsStr = "";
                    if (params != null) {
                        for (Object o : params) {
                            if (o == null) {
                                paramsStr += "null" + ", ";
                            } else {
                                paramsStr += o + " [" + o.getClass().getName() + "]" + ", ";
                            }

                        }
                    }
                    Object returnObject = null;
                    if (params == null || params.size() == 0) {
                        returnObject = method.invoke(abstractService);
                    } else if (params.size() == 1) {
                        returnObject = method.invoke(abstractService, params.get(0));
                    } else {
                        returnObject = method.invoke(abstractService, params);
                    }
                    return createResponse(abstractService.getServiceId(), request, method, returnObject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return new ErrorResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), abstractService.getServiceId(), request.getSourceIp(), request.getSourceServiceId(), e.getMessage());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    return new ErrorResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), abstractService.getServiceId(), request.getSourceIp(), request.getSourceServiceId(), e.getCause().getMessage());
                } catch (ServiceMethodAnnotationException e) {
                    e.printStackTrace();
                    return new ErrorResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), abstractService.getServiceId(), request.getSourceIp(), request.getSourceServiceId(), e.getMessage());
                } catch (Throwable t) {
                    return new ErrorResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), abstractService.getServiceId(), request.getSourceIp(), request.getSourceServiceId(), t.getCause().getMessage());
                }
            }
        }
        return null;
    }

    public static ErrorResponse createErrorResponse(String errorMessage, Request request) {
        return new ErrorResponse(UUID.randomUUID(), request.getMessageId(), System.currentTimeMillis(), request.getDestIp(), request.getDestServiceId(), request.getSourceIp(), request.getSourceServiceId(), errorMessage);
    }
}
