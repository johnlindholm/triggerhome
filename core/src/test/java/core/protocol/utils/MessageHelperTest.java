package core.protocol.utils;

import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.*;
import com.home.security.core.protocol.utils.MessageHelper;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import com.home.security.core.utils.PropertyException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import static core.protocol.utils.TestHelper.*;
import static org.junit.Assert.*;

public class MessageHelperTest {

    @Test
    public void testResponse() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        byte[] value = FileUtils.readFileToByteArray(new File(classloader.getResource("cat.jpg").toURI()));
        ServiceId sourceServiceId = createServiceId();
        ServiceId destServiceId = createServiceId();
        Response response = new Response(
                UUID.randomUUID(),
                UUID.randomUUID(),
                System.currentTimeMillis(),
                createAddress(),
                sourceServiceId,
                createAddress(),
                destServiceId,
                new Param("testName", value));
        String xmlString = MessageHelper.toXMLString(response);
        try {
            Response response1 = (Response) MessageHelper.parseMessage(new ByteArrayInputStream(xmlString.getBytes()));
            assertMessageEquals(response, response1);
        } catch (MessageParseException e) {
            fail(e.getMessage());
        } catch (PropertyException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testRequest() throws UnknownHostException {
        Request request = createRequest();

        String xml;
        Request request1;
        try {
            xml = MessageHelper.toXMLString(request);
            request1 = (Request) MessageHelper.parseMessage(new ByteArrayInputStream(xml.getBytes()));
            assertEquals(request1.getName(), request.getName());
            assertMessageEquals(request, request1);
        } catch (ParserConfigurationException e) {
            fail(e.getMessage());
        } catch (TransformerException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (SAXException e) {
            fail(e.getMessage());
        } catch (MessageParseException e) {
            fail(e.getMessage());
        } catch (PropertyException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testHeartAttack() throws UnknownHostException {
        ServiceId sourceServiceId = createServiceId();
        ServiceId destServiceId = createServiceId();
        UUID messageId = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        InetAddress sourceIp = createAddress();
        InetAddress destIp = createAddress();

        Service[] services = createServices();

        HeartAttack heartAttack = new HeartAttack(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, services);
        try {
            String xml = MessageHelper.toXMLString(heartAttack);
            HeartAttack heartAttack1 = (HeartAttack) MessageHelper.parseMessage(new ByteArrayInputStream(xml.getBytes()));
            assertMessageEquals(heartAttack, heartAttack1);
            Service[] services1 = heartAttack1.getServices();
            assertNotNull(services1);
            assertEquals(services.length, services1.length);
            for (int i = 0; i < services.length; i++) {
                assertServiceEquals(services[i], services1[i]);
            }

        } catch (ParserConfigurationException e) {
            fail(e.getMessage());
        } catch (TransformerException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (SAXException e) {
            fail(e.getMessage());
        } catch (MessageParseException e) {
            fail(e.getMessage());
        } catch (PropertyException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testHeartBeat() throws UnknownHostException {
        ServiceId sourceServiceId = createServiceId();
        ServiceId destServiceId = createServiceId();
        UUID messageId = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        InetAddress sourceIp = createAddress();
        InetAddress destIp = createAddress();

        Service[] services = createServices();

        HeartBeat heartBeat = new HeartBeat(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, services);
        try {
            String xml = MessageHelper.toXMLString(heartBeat);
            HeartBeat heartBeat1 = (HeartBeat) MessageHelper.parseMessage(new ByteArrayInputStream(xml.getBytes()));
            assertMessageEquals(heartBeat, heartBeat1);
            Service[] services1 = heartBeat1.getServices();
            assertNotNull(services1);
            assertEquals(services.length, services1.length);
            for (int i = 0; i < services.length; i++) {
                assertServiceEquals(services[i], services1[i]);
            }

        } catch (ParserConfigurationException e) {
            fail(e.getMessage());
        } catch (TransformerException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (SAXException e) {
            fail(e.getMessage());
        } catch (MessageParseException e) {
            fail(e.getMessage());
        } catch (PropertyException e) {
            fail(e.getMessage());
        }
    }


}