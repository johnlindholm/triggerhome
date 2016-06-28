package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer42 extends OneWireDevice
        implements OneWireTemperatureContainer, OneWireSwitchContainer {
    private static String FAM_42_LATCH_A = "latch.A";
    private static String FAM_42_R_ADDRESS = "r_address";
    private static String FAM_42_TYPE = "type";
    private static String FAM_42_TEMPERATURE = "temperature";
    private static String FAM_42_ID = "id";
    private static String FAM_42_TEMPHIGH = "temphigh";
    private static String FAM_42_LATCH_ALL = "latch.ALL";
    private static String FAM_42_FAMILY = "family";
    private static String FAM_42_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_42_CRC8 = "crc8";
    private static String FAM_42_POWER = "power";
    private static String FAM_42_LOCATOR = "locator";
    private static String FAM_42_PIO_BYTE = "PIO.BYTE";
    private static String FAM_42_R_ID = "r_id";
    private static String FAM_42_ALIAS = "alias";
    private static String FAM_42_TEMPERATURE9 = "temperature9";
    private static String FAM_42_LATCH_BYTE = "latch.BYTE";
    private static String FAM_42_PIO_ALL = "PIO.ALL";
    private static String FAM_42_R_LOCATOR = "r_locator";
    private static String FAM_42_TEMPLOW = "templow";
    private static String FAM_42_PIO_A = "PIO.A";
    private static String FAM_42_TEMPERATURE10 = "temperature10";
    private static String FAM_42_TEMPERATURE12 = "temperature12";
    private static String FAM_42_ADDRESS = "address";
    private static String FAM_42_SENSED_ALL = "sensed.ALL";
    private static String FAM_42_TEMPERATURE11 = "temperature11";
    private static String FAM_42_FASTTEMP = "fasttemp";
    private static String FAM_42_SENSED_A = "sensed.A";
    private static int FAM_42_LATCH_A_SIZE = 1;
    private static int FAM_42_R_ADDRESS_SIZE = 16;
    private static int FAM_42_TYPE_SIZE = 32;
    private static int FAM_42_TEMPERATURE_SIZE = 12;
    private static int FAM_42_ID_SIZE = 12;
    private static int FAM_42_TEMPHIGH_SIZE = 12;
    private static int FAM_42_LATCH_ALL_SIZE = 3;
    private static int FAM_42_FAMILY_SIZE = 2;
    private static int FAM_42_SENSED_BYTE_SIZE = 12;
    private static int FAM_42_CRC8_SIZE = 2;
    private static int FAM_42_POWER_SIZE = 1;
    private static int FAM_42_LOCATOR_SIZE = 16;
    private static int FAM_42_PIO_BYTE_SIZE = 12;
    private static int FAM_42_R_ID_SIZE = 12;
    private static int FAM_42_ALIAS_SIZE = 256;
    private static int FAM_42_TEMPERATURE9_SIZE = 12;
    private static int FAM_42_LATCH_BYTE_SIZE = 12;
    private static int FAM_42_PIO_ALL_SIZE = 3;
    private static int FAM_42_R_LOCATOR_SIZE = 16;
    private static int FAM_42_TEMPLOW_SIZE = 12;
    private static int FAM_42_PIO_A_SIZE = 1;
    private static int FAM_42_TEMPERATURE10_SIZE = 12;
    private static int FAM_42_TEMPERATURE12_SIZE = 12;
    private static int FAM_42_ADDRESS_SIZE = 16;
    private static int FAM_42_SENSED_ALL_SIZE = 3;
    private static int FAM_42_TEMPERATURE11_SIZE = 12;
    private static int FAM_42_FASTTEMP_SIZE = 12;
    private static int FAM_42_SENSED_A_SIZE = 1;

    public OneWireContainer42() {
    }

    public OneWireContainer42(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_42_LATCH_A))
            return FAM_42_LATCH_A_SIZE;
        if (path.equals(FAM_42_R_ADDRESS))
            return FAM_42_R_ADDRESS_SIZE;
        if (path.equals(FAM_42_TYPE))
            return FAM_42_TYPE_SIZE;
        if (path.equals(FAM_42_TEMPERATURE))
            return FAM_42_TEMPERATURE_SIZE;
        if (path.equals(FAM_42_ID))
            return FAM_42_ID_SIZE;
        if (path.equals(FAM_42_TEMPHIGH))
            return FAM_42_TEMPHIGH_SIZE;
        if (path.equals(FAM_42_LATCH_ALL))
            return FAM_42_LATCH_ALL_SIZE;
        if (path.equals(FAM_42_FAMILY))
            return FAM_42_FAMILY_SIZE;
        if (path.equals(FAM_42_SENSED_BYTE))
            return FAM_42_SENSED_BYTE_SIZE;
        if (path.equals(FAM_42_CRC8))
            return FAM_42_CRC8_SIZE;
        if (path.equals(FAM_42_POWER))
            return FAM_42_POWER_SIZE;
        if (path.equals(FAM_42_LOCATOR))
            return FAM_42_LOCATOR_SIZE;
        if (path.equals(FAM_42_PIO_BYTE))
            return FAM_42_PIO_BYTE_SIZE;
        if (path.equals(FAM_42_R_ID))
            return FAM_42_R_ID_SIZE;
        if (path.equals(FAM_42_ALIAS))
            return FAM_42_ALIAS_SIZE;
        if (path.equals(FAM_42_TEMPERATURE9))
            return FAM_42_TEMPERATURE9_SIZE;
        if (path.equals(FAM_42_LATCH_BYTE))
            return FAM_42_LATCH_BYTE_SIZE;
        if (path.equals(FAM_42_PIO_ALL))
            return FAM_42_PIO_ALL_SIZE;
        if (path.equals(FAM_42_R_LOCATOR))
            return FAM_42_R_LOCATOR_SIZE;
        if (path.equals(FAM_42_TEMPLOW))
            return FAM_42_TEMPLOW_SIZE;
        if (path.equals(FAM_42_PIO_A))
            return FAM_42_PIO_A_SIZE;
        if (path.equals(FAM_42_TEMPERATURE10))
            return FAM_42_TEMPERATURE10_SIZE;
        if (path.equals(FAM_42_TEMPERATURE12))
            return FAM_42_TEMPERATURE12_SIZE;
        if (path.equals(FAM_42_ADDRESS))
            return FAM_42_ADDRESS_SIZE;
        if (path.equals(FAM_42_SENSED_ALL))
            return FAM_42_SENSED_ALL_SIZE;
        if (path.equals(FAM_42_TEMPERATURE11))
            return FAM_42_TEMPERATURE11_SIZE;
        if (path.equals(FAM_42_FASTTEMP))
            return FAM_42_FASTTEMP_SIZE;
        if (path.equals(FAM_42_SENSED_A)) {
            return FAM_42_SENSED_A_SIZE;
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

    public boolean isOn()
            throws IOException {
        String response = readValue("sensed.BYTE", true);
        if (response != null) {
            int value = Integer.parseInt(response);
            return value != 0;
        }
        return false;
    }

    public void turnAllOn()
            throws IOException {
        writeValue("PIO.BYTE", "3");
    }

    public void turnAllOff()
            throws IOException {
        writeValue("PIO.BYTE", "0");
    }
}