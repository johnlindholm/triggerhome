package com.home.security.core.comm.connection;

import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.Message;
import com.home.security.core.protocol.message.Ping;
import com.home.security.core.protocol.utils.HostNameUtils;
import com.home.security.core.protocol.utils.MessageHelper;
import com.home.security.core.service.Service;
import com.home.security.core.service.Universe;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by john on 2014-12-14.
 */
public class TCPConnection implements Connection {

    private final static int HEADER_SIZE_LENGTH = 4;

    private final static Logger logger = LogManager.getLogger(TCPConnection.class.getName());

    private final Socket socket;

    public TCPConnection(Socket socket) throws IOException {
        this.socket = socket;
    }

    private static byte[] createSizeHeader(int size) {
        ByteBuffer buffer = ByteBuffer.allocate(HEADER_SIZE_LENGTH);
        buffer.putInt(size);
        return buffer.array();
    }

    public Message receiveMessage() throws SAXException, ParserConfigurationException, MessageParseException, IOException, TransformerException, PropertyException {
        InputStream in = socket.getInputStream();
        byte[] lengthBuffer = new byte[HEADER_SIZE_LENGTH];
        int read = in.read(lengthBuffer);
        if (read != 4) {
            throw new IOException("Unable to read initial bytes!");
        }
        int messageLength = ByteBuffer.wrap(lengthBuffer).getInt();
        byte[] buffer = new byte[messageLength];
        int offset = 0;
        while ((read = in.read(buffer, offset, buffer.length - offset)) > 0) {
            offset += read;
        }
        return MessageHelper.parseMessage(new ByteArrayInputStream(buffer), "TCPConnection.receiveMessage");
    }

    public void sendMessage(Message message) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        OutputStream out = socket.getOutputStream();
        String xmlMessage = MessageHelper.toXMLString(message);
        logger.info("TCPConnection.sendMessage message: " + message);
        out.write(createSizeHeader(xmlMessage.getBytes().length));
        out.write(xmlMessage.getBytes());
        out.flush();
    }

    public synchronized void closeConnection() {
        logger.debug("TCPConnection.closeConnection " + socket.getInetAddress().getHostAddress());
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        Service[] services = Universe.getUniverse().getServices(socket.getInetAddress());
        if (services == null || services.length == 0) {
            return false;
        }
        try {
            sendMessage(new Ping(
                    UUID.randomUUID(),
                    System.currentTimeMillis(),
                    HostNameUtils.getLocalHostLANAddress(),
                    socket.getInetAddress()));
        } catch (ParserConfigurationException e) {
            logger.error(e);
            return false;
        } catch (TransformerException e) {
            logger.error(e);
            return false;
        } catch (SAXException e) {
            logger.error(e);
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public InetAddress getAddress() {
        return socket.getInetAddress();
    }

}
