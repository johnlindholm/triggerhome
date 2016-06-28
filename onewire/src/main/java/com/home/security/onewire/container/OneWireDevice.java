package com.home.security.onewire.container;

import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.AbstractService;
import com.home.security.onewire.OWFSClient;
import com.home.security.onewire.util.OneWireCreator;

import java.io.IOException;

public abstract class OneWireDevice extends AbstractService {
    public static final String LABEL_ADDRESS = "address";
    public static final String LABEL_ALIAS = "alias";
    public static final String LABEL_CRC8 = "crc8";
    public static final String LABEL_FAMILY = "family";
    public static final String LABEL_ID = "id";
    public static final String LABEL_LOCATOR = "locator";
    public static final String LABEL_R_ADDRESS = "r_address";
    public static final String LABEL_R_ID = "r_id";
    public static final String LABEL_R_LOCATOR = "r_locator";
    public static final String LABEL_TYPE = "type";
    private String address;
    private String alias;
    private String crc8;
    private String family;
    private String id;
    private String locator;
    private String r_address;
    private String r_id;
    private String r_locator;
    private String type;
    private OWFSClient owfsClient;
    private String owfsRootPath;

    public OneWireDevice() {
        super("name", "1.0", null, null);
    }

    public OneWireDevice(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(null, null, null, null);
        this.owfsClient = owfsClient;
        this.address = address;
        this.alias = alias;
        this.crc8 = crc8;
        this.family = family;
        this.id = id;
        this.locator = locator;
        this.r_address = r_address;
        this.r_id = r_id;
        this.r_locator = r_locator;
        this.type = type;
    }

    public void init(String owfsRootPath, OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        this.owfsRootPath = owfsRootPath;
        this.owfsClient = owfsClient;
        this.address = address;
        this.alias = alias;
        this.crc8 = crc8;
        this.family = family;
        this.id = id;
        this.locator = locator;
        this.r_address = r_address;
        this.r_id = r_id;
        this.r_locator = r_locator;
        this.type = type;
    }

    public String getOWFSPath(String fileName) {
        return getOWFSDevicePath() + "/" + fileName;
    }

    public String getOWFSRootPath() {
        return this.owfsRootPath;
    }

    public String getOWFSDevicePath() {
        return getOWFSRootPath() + "/" + this.family + "." + this.id;
    }

    protected String readValue(String fileName, boolean uncached)
            throws IOException {
        int expected_size = OneWireCreator.pathToSize(this.family, fileName);
        String response = null;
        response = this.owfsClient.readValue(getOWFSPath(fileName), expected_size, true);
        return response;
    }

    protected void writeValue(String fileName, String value) throws IOException {
        int expected_size = OneWireCreator.pathToSize(this.family, fileName);
        this.owfsClient.writeValue(getOWFSPath(fileName), value, expected_size);
    }

    public void print() {
        System.out.println("------- Device -------");
        System.out.println("[] address: " + this.address);
        System.out.println("[] alias: " + this.alias);
        System.out.println("[] crc8: " + this.crc8);
        System.out.println("[] family: " + this.family);
        System.out.println("[] id: " + this.id);
        System.out.println("[] locator: " + this.locator);
        System.out.println("[] r_address: " + this.r_address);
        System.out.println("[] r_id: " + this.r_id);
        System.out.println("[] r_locator: " + this.r_locator);
        System.out.println("[] type: " + this.type);
    }

    public String getAddress() {
        return this.address;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCrc8() {
        return this.crc8;
    }

    public String getFamily() {
        return this.family;
    }

    public String getId() {
        return this.id;
    }

    public String getLocator() {
        return this.locator;
    }

    public String getR_address() {
        return this.r_address;
    }

    public String getR_id() {
        return this.r_id;
    }

    public String getR_locator() {
        return this.r_locator;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public void handleResponse(Response response) {

    }

    @Override
    public void stop() {

    }
}