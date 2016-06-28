package com.home.security.core.comm.connection;

import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.Message;
import com.home.security.core.protocol.utils.MessageHelper;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.*;

/**
 * Created by john on 2014-12-17.
 */
public class BroadCastConnection implements Connection {

    private final static Logger logger = LogManager.getLogger(BroadCastConnection.class.getName());

    private InetAddress broadcastAddress;
    private DatagramSocket sendSocket;
    private DatagramSocket receiveSocket;
    private DatagramPacket recievePacket;
    private int port;

    public BroadCastConnection(InetAddress broadcastAddress, int port) throws SocketException, UnknownHostException {
        this.broadcastAddress = broadcastAddress;
        this.port = port;
        sendSocket = new DatagramSocket();
        sendSocket.setBroadcast(true);
        receiveSocket = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
        int bufferSize = receiveSocket.getReceiveBufferSize();
        recievePacket = new DatagramPacket(new byte[bufferSize], bufferSize);
    }

    public Message receiveMessage() throws IOException, MessageParseException, SAXException, ParserConfigurationException, TransformerException, PropertyException {
        receiveSocket.receive(recievePacket);
        byte[] messageData = new byte[recievePacket.getLength()];
        System.arraycopy(recievePacket.getData(), 0, messageData, 0, messageData.length);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(messageData);
        return MessageHelper.parseMessage(inputStream, "BroadCastConnection.receiveMessage");
    }

    public void sendMessage(Message message) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        String xmlMessage = MessageHelper.toXMLString(message);
        logger.trace("BroadCastConnection.sendMessage\n" + xmlMessage);
        byte[] messageData = xmlMessage.getBytes();
        if (messageData.length > sendSocket.getSendBufferSize()) {
            throw new IOException("Packet is too large! size: " + messageData.length + ", limit: " + sendSocket.getSendBufferSize());
        }
        DatagramPacket packet = new DatagramPacket(messageData, 0, messageData.length, broadcastAddress, port);
        sendSocket.send(packet);
    }

    public void closeConnection() {
        logger.debug("BroadCastConnection.closeConnection");
        receiveSocket.close();
        sendSocket.close();
    }

    public boolean isConnected() {
        return sendSocket != null && sendSocket.isConnected() && receiveSocket != null && receiveSocket.isConnected();
    }

    public InetAddress getAddress() {
        return broadcastAddress;
    }
}
