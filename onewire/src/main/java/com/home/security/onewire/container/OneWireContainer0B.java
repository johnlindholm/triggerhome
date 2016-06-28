package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer0B extends OneWireDevice {
    private static String FAM_0B_LOCATOR = "locator";
    private static String FAM_0B_STATUS_PAGE_ALL = "status/page.ALL";
    private static String FAM_0B_R_ID = "r_id";
    private static String FAM_0B_ALIAS = "alias";
    private static String FAM_0B_R_ADDRESS = "r_address";
    private static String FAM_0B_R_LOCATOR = "r_locator";
    private static String FAM_0B_TYPE = "type";
    private static String FAM_0B_MEMORY = "memory";
    private static String FAM_0B_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_0B_ID = "id";
    private static String FAM_0B_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_0B_STATUS_PAGE_0 = "status/page.0";
    private static String FAM_0B_ADDRESS = "address";
    private static String FAM_0B_FAMILY = "family";
    private static String FAM_0B_CRC8 = "crc8";
    private static int FAM_0B_LOCATOR_SIZE = 16;
    private static int FAM_0B_STATUS_PAGE_ALL_SIZE = 88;
    private static int FAM_0B_R_ID_SIZE = 12;
    private static int FAM_0B_ALIAS_SIZE = 256;
    private static int FAM_0B_R_ADDRESS_SIZE = 16;
    private static int FAM_0B_R_LOCATOR_SIZE = 16;
    private static int FAM_0B_TYPE_SIZE = 32;
    private static int FAM_0B_MEMORY_SIZE = 2048;
    private static int FAM_0B_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_0B_ID_SIZE = 12;
    private static int FAM_0B_PAGES_PAGE_ALL_SIZE = 2048;
    private static int FAM_0B_STATUS_PAGE_0_SIZE = 8;
    private static int FAM_0B_ADDRESS_SIZE = 16;
    private static int FAM_0B_FAMILY_SIZE = 2;
    private static int FAM_0B_CRC8_SIZE = 2;

    public OneWireContainer0B() {
    }

    public OneWireContainer0B(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_0B_LOCATOR))
            return FAM_0B_LOCATOR_SIZE;
        if (path.equals(FAM_0B_STATUS_PAGE_ALL))
            return FAM_0B_STATUS_PAGE_ALL_SIZE;
        if (path.equals(FAM_0B_R_ID))
            return FAM_0B_R_ID_SIZE;
        if (path.equals(FAM_0B_ALIAS))
            return FAM_0B_ALIAS_SIZE;
        if (path.equals(FAM_0B_R_ADDRESS))
            return FAM_0B_R_ADDRESS_SIZE;
        if (path.equals(FAM_0B_R_LOCATOR))
            return FAM_0B_R_LOCATOR_SIZE;
        if (path.equals(FAM_0B_TYPE))
            return FAM_0B_TYPE_SIZE;
        if (path.equals(FAM_0B_MEMORY))
            return FAM_0B_MEMORY_SIZE;
        if (path.equals(FAM_0B_PAGES_PAGE_0))
            return FAM_0B_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_0B_ID))
            return FAM_0B_ID_SIZE;
        if (path.equals(FAM_0B_PAGES_PAGE_ALL))
            return FAM_0B_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_0B_STATUS_PAGE_0))
            return FAM_0B_STATUS_PAGE_0_SIZE;
        if (path.equals(FAM_0B_ADDRESS))
            return FAM_0B_ADDRESS_SIZE;
        if (path.equals(FAM_0B_FAMILY))
            return FAM_0B_FAMILY_SIZE;
        if (path.equals(FAM_0B_CRC8)) {
            return FAM_0B_CRC8_SIZE;
        }
        return -1;
    }
}