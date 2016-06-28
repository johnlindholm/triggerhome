package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer1B extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_1B_VOLTS = "volts";
    private static String FAM_1B_LOCATOR = "locator";
    private static String FAM_1B_R_ID = "r_id";
    private static String FAM_1B_ALIAS = "alias";
    private static String FAM_1B_R_ADDRESS = "r_address";
    private static String FAM_1B_R_LOCATOR = "r_locator";
    private static String FAM_1B_TYPE = "type";
    private static String FAM_1B_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_1B_TEMPERATURE = "temperature";
    private static String FAM_1B_ID = "id";
    private static String FAM_1B_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_1B_ADDRESS = "address";
    private static String FAM_1B_FAMILY = "family";
    private static String FAM_1B_CRC8 = "crc8";
    private static int FAM_1B_VOLTS_SIZE = 12;
    private static int FAM_1B_LOCATOR_SIZE = 16;
    private static int FAM_1B_R_ID_SIZE = 12;
    private static int FAM_1B_ALIAS_SIZE = 256;
    private static int FAM_1B_R_ADDRESS_SIZE = 16;
    private static int FAM_1B_R_LOCATOR_SIZE = 16;
    private static int FAM_1B_TYPE_SIZE = 32;
    private static int FAM_1B_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_1B_TEMPERATURE_SIZE = 12;
    private static int FAM_1B_ID_SIZE = 12;
    private static int FAM_1B_PAGES_PAGE_ALL_SIZE = 96;
    private static int FAM_1B_ADDRESS_SIZE = 16;
    private static int FAM_1B_FAMILY_SIZE = 2;
    private static int FAM_1B_CRC8_SIZE = 2;

    public OneWireContainer1B() {
    }

    public OneWireContainer1B(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_1B_VOLTS))
            return FAM_1B_VOLTS_SIZE;
        if (path.equals(FAM_1B_LOCATOR))
            return FAM_1B_LOCATOR_SIZE;
        if (path.equals(FAM_1B_R_ID))
            return FAM_1B_R_ID_SIZE;
        if (path.equals(FAM_1B_ALIAS))
            return FAM_1B_ALIAS_SIZE;
        if (path.equals(FAM_1B_R_ADDRESS))
            return FAM_1B_R_ADDRESS_SIZE;
        if (path.equals(FAM_1B_R_LOCATOR))
            return FAM_1B_R_LOCATOR_SIZE;
        if (path.equals(FAM_1B_TYPE))
            return FAM_1B_TYPE_SIZE;
        if (path.equals(FAM_1B_PAGES_PAGE_0))
            return FAM_1B_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_1B_TEMPERATURE))
            return FAM_1B_TEMPERATURE_SIZE;
        if (path.equals(FAM_1B_ID))
            return FAM_1B_ID_SIZE;
        if (path.equals(FAM_1B_PAGES_PAGE_ALL))
            return FAM_1B_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_1B_ADDRESS))
            return FAM_1B_ADDRESS_SIZE;
        if (path.equals(FAM_1B_FAMILY))
            return FAM_1B_FAMILY_SIZE;
        if (path.equals(FAM_1B_CRC8)) {
            return FAM_1B_CRC8_SIZE;
        }
        return -1;
    }

    public String getTemperature()
            throws IOException {
        return readValue("temperature", true);
    }

    public boolean hasTemperatureResolution() {
        return false;
    }

    public String getTemperatureHigh()
            throws IOException {
        if (!hasTemperatureResolution()) return null;
        return readValue("temphigh", true);
    }

    public void setTemperatureHigh(String temphigh)
            throws IOException {
        if (!hasTemperatureResolution()) return;
        writeValue("temphigh", temphigh);
    }

    public String getTemperatureLow()
            throws IOException {
        if (!hasTemperatureResolution()) return null;
        return readValue("templow", true);
    }

    public void setTemperatureLow(String templow)
            throws IOException {
        if (!hasTemperatureResolution()) return;
        writeValue("templow", templow);
    }
}