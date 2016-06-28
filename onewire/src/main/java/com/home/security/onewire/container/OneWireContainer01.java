package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer01 extends OneWireDevice {
    private static String FAM_01_ID = "id";
    private static String FAM_01_LOCATOR = "locator";
    private static String FAM_01_R_ID = "r_id";
    private static String FAM_01_R_ADDRESS = "r_address";
    private static String FAM_01_ALIAS = "alias";
    private static String FAM_01_ADDRESS = "address";
    private static String FAM_01_FAMILY = "family";
    private static String FAM_01_CRC8 = "crc8";
    private static String FAM_01_R_LOCATOR = "r_locator";
    private static String FAM_01_TYPE = "type";
    private static int FAM_01_ID_SIZE = 12;
    private static int FAM_01_LOCATOR_SIZE = 16;
    private static int FAM_01_R_ID_SIZE = 12;
    private static int FAM_01_R_ADDRESS_SIZE = 16;
    private static int FAM_01_ALIAS_SIZE = 256;
    private static int FAM_01_ADDRESS_SIZE = 16;
    private static int FAM_01_FAMILY_SIZE = 2;
    private static int FAM_01_CRC8_SIZE = 2;
    private static int FAM_01_R_LOCATOR_SIZE = 16;
    private static int FAM_01_TYPE_SIZE = 32;

    public OneWireContainer01() {
    }

    public OneWireContainer01(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_01_ID))
            return FAM_01_ID_SIZE;
        if (path.equals(FAM_01_LOCATOR))
            return FAM_01_LOCATOR_SIZE;
        if (path.equals(FAM_01_R_ID))
            return FAM_01_R_ID_SIZE;
        if (path.equals(FAM_01_R_ADDRESS))
            return FAM_01_R_ADDRESS_SIZE;
        if (path.equals(FAM_01_ALIAS))
            return FAM_01_ALIAS_SIZE;
        if (path.equals(FAM_01_ADDRESS))
            return FAM_01_ADDRESS_SIZE;
        if (path.equals(FAM_01_FAMILY))
            return FAM_01_FAMILY_SIZE;
        if (path.equals(FAM_01_CRC8))
            return FAM_01_CRC8_SIZE;
        if (path.equals(FAM_01_R_LOCATOR))
            return FAM_01_R_LOCATOR_SIZE;
        if (path.equals(FAM_01_TYPE)) {
            return FAM_01_TYPE_SIZE;
        }
        return -1;
    }
}