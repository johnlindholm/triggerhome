package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer2C extends OneWireDevice {
    private static String FAM_2C_ID = "id";
    private static String FAM_2C_CHARGEPUMP = "chargepump";
    private static String FAM_2C_LOCATOR = "locator";
    private static String FAM_2C_R_ID = "r_id";
    private static String FAM_2C_R_ADDRESS = "r_address";
    private static String FAM_2C_ALIAS = "alias";
    private static String FAM_2C_ADDRESS = "address";
    private static String FAM_2C_FAMILY = "family";
    private static String FAM_2C_WIPER = "wiper";
    private static String FAM_2C_CRC8 = "crc8";
    private static String FAM_2C_R_LOCATOR = "r_locator";
    private static String FAM_2C_TYPE = "type";
    private static int FAM_2C_ID_SIZE = 12;
    private static int FAM_2C_CHARGEPUMP_SIZE = 1;
    private static int FAM_2C_LOCATOR_SIZE = 16;
    private static int FAM_2C_R_ID_SIZE = 12;
    private static int FAM_2C_R_ADDRESS_SIZE = 16;
    private static int FAM_2C_ALIAS_SIZE = 256;
    private static int FAM_2C_ADDRESS_SIZE = 16;
    private static int FAM_2C_FAMILY_SIZE = 2;
    private static int FAM_2C_WIPER_SIZE = 12;
    private static int FAM_2C_CRC8_SIZE = 2;
    private static int FAM_2C_R_LOCATOR_SIZE = 16;
    private static int FAM_2C_TYPE_SIZE = 32;

    public OneWireContainer2C() {
    }

    public OneWireContainer2C(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_2C_ID))
            return FAM_2C_ID_SIZE;
        if (path.equals(FAM_2C_CHARGEPUMP))
            return FAM_2C_CHARGEPUMP_SIZE;
        if (path.equals(FAM_2C_LOCATOR))
            return FAM_2C_LOCATOR_SIZE;
        if (path.equals(FAM_2C_R_ID))
            return FAM_2C_R_ID_SIZE;
        if (path.equals(FAM_2C_R_ADDRESS))
            return FAM_2C_R_ADDRESS_SIZE;
        if (path.equals(FAM_2C_ALIAS))
            return FAM_2C_ALIAS_SIZE;
        if (path.equals(FAM_2C_ADDRESS))
            return FAM_2C_ADDRESS_SIZE;
        if (path.equals(FAM_2C_FAMILY))
            return FAM_2C_FAMILY_SIZE;
        if (path.equals(FAM_2C_WIPER))
            return FAM_2C_WIPER_SIZE;
        if (path.equals(FAM_2C_CRC8))
            return FAM_2C_CRC8_SIZE;
        if (path.equals(FAM_2C_R_LOCATOR))
            return FAM_2C_R_LOCATOR_SIZE;
        if (path.equals(FAM_2C_TYPE)) {
            return FAM_2C_TYPE_SIZE;
        }
        return -1;
    }
}