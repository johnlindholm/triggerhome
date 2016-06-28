package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer14 extends OneWireDevice {
    private static String FAM_14_LOCATOR = "locator";
    private static String FAM_14_APPLICATION = "application";
    private static String FAM_14_R_ID = "r_id";
    private static String FAM_14_ALIAS = "alias";
    private static String FAM_14_R_ADDRESS = "r_address";
    private static String FAM_14_STATUS = "status";
    private static String FAM_14_R_LOCATOR = "r_locator";
    private static String FAM_14_TYPE = "type";
    private static String FAM_14_MEMORY = "memory";
    private static String FAM_14_ID = "id";
    private static String FAM_14_ADDRESS = "address";
    private static String FAM_14_FAMILY = "family";
    private static String FAM_14_CRC8 = "crc8";
    private static int FAM_14_LOCATOR_SIZE = 16;
    private static int FAM_14_APPLICATION_SIZE = 8;
    private static int FAM_14_R_ID_SIZE = 12;
    private static int FAM_14_ALIAS_SIZE = 256;
    private static int FAM_14_R_ADDRESS_SIZE = 16;
    private static int FAM_14_STATUS_SIZE = 12;
    private static int FAM_14_R_LOCATOR_SIZE = 16;
    private static int FAM_14_TYPE_SIZE = 32;
    private static int FAM_14_MEMORY_SIZE = 32;
    private static int FAM_14_ID_SIZE = 12;
    private static int FAM_14_ADDRESS_SIZE = 16;
    private static int FAM_14_FAMILY_SIZE = 2;
    private static int FAM_14_CRC8_SIZE = 2;

    public OneWireContainer14() {
    }

    public OneWireContainer14(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_14_LOCATOR))
            return FAM_14_LOCATOR_SIZE;
        if (path.equals(FAM_14_APPLICATION))
            return FAM_14_APPLICATION_SIZE;
        if (path.equals(FAM_14_R_ID))
            return FAM_14_R_ID_SIZE;
        if (path.equals(FAM_14_ALIAS))
            return FAM_14_ALIAS_SIZE;
        if (path.equals(FAM_14_R_ADDRESS))
            return FAM_14_R_ADDRESS_SIZE;
        if (path.equals(FAM_14_STATUS))
            return FAM_14_STATUS_SIZE;
        if (path.equals(FAM_14_R_LOCATOR))
            return FAM_14_R_LOCATOR_SIZE;
        if (path.equals(FAM_14_TYPE))
            return FAM_14_TYPE_SIZE;
        if (path.equals(FAM_14_MEMORY))
            return FAM_14_MEMORY_SIZE;
        if (path.equals(FAM_14_ID))
            return FAM_14_ID_SIZE;
        if (path.equals(FAM_14_ADDRESS))
            return FAM_14_ADDRESS_SIZE;
        if (path.equals(FAM_14_FAMILY))
            return FAM_14_FAMILY_SIZE;
        if (path.equals(FAM_14_CRC8)) {
            return FAM_14_CRC8_SIZE;
        }
        return -1;
    }
}