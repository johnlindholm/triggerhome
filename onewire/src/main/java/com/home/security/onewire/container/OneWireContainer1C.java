package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer1C extends OneWireDevice
        implements OneWireSwitchContainer {
    private static String FAM_1C_R_ADDRESS = "r_address";
    private static String FAM_1C_PIO_0 = "PIO.0";
    private static String FAM_1C_POR = "por";
    private static String FAM_1C_TYPE = "type";
    private static String FAM_1C_SENSED_0 = "sensed.0";
    private static String FAM_1C_ID = "id";
    private static String FAM_1C_LATCH_0 = "latch.0";
    private static String FAM_1C_LATCH_ALL = "latch.ALL";
    private static String FAM_1C_FAMILY = "family";
    private static String FAM_1C_POLARITY = "polarity";
    private static String FAM_1C_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_1C_CRC8 = "crc8";
    private static String FAM_1C_POWER = "power";
    private static String FAM_1C_LOCATOR = "locator";
    private static String FAM_1C_PIO_BYTE = "PIO.BYTE";
    private static String FAM_1C_R_ID = "r_id";
    private static String FAM_1C_ALIAS = "alias";
    private static String FAM_1C_LATCH_BYTE = "latch.BYTE";
    private static String FAM_1C_PIO_ALL = "PIO.ALL";
    private static String FAM_1C_R_LOCATOR = "r_locator";
    private static String FAM_1C_MEMORY = "memory";
    private static String FAM_1C_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_1C_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_1C_ADDRESS = "address";
    private static String FAM_1C_SENSED_ALL = "sensed.ALL";
    private static String FAM_1C_SET_ALARM = "set_alarm";
    private static int FAM_1C_R_ADDRESS_SIZE = 16;
    private static int FAM_1C_PIO_0_SIZE = 1;
    private static int FAM_1C_POR_SIZE = 1;
    private static int FAM_1C_TYPE_SIZE = 32;
    private static int FAM_1C_SENSED_0_SIZE = 1;
    private static int FAM_1C_ID_SIZE = 12;
    private static int FAM_1C_LATCH_0_SIZE = 1;
    private static int FAM_1C_LATCH_ALL_SIZE = 3;
    private static int FAM_1C_FAMILY_SIZE = 2;
    private static int FAM_1C_POLARITY_SIZE = 1;
    private static int FAM_1C_SENSED_BYTE_SIZE = 12;
    private static int FAM_1C_CRC8_SIZE = 2;
    private static int FAM_1C_POWER_SIZE = 1;
    private static int FAM_1C_LOCATOR_SIZE = 16;
    private static int FAM_1C_PIO_BYTE_SIZE = 12;
    private static int FAM_1C_R_ID_SIZE = 12;
    private static int FAM_1C_ALIAS_SIZE = 256;
    private static int FAM_1C_LATCH_BYTE_SIZE = 12;
    private static int FAM_1C_PIO_ALL_SIZE = 3;
    private static int FAM_1C_R_LOCATOR_SIZE = 16;
    private static int FAM_1C_MEMORY_SIZE = 550;
    private static int FAM_1C_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_1C_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_1C_ADDRESS_SIZE = 16;
    private static int FAM_1C_SENSED_ALL_SIZE = 3;
    private static int FAM_1C_SET_ALARM_SIZE = 12;

    public OneWireContainer1C() {
    }

    public OneWireContainer1C(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_1C_R_ADDRESS))
            return FAM_1C_R_ADDRESS_SIZE;
        if (path.equals(FAM_1C_PIO_0))
            return FAM_1C_PIO_0_SIZE;
        if (path.equals(FAM_1C_POR))
            return FAM_1C_POR_SIZE;
        if (path.equals(FAM_1C_TYPE))
            return FAM_1C_TYPE_SIZE;
        if (path.equals(FAM_1C_SENSED_0))
            return FAM_1C_SENSED_0_SIZE;
        if (path.equals(FAM_1C_ID))
            return FAM_1C_ID_SIZE;
        if (path.equals(FAM_1C_LATCH_0))
            return FAM_1C_LATCH_0_SIZE;
        if (path.equals(FAM_1C_LATCH_ALL))
            return FAM_1C_LATCH_ALL_SIZE;
        if (path.equals(FAM_1C_FAMILY))
            return FAM_1C_FAMILY_SIZE;
        if (path.equals(FAM_1C_POLARITY))
            return FAM_1C_POLARITY_SIZE;
        if (path.equals(FAM_1C_SENSED_BYTE))
            return FAM_1C_SENSED_BYTE_SIZE;
        if (path.equals(FAM_1C_CRC8))
            return FAM_1C_CRC8_SIZE;
        if (path.equals(FAM_1C_POWER))
            return FAM_1C_POWER_SIZE;
        if (path.equals(FAM_1C_LOCATOR))
            return FAM_1C_LOCATOR_SIZE;
        if (path.equals(FAM_1C_PIO_BYTE))
            return FAM_1C_PIO_BYTE_SIZE;
        if (path.equals(FAM_1C_R_ID))
            return FAM_1C_R_ID_SIZE;
        if (path.equals(FAM_1C_ALIAS))
            return FAM_1C_ALIAS_SIZE;
        if (path.equals(FAM_1C_LATCH_BYTE))
            return FAM_1C_LATCH_BYTE_SIZE;
        if (path.equals(FAM_1C_PIO_ALL))
            return FAM_1C_PIO_ALL_SIZE;
        if (path.equals(FAM_1C_R_LOCATOR))
            return FAM_1C_R_LOCATOR_SIZE;
        if (path.equals(FAM_1C_MEMORY))
            return FAM_1C_MEMORY_SIZE;
        if (path.equals(FAM_1C_PAGES_PAGE_0))
            return FAM_1C_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_1C_PAGES_PAGE_ALL))
            return FAM_1C_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_1C_ADDRESS))
            return FAM_1C_ADDRESS_SIZE;
        if (path.equals(FAM_1C_SENSED_ALL))
            return FAM_1C_SENSED_ALL_SIZE;
        if (path.equals(FAM_1C_SET_ALARM)) {
            return FAM_1C_SET_ALARM_SIZE;
        }
        return -1;
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