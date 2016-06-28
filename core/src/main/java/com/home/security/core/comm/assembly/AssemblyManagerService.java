package com.home.security.core.comm.assembly;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.annotation.ServiceMethod;
import com.home.security.core.protocol.annotation.ServiceMethodParam;
import com.home.security.core.protocol.exception.AssemblyParseException;
import com.home.security.core.protocol.exception.AssemblyRunException;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.protocol.utils.AssemblyHelper;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.ServiceId;
import com.home.security.core.service.Universe;
import com.home.security.core.utils.HSProperties;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by john on 2014-12-08.
 */
public final class AssemblyManagerService extends AbstractService {

    public static final String ASSEMBLY_ROOT_DIR = HSProperties.ROOT_DIR + File.separator + "assemblies";
    public static final String ASSEMBLY_LIST_DELIMITER = ";;";
    public final static String VERSION = "1.0";
    private final static Logger logger = LogManager.getLogger(AssemblyHelper.class.getName());
    private final static Universe universe = Universe.getUniverse();

    private HashMap<UUID, Assembly> assemblyHashMap = new HashMap<UUID, Assembly>();

    public AssemblyManagerService(CommunicationManager communicationManager, ServiceId serviceId) {
        super("AssemblyManager", VERSION, communicationManager, serviceId);
        loadStoredAssemblies();
    }

    private void loadStoredAssemblies() {
        File assebmblyDir = new File(ASSEMBLY_ROOT_DIR);
        if (!assebmblyDir.exists()) {
            if (!assebmblyDir.mkdir()) {
                logger.error("AssemblyManager.loadStoredAssemblies Unable to create " + ASSEMBLY_ROOT_DIR + " !");
                return;
            }
        }
        if (!assebmblyDir.isDirectory()) {
            //Remove file and create dir
            if (!assebmblyDir.delete()) {
                logger.error("AssemblyManager.loadStoredAssemblies Unable to remove file " + ASSEMBLY_ROOT_DIR + " !");
                return;
            }
            assebmblyDir = new File(ASSEMBLY_ROOT_DIR);
            if (!assebmblyDir.mkdir()) {
                logger.error("AssemblyManager.loadStoredAssemblies Unable to create " + ASSEMBLY_ROOT_DIR + " !");
                return;
            }
        }
        File[] assemblyFiles = assebmblyDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".xml");
            }
        });
        for (File file : assemblyFiles) {
            String assemblyId = null;
            try {
                assemblyId = loadAssembly(FileUtils.readFileToByteArray(file));
                if (assemblyId != null) {
                    startAssembly(assemblyId);
                } else {
                    logger.error("AssemblyManager.loadStoredAssemblies Unable to start assembly: " + file.getName());
                }
            } catch (IOException e) {
                logger.error("AssemblyManager.loadStoredAssemblies Unable to read file " + file.getName() + ", msg: " + e.getMessage());
            }
        }
    }

    @Override
    public void handleResponse(Response response) {
        //TODO
    }

    @Override
    public void stop() {

    }

    @ServiceMethod(name = "loadAssembly", returnParamNames = "uuid")
    public String loadAssembly(@ServiceMethodParam(name = "assemblyXML") byte[] assemblyXML) {
        Assembly assembly = null;
        try {
            assembly = parseAssemblyXML(assemblyXML);
            assemblyHashMap.put(assembly.getServiceId().id, assembly);
        } catch (AssemblyParseException e) {
            logger.error(e);
            return null;
        } catch (SAXException e) {
            logger.error(e);
            return null;
        } catch (ParserConfigurationException e) {
            logger.error(e);
            return null;
        } catch (IOException e) {
            logger.error(e);
            return null;
        } catch (TransformerException e) {
            logger.error(e);
            return null;
        }
        return assembly.getServiceId().id.toString();
    }

    private Assembly parseAssemblyXML(byte[] assemblyXML) throws AssemblyParseException, SAXException, TransformerException, ParserConfigurationException, IOException {
        return AssemblyHelper.parseAssembly(communicationManager, new ByteArrayInputStream(assemblyXML));
    }

    @ServiceMethod(name = "startAssembly", returnParamNames = {"successful"})
    public boolean startAssembly(@ServiceMethodParam(name = "assemblyId") String assemblyId) {
        Assembly assembly = assemblyHashMap.get(UUID.fromString(assemblyId));
        if (assembly == null) {
            return false;
        }
        try {
            universe.addService(assembly);
            assembly.start();
        } catch (AssemblyRunException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @ServiceMethod(name = "stopAssembly")
    public void stopAssembly(@ServiceMethodParam(name = "assemblyId") String assemblyId) {
        Assembly assembly = assemblyHashMap.get(UUID.fromString(assemblyId));
        if (assembly != null) {
            assembly.stop();
            universe.removeService(assembly.getServiceId().id);
        }
    }

    @ServiceMethod(name = "unloadAssembly")
    public void unloadAssembly(@ServiceMethodParam(name = "assemblyId") String assemblyId) {
        stopAssembly(assemblyId);
        assemblyHashMap.remove(UUID.fromString(assemblyId));
    }

    @ServiceMethod(name = "getAssemblies", returnParamNames = "assemblyIdList")
    public String getAssemblies() {
        String assemblyListStr = "";
        Collection<Assembly> assemblies = assemblyHashMap.values();
        for (Assembly assembly : assemblies) {
            assemblyListStr += getAssembly(assembly.getServiceId().id.toString()) + ASSEMBLY_LIST_DELIMITER;
        }
        return assemblyListStr;
    }

    @ServiceMethod(name = "isAssemblyStarted", returnParamNames = "assemblyIdList")
    public boolean isAssemblyStarted(@ServiceMethodParam(name = "assemblyId") String assemblyId) {
        Assembly assembly = assemblyHashMap.get(UUID.fromString(assemblyId));
        if (assembly == null) {
            return false;
        }
        return assembly.isRunning();
    }

    @ServiceMethod(name = "getAssembly", returnParamNames = "assemblyXML")
    public String getAssembly(@ServiceMethodParam(name = "assemblyId") String assemblyId) {
        Assembly assembly = assemblyHashMap.get(UUID.fromString(assemblyId));
        if (assembly == null) {
            return null; //TODO check that the parser handles null for all return types.
        }
        String xml = null;
        try {
            xml = AssemblyHelper.toXMLString(assembly);
        } catch (ParserConfigurationException e) {
            logger.error(e);
        } catch (TransformerException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        } catch (SAXException e) {
            logger.error(e);
        }
        return xml;
    }
}
