package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer09 extends OneWireDevice {
    private static String FAM_09_LOCATOR = "locator";
    private static String FAM_09_R_ID = "r_id";
    private static String FAM_09_ALIAS = "alias";
    private static String FAM_09_R_ADDRESS = "r_address";
    private static String FAM_09_R_LOCATOR = "r_locator";
    private static String FAM_09_TYPE = "type";
    private static String FAM_09_MEMORY = "memory";
    private static String FAM_09_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_09_ID = "id";
    private static String FAM_09_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_09_ADDRESS = "address";
    private static String FAM_09_FAMILY = "family";
    private static String FAM_09_CRC8 = "crc8";
    private static int FAM_09_LOCATOR_SIZE = 16;
    private static int FAM_09_R_ID_SIZE = 12;
    private static int FAM_09_ALIAS_SIZE = 256;
    private static int FAM_09_R_ADDRESS_SIZE = 16;
    private static int FAM_09_R_LOCATOR_SIZE = 16;
    private static int FAM_09_TYPE_SIZE = 32;
    private static int FAM_09_MEMORY_SIZE = 128;
    private static int FAM_09_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_09_ID_SIZE = 12;
    private static int FAM_09_PAGES_PAGE_ALL_SIZE = 128;
    private static int FAM_09_ADDRESS_SIZE = 16;
    private static int FAM_09_FAMILY_SIZE = 2;
    private static int FAM_09_CRC8_SIZE = 2;

    public OneWireContainer09() {
    }

    public OneWireContainer09(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_09_LOCATOR))
            return FAM_09_LOCATOR_SIZE;
        if (path.equals(FAM_09_R_ID))
            return FAM_09_R_ID_SIZE;
        if (path.equals(FAM_09_ALIAS))
            return FAM_09_ALIAS_SIZE;
        if (path.equals(FAM_09_R_ADDRESS))
            return FAM_09_R_ADDRESS_SIZE;
        if (path.equals(FAM_09_R_LOCATOR))
            return FAM_09_R_LOCATOR_SIZE;
        if (path.equals(FAM_09_TYPE))
            return FAM_09_TYPE_SIZE;
        if (path.equals(FAM_09_MEMORY))
            return FAM_09_MEMORY_SIZE;
        if (path.equals(FAM_09_PAGES_PAGE_0))
            return FAM_09_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_09_ID))
            return FAM_09_ID_SIZE;
        if (path.equals(FAM_09_PAGES_PAGE_ALL))
            return FAM_09_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_09_ADDRESS))
            return FAM_09_ADDRESS_SIZE;
        if (path.equals(FAM_09_FAMILY))
            return FAM_09_FAMILY_SIZE;
        if (path.equals(FAM_09_CRC8)) {
            return FAM_09_CRC8_SIZE;
        }
        return -1;
    }
}