package com.home.security.onewire;

import com.home.security.onewire.container.OneWireContainer01;
import com.home.security.onewire.container.OneWireDevice;
import com.home.security.onewire.event.OneWireDeviceChangedEvent;
import com.home.security.onewire.event.OneWireValueAlarmEvent;
import com.home.security.onewire.util.AddressUtils;
import com.home.security.onewire.util.DoubleStringCompare;
import com.home.security.onewire.util.OneWireCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;

public class OneWireController {

    public static final long DEFAULT_DEVICE_UPDATE_INTERVAL = 10000L;
    private long deviceUpdateInterval = DEFAULT_DEVICE_UPDATE_INTERVAL;
    public static final long DEFAULT_VALUE_UPDATE_INTERVAL = 1000L;
    private long valueUpdateInterval = DEFAULT_VALUE_UPDATE_INTERVAL;
    private final static Logger logger = LogManager.getLogger(OneWireController.class.getName());
    public static String DEFAULT_OWSERVER_ADDRESS = "127.0.0.1";
    public static int DEFAULT_OWSERVER_PORT = 4304;
    private OWFSClient client;
    private ArrayList<OneWireEventListener> deviceChangedListeners;
    private HashMap<String, FileAlarmsMapping> valueChangedListenerMap;
    private HashMap<String, Long> deviceChangedDirs;
    private boolean running = false;
    private boolean connected = false;
    private UpdateThread updateThread;
    private Vector<String> oneWireDeviceAddresses;
    private Vector<OneWireDevice> oneWireDevices;
    private WaitForServerConnectionThread waitForServer;
    private boolean FULLY_READ_01_DEVICES = false;

    public OneWireController(OneWireEventListener listener) {
        init(listener);
    }

    public OneWireController(OneWireEventListener listener, long deviceUpdateInterval, long valueUpdateInterval, HashMap<String, Long> deviceChangedDirs) {
        this.deviceChangedDirs = deviceChangedDirs;
        if (deviceUpdateInterval > 0L) {
            this.deviceUpdateInterval = deviceUpdateInterval;
        }
        if (valueUpdateInterval > 0L) {
            this.valueUpdateInterval = valueUpdateInterval;
        }
        init(listener);
    }

    private void init(OneWireEventListener listener) {
        deviceChangedListeners = new ArrayList();
        deviceChangedListeners.add(listener);
        valueChangedListenerMap = new HashMap();
    }

    public void registerForDeviceChangedEvent(OneWireEventListener listener) {
        deviceChangedListeners.add(listener);
    }

    public void unregisterForDeviceChangedEvent(OneWireEventListener listener) {
        deviceChangedListeners.remove(listener);
    }

    public int registerForAlarm(OneWireEventListener listener, OneWireDevice device, String fileName, int alarmType, String boundryValue) {
        logger.debug("OneWireController.registerForAlarm() device:" + device.getOWFSDevicePath() +
                        ", file:" + fileName + ", type:" + alarmType + ", boundry:" + boundryValue,
                9, 0);
        String owfsPath = device.getOWFSPath(fileName);
        FileAlarmsMapping value = valueChangedListenerMap.get(owfsPath);
        int ret = -1;
        if (value == null) {
            String currentValue = null;
            int expected_size = -1;
            try {
                expected_size = OneWireCreator.pathToSize(device.getFamily(), fileName);
                currentValue = client.readValue(owfsPath, expected_size, true);
                if (currentValue == null)
                    logger.debug("OneWireController.registerForAlarm() The initial value for the alarm could not be read, ignoring.",
                            9, 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            value = new FileAlarmsMapping(device, fileName, expected_size, currentValue);
            ret = value.addAlarmListener(new AlarmListener(listener, alarmType, boundryValue));
            valueChangedListenerMap.put(owfsPath, value);
        } else {
            ret = value.addAlarmListener(new AlarmListener(listener, alarmType, boundryValue));
        }
        return ret;
    }

    public void unregisterAlarm(OneWireEventListener listener, OneWireDevice device, String fileName, int id) {
        String owfsPath = device.getOWFSPath(fileName);
        FileAlarmsMapping value = valueChangedListenerMap.get(owfsPath);
        if (value != null)
            value.removeAlarmListener(id);
    }

    public void start(String host, int port) {
        if (running) {
            stop();
        }
        System.out.println("OneWireController.start");
        running = true;
        connected = true;
        client = new OWFSClient(host, port);
        oneWireDeviceAddresses = new Vector();
        OneWireDevice[] devices = null;
        try {
            logger.debug("OneWireController.start() Reading connected 1-wire devices ...");
            devices = client.init();
            logger.debug("OneWireController.start() done!");
        } catch (UnknownHostException e) {
            logger.warn("OneWireController.start() Cannot connect to owserver.", e);
            connected = false;
        } catch (IOException e) {
            logger.error("OneWireController.start() Error accured while reading from owserver.", e);
            connected = false;
        }
        if (!connected) {
            logger.debug("OneWireController.start() Waiting for owserver to appear ...");
            startWaitForServerConnection();
        } else {
            if (devices != null) {
                oneWireDevices = new Vector(devices.length);
                for (int i = 0; i < devices.length; i++) {
                    oneWireDevices.add(devices[i]);
                    oneWireDeviceAddresses.add(devices[i].getOWFSDevicePath());
                    OneWireDeviceChangedEvent event = new OneWireDeviceChangedEvent(
                            OneWireDeviceChangedEvent.DEVICE_APPEARED, devices[i]);
                    sendDeviceEvent(event);
                }
            } else {
                oneWireDevices = new Vector();
            }
            updateThread = new UpdateThread();
            updateThread.start();
        }
    }

    private void startWaitForServerConnection() {
        waitForServer = new WaitForServerConnectionThread();
        waitForServer.start();
    }

    private void reportServerConnectionOpened() {
        connected = true;
        if (waitForServer != null) {
            waitForServer.interrupt();
            try {
                waitForServer.join();
            } catch (InterruptedException e) {
            }
        }
        start(client.getServerAddress(), client.getServerPort());
    }

    public void stop() {
        if (!running) {
            return;
        }
        running = false;
        if (updateThread != null) {
            updateThread.interrupt();
            try {
                updateThread.join();
            } catch (InterruptedException e) {
            }
        }
        if (waitForServer != null) {
            waitForServer.interrupt();
            try {
                waitForServer.join();
            } catch (InterruptedException e) {
            }
        }
    }

    private void sendDeviceEvent(OneWireDeviceChangedEvent event) {
        for (int ii = 0; ii < deviceChangedListeners.size(); ii++)
            (deviceChangedListeners.get(ii)).update(event);
    }

    private void checkForValueChanges() throws NumberFormatException, IOException {
        Set set = valueChangedListenerMap.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry e = (Map.Entry) itr.next();
            String owfsPath = (String) e.getKey();
            FileAlarmsMapping value = (FileAlarmsMapping) e.getValue();
            if (oneWireDeviceAddresses.contains(value.device.getOWFSDevicePath())) {
                String current = client.readValue(owfsPath, value.getExpectedSize(), true);
                if (current != null)
                    value.processAlarms(current);
                else
                    logger.debug("OneWireController.start() current value for: " + owfsPath + " is null !",
                            9, 3);
            }
        }
    }

    private void checkForSingleDirChanges(String owfsRootPath) throws UnknownHostException, IOException {
        String[] devicesAddressStrings = client.getOWFSDevicePaths(owfsRootPath);
        ArrayList devicesWithSameRoot = new ArrayList();
        for (int i = 0; i < oneWireDeviceAddresses.size(); i++) {
            String address = oneWireDeviceAddresses.get(i);
            if ((address.startsWith(owfsRootPath)) && (!address.substring(owfsRootPath.length() + 1).contains("/"))) {
                devicesWithSameRoot.add(address);
            }
        }
        boolean[] exists = new boolean[devicesWithSameRoot.size()];
        for (int i = 0; i < exists.length; i++) {
            exists[i] = false;
        }
        for (int i = 0; i < devicesAddressStrings.length; i++) {
            if (!devicesWithSameRoot.contains(devicesAddressStrings[i])) {
                OneWireDevice newDevice;
                if (devicesAddressStrings[i].startsWith("01")) {
                    if (FULLY_READ_01_DEVICES) {
                        newDevice = getDevice(devicesAddressStrings[i], false);
                    } else {
                        newDevice = new OneWireContainer01();
                        String id = client.getIdFromOWFSDevicePath(devicesAddressStrings[i]);
                        String r_id = AddressUtils.idToReverseId(id);
                        newDevice.init(
                                OWFSClient.getOWFSRootPathFromOWFSDevicePath(devicesAddressStrings[i]),
                                client, null, null, null, "01", id, null, null, r_id, null, null);
                    }
                } else {
                    newDevice = getDevice(devicesAddressStrings[i], false);
                }
                if (newDevice != null) {
                    sendDeviceEvent(new OneWireDeviceChangedEvent(OneWireDeviceChangedEvent.DEVICE_APPEARED,
                            newDevice));
                    oneWireDevices.add(newDevice);
                    oneWireDeviceAddresses.add(newDevice.getOWFSDevicePath());
                } else {
                    logger.debug("OneWireController.checkForSingleDirChanges() device == null, dir = " +
                            devicesAddressStrings[i]);
                }
            } else {
                exists[devicesWithSameRoot.indexOf(devicesAddressStrings[i])] = true;
            }
        }
        for (int i = 0; i < exists.length; i++)
            if (exists[i]) {
                OneWireDevice old = oneWireDevices.get(oneWireDeviceAddresses.indexOf(devicesWithSameRoot.get(i)));
                sendDeviceEvent(new OneWireDeviceChangedEvent(1, old));
                oneWireDevices.remove(old);
                oneWireDeviceAddresses.remove(old.getOWFSDevicePath());
            }
    }

    private void checkForDeviceChanges() throws IOException {
        String[] devicesAddressStrings = client.getOWFSDevicePaths();
        if (devicesAddressStrings == null) {
            removeAllDevices();
            return;
        }
        boolean[] exists = new boolean[oneWireDeviceAddresses.size()];
        for (int i = 0; i < exists.length; i++) {
            exists[i] = false;
        }
        Vector toAdd = new Vector();
        for (int i = 0; i < devicesAddressStrings.length; i++) {
            if (!oneWireDeviceAddresses.contains(devicesAddressStrings[i])) {
                OneWireDevice newDevice;
                if (devicesAddressStrings[i].startsWith("01")) {
                    if (FULLY_READ_01_DEVICES) {
                        newDevice = getDevice(devicesAddressStrings[i], false);
                    } else {
                        newDevice = new OneWireContainer01();
                        String id = client.getIdFromOWFSDevicePath(devicesAddressStrings[i]);
                        String r_id = AddressUtils.idToReverseId(id);
                        newDevice.init(
                                OWFSClient.getOWFSRootPathFromOWFSDevicePath(devicesAddressStrings[i]),
                                client, null, null, null, "01", id, null, null, r_id, null, null);
                    }
                } else {
                    newDevice = getDevice(devicesAddressStrings[i], false);
                }
                if (newDevice != null) {
                    sendDeviceEvent(new OneWireDeviceChangedEvent(OneWireDeviceChangedEvent.DEVICE_APPEARED,
                            newDevice));
                    toAdd.add(newDevice);
                } else {
                    logger.debug("OneWireController.checkForDeviceChanges() device == null, dir = " +
                            devicesAddressStrings[i]);
                }
            } else {
                exists[oneWireDeviceAddresses.indexOf(devicesAddressStrings[i])] = true;
            }
        }
        Vector toRemove = new Vector();
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                sendDeviceEvent(new OneWireDeviceChangedEvent(OneWireDeviceChangedEvent.DEVICE_REMOVED, oneWireDevices.get(i)));
                toRemove.add(oneWireDevices.get(i));
            }
        }
        for (int i = 0; i < toRemove.size(); i++) {
            OneWireDevice old = (OneWireDevice) toRemove.get(i);
            oneWireDevices.remove(old);
            oneWireDeviceAddresses.remove(old.getOWFSDevicePath());
        }
        for (int i = 0; i < toAdd.size(); i++) {
            OneWireDevice newDevice = (OneWireDevice) toAdd.get(i);
            oneWireDevices.add(newDevice);
            oneWireDeviceAddresses.add(newDevice.getOWFSDevicePath());
        }
    }

    private OneWireDevice getDevice(String address, boolean unchached) throws UnknownHostException, IOException {
        return client.getDevice(address, unchached);
    }

    private void reportServerConnectionClosed() {
        connected = false;
        if ((updateThread != null) && (updateThread.isAlive())) {
            updateThread.interrupt();
            try {
                updateThread.join(500L);
            } catch (InterruptedException localInterruptedException) {
            }
        }
        removeAllDevices();
        startWaitForServerConnection();
    }

    private void removeAllDevices() {
        for (int i = 0; (oneWireDevices != null) && (i < oneWireDevices.size()); i++) {
            sendDeviceEvent(new OneWireDeviceChangedEvent(OneWireDeviceChangedEvent.DEVICE_REMOVED, oneWireDevices.get(i)));
        }
        oneWireDeviceAddresses.removeAllElements();
        oneWireDevices.removeAllElements();
    }

    private HashMap<String, Long> getDeviceChangedDirs() {
        return deviceChangedDirs;
    }

    public OWFSClient getOWFSClient() {
        return client;
    }

    public long getDeviceUpdateInterval() {
        return deviceUpdateInterval;
    }

    public void setDeviceUpdateInterval(long deviceUpdateInterval) {
        this.deviceUpdateInterval = deviceUpdateInterval;
    }

    public long getValueUpdateInterval() {
        return valueUpdateInterval;
    }

    public void setValueUpdateInterval(long valueUpdateInterval) {
        this.valueUpdateInterval = valueUpdateInterval;
    }

    private class AlarmListener {
        private OneWireEventListener listener;
        private int alarm_type;
        private String boundryValue;

        public AlarmListener(OneWireEventListener listener, int alarm_type, String boundryValue) {
            this.listener = listener;
            this.alarm_type = alarm_type;
            this.boundryValue = boundryValue;
        }
    }

    private class FileAlarmsMapping {
        private OneWireDevice device;
        private String fileName;
        private int expected_size;
        private String currentValue;
        private HashMap<Integer, AlarmListener> listenersMap;
        private int id = -1;

        public FileAlarmsMapping(OneWireDevice device, String fileName, int expected_size, String currentValue) {
            this.device = device;
            this.fileName = fileName;
            this.expected_size = expected_size;
            this.currentValue = currentValue;
            listenersMap = new HashMap();
        }

        public int addAlarmListener(AlarmListener listener) {
            id += 1;
            listenersMap.put(Integer.valueOf(id), listener);
            return id;
        }

        public void removeAlarmListener(int idKey) {
            listenersMap.remove(Integer.valueOf(idKey));
        }

        public int getExpectedSize() {
            return expected_size;
        }

        public int getAlarmType(int id) {
            return (listenersMap.get(Integer.valueOf(id))).alarm_type;
        }

        public void processAlarms(String newValueStr) {
            if (newValueStr == null) {
                logger.debug("OneWireController::FileAlarmsMapping: processAlarms, newValueStr == null",
                        9, 3);
                return;
            }
            boolean changed = !newValueStr.trim().equals(currentValue.trim());
            if (!changed) {
                return;
            }
            boolean parsedValue = false;
            String newValue = "-1";
            String oldValue = "-1";

            Iterator ids = listenersMap.keySet().iterator();
            while (ids.hasNext()) {
                int id = ((Integer) ids.next()).intValue();
                OneWireValueAlarmEvent event = new OneWireValueAlarmEvent(device, fileName, newValueStr, id);
                AlarmListener al = listenersMap.get(Integer.valueOf(id));
                if (al.alarm_type == OneWireValueAlarmEvent.ON_CHANGE) {
                    event.setAlarmType(OneWireValueAlarmEvent.ON_CHANGE);
                    al.listener.update(event);
                } else {
                    try {
                        String boundry = al.boundryValue;
                        if (!parsedValue) {
                            newValue = newValueStr;
                            oldValue = currentValue;
                            parsedValue = true;
                        }
                        DoubleStringCompare.compare(oldValue, boundry);
                        if ((al.alarm_type == OneWireValueAlarmEvent.ON_RISING) &&
                                (DoubleStringCompare.compare(oldValue, boundry) < 0) &&
                                (DoubleStringCompare.compare(newValue, boundry) >= 0)) {
                            event.setAlarmType(OneWireValueAlarmEvent.ON_RISING);
                            al.listener.update(event);
                        } else if ((al.alarm_type == OneWireValueAlarmEvent.ON_DECLINING) &&
                                (DoubleStringCompare.compare(oldValue, boundry) > 0) &&
                                (DoubleStringCompare.compare(newValue, boundry) <= 0)) {
                            event.setAlarmType(OneWireValueAlarmEvent.ON_DECLINING);
                            al.listener.update(event);
                        }
                    } catch (Exception localException) {
                    }
                }
            }
            currentValue = newValueStr;
        }
    }

    private class UpdateThread extends Thread {
        private long allDeviceUpdateTime;
        private long valueUpdateTime;
        private ArrayList<DirUpdateTime> singleDirUpdateTimes;

        public UpdateThread() {
            long current = System.currentTimeMillis();
            allDeviceUpdateTime = (current + OneWireController.this.getDeviceUpdateInterval());
            valueUpdateTime = (current + OneWireController.this.getValueUpdateInterval());
            singleDirUpdateTimes = new ArrayList();
            HashMap map = OneWireController.this.getDeviceChangedDirs();
            if (map != null) {
                Set dirs = map.keySet();
                Iterator itr = dirs.iterator();
                while (itr.hasNext()) {
                    String dir = (String) itr.next();
                    long interval = ((Long) map.get(dir)).longValue();
                    singleDirUpdateTimes.add(new DirUpdateTime(dir, interval, current + interval));
                }
            }
        }

        public void run() {
            while (OneWireController.this.running && OneWireController.this.connected && !isInterrupted())
                try {
                    long current = System.currentTimeMillis();
                    long minSleep = Long.MAX_VALUE;
                    for (int i = 0; i < singleDirUpdateTimes.size(); i++) {
                        DirUpdateTime dirUpdateTime = singleDirUpdateTimes.get(i);
                        if (current >= dirUpdateTime.updateTime) {
                            OneWireController.this.checkForSingleDirChanges(dirUpdateTime.dir);
                            dirUpdateTime.updateTime = (current + dirUpdateTime.updateInterval);
                        } else if (current - dirUpdateTime.updateTime < minSleep) {
                            minSleep = current - dirUpdateTime.updateTime;
                        }
                    }

                    if (current >= allDeviceUpdateTime) {
                        OneWireController.this.checkForDeviceChanges();
                        allDeviceUpdateTime = (current + OneWireController.this.getDeviceUpdateInterval());
                    }
                    if (current >= valueUpdateTime) {
                        OneWireController.this.checkForValueChanges();
                        valueUpdateTime = (current + OneWireController.this.getValueUpdateInterval());
                    }
                    long sleep = min(new long[]{minSleep, allDeviceUpdateTime - current,
                            valueUpdateTime - current});
                    if (sleep > 0L)
                        sleep(sleep);
                } catch (InterruptedException localInterruptedException) {
                } catch (UnknownHostException e) {
                    OneWireController.this.reportServerConnectionClosed();
                } catch (IOException e) {
                    OneWireController.this.reportServerConnectionClosed();
                }
        }

        private long min(long[] sleeps) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < sleeps.length; i++) {
                if (sleeps[i] < min) {
                    min = sleeps[i];
                }
            }
            return min;
        }

        private class DirUpdateTime {
            String dir;
            long updateTime;
            long updateInterval;

            public DirUpdateTime(String dir, long updateInterval, long updateTime) {
                this.dir = dir;
                this.updateInterval = updateInterval;
                this.updateTime = updateTime;
            }
        }
    }

    private class WaitForServerConnectionThread extends Thread {
        private WaitForServerConnectionThread() {
        }

        public void run() {
            while ((!OneWireController.this.connected) && (OneWireController.this.running) && (!isInterrupted())) {
                try {
                    if (OneWireController.this.client.checkForServerExistence()) {
                        OneWireController.this.reportServerConnectionOpened();
                    } else
                        sleep(5000L);
                } catch (InterruptedException localInterruptedException) {
                }
            }
        }
    }
}