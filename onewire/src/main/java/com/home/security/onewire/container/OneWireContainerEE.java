package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainerEE extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_EE_LOCATOR = "locator";
    private static String FAM_EE_UVI_UVI = "UVI/UVI";
    private static String FAM_EE_R_ID = "r_id";
    private static String FAM_EE_TYPE_NUMBER = "type_number";
    private static String FAM_EE_ALIAS = "alias";
    private static String FAM_EE_R_ADDRESS = "r_address";
    private static String FAM_EE_R_LOCATOR = "r_locator";
    private static String FAM_EE_TYPE = "type";
    private static String FAM_EE_UVI_UVI_OFFSET = "UVI/UVI_offset";
    private static String FAM_EE_UVI_IN_CASE = "UVI/in_case";
    private static String FAM_EE_VERSION = "version";
    private static String FAM_EE_TEMPERATURE = "temperature";
    private static String FAM_EE_TEMPERATURE_OFFSET = "temperature_offset";
    private static String FAM_EE_ID = "id";
    private static String FAM_EE_UVI_VALID = "UVI/valid";
    private static String FAM_EE_ADDRESS = "address";
    private static String FAM_EE_FAMILY = "family";
    private static String FAM_EE_CRC8 = "crc8";
    private static int FAM_EE_LOCATOR_SIZE = 16;
    private static int FAM_EE_UVI_UVI_SIZE = 12;
    private static int FAM_EE_R_ID_SIZE = 12;
    private static int FAM_EE_TYPE_NUMBER_SIZE = 12;
    private static int FAM_EE_ALIAS_SIZE = 256;
    private static int FAM_EE_R_ADDRESS_SIZE = 16;
    private static int FAM_EE_R_LOCATOR_SIZE = 16;
    private static int FAM_EE_TYPE_SIZE = 32;
    private static int FAM_EE_UVI_UVI_OFFSET_SIZE = 12;
    private static int FAM_EE_UVI_IN_CASE_SIZE = 1;
    private static int FAM_EE_VERSION_SIZE = 5;
    private static int FAM_EE_TEMPERATURE_SIZE = 12;
    private static int FAM_EE_TEMPERATURE_OFFSET_SIZE = 12;
    private static int FAM_EE_ID_SIZE = 12;
    private static int FAM_EE_UVI_VALID_SIZE = 1;
    private static int FAM_EE_ADDRESS_SIZE = 16;
    private static int FAM_EE_FAMILY_SIZE = 2;
    private static int FAM_EE_CRC8_SIZE = 2;

    public OneWireContainerEE() {
    }

    public OneWireContainerEE(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_EE_LOCATOR))
            return FAM_EE_LOCATOR_SIZE;
        if (path.equals(FAM_EE_UVI_UVI))
            return FAM_EE_UVI_UVI_SIZE;
        if (path.equals(FAM_EE_R_ID))
            return FAM_EE_R_ID_SIZE;
        if (path.equals(FAM_EE_TYPE_NUMBER))
            return FAM_EE_TYPE_NUMBER_SIZE;
        if (path.equals(FAM_EE_ALIAS))
            return FAM_EE_ALIAS_SIZE;
        if (path.equals(FAM_EE_R_ADDRESS))
            return FAM_EE_R_ADDRESS_SIZE;
        if (path.equals(FAM_EE_R_LOCATOR))
            return FAM_EE_R_LOCATOR_SIZE;
        if (path.equals(FAM_EE_TYPE))
            return FAM_EE_TYPE_SIZE;
        if (path.equals(FAM_EE_UVI_UVI_OFFSET))
            return FAM_EE_UVI_UVI_OFFSET_SIZE;
        if (path.equals(FAM_EE_UVI_IN_CASE))
            return FAM_EE_UVI_IN_CASE_SIZE;
        if (path.equals(FAM_EE_VERSION))
            return FAM_EE_VERSION_SIZE;
        if (path.equals(FAM_EE_TEMPERATURE))
            return FAM_EE_TEMPERATURE_SIZE;
        if (path.equals(FAM_EE_TEMPERATURE_OFFSET))
            return FAM_EE_TEMPERATURE_OFFSET_SIZE;
        if (path.equals(FAM_EE_ID))
            return FAM_EE_ID_SIZE;
        if (path.equals(FAM_EE_UVI_VALID))
            return FAM_EE_UVI_VALID_SIZE;
        if (path.equals(FAM_EE_ADDRESS))
            return FAM_EE_ADDRESS_SIZE;
        if (path.equals(FAM_EE_FAMILY))
            return FAM_EE_FAMILY_SIZE;
        if (path.equals(FAM_EE_CRC8)) {
            return FAM_EE_CRC8_SIZE;
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