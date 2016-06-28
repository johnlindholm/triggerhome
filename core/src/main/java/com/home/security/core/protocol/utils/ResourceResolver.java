package com.home.security.core.protocol.utils;

import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

import java.io.InputStream;

/**
 * Created by john on 2014-12-23.
 */
public class ResourceResolver implements LSResourceResolver {

    @Override
    public LSInput resolveResource(String type, String namespaceURI,
                                   String publicId, String systemId, String baseURI) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream schemaStream = classloader.getResourceAsStream("schema/" + systemId);
        return new Input(publicId, systemId, schemaStream);
    }
}
