package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer28 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_28_ERRATA_DIE = "errata/die";
    private static String FAM_28_ERRATA_TRIM = "errata/trim";
    private static String FAM_28_LOCATOR = "locator";
    private static String FAM_28_R_ID = "r_id";
    private static String FAM_28_TEMPERATURE9 = "temperature9";
    private static String FAM_28_ALIAS = "alias";
    private static String FAM_28_ERRATA_TRIMVALID = "errata/trimvalid";
    private static String FAM_28_R_ADDRESS = "r_address";
    private static String FAM_28_R_LOCATOR = "r_locator";
    private static String FAM_28_TYPE = "type";
    private static String FAM_28_TEMPLOW = "templow";
    private static String FAM_28_TEMPERATURE = "temperature";
    private static String FAM_28_ID = "id";
    private static String FAM_28_TEMPERATURE10 = "temperature10";
    private static String FAM_28_TEMPHIGH = "temphigh";
    private static String FAM_28_TEMPERATURE12 = "temperature12";
    private static String FAM_28_TEMPERATURE11 = "temperature11";
    private static String FAM_28_ADDRESS = "address";
    private static String FAM_28_FAMILY = "family";
    private static String FAM_28_FASTTEMP = "fasttemp";
    private static String FAM_28_CRC8 = "crc8";
    private static String FAM_28_POWER = "power";
    private static String FAM_28_ERRATA_TRIMBLANKET = "errata/trimblanket";
    private static int FAM_28_ERRATA_DIE_SIZE = 2;
    private static int FAM_28_ERRATA_TRIM_SIZE = 12;
    private static int FAM_28_LOCATOR_SIZE = 16;
    private static int FAM_28_R_ID_SIZE = 12;
    private static int FAM_28_TEMPERATURE9_SIZE = 12;
    private static int FAM_28_ALIAS_SIZE = 256;
    private static int FAM_28_ERRATA_TRIMVALID_SIZE = 1;
    private static int FAM_28_R_ADDRESS_SIZE = 16;
    private static int FAM_28_R_LOCATOR_SIZE = 16;
    private static int FAM_28_TYPE_SIZE = 32;
    private static int FAM_28_TEMPLOW_SIZE = 12;
    private static int FAM_28_TEMPERATURE_SIZE = 12;
    private static int FAM_28_ID_SIZE = 12;
    private static int FAM_28_TEMPERATURE10_SIZE = 12;
    private static int FAM_28_TEMPHIGH_SIZE = 12;
    private static int FAM_28_TEMPERATURE12_SIZE = 12;
    private static int FAM_28_TEMPERATURE11_SIZE = 12;
    private static int FAM_28_ADDRESS_SIZE = 16;
    private static int FAM_28_FAMILY_SIZE = 2;
    private static int FAM_28_FASTTEMP_SIZE = 12;
    private static int FAM_28_CRC8_SIZE = 2;
    private static int FAM_28_POWER_SIZE = 1;
    private static int FAM_28_ERRATA_TRIMBLANKET_SIZE = 1;

    public OneWireContainer28() {
    }

    public OneWireContainer28(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_28_ERRATA_DIE))
            return FAM_28_ERRATA_DIE_SIZE;
        if (path.equals(FAM_28_ERRATA_TRIM))
            return FAM_28_ERRATA_TRIM_SIZE;
        if (path.equals(FAM_28_LOCATOR))
            return FAM_28_LOCATOR_SIZE;
        if (path.equals(FAM_28_R_ID))
            return FAM_28_R_ID_SIZE;
        if (path.equals(FAM_28_TEMPERATURE9))
            return FAM_28_TEMPERATURE9_SIZE;
        if (path.equals(FAM_28_ALIAS))
            return FAM_28_ALIAS_SIZE;
        if (path.equals(FAM_28_ERRATA_TRIMVALID))
            return FAM_28_ERRATA_TRIMVALID_SIZE;
        if (path.equals(FAM_28_R_ADDRESS))
            return FAM_28_R_ADDRESS_SIZE;
        if (path.equals(FAM_28_R_LOCATOR))
            return FAM_28_R_LOCATOR_SIZE;
        if (path.equals(FAM_28_TYPE))
            return FAM_28_TYPE_SIZE;
        if (path.equals(FAM_28_TEMPLOW))
            return FAM_28_TEMPLOW_SIZE;
        if (path.equals(FAM_28_TEMPERATURE))
            return FAM_28_TEMPERATURE_SIZE;
        if (path.equals(FAM_28_ID))
            return FAM_28_ID_SIZE;
        if (path.equals(FAM_28_TEMPERATURE10))
            return FAM_28_TEMPERATURE10_SIZE;
        if (path.equals(FAM_28_TEMPHIGH))
            return FAM_28_TEMPHIGH_SIZE;
        if (path.equals(FAM_28_TEMPERATURE12))
            return FAM_28_TEMPERATURE12_SIZE;
        if (path.equals(FAM_28_TEMPERATURE11))
            return FAM_28_TEMPERATURE11_SIZE;
        if (path.equals(FAM_28_ADDRESS))
            return FAM_28_ADDRESS_SIZE;
        if (path.equals(FAM_28_FAMILY))
            return FAM_28_FAMILY_SIZE;
        if (path.equals(FAM_28_FASTTEMP))
            return FAM_28_FASTTEMP_SIZE;
        if (path.equals(FAM_28_CRC8))
            return FAM_28_CRC8_SIZE;
        if (path.equals(FAM_28_POWER))
            return FAM_28_POWER_SIZE;
        if (path.equals(FAM_28_ERRATA_TRIMBLANKET)) {
            return FAM_28_ERRATA_TRIMBLANKET_SIZE;
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