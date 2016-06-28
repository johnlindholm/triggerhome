package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer3A extends OneWireDevice
        implements OneWireSwitchContainer {
    private static String FAM_3A_LOCATOR = "locator";
    private static String FAM_3A_PIO_BYTE = "PIO.BYTE";
    private static String FAM_3A_R_ID = "r_id";
    private static String FAM_3A_ALIAS = "alias";
    private static String FAM_3A_R_ADDRESS = "r_address";
    private static String FAM_3A_PIO_ALL = "PIO.ALL";
    private static String FAM_3A_R_LOCATOR = "r_locator";
    private static String FAM_3A_TYPE = "type";
    private static String FAM_3A_ID = "id";
    private static String FAM_3A_PIO_A = "PIO.A";
    private static String FAM_3A_SENSED_ALL = "sensed.ALL";
    private static String FAM_3A_ADDRESS = "address";
    private static String FAM_3A_FAMILY = "family";
    private static String FAM_3A_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_3A_CRC8 = "crc8";
    private static String FAM_3A_SENSED_A = "sensed.A";
    private static int FAM_3A_LOCATOR_SIZE = 16;
    private static int FAM_3A_PIO_BYTE_SIZE = 12;
    private static int FAM_3A_R_ID_SIZE = 12;
    private static int FAM_3A_ALIAS_SIZE = 256;
    private static int FAM_3A_R_ADDRESS_SIZE = 16;
    private static int FAM_3A_PIO_ALL_SIZE = 3;
    private static int FAM_3A_R_LOCATOR_SIZE = 16;
    private static int FAM_3A_TYPE_SIZE = 32;
    private static int FAM_3A_ID_SIZE = 12;
    private static int FAM_3A_PIO_A_SIZE = 1;
    private static int FAM_3A_SENSED_ALL_SIZE = 3;
    private static int FAM_3A_ADDRESS_SIZE = 16;
    private static int FAM_3A_FAMILY_SIZE = 2;
    private static int FAM_3A_SENSED_BYTE_SIZE = 12;
    private static int FAM_3A_CRC8_SIZE = 2;
    private static int FAM_3A_SENSED_A_SIZE = 1;

    public OneWireContainer3A() {
    }

    public OneWireContainer3A(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_3A_LOCATOR))
            return FAM_3A_LOCATOR_SIZE;
        if (path.equals(FAM_3A_PIO_BYTE))
            return FAM_3A_PIO_BYTE_SIZE;
        if (path.equals(FAM_3A_R_ID))
            return FAM_3A_R_ID_SIZE;
        if (path.equals(FAM_3A_ALIAS))
            return FAM_3A_ALIAS_SIZE;
        if (path.equals(FAM_3A_R_ADDRESS))
            return FAM_3A_R_ADDRESS_SIZE;
        if (path.equals(FAM_3A_PIO_ALL))
            return FAM_3A_PIO_ALL_SIZE;
        if (path.equals(FAM_3A_R_LOCATOR))
            return FAM_3A_R_LOCATOR_SIZE;
        if (path.equals(FAM_3A_TYPE))
            return FAM_3A_TYPE_SIZE;
        if (path.equals(FAM_3A_ID))
            return FAM_3A_ID_SIZE;
        if (path.equals(FAM_3A_PIO_A))
            return FAM_3A_PIO_A_SIZE;
        if (path.equals(FAM_3A_SENSED_ALL))
            return FAM_3A_SENSED_ALL_SIZE;
        if (path.equals(FAM_3A_ADDRESS))
            return FAM_3A_ADDRESS_SIZE;
        if (path.equals(FAM_3A_FAMILY))
            return FAM_3A_FAMILY_SIZE;
        if (path.equals(FAM_3A_SENSED_BYTE))
            return FAM_3A_SENSED_BYTE_SIZE;
        if (path.equals(FAM_3A_CRC8))
            return FAM_3A_CRC8_SIZE;
        if (path.equals(FAM_3A_SENSED_A)) {
            return FAM_3A_SENSED_A_SIZE;
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