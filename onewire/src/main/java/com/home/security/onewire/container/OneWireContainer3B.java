package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer3B extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_3B_LOCATOR = "locator";
    private static String FAM_3B_R_ID = "r_id";
    private static String FAM_3B_TEMPERATURE9 = "temperature9";
    private static String FAM_3B_ALIAS = "alias";
    private static String FAM_3B_R_ADDRESS = "r_address";
    private static String FAM_3B_R_LOCATOR = "r_locator";
    private static String FAM_3B_TYPE = "type";
    private static String FAM_3B_TEMPLOW = "templow";
    private static String FAM_3B_TEMPERATURE = "temperature";
    private static String FAM_3B_ID = "id";
    private static String FAM_3B_TEMPERATURE10 = "temperature10";
    private static String FAM_3B_TEMPHIGH = "temphigh";
    private static String FAM_3B_TEMPERATURE12 = "temperature12";
    private static String FAM_3B_TEMPERATURE11 = "temperature11";
    private static String FAM_3B_ADDRESS = "address";
    private static String FAM_3B_FAMILY = "family";
    private static String FAM_3B_FASTTEMP = "fasttemp";
    private static String FAM_3B_PROG_ADDR = "prog_addr";
    private static String FAM_3B_CRC8 = "crc8";
    private static String FAM_3B_POWER = "power";
    private static int FAM_3B_LOCATOR_SIZE = 16;
    private static int FAM_3B_R_ID_SIZE = 12;
    private static int FAM_3B_TEMPERATURE9_SIZE = 12;
    private static int FAM_3B_ALIAS_SIZE = 256;
    private static int FAM_3B_R_ADDRESS_SIZE = 16;
    private static int FAM_3B_R_LOCATOR_SIZE = 16;
    private static int FAM_3B_TYPE_SIZE = 32;
    private static int FAM_3B_TEMPLOW_SIZE = 12;
    private static int FAM_3B_TEMPERATURE_SIZE = 12;
    private static int FAM_3B_ID_SIZE = 12;
    private static int FAM_3B_TEMPERATURE10_SIZE = 12;
    private static int FAM_3B_TEMPHIGH_SIZE = 12;
    private static int FAM_3B_TEMPERATURE12_SIZE = 12;
    private static int FAM_3B_TEMPERATURE11_SIZE = 12;
    private static int FAM_3B_ADDRESS_SIZE = 16;
    private static int FAM_3B_FAMILY_SIZE = 2;
    private static int FAM_3B_FASTTEMP_SIZE = 12;
    private static int FAM_3B_PROG_ADDR_SIZE = 12;
    private static int FAM_3B_CRC8_SIZE = 2;
    private static int FAM_3B_POWER_SIZE = 1;

    public OneWireContainer3B() {
    }

    public OneWireContainer3B(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_3B_LOCATOR))
            return FAM_3B_LOCATOR_SIZE;
        if (path.equals(FAM_3B_R_ID))
            return FAM_3B_R_ID_SIZE;
        if (path.equals(FAM_3B_TEMPERATURE9))
            return FAM_3B_TEMPERATURE9_SIZE;
        if (path.equals(FAM_3B_ALIAS))
            return FAM_3B_ALIAS_SIZE;
        if (path.equals(FAM_3B_R_ADDRESS))
            return FAM_3B_R_ADDRESS_SIZE;
        if (path.equals(FAM_3B_R_LOCATOR))
            return FAM_3B_R_LOCATOR_SIZE;
        if (path.equals(FAM_3B_TYPE))
            return FAM_3B_TYPE_SIZE;
        if (path.equals(FAM_3B_TEMPLOW))
            return FAM_3B_TEMPLOW_SIZE;
        if (path.equals(FAM_3B_TEMPERATURE))
            return FAM_3B_TEMPERATURE_SIZE;
        if (path.equals(FAM_3B_ID))
            return FAM_3B_ID_SIZE;
        if (path.equals(FAM_3B_TEMPERATURE10))
            return FAM_3B_TEMPERATURE10_SIZE;
        if (path.equals(FAM_3B_TEMPHIGH))
            return FAM_3B_TEMPHIGH_SIZE;
        if (path.equals(FAM_3B_TEMPERATURE12))
            return FAM_3B_TEMPERATURE12_SIZE;
        if (path.equals(FAM_3B_TEMPERATURE11))
            return FAM_3B_TEMPERATURE11_SIZE;
        if (path.equals(FAM_3B_ADDRESS))
            return FAM_3B_ADDRESS_SIZE;
        if (path.equals(FAM_3B_FAMILY))
            return FAM_3B_FAMILY_SIZE;
        if (path.equals(FAM_3B_FASTTEMP))
            return FAM_3B_FASTTEMP_SIZE;
        if (path.equals(FAM_3B_PROG_ADDR))
            return FAM_3B_PROG_ADDR_SIZE;
        if (path.equals(FAM_3B_CRC8))
            return FAM_3B_CRC8_SIZE;
        if (path.equals(FAM_3B_POWER)) {
            return FAM_3B_POWER_SIZE;
        }
        return -1;
    }

    public String getTemperature()
            throws IOException {
        return readValue("temperature", true);
    }

    public boolean hasTemperatureResolution() {
        return true;
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