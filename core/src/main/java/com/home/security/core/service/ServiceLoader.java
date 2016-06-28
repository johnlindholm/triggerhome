package com.home.security.core.service;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.utils.HSProperties;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.jar.JarFile;

/**
 * Created by john on 2014-12-04.
 */
public class ServiceLoader {

    public final static String SERVICE_JAR_PATH = HSProperties.ROOT_DIR + File.separator + "services";
    private final static Logger logger = LogManager.getLogger(ServiceLoader.class.getName());
    private static ServiceLoader instance = null;
    private final Universe universe;
    private final HSProperties hsProperties;
    private final CommunicationManager communicationManager;
    private boolean isRunning = false;
    private DirChangeThread dirChangeThread;
    private HashMap<String, ArrayList<AbstractService>> jarFileNameToServiceMap = new HashMap<String, ArrayList<AbstractService>>();
    private HashMap<String, ServiceJarClassLoader> jarFileNameClassLoaderMap = new HashMap<String, ServiceJarClassLoader>();
    private File serviceDir;

    private ServiceLoader(CommunicationManager communicationManager) throws PropertyException {
        universe = Universe.getUniverse();
        hsProperties = HSProperties.getInstance();
        this.communicationManager = communicationManager;
    }

    public static ServiceLoader getInstance(CommunicationManager communicationManager) throws PropertyException {
        if (instance == null) {
            instance = new ServiceLoader(communicationManager);
        }
        return instance;
    }

    public void start() {
        logger.info("ServiceLoader start() SERVICE_JAR_PATH: " + SERVICE_JAR_PATH);
        if (isRunning) {
            return;
        }
        isRunning = true;
        serviceDir = new File(SERVICE_JAR_PATH);
        if (!serviceDir.exists()) {
            if (serviceDir.mkdir()) {
                logger.debug("ServiceLoader Successfully created " + serviceDir.getAbsolutePath());
            } else {
                logger.error("ServiceLoader Unable to create " + serviceDir.getAbsolutePath());
            }
        } else {
            logger.debug("ServiceLoader " + serviceDir.getAbsolutePath() + " already exists");
        }
        dirChangeThread = new DirChangeThread(serviceDir);
        dirChangeThread.start();
        initLoadServices();
    }

    private void initLoadServices() {
        File[] jarFiles = serviceDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        for (File file : jarFiles) {
            loadServiceJar(file);
        }
    }

    public void stop() {
        logger.info("ServiceLoader.stop");
        isRunning = false;
        if (dirChangeThread != null) {
            dirChangeThread.interrupt();
            try {
                dirChangeThread.join();
            } catch (InterruptedException e) {
            }
        }
    }

    private void unloadServiceJar(File jarFile) {
        String jarFileName = jarFile.getName();
        ArrayList<AbstractService> abstractServices = jarFileNameToServiceMap.get(jarFileName);
        for (AbstractService service : abstractServices) {
            universe.removeService(service.getServiceId().id);
            try {
                hsProperties.removeService(jarFileName, service.getClass());
            } catch (PropertyException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadServiceJar(File jarFile) {
        logger.debug("ServiceLoader loadServiceJar jarFile: " + jarFile.getAbsolutePath());
        String jarFileName = jarFile.getName();
        try {
            ServiceJarClassLoader classLoader = new ServiceJarClassLoader(this, new JarFile(jarFile), this.getClass().getClassLoader());
            jarFileNameClassLoaderMap.put(jarFileName, classLoader);
            List<Class<AbstractService>> serviceClassList = classLoader.getServiceClasses();
            for (Class<AbstractService> clazz : serviceClassList) {
                //Server server, ServiceId serviceId
                Constructor constructor = clazz.getConstructor(CommunicationManager.class, ServiceId.class);
                ServiceId serviceId = hsProperties.getServiceId(jarFileName, clazz);
                if (serviceId == null) {
                    serviceId = new ServiceId(UUID.randomUUID());
                    hsProperties.addService(jarFileName, clazz, serviceId);
                }
                AbstractService service = (AbstractService) constructor.newInstance(communicationManager, serviceId);
                ArrayList<AbstractService> abstractServices = jarFileNameToServiceMap.get(jarFileName);
                if (abstractServices == null) {
                    abstractServices = new ArrayList<AbstractService>();
                }
                abstractServices.add(service);
                jarFileNameToServiceMap.put(jarFileName, abstractServices);
                universe.addService(service);
            }

        } catch (MalformedURLException e) {
            logger.error(e);
        } catch (NoSuchMethodException e) {
            logger.error(e);
        } catch (InvocationTargetException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        } catch (PropertyException e) {
            logger.error(e);
        } catch (IOException e) {
            logger.error(e);
        }
    }

    private final class DirChangeThread extends Thread {

        private File serviceDir;

        public DirChangeThread(File serviceDir) {
            this.serviceDir = serviceDir;
        }

        public void run() {
            WatchService watcher = null;
            while (!isInterrupted() && isRunning) {
                try {
                    watcher = FileSystems.getDefault().newWatchService();
                    serviceDir.toPath().register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                logger.debug("ServiceLoader Listening for dir changes");
                try {
                    WatchKey watchKey = watcher.take();
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        logger.debug("ServiceLoader event.kind() " + event.kind());
                        WatchEvent.Kind<?> kind = event.kind();
                        if (kind == StandardWatchEventKinds.OVERFLOW) {
                            continue;
                        } else if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                            File file = getJarFile(event);
                            if (file != null) {
                                logger.debug("ServiceLoader file != null");
                                loadServiceJar(file);
                            } else {
                                logger.debug("ServiceLoader file == null");
                            }
                        } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                            File file = getJarFile(event);
                            if (file != null) {
                                unloadServiceJar(file);
                            }
                        } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                            //TODO not supported yet
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
            if (watcher != null) {
                try {
                    watcher.close();
                } catch (IOException e) {
                }
            }
            logger.debug(getId() + "_DirChangeThread.run exiting");
        }

        private File getJarFile(WatchEvent event) {
            WatchEvent<Path> ev = (WatchEvent<Path>) event;
            Path filePath = ev.context();
            if (!filePath.getFileName().toString().endsWith(".jar")) {
                logger.debug("ServiceLoader returning null");
                return null;
            }
            File file = filePath.toFile();
            if (!file.getAbsolutePath().startsWith(serviceDir.getAbsolutePath())) {
                //Some bug
                logger.debug("File is not correct yet... file: " + file.getAbsolutePath());
                file = new File(serviceDir, file.getName());
                logger.debug("new file: " + file.getAbsolutePath());
            }
            return file;
        }

    }
}

