package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer8F extends OneWireDevice {
    private static String FAM_8F_LOCATOR = "locator";
    private static String FAM_8F_STATUS_PAGE_ALL = "status/page.ALL";
    private static String FAM_8F_R_ID = "r_id";
    private static String FAM_8F_ALIAS = "alias";
    private static String FAM_8F_R_ADDRESS = "r_address";
    private static String FAM_8F_R_LOCATOR = "r_locator";
    private static String FAM_8F_TYPE = "type";
    private static String FAM_8F_MEMORY = "memory";
    private static String FAM_8F_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_8F_ID = "id";
    private static String FAM_8F_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_8F_STATUS_PAGE_0 = "status/page.0";
    private static String FAM_8F_ADDRESS = "address";
    private static String FAM_8F_FAMILY = "family";
    private static String FAM_8F_CRC8 = "crc8";
    private static int FAM_8F_LOCATOR_SIZE = 16;
    private static int FAM_8F_STATUS_PAGE_ALL_SIZE = 352;
    private static int FAM_8F_R_ID_SIZE = 12;
    private static int FAM_8F_ALIAS_SIZE = 256;
    private static int FAM_8F_R_ADDRESS_SIZE = 16;
    private static int FAM_8F_R_LOCATOR_SIZE = 16;
    private static int FAM_8F_TYPE_SIZE = 32;
    private static int FAM_8F_MEMORY_SIZE = 8192;
    private static int FAM_8F_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_8F_ID_SIZE = 12;
    private static int FAM_8F_PAGES_PAGE_ALL_SIZE = 8192;
    private static int FAM_8F_STATUS_PAGE_0_SIZE = 32;
    private static int FAM_8F_ADDRESS_SIZE = 16;
    private static int FAM_8F_FAMILY_SIZE = 2;
    private static int FAM_8F_CRC8_SIZE = 2;

    public OneWireContainer8F() {
    }

    public OneWireContainer8F(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_8F_LOCATOR))
            return FAM_8F_LOCATOR_SIZE;
        if (path.equals(FAM_8F_STATUS_PAGE_ALL))
            return FAM_8F_STATUS_PAGE_ALL_SIZE;
        if (path.equals(FAM_8F_R_ID))
            return FAM_8F_R_ID_SIZE;
        if (path.equals(FAM_8F_ALIAS))
            return FAM_8F_ALIAS_SIZE;
        if (path.equals(FAM_8F_R_ADDRESS))
            return FAM_8F_R_ADDRESS_SIZE;
        if (path.equals(FAM_8F_R_LOCATOR))
            return FAM_8F_R_LOCATOR_SIZE;
        if (path.equals(FAM_8F_TYPE))
            return FAM_8F_TYPE_SIZE;
        if (path.equals(FAM_8F_MEMORY))
            return FAM_8F_MEMORY_SIZE;
        if (path.equals(FAM_8F_PAGES_PAGE_0))
            return FAM_8F_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_8F_ID))
            return FAM_8F_ID_SIZE;
        if (path.equals(FAM_8F_PAGES_PAGE_ALL))
            return FAM_8F_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_8F_STATUS_PAGE_0))
            return FAM_8F_STATUS_PAGE_0_SIZE;
        if (path.equals(FAM_8F_ADDRESS))
            return FAM_8F_ADDRESS_SIZE;
        if (path.equals(FAM_8F_FAMILY))
            return FAM_8F_FAMILY_SIZE;
        if (path.equals(FAM_8F_CRC8)) {
            return FAM_8F_CRC8_SIZE;
        }
        return -1;
    }
}