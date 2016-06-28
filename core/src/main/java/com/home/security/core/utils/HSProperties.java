package com.home.security.core.utils;

import com.home.security.core.service.ServiceId;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by john on 2014-12-06.
 */
public class HSProperties extends Properties {

    public final static String ROOT_DIR = "/etc/HomeSecurity";
    private static HSProperties HSProperties = null;
    private static String SEPARATOR = File.separator;
    private static String FILE_NAME = "hs.properties";
    private File propFile;

    private HSProperties() throws PropertyException {
        super();
        propFile = new File(ROOT_DIR + SEPARATOR + FILE_NAME);
        File dir = new File(ROOT_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }
        if (!dir.isDirectory()) {
            throw new PropertyException(ROOT_DIR + " already exists but its not a directory!");
        }
        if (propFile.exists()) {
            try {
                load(new FileInputStream(propFile));
            } catch (IOException e) {
                e.printStackTrace();
                throw new PropertyException("Unable to load properties from " + propFile.getAbsolutePath(), e);
            }
        }
    }

    public static HSProperties getInstance() throws PropertyException {
        if (HSProperties == null) {
            HSProperties = new HSProperties();
        }
        return HSProperties;
    }

    public synchronized void addService(String jarFileName, Class serviceClass, ServiceId serviceId) throws PropertyException {
        put(createKey(jarFileName, serviceClass), serviceId.id.toString());
        storeProperties();
    }

    public ServiceId getServiceId(String jarFileName, Class serviceClass) {
        Object o = get(createKey(jarFileName, serviceClass));
        if (o == null) {
            return null;
        }
        return new ServiceId(UUID.fromString((String) o));
    }

    public synchronized void removeService(String jarFileName, Class serviceClass) throws PropertyException {
        remove(createKey(jarFileName, serviceClass));
        storeProperties();
    }

    public synchronized void removeServices(String jarFileName) throws PropertyException {
        ArrayList<String> toRemoveList = new ArrayList<String>();
        Enumeration<Object> keys = keys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (key.startsWith("FILE-" + jarFileName + "-CLASS-")) {
                toRemoveList.add(key);
            }
        }
        for (String key : toRemoveList) {
            remove(key);
        }
        storeProperties();
    }

    private String createKey(String jarFileName, Class serviceClass) {
        return "FILE-" + jarFileName + "-CLASS-" + serviceClass.getName();
    }

    private void storeProperties() throws PropertyException {
        try {
            store(new FileOutputStream(propFile), "");
        } catch (IOException e) {
            e.printStackTrace();
            throw new PropertyException("Unable to store properties to " + propFile.getAbsolutePath(), e);
        }
    }

    @Override
    public Object put(Object key, Object value) {
        Object o = super.put(key, value);
        try {
            storeProperties();
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    @Override
    public Object remove(Object key) {
        Object o = super.remove(key);
        try {
            storeProperties();
        } catch (PropertyException e) {
            e.printStackTrace();
        }
        return o;
    }

}
