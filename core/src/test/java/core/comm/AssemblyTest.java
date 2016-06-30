package core.comm;

import com.home.security.core.comm.assembly.Assembly;
import com.home.security.core.comm.assembly.AssemblyAction;
import com.home.security.core.comm.assembly.Init;
import com.home.security.core.comm.assembly.Trigger;
import com.home.security.core.protocol.exception.AssemblyParseException;
import com.home.security.core.protocol.message.Param;
import com.home.security.core.protocol.utils.AssemblyHelper;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import com.home.security.core.service.ServiceStub;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.fail;

public class AssemblyTest {

    @Test
    public void testAssembly() throws UnknownHostException {
        //Raspberrypi
//        <service ipAddress="192.168.1.14" name="TestService" serviceId="74d3f1b6-40f8-457e-8a43-a7c698f083c2" version="1.0"/>

        //Local
        //<service ipAddress="192.168.1.156" name="TestService" serviceId="7c616a5e-cfde-4500-aaef-78e27be81c00" version="1.0"/>

        String version = "1.0";
        String name = "AssemblyName";
        ServiceId serviceId = new ServiceId(UUID.randomUUID());
        Service raspberryTestService = new ServiceStub(new ServiceId(UUID.fromString("74d3f1b6-40f8-457e-8a43-a7c698f083c2")), "TestService", "1.0", InetAddress.getByName("192.168.1.14"));
        Service localTestService = new ServiceStub(new ServiceId(UUID.fromString("7c616a5e-cfde-4500-aaef-78e27be81c00")), "TestService", "1.0", InetAddress.getByName("192.168.1.156"));
        ArrayList<Service> serviceList = new ArrayList<Service>(Arrays.asList(new Service[]{raspberryTestService, localTestService}));
        AssemblyAction[] initActions = new AssemblyAction[]{new AssemblyAction(raspberryTestService, "getA", null)};
        Init init = new Init(initActions);
        ArrayList<Trigger> triggerList = new ArrayList<Trigger>();
        Trigger trigger1 = new Trigger(raspberryTestService, "getA", new AssemblyAction[]{new AssemblyAction(raspberryTestService, "getB", null)});
        Trigger trigger2 = new Trigger(raspberryTestService, "getB", new AssemblyAction[]{new AssemblyAction(raspberryTestService, "getC", null)});
        Trigger trigger3 = new Trigger(raspberryTestService, "getC", new AssemblyAction[]{new AssemblyAction(raspberryTestService, "getD", null)});
        Trigger trigger4 = new Trigger(raspberryTestService, "getD", new AssemblyAction[]{new AssemblyAction(localTestService, "print", new Param("toPrint", "ABCD"))});
        triggerList.add(trigger1);
        triggerList.add(trigger2);
        triggerList.add(trigger3);
        triggerList.add(trigger4);

        Assembly assembly = new Assembly(version, name, null, serviceId, serviceList, init, triggerList, null, null);
        try {
            String xml = AssemblyHelper.toXMLString(assembly);
            Assembly assembly1 = AssemblyHelper.parseAssembly(null, new ByteArrayInputStream(xml.getBytes()));
        } catch (ParserConfigurationException e) {
            fail(e.getMessage());
        } catch (TransformerException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (SAXException e) {
            fail(e.getMessage());
        } catch (AssemblyParseException e) {
            fail(e.getMessage());
        }
    }

}