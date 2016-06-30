package core.protocol.utils;

import com.home.security.core.comm.assembly.*;
import com.home.security.core.protocol.exception.AssemblyParseException;
import com.home.security.core.protocol.utils.AssemblyHelper;
import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import static core.protocol.utils.TestHelper.createParams;
import static core.protocol.utils.TestHelper.createServices;
import static org.junit.Assert.fail;

public class AssemblyHelperTest {

    @Test
    public void testAssemblyParseUnparse() throws UnknownHostException {
        String version = "1.0";
        String name = "AssemblyName";
        ServiceId serviceId = new ServiceId(UUID.randomUUID());
        Service[] services = createServices();
        ArrayList<Service> serviceList = new ArrayList<Service>(Arrays.asList(services));
        AssemblyAction[] initActions = createAssemblyActions(services);
        Init init = new Init(initActions);
        ArrayList<Trigger> triggerList = createTriggerList(services);
        ArrayList<Repeat> repeatList = createRepeatList(services);
        HashMap<UUID, ArrayList<Service>> serviceAlternatives = new HashMap<UUID, ArrayList<Service>>();
        serviceAlternatives.put(takeRandomService(services).getServiceId().id, new ArrayList<Service>(Arrays.asList(createServices())));
        Assembly assembly = new Assembly(version, name, null, serviceId,
                serviceList, init, triggerList, repeatList, serviceAlternatives);
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

    private ArrayList<Repeat> createRepeatList(Service[] services) {
        ArrayList<Repeat> repeats = new ArrayList<Repeat>();
        int length = 1 + (int) (Math.random() * 5);
        for (int i = 0; i < length; i++) {
            repeats.add(new Repeat(500 + (long) (Math.random() * 10000), createAssemblyAction(takeRandomService(services))));
        }
        return repeats;
    }

    private ArrayList<Trigger> createTriggerList(Service[] services) {
        ArrayList<Trigger> triggers = new ArrayList<Trigger>();
        int length = 1 + (int) (Math.random() * 5);
        for (int i = 0; i < length; i++) {
            triggers.add(new Trigger(takeRandomService(services), "requestName_" + (int) (Math.random() * 100), createAssemblyActions(services)));
        }
        return triggers;
    }

    private AssemblyAction[] createAssemblyActions(Service[] services) {
        AssemblyAction[] assemblyActions = new AssemblyAction[1 + (int) (Math.random() * 10)];
        for (int i = 0; i < assemblyActions.length; i++) {
            assemblyActions[i] = createAssemblyAction(takeRandomService(services));
        }
        return assemblyActions;
    }

    private Service takeRandomService(Service[] services) {
        return services[(int) (Math.random() * (services.length - 1))];
    }

    private AssemblyAction createAssemblyAction(Service service) {
        return new AssemblyAction(service, "requestName_" + System.currentTimeMillis(), createParams());
    }

}