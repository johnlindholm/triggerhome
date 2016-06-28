package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer06 extends OneWireDevice {
    private static String FAM_06_LOCATOR = "locator";
    private static String FAM_06_R_ID = "r_id";
    private static String FAM_06_ALIAS = "alias";
    private static String FAM_06_R_ADDRESS = "r_address";
    private static String FAM_06_R_LOCATOR = "r_locator";
    private static String FAM_06_TYPE = "type";
    private static String FAM_06_MEMORY = "memory";
    private static String FAM_06_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_06_ID = "id";
    private static String FAM_06_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_06_ADDRESS = "address";
    private static String FAM_06_FAMILY = "family";
    private static String FAM_06_CRC8 = "crc8";
    private static int FAM_06_LOCATOR_SIZE = 16;
    private static int FAM_06_R_ID_SIZE = 12;
    private static int FAM_06_ALIAS_SIZE = 256;
    private static int FAM_06_R_ADDRESS_SIZE = 16;
    private static int FAM_06_R_LOCATOR_SIZE = 16;
    private static int FAM_06_TYPE_SIZE = 32;
    private static int FAM_06_MEMORY_SIZE = 512;
    private static int FAM_06_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_06_ID_SIZE = 12;
    private static int FAM_06_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_06_ADDRESS_SIZE = 16;
    private static int FAM_06_FAMILY_SIZE = 2;
    private static int FAM_06_CRC8_SIZE = 2;

    public OneWireContainer06() {
    }

    public OneWireContainer06(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_06_LOCATOR))
            return FAM_06_LOCATOR_SIZE;
        if (path.equals(FAM_06_R_ID))
            return FAM_06_R_ID_SIZE;
        if (path.equals(FAM_06_ALIAS))
            return FAM_06_ALIAS_SIZE;
        if (path.equals(FAM_06_R_ADDRESS))
            return FAM_06_R_ADDRESS_SIZE;
        if (path.equals(FAM_06_R_LOCATOR))
            return FAM_06_R_LOCATOR_SIZE;
        if (path.equals(FAM_06_TYPE))
            return FAM_06_TYPE_SIZE;
        if (path.equals(FAM_06_MEMORY))
            return FAM_06_MEMORY_SIZE;
        if (path.equals(FAM_06_PAGES_PAGE_0))
            return FAM_06_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_06_ID))
            return FAM_06_ID_SIZE;
        if (path.equals(FAM_06_PAGES_PAGE_ALL))
            return FAM_06_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_06_ADDRESS))
            return FAM_06_ADDRESS_SIZE;
        if (path.equals(FAM_06_FAMILY))
            return FAM_06_FAMILY_SIZE;
        if (path.equals(FAM_06_CRC8)) {
            return FAM_06_CRC8_SIZE;
        }
        return -1;
    }
}