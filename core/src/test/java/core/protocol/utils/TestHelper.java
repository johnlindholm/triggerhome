package core.protocol.utils;

import com.home.security.core.protocol.message.Message;
import com.home.security.core.protocol.message.Param;
import com.home.security.core.protocol.message.Request;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import com.home.security.core.service.ServiceStub;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by john on 2014-12-24.
 */
public class TestHelper {

    public static void assertServiceEquals(Service service, Service service1) {
        assertEquals(service.getName(), service1.getName());
        assertEquals(service.getIpAddress().getHostAddress(), service1.getIpAddress().getHostAddress());
        assertEquals(service.getServiceId().id, service1.getServiceId().id);
        assertEquals(service.getVersion(), service1.getVersion());
    }

    public static void assertMessageEquals(Message message1, Message message2) {
        assertEquals(message1.getMessageId(), message2.getMessageId());
        assertEquals(message1.getDestIp(), message2.getDestIp());
        assertEquals(message1.getDestServiceId().id, message2.getDestServiceId().id);
        assertEquals(message1.getSourceIp(), message2.getSourceIp());
        assertEquals(message1.getSourceServiceId().id, message2.getSourceServiceId().id);
        assertEquals(message1.getTimestamp(), message2.getTimestamp());
        if (message1.getParamList() == null) {
            assertNull(message2.getParamList());
        } else if (message2.getParamList() == null) {
            assertNull(message1.getParamList());
        } else {
            assertEquals(message1.getParamList().size(), message2.getParamList().size());
            for (int i = 0; i < message1.getParamList().size(); i++) {
                Param p = message2.getParamList().get(i);
                Param p1 = message1.getParamList().get(i);
                assertEquals(p1.getName(), p.getName());
                if (p1.getValue() instanceof byte[]) {
                    assertEquals(Arrays.toString((byte[]) p1.getValue()), Arrays.toString((byte[]) p.getValue()));
                } else {
                    assertEquals(p1.getValue(), p.getValue());
                }
            }
        }
    }

    public static ServiceId createServiceId() {
        return new ServiceId(UUID.randomUUID());
    }

    public static Service[] createServices() throws UnknownHostException {
        Service[] services = new Service[2 + (int) (Math.random() * 6)];
        for (int i = 0; i < services.length; i++) {
            services[i] = new ServiceStub(createServiceId(), "service_" + i + "_" + System.currentTimeMillis(), String.valueOf(Math.random() * 1000), createAddress());
        }
        return services;
    }

    public static Request createRequest() throws UnknownHostException {
        ServiceId sourceServiceId = new ServiceId(UUID.randomUUID());
        ServiceId destServiceId = new ServiceId(UUID.randomUUID());
        UUID messageId = UUID.randomUUID();
        long timestamp = System.currentTimeMillis();
        InetAddress sourceIp = createAddress();
        InetAddress destIp = createAddress();

        Param[] params = createParams();
        String requestName = "testRequest_" + System.currentTimeMillis();

        return new Request(
                messageId,
                timestamp,
                requestName,
                sourceIp,
                sourceServiceId,
                destIp,
                destServiceId,
                params);
    }

    public static InetAddress createAddress() throws UnknownHostException {
        return InetAddress.getByName("192.168." + (int) (Math.random() * 255) + "." + (int) (Math.random() * 255));
    }

    public static Param[] createParams() {
        Param[] params = new Param[3 + (int) (Math.random() * 10)];
        for (int i = 0; i < params.length; i++) {
            params[i] = new Param("p" + i, createParamValue());
        }
        return params;
    }

    public static Object createParamValue() {
        int i = (int) Math.round(Math.random() * 5.0);
        switch (i) {
            case 0:
                return String.valueOf(System.currentTimeMillis()).getBytes();
            case 1:
                return Integer.valueOf((int) System.currentTimeMillis());
            case 2:
                return new Long(System.currentTimeMillis());
            case 3:
                return Double.valueOf((double) System.currentTimeMillis());
            case 4:
                return String.valueOf(System.currentTimeMillis());
            case 5:
                return new Boolean((Math.random() * 10) > 5);
        }
        return null;
    }
}
