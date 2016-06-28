package com.home.security.onewire;

import com.home.security.onewire.container.OneWireDevice;
import com.home.security.onewire.util.OneWireCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

public class OWFSClient {

    private final static Logger logger = LogManager.getLogger(OWFSClient.class.getName());

    private static final int VERSION = 0;
    private static final int TYPE_ERROR = 0;
    private static final int TYPE_NOP = 1;
    private static final int TYPE_READ = 2;
    private static final int TYPE_WRITE = 3;
    private static final int TYPE_DIR = 4;
    private static final int TYPE_SIZE = 5;
    private static final int TYPE_PRESENT = 6;
    private static final int TYPE_DIRALL = 7;
    private static final int TYPE_GET = 8;
    private static final int TYPE_DIRALLSLASH = 9;
    private static final int TYPE_GETSLASH = 10;
    private static final int FLAG_DEVICE_DISPLAY_F_I = 0;
    private static final int FLAG_DEVICE_DISPLAY_FI = 16777216;
    private static final int FLAG_DEVICE_DISPLAY_F_I_C = 33554432;
    private static final int FLAG_DEVICE_DISPLAY_F_IC = 50331648;
    private static final int FLAG_DEVICE_DISPLAY_FI_C = 67108864;
    private static final int FLAG_DEVICE_DISPLAY_FIC = 83886080;
    private static final int FLAG_TEMPERATURE_C = 0;
    private static final int FLAG_TEMPERATURE_F = 65536;
    private static final int FLAG_TEMPERATURE_K = 131072;
    private static final int FLAG_TEMPERATURE_R = 196608;
    private static final int FLAG_PRESSURE_MBAR = 0;
    private static final int FLAG_PRESSURE_ATM = 262144;
    private static final int FLAG_PRESSURE_MMHG = 524288;
    private static final int FLAG_PRESSURE_INHG = 786432;
    private static final int FLAG_PRESSURE_PSI = 1048576;
    private static final int FLAG_PRESSURE_PA = 1310720;
    private static final int FLAG_OWNET = 256;
    private static final int FLAG_SAFEMODE = 256;
    private static final int FLAG_ALIAS = 8;
    private static final int FLAG_PERSISTENCE = 4;
    private static final int FLAG_BUS_RET = 2;
    private static final int HEADER_LENGTH = 24;
    private static final String UNCACHED_DIR = "/uncached";
    private static final String NULL_TERMINATION = "";
    private String server_address;
    private int server_port;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private boolean persistence = false;

    public OWFSClient(String server_address, int server_port) {
        this.server_address = server_address;
        this.server_port = server_port;
    }

    public static String getOWFSRootPathFromOWFSDevicePath(String owfsDevicePath) {
        int index = -1;
        if (owfsDevicePath.charAt(owfsDevicePath.length() - 1) == '/') {
            owfsDevicePath = owfsDevicePath.substring(0, owfsDevicePath.length() - 1);
            index = owfsDevicePath.lastIndexOf('/');
        } else {
            index = owfsDevicePath.lastIndexOf('/');
        }
        if (index <= 0) {
            return "";
        }
        return owfsDevicePath.substring(0, index);
    }

    private static String typeToString(int type) {
        switch (type) {
            case 4:
                return "TYPE_DIR";
            case 7:
                return "TYPE_DIRALL";
            case 9:
                return "TYPE_DIRALLSLASH";
            case 0:
                return "TYPE_ERROR";
            case 8:
                return "TYPE_GET";
            case 10:
                return "TYPE_GETSLASH";
            case 1:
                return "TYPE_NOP";
            case 6:
                return "TYPE_PRESENT";
            case 2:
                return "TYPE_READ";
            case 5:
                return "TYPE_SIZE";
            case 3:
                return "TYPE_WRITE";
        }
        return null;
    }

    public String getServerAddress() {
        return server_address;
    }

    public int getServerPort() {
        return server_port;
    }

    public OneWireDevice[] init() throws IOException {
        String[] response = getOWFSDevicePaths();
        ArrayList deviceList = new ArrayList();
        for (int i = 0; i < response.length; i++) {
            OneWireDevice device = readDevice(response[i], false);
            if (device == null)
                logger.debug("OWFSClient.init() device == null, dir = " + response[i]);
            else {
                deviceList.add(device);
            }
        }
        OneWireDevice[] devices = new OneWireDevice[deviceList.size()];
        for (int i = 0; i < deviceList.size(); i++) {
            devices[i] = ((OneWireDevice) deviceList.get(i));
        }
        return devices;
    }

    public boolean checkForServerExistence() {
        try {
            socket = new Socket(InetAddress.getByName(server_address), server_port);
        } catch (UnknownHostException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return socket.isConnected();
    }

    public String[] getOWFSDevicePaths() throws IOException {
        ArrayList devicesList = addDevicesFromDir(new ArrayList(), "/");
        String[] devices = new String[devicesList.size()];
        for (int i = 0; i < devices.length; i++) {
            devices[i] = ((String) devicesList.get(i));
        }
        return devices;
    }

    public String[] getOWFSDevicePaths(String rootDir) throws IOException {
        ArrayList devicesList = addDevicesFromDir(new ArrayList(), rootDir);
        String[] devices = new String[devicesList.size()];
        for (int i = 0; i < devices.length; i++) {
            devices[i] = ((String) devicesList.get(i));
        }
        return devices;
    }

    private ArrayList<String> addDevicesFromDir(ArrayList<String> devices, String rootDir) throws IOException {
        String[] response = processRequest(rootDir, TYPE_DIRALL, 0, true);
        for (int i = 0; (response != null) && (i < response.length); i++) {
            if (response[i].substring(rootDir.length()).startsWith("1F")) {
                devices = addDevicesFromDir(devices, response[i] + "/aux/");
                devices = addDevicesFromDir(devices, response[i] + "/main/");
            } else {
                devices.add(response[i]);
            }
        }
        return devices;
    }

    private OneWireDevice readDevice(String owfsDevicePath, boolean uncached) throws IOException {
        HashMap map = new HashMap();
        readDir(owfsDevicePath, map, uncached);
        logger.debug("OWFSClient.readDevice() readDevice(" + owfsDevicePath + ", " + uncached + ")");
        String owfsRootPath = getOWFSRootPathFromOWFSDevicePath(owfsDevicePath);
        logger.debug("OWFSClient.readDevice() owfsRootPath: " + owfsRootPath);
        String baseDir = new String(owfsDevicePath).trim() + "/";
        logger.debug("OWFSClient.readDevice() baseDir: " + baseDir);
        String address = (String) map.get(baseDir + "address");
        logger.debug("OWFSClient.readDevice() address: " + address);
        String alias = (String) map.get(baseDir + "alias");
        logger.debug("OWFSClient.readDevice() alias: " + alias);
        String crc8 = (String) map.get(baseDir + "crc8");
        logger.debug("OWFSClient.readDevice() crc8: " + crc8);
        String family = (String) map.get(baseDir + "family");
        logger.debug("OWFSClient.readDevice() family: " + family);
        String id = (String) map.get(baseDir + "id");
        logger.debug("OWFSClient.readDevice() id: " + id);
        String locator = (String) map.get(baseDir + "locator");
        logger.debug("OWFSClient.readDevice() locator: " + locator);
        String r_address = (String) map.get(baseDir + "r_address");
        logger.debug("OWFSClient.readDevice() r_address: " + r_address);
        String r_id = (String) map.get(baseDir + "r_id");
        logger.debug("OWFSClient.readDevice() r_id: " + r_id);
        String r_locator = (String) map.get(baseDir + "r_locator");
        logger.debug("OWFSClient.readDevice() r_locator: " + r_locator);
        String type = (String) map.get(baseDir + "type");
        logger.debug("OWFSClient.readDevice() type: " + type);
        if (family == null) {
            logger.debug("OWFSClient.readDevice() readDevice(" + owfsDevicePath + ", " + uncached + "), family ==  null");
            return null;
        }
        OneWireDevice device = null;
        device = OneWireCreator.createDevice(family);
        if (device == null) {
            logger.debug("OWFSClient.readDevice() OneWireCreator.createDevice(" + family + ") returned null");
            return null;
        }
        device.init(owfsRootPath, this, address, alias, crc8, family, id, locator, r_address, r_id,
                r_locator, type);
        return device;
    }

    private byte[] createRequest(int version, int payload_len, int type, int flag, int expected_size, int offset, String payload, String tokens, boolean uncached, boolean nullterminated) {
        int extra_len = (tokens == null) || (tokens.length() == 0) ? 0 : tokens.length() + 1;
        if ((payload_len > 0) && (nullterminated)) {
            payload_len++;
        }

        if (uncached) {
            payload_len += UNCACHED_DIR.length();
        }
        ByteBuffer buffer = ByteBuffer.allocate(HEADER_LENGTH + payload_len + extra_len);
        logger.debug("OWFSClient.createRequest() version:" + version);
        buffer.putInt(version);
        logger.debug("OWFSClient.createRequest() payload_len:" + payload_len);
        buffer.putInt(payload_len);
        logger.debug("OWFSClient.createRequest() type:" + type + " (" + typeToString(type) + ")");
        buffer.putInt(type);
        logger.debug("OWFSClient.createRequest() flag:" + flag);
        buffer.putInt(flag);
        logger.debug("OWFSClient.createRequest() expected_size:" + expected_size);
        buffer.putInt(expected_size);
        logger.debug("OWFSClient.createRequest() offset:" + offset);
        buffer.putInt(offset);
        if ((payload != null) && (payload.length() > 0)) {
            logger.debug("OWFSClient.createRequest() payload:");
            if (uncached) {
                logger.debug("OWFSClient.createRequest() /uncached");
                buffer.put(UNCACHED_DIR.getBytes());
            }
            logger.debug("OWFSClient.createRequest() " + payload);
            if (nullterminated)
                buffer.put((payload + NULL_TERMINATION).getBytes());
            else {
                buffer.put(payload.getBytes());
            }
        }
        if ((tokens != null) && (tokens.length() > 0)) {
            buffer.put(tokens.getBytes());
        }
        return buffer.array();
    }

    public String getFamilyFromOWFSFilePath(String owfsFilePath) {
        if (owfsFilePath.startsWith("/1F")) {
            int slashFamDotIdLength = 16;
            if (owfsFilePath.substring(slashFamDotIdLength).startsWith("/aux"))
                return getFamilyFromOWFSFilePath(owfsFilePath
                        .substring(slashFamDotIdLength + "/aux".length()));
            if (owfsFilePath.substring(slashFamDotIdLength).startsWith("/main")) {
                return getFamilyFromOWFSFilePath(owfsFilePath.substring(slashFamDotIdLength +
                        "/main".length()));
            }
        }
        return owfsFilePath.substring(1, 3);
    }

    public String getFamilyFromOWFSDevicePath(String owfsDevicePath) {
        int dotIndex = owfsDevicePath.lastIndexOf('.');
        return owfsDevicePath.substring(dotIndex - 2, dotIndex);
    }

    public String getIdFromOWFSDevicePath(String owfsDevicePath) {
        int dotIndex = owfsDevicePath.lastIndexOf('.');
        return owfsDevicePath.substring(dotIndex, dotIndex + 12);
    }

    private String getFilePathFromCompletePath(String path) {
        if (path.startsWith("/1F")) {
            int slashFamDotIdLength = 16;
            if (path.substring(slashFamDotIdLength).startsWith("/aux"))
                return getFilePathFromCompletePath(path.substring(slashFamDotIdLength + "/aux".length()));
            if (path.substring(slashFamDotIdLength).startsWith("/main")) {
                return getFilePathFromCompletePath(path.substring(slashFamDotIdLength + "/main".length()));
            }
        }
        return path.substring(17);
    }

    private void readDir(String fileName, HashMap<String, String> map, boolean uncached) throws IOException {
        String[] dirResponse = processRequest(fileName, TYPE_DIRALLSLASH, 0, uncached);
        if (dirResponse == null) {
            logger.debug("OWFSClient.readDir() no directory entries where found at: " + fileName);
            return;
        }
        for (int i = 0; i < dirResponse.length; i++)
            if (dirResponse[i].charAt(dirResponse[i].length() - 1) == '/') {
                readDir(dirResponse[i], map, uncached);
            } else {
                int expected_size = OneWireCreator.pathToSize(getFamilyFromOWFSFilePath(dirResponse[i]),
                        getFilePathFromCompletePath(dirResponse[i]));
                String[] readResponse = processRequest(dirResponse[i], TYPE_READ, expected_size, uncached);
                String value = "";
                for (int ii = 0; (readResponse != null) && (ii < readResponse.length); ii++) {
                    if (ii == readResponse.length - 1)
                        value = value + readResponse[ii];
                    else {
                        value = value + readResponse[ii] + ",";
                    }
                }
                if (readResponse != null)
                    map.put(new String(dirResponse[i]).trim(), value);
            }
    }

    public String readValue(String fileName, int expected_size, boolean uncached)
            throws IOException {
        String[] response = processRequest(fileName, TYPE_READ, expected_size, uncached);
        for (int i = 0; i < response.length; i++) {
            logger.debug("OWFSClient.readValue() readValue(" + fileName + ") RETURNS " + i + ": " + response[i]);
        }
        return response != null ? response[0] : null;
    }

    public void writeValue(String fileName, String value, int expected_size)
            throws IOException {
        String padding = "";
        if (expected_size != value.length()) {
            for (int i = 0; i < expected_size - value.length(); i++) {
                padding = padding + " ";
            }
        }
        processRequest(fileName + "" + padding + value, TYPE_WRITE, expected_size, false);
    }

    private synchronized String[] processRequest(String payload, int type, int expected_size, boolean uncached)
            throws IOException {
        byte[] requestPacket;
        if (type == TYPE_WRITE)
            requestPacket = createRequest(VERSION, payload.length(), type, 260,
                    expected_size, 0, payload, null, uncached, false);
        else {
            requestPacket = createRequest(VERSION, payload.length(), type, 260,
                    expected_size, 0, payload, null, uncached, true);
        }
        if ((persistence) && (socket != null)) {
            out.write(requestPacket);
            out.flush();
        } else {
            if ((socket != null) && (socket.isConnected())) {
                socket.close();
            }
            socket = new Socket(InetAddress.getByName(server_address), server_port);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(requestPacket);
            out.flush();
        }
        String[] response = null;
        try {
            response = receiveResponse();
        } catch (OneWireException e) {
            printRequest(requestPacket);
            if (type == 2) {
                try {
                    response = receiveResponse();
                } catch (OneWireException e1) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return response;
    }

    private void printRequest(byte[] requestPacket) {
        ByteBuffer buffer = ByteBuffer.wrap(requestPacket);
        logger.debug("OWFSClient.printRequest() Version: " + Integer.toHexString(buffer.getInt()));
        int payload_len = buffer.getInt();
        logger.debug("OWFSClient.printRequest() Payload length: " + Integer.toHexString(payload_len));
        logger.debug("OWFSClient.printRequest() Type: " + Integer.toHexString(buffer.getInt()));
        logger.debug("OWFSClient.printRequest() Flag: " + Integer.toHexString(buffer.getInt()));
        logger.debug("OWFSClient.printRequest() Expected size: " + buffer.getInt());
        int offset = buffer.getInt();
        logger.debug("OWFSClient.printRequest() Offset: " + offset);
        if (payload_len > 0) {
            byte[] payload = new byte[payload_len];
            buffer.get(payload);
            logger.debug("OWFSClient.printRequest() Payload:" + new String(payload));
            for (int i = 0; i < payload.length; i++)
                logger.debug("OWFSClient.printRequest() [" + i + "]:0x" + Integer.toHexString(payload[i]) + " ");
        }
    }

    private String[] receiveResponse() throws IOException, OneWireException {
        byte[] header = new byte[HEADER_LENGTH];

        int offset = 0;
        int read;
        while (((read = in.read(header, offset, header.length - offset)) != -1) && (offset < header.length)) {
            offset += read;
        }
        if (offset != header.length) {
            logger.debug("OWFSClient.receiveResponse() total read != HEADER_LENGTH, total read = " + offset + ", last read = " + read);
            if (read > 0) {
                logger.debug("OWFSClient.receiveResponse() response: " + new String(header, 0, offset));
            }
            return null;
        }
        ByteBuffer buffer = ByteBuffer.wrap(header);
        int version = buffer.getInt();
        logger.debug("OWFSClient.receiveResponse() Version: " + version);
        int payload_len = buffer.getInt();
        logger.debug("OWFSClient.receiveResponse() Payload length: " + payload_len);
        int return_value = buffer.getInt();
        logger.debug("OWFSClient.receiveResponse() Return value: " + Integer.toHexString(return_value));
        int flag = buffer.getInt();
        persistence = ((flag & 0x4) > 0);
        logger.debug("OWFSClient.receiveResponse() Flag: " + Integer.toHexString(flag));
        int size = buffer.getInt();
        logger.debug("OWFSClient.receiveResponse() Size: " + size);
        offset = buffer.getInt();
        logger.debug("OWFSClient.receiveResponse() Offset: " + offset);

        byte[] payload;
        if (payload_len > 0) {
            payload = new byte[payload_len];
            in.read(payload);
        } else {
            if (payload_len == -1) {
                throw new OneWireException("payload_len == -1");
            }
            return null;
        }

        String payloadStr = new String(payload).trim();
        if (payloadStr.startsWith(UNCACHED_DIR))
            payloadStr = payloadStr.replaceAll(UNCACHED_DIR, "");
        String[] response;
        if (payloadStr.indexOf(',') != -1)
            response = payloadStr.split(",");
        else {
            response = new String[]{payloadStr};
        }
        printResponse(header, response);
        return response;
    }

    private void printResponse(byte[] header, String[] payload) {
        ByteBuffer buffer = ByteBuffer.wrap(header);
        logger.debug("OWFSClient.printResponse() Version: " + buffer.getInt());
        int payload_len = buffer.getInt();
        logger.debug("OWFSClient.printResponse() Payload length: " + payload_len);
        logger.debug("OWFSClient.printResponse() Return value: " + Integer.toHexString(buffer.getInt()));
        logger.debug("OWFSClient.printResponse() Flag: " + Integer.toHexString(buffer.getInt()));
        logger.debug("OWFSClient.printResponse() Size: " + buffer.getInt());
        int offset = buffer.getInt();
        logger.debug("OWFSClient.printResponse() Offset: " + offset);
        if (payload != null) {
            logger.debug("OWFSClient.printResponse() Payload:");
            for (int i = 0; i < payload.length; i++)
                logger.debug("OWFSClient.printResponse() payload[" + i + "]:" + payload[i]);
        }
    }

    public OneWireDevice getDevice(String owfsDevicePath, boolean uncached)
            throws IOException {
        return readDevice(owfsDevicePath, uncached);
    }
}