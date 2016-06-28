package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer81 extends OneWireDevice {
    private static String FAM_81_ID = "id";
    private static String FAM_81_LOCATOR = "locator";
    private static String FAM_81_R_ID = "r_id";
    private static String FAM_81_R_ADDRESS = "r_address";
    private static String FAM_81_ALIAS = "alias";
    private static String FAM_81_ADDRESS = "address";
    private static String FAM_81_FAMILY = "family";
    private static String FAM_81_CRC8 = "crc8";
    private static String FAM_81_R_LOCATOR = "r_locator";
    private static String FAM_81_TYPE = "type";
    private static int FAM_81_ID_SIZE = 12;
    private static int FAM_81_LOCATOR_SIZE = 16;
    private static int FAM_81_R_ID_SIZE = 12;
    private static int FAM_81_R_ADDRESS_SIZE = 16;
    private static int FAM_81_ALIAS_SIZE = 256;
    private static int FAM_81_ADDRESS_SIZE = 16;
    private static int FAM_81_FAMILY_SIZE = 2;
    private static int FAM_81_CRC8_SIZE = 2;
    private static int FAM_81_R_LOCATOR_SIZE = 16;
    private static int FAM_81_TYPE_SIZE = 32;

    public OneWireContainer81() {
    }

    public OneWireContainer81(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_81_ID))
            return FAM_81_ID_SIZE;
        if (path.equals(FAM_81_LOCATOR))
            return FAM_81_LOCATOR_SIZE;
        if (path.equals(FAM_81_R_ID))
            return FAM_81_R_ID_SIZE;
        if (path.equals(FAM_81_R_ADDRESS))
            return FAM_81_R_ADDRESS_SIZE;
        if (path.equals(FAM_81_ALIAS))
            return FAM_81_ALIAS_SIZE;
        if (path.equals(FAM_81_ADDRESS))
            return FAM_81_ADDRESS_SIZE;
        if (path.equals(FAM_81_FAMILY))
            return FAM_81_FAMILY_SIZE;
        if (path.equals(FAM_81_CRC8))
            return FAM_81_CRC8_SIZE;
        if (path.equals(FAM_81_R_LOCATOR))
            return FAM_81_R_LOCATOR_SIZE;
        if (path.equals(FAM_81_TYPE)) {
            return FAM_81_TYPE_SIZE;
        }
        return -1;
    }
}