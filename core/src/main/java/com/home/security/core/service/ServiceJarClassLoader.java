package com.home.security.core.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * Created by john on 2014-12-06.
 */
public class ServiceJarClassLoader extends ClassLoader {

    private final static Logger logger = LogManager.getLogger(ServiceJarClassLoader.class.getName());
    private final ServiceLoader serviceLoader;
    private JarFile jarFile;

    public ServiceJarClassLoader(ServiceLoader serviceLoader, JarFile jarFile, ClassLoader parent) {
        super(parent);
        this.jarFile = jarFile;
        this.serviceLoader = serviceLoader;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // load from parent
        Class<?> result = findLoadedClass(name);
        if (result != null) {
            return result;
        }
        try {
            result = findSystemClass(name);
        } catch (Exception e) {
            // Ignore these
        }
        if (result != null) {
            return result;
        }
        ZipEntry entry = jarFile.getEntry(name.replace('.', '/') + ".class");
        if (entry == null) {
            throw new ClassNotFoundException(name);
        }
        try {
            byte[] array = new byte[1024];
            InputStream in = jarFile.getInputStream(entry);
            ByteArrayOutputStream out = new ByteArrayOutputStream(array.length);
            int length = in.read(array);
            while (length > 0) {
                out.write(array, 0, length);
                length = in.read(array);
            }
            return defineClass(name, out.toByteArray(), 0, out.size());
        } catch (IOException exception) {
            throw new ClassNotFoundException(name, exception);
        }
    }

    public List<Class<AbstractService>> getServiceClasses() {
        List<Class<AbstractService>> classList = new ArrayList<Class<AbstractService>>();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            if (!entry.getName().endsWith(".class")) {
                continue;
            }
            try {
                byte[] array = new byte[1024];
                InputStream in = jarFile.getInputStream(entry);
                ByteArrayOutputStream out = new ByteArrayOutputStream(array.length);
                int length = in.read(array);
                while (length > 0) {
                    out.write(array, 0, length);
                    length = in.read(array);
                }
                String className = entry.getName().replace('/', '.');
                className = className.substring(0, className.indexOf(".class"));
                Class clazz = defineClass(className, out.toByteArray(), 0, out.size());
                if (AbstractService.class.isAssignableFrom(clazz)) {
                    classList.add(clazz);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classList;
    }
}
