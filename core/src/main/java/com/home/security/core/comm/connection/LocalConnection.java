package com.home.security.core.comm.connection;

import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.Message;
import com.home.security.core.protocol.message.Request;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.protocol.utils.HostNameUtils;
import com.home.security.core.service.AbstractService;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by john on 2014-12-28.
 */
public class LocalConnection implements Connection {

    private final static Logger logger = LogManager.getLogger(LocalConnection.class.getName());
    private final AbstractService service;
    private ArrayBlockingQueue<Message> responseQueue = new ArrayBlockingQueue<Message>(1024);
    private boolean connected = true;

    public LocalConnection(AbstractService service) {
        this.service = service;
    }

    public Message receiveMessage() throws SAXException, ParserConfigurationException, MessageParseException, IOException, TransformerException, PropertyException {
        try {
            return responseQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendMessage(Message message) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        if (message instanceof Request) {
            Response response = service.handleRequest((Request) message);
            if (!responseQueue.add(response)) {
                logger.error("Unable to add message to queue");
            }
        } else {
            service.handleResponse((Response) message);
        }
    }

    public void closeConnection() {
        connected = false;
    }

    public boolean isConnected() {
        return connected;
    }

    public InetAddress getAddress() {
        try {
            return HostNameUtils.getLocalHostLANAddress();
        } catch (UnknownHostException e) {
            logger.error("Unable to get local address " + e.getMessage());
        }
        return null;
    }
}
