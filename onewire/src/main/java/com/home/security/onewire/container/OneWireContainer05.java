package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer05 extends OneWireDevice {
    private static String FAM_05_ID = "id";
    private static String FAM_05_LOCATOR = "locator";
    private static String FAM_05_SENSED = "sensed";
    private static String FAM_05_R_ID = "r_id";
    private static String FAM_05_R_ADDRESS = "r_address";
    private static String FAM_05_ALIAS = "alias";
    private static String FAM_05_ADDRESS = "address";
    private static String FAM_05_FAMILY = "family";
    private static String FAM_05_CRC8 = "crc8";
    private static String FAM_05_PIO = "PIO";
    private static String FAM_05_R_LOCATOR = "r_locator";
    private static String FAM_05_TYPE = "type";
    private static int FAM_05_ID_SIZE = 12;
    private static int FAM_05_LOCATOR_SIZE = 16;
    private static int FAM_05_SENSED_SIZE = 1;
    private static int FAM_05_R_ID_SIZE = 12;
    private static int FAM_05_R_ADDRESS_SIZE = 16;
    private static int FAM_05_ALIAS_SIZE = 256;
    private static int FAM_05_ADDRESS_SIZE = 16;
    private static int FAM_05_FAMILY_SIZE = 2;
    private static int FAM_05_CRC8_SIZE = 2;
    private static int FAM_05_PIO_SIZE = 1;
    private static int FAM_05_R_LOCATOR_SIZE = 16;
    private static int FAM_05_TYPE_SIZE = 32;

    public OneWireContainer05() {
    }

    public OneWireContainer05(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_05_ID))
            return FAM_05_ID_SIZE;
        if (path.equals(FAM_05_LOCATOR))
            return FAM_05_LOCATOR_SIZE;
        if (path.equals(FAM_05_SENSED))
            return FAM_05_SENSED_SIZE;
        if (path.equals(FAM_05_R_ID))
            return FAM_05_R_ID_SIZE;
        if (path.equals(FAM_05_R_ADDRESS))
            return FAM_05_R_ADDRESS_SIZE;
        if (path.equals(FAM_05_ALIAS))
            return FAM_05_ALIAS_SIZE;
        if (path.equals(FAM_05_ADDRESS))
            return FAM_05_ADDRESS_SIZE;
        if (path.equals(FAM_05_FAMILY))
            return FAM_05_FAMILY_SIZE;
        if (path.equals(FAM_05_CRC8))
            return FAM_05_CRC8_SIZE;
        if (path.equals(FAM_05_PIO))
            return FAM_05_PIO_SIZE;
        if (path.equals(FAM_05_R_LOCATOR))
            return FAM_05_R_LOCATOR_SIZE;
        if (path.equals(FAM_05_TYPE)) {
            return FAM_05_TYPE_SIZE;
        }
        return -1;
    }
}