package com.home.security.core.comm.connection;

import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.Message;
import com.home.security.core.utils.PropertyException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by john on 2014-12-17.
 */
public interface Connection {

    Message receiveMessage() throws SAXException, ParserConfigurationException, MessageParseException, IOException, TransformerException, PropertyException;

    void sendMessage(Message message) throws ParserConfigurationException, TransformerException, SAXException, IOException;

    void closeConnection();

    boolean isConnected();

    InetAddress getAddress();
}
