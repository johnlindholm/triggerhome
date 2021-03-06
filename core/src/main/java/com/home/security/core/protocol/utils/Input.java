package com.home.security.core.protocol.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.ls.LSInput;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Created by john on 2014-12-23.
 */
public class Input implements LSInput {

    private final static Logger logger = LogManager.getLogger(Input.class.getName());

    private String publicId;

    private String systemId;
    private BufferedInputStream inputStream;

    public Input(String publicId, String sysId, InputStream input) {
        this.publicId = publicId;
        this.systemId = sysId;
        this.inputStream = new BufferedInputStream(input);
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getBaseURI() {
        return null;
    }

    public void setBaseURI(String baseURI) {
    }

    public InputStream getByteStream() {
        return null;
    }

    public void setByteStream(InputStream byteStream) {
    }

    public boolean getCertifiedText() {
        return false;
    }

    public void setCertifiedText(boolean certifiedText) {
    }

    public Reader getCharacterStream() {
        return null;
    }

    public void setCharacterStream(Reader characterStream) {
    }

    public String getEncoding() {
        return null;
    }

    public void setEncoding(String encoding) {
    }

    public String getStringData() {
        synchronized (inputStream) {
            try {
                byte[] input = new byte[inputStream.available()];
                inputStream.read(input);
                String contents = new String(input);
                return contents;
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Exception " + e);
                return null;
            }
        }
    }

    public void setStringData(String stringData) {
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public BufferedInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(BufferedInputStream inputStream) {
        this.inputStream = inputStream;
    }
}
