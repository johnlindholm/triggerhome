package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer18 extends OneWireDevice {
    private static String FAM_18_LOCATOR = "locator";
    private static String FAM_18_R_ID = "r_id";
    private static String FAM_18_R_ADDRESS = "r_address";
    private static String FAM_18_ALIAS = "alias";
    private static String FAM_18_PAGES_PASSWORD = "pages/password";
    private static String FAM_18_R_LOCATOR = "r_locator";
    private static String FAM_18_TYPE = "type";
    private static String FAM_18_PASSWORD = "password";
    private static String FAM_18_MEMORY = "memory";
    private static String FAM_18_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_18_ID = "id";
    private static String FAM_18_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_18_PAGES_COUNT_ALL = "pages/count.ALL";
    private static String FAM_18_ADDRESS = "address";
    private static String FAM_18_FAMILY = "family";
    private static String FAM_18_PAGES_COUNT_0 = "pages/count.0";
    private static String FAM_18_CRC8 = "crc8";
    private static int FAM_18_LOCATOR_SIZE = 16;
    private static int FAM_18_R_ID_SIZE = 12;
    private static int FAM_18_R_ADDRESS_SIZE = 16;
    private static int FAM_18_ALIAS_SIZE = 256;
    private static int FAM_18_PAGES_PASSWORD_SIZE = 8;
    private static int FAM_18_R_LOCATOR_SIZE = 16;
    private static int FAM_18_TYPE_SIZE = 32;
    private static int FAM_18_PASSWORD_SIZE = 8;
    private static int FAM_18_MEMORY_SIZE = 512;
    private static int FAM_18_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_18_ID_SIZE = 12;
    private static int FAM_18_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_18_PAGES_COUNT_ALL_SIZE = 207;
    private static int FAM_18_ADDRESS_SIZE = 16;
    private static int FAM_18_FAMILY_SIZE = 2;
    private static int FAM_18_PAGES_COUNT_0_SIZE = 12;
    private static int FAM_18_CRC8_SIZE = 2;

    public OneWireContainer18() {
    }

    public OneWireContainer18(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_18_LOCATOR))
            return FAM_18_LOCATOR_SIZE;
        if (path.equals(FAM_18_R_ID))
            return FAM_18_R_ID_SIZE;
        if (path.equals(FAM_18_R_ADDRESS))
            return FAM_18_R_ADDRESS_SIZE;
        if (path.equals(FAM_18_ALIAS))
            return FAM_18_ALIAS_SIZE;
        if (path.equals(FAM_18_PAGES_PASSWORD))
            return FAM_18_PAGES_PASSWORD_SIZE;
        if (path.equals(FAM_18_R_LOCATOR))
            return FAM_18_R_LOCATOR_SIZE;
        if (path.equals(FAM_18_TYPE))
            return FAM_18_TYPE_SIZE;
        if (path.equals(FAM_18_PASSWORD))
            return FAM_18_PASSWORD_SIZE;
        if (path.equals(FAM_18_MEMORY))
            return FAM_18_MEMORY_SIZE;
        if (path.equals(FAM_18_PAGES_PAGE_0))
            return FAM_18_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_18_ID))
            return FAM_18_ID_SIZE;
        if (path.equals(FAM_18_PAGES_PAGE_ALL))
            return FAM_18_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_18_PAGES_COUNT_ALL))
            return FAM_18_PAGES_COUNT_ALL_SIZE;
        if (path.equals(FAM_18_ADDRESS))
            return FAM_18_ADDRESS_SIZE;
        if (path.equals(FAM_18_FAMILY))
            return FAM_18_FAMILY_SIZE;
        if (path.equals(FAM_18_PAGES_COUNT_0))
            return FAM_18_PAGES_COUNT_0_SIZE;
        if (path.equals(FAM_18_CRC8)) {
            return FAM_18_CRC8_SIZE;
        }
        return -1;
    }
}