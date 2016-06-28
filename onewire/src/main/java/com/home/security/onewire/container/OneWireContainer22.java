package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer22 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_22_ERRATA_DIE = "errata/die";
    private static String FAM_22_ERRATA_TRIM = "errata/trim";
    private static String FAM_22_LOCATOR = "locator";
    private static String FAM_22_R_ID = "r_id";
    private static String FAM_22_TEMPERATURE9 = "temperature9";
    private static String FAM_22_ALIAS = "alias";
    private static String FAM_22_ERRATA_TRIMVALID = "errata/trimvalid";
    private static String FAM_22_R_ADDRESS = "r_address";
    private static String FAM_22_R_LOCATOR = "r_locator";
    private static String FAM_22_TYPE = "type";
    private static String FAM_22_TEMPLOW = "templow";
    private static String FAM_22_TEMPERATURE = "temperature";
    private static String FAM_22_ID = "id";
    private static String FAM_22_TEMPERATURE10 = "temperature10";
    private static String FAM_22_TEMPHIGH = "temphigh";
    private static String FAM_22_TEMPERATURE12 = "temperature12";
    private static String FAM_22_TEMPERATURE11 = "temperature11";
    private static String FAM_22_ADDRESS = "address";
    private static String FAM_22_FAMILY = "family";
    private static String FAM_22_FASTTEMP = "fasttemp";
    private static String FAM_22_CRC8 = "crc8";
    private static String FAM_22_POWER = "power";
    private static String FAM_22_ERRATA_TRIMBLANKET = "errata/trimblanket";
    private static int FAM_22_ERRATA_DIE_SIZE = 2;
    private static int FAM_22_ERRATA_TRIM_SIZE = 12;
    private static int FAM_22_LOCATOR_SIZE = 16;
    private static int FAM_22_R_ID_SIZE = 12;
    private static int FAM_22_TEMPERATURE9_SIZE = 12;
    private static int FAM_22_ALIAS_SIZE = 256;
    private static int FAM_22_ERRATA_TRIMVALID_SIZE = 1;
    private static int FAM_22_R_ADDRESS_SIZE = 16;
    private static int FAM_22_R_LOCATOR_SIZE = 16;
    private static int FAM_22_TYPE_SIZE = 32;
    private static int FAM_22_TEMPLOW_SIZE = 12;
    private static int FAM_22_TEMPERATURE_SIZE = 12;
    private static int FAM_22_ID_SIZE = 12;
    private static int FAM_22_TEMPERATURE10_SIZE = 12;
    private static int FAM_22_TEMPHIGH_SIZE = 12;
    private static int FAM_22_TEMPERATURE12_SIZE = 12;
    private static int FAM_22_TEMPERATURE11_SIZE = 12;
    private static int FAM_22_ADDRESS_SIZE = 16;
    private static int FAM_22_FAMILY_SIZE = 2;
    private static int FAM_22_FASTTEMP_SIZE = 12;
    private static int FAM_22_CRC8_SIZE = 2;
    private static int FAM_22_POWER_SIZE = 1;
    private static int FAM_22_ERRATA_TRIMBLANKET_SIZE = 1;

    public OneWireContainer22() {
    }

    public OneWireContainer22(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_22_ERRATA_DIE))
            return FAM_22_ERRATA_DIE_SIZE;
        if (path.equals(FAM_22_ERRATA_TRIM))
            return FAM_22_ERRATA_TRIM_SIZE;
        if (path.equals(FAM_22_LOCATOR))
            return FAM_22_LOCATOR_SIZE;
        if (path.equals(FAM_22_R_ID))
            return FAM_22_R_ID_SIZE;
        if (path.equals(FAM_22_TEMPERATURE9))
            return FAM_22_TEMPERATURE9_SIZE;
        if (path.equals(FAM_22_ALIAS))
            return FAM_22_ALIAS_SIZE;
        if (path.equals(FAM_22_ERRATA_TRIMVALID))
            return FAM_22_ERRATA_TRIMVALID_SIZE;
        if (path.equals(FAM_22_R_ADDRESS))
            return FAM_22_R_ADDRESS_SIZE;
        if (path.equals(FAM_22_R_LOCATOR))
            return FAM_22_R_LOCATOR_SIZE;
        if (path.equals(FAM_22_TYPE))
            return FAM_22_TYPE_SIZE;
        if (path.equals(FAM_22_TEMPLOW))
            return FAM_22_TEMPLOW_SIZE;
        if (path.equals(FAM_22_TEMPERATURE))
            return FAM_22_TEMPERATURE_SIZE;
        if (path.equals(FAM_22_ID))
            return FAM_22_ID_SIZE;
        if (path.equals(FAM_22_TEMPERATURE10))
            return FAM_22_TEMPERATURE10_SIZE;
        if (path.equals(FAM_22_TEMPHIGH))
            return FAM_22_TEMPHIGH_SIZE;
        if (path.equals(FAM_22_TEMPERATURE12))
            return FAM_22_TEMPERATURE12_SIZE;
        if (path.equals(FAM_22_TEMPERATURE11))
            return FAM_22_TEMPERATURE11_SIZE;
        if (path.equals(FAM_22_ADDRESS))
            return FAM_22_ADDRESS_SIZE;
        if (path.equals(FAM_22_FAMILY))
            return FAM_22_FAMILY_SIZE;
        if (path.equals(FAM_22_FASTTEMP))
            return FAM_22_FASTTEMP_SIZE;
        if (path.equals(FAM_22_CRC8))
            return FAM_22_CRC8_SIZE;
        if (path.equals(FAM_22_POWER))
            return FAM_22_POWER_SIZE;
        if (path.equals(FAM_22_ERRATA_TRIMBLANKET)) {
            return FAM_22_ERRATA_TRIMBLANKET_SIZE;
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