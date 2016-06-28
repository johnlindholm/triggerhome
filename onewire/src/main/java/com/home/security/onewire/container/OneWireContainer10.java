package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer10 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_10_ERRATA_DIE = "errata/die";
    private static String FAM_10_ERRATA_TRIM = "errata/trim";
    private static String FAM_10_LOCATOR = "locator";
    private static String FAM_10_R_ID = "r_id";
    private static String FAM_10_ALIAS = "alias";
    private static String FAM_10_ERRATA_TRIMVALID = "errata/trimvalid";
    private static String FAM_10_R_ADDRESS = "r_address";
    private static String FAM_10_R_LOCATOR = "r_locator";
    private static String FAM_10_TYPE = "type";
    private static String FAM_10_TEMPLOW = "templow";
    private static String FAM_10_TEMPERATURE = "temperature";
    private static String FAM_10_ID = "id";
    private static String FAM_10_TEMPHIGH = "temphigh";
    private static String FAM_10_ADDRESS = "address";
    private static String FAM_10_FAMILY = "family";
    private static String FAM_10_CRC8 = "crc8";
    private static String FAM_10_POWER = "power";
    private static String FAM_10_ERRATA_TRIMBLANKET = "errata/trimblanket";
    private static int FAM_10_ERRATA_DIE_SIZE = 2;
    private static int FAM_10_ERRATA_TRIM_SIZE = 12;
    private static int FAM_10_LOCATOR_SIZE = 16;
    private static int FAM_10_R_ID_SIZE = 12;
    private static int FAM_10_ALIAS_SIZE = 256;
    private static int FAM_10_ERRATA_TRIMVALID_SIZE = 1;
    private static int FAM_10_R_ADDRESS_SIZE = 16;
    private static int FAM_10_R_LOCATOR_SIZE = 16;
    private static int FAM_10_TYPE_SIZE = 32;
    private static int FAM_10_TEMPLOW_SIZE = 12;
    private static int FAM_10_TEMPERATURE_SIZE = 12;
    private static int FAM_10_ID_SIZE = 12;
    private static int FAM_10_TEMPHIGH_SIZE = 12;
    private static int FAM_10_ADDRESS_SIZE = 16;
    private static int FAM_10_FAMILY_SIZE = 2;
    private static int FAM_10_CRC8_SIZE = 2;
    private static int FAM_10_POWER_SIZE = 1;
    private static int FAM_10_ERRATA_TRIMBLANKET_SIZE = 1;

    public OneWireContainer10() {
    }

    public OneWireContainer10(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_10_ERRATA_DIE))
            return FAM_10_ERRATA_DIE_SIZE;
        if (path.equals(FAM_10_ERRATA_TRIM))
            return FAM_10_ERRATA_TRIM_SIZE;
        if (path.equals(FAM_10_LOCATOR))
            return FAM_10_LOCATOR_SIZE;
        if (path.equals(FAM_10_R_ID))
            return FAM_10_R_ID_SIZE;
        if (path.equals(FAM_10_ALIAS))
            return FAM_10_ALIAS_SIZE;
        if (path.equals(FAM_10_ERRATA_TRIMVALID))
            return FAM_10_ERRATA_TRIMVALID_SIZE;
        if (path.equals(FAM_10_R_ADDRESS))
            return FAM_10_R_ADDRESS_SIZE;
        if (path.equals(FAM_10_R_LOCATOR))
            return FAM_10_R_LOCATOR_SIZE;
        if (path.equals(FAM_10_TYPE))
            return FAM_10_TYPE_SIZE;
        if (path.equals(FAM_10_TEMPLOW))
            return FAM_10_TEMPLOW_SIZE;
        if (path.equals(FAM_10_TEMPERATURE))
            return FAM_10_TEMPERATURE_SIZE;
        if (path.equals(FAM_10_ID))
            return FAM_10_ID_SIZE;
        if (path.equals(FAM_10_TEMPHIGH))
            return FAM_10_TEMPHIGH_SIZE;
        if (path.equals(FAM_10_ADDRESS))
            return FAM_10_ADDRESS_SIZE;
        if (path.equals(FAM_10_FAMILY))
            return FAM_10_FAMILY_SIZE;
        if (path.equals(FAM_10_CRC8))
            return FAM_10_CRC8_SIZE;
        if (path.equals(FAM_10_POWER))
            return FAM_10_POWER_SIZE;
        if (path.equals(FAM_10_ERRATA_TRIMBLANKET)) {
            return FAM_10_ERRATA_TRIMBLANKET_SIZE;
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