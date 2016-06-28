package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer89 extends OneWireDevice {
    private static String FAM_89_LOCATOR = "locator";
    private static String FAM_89_R_ID = "r_id";
    private static String FAM_89_ALIAS = "alias";
    private static String FAM_89_MAC_E = "mac_e";
    private static String FAM_89_R_ADDRESS = "r_address";
    private static String FAM_89_MAC_FW = "mac_fw";
    private static String FAM_89_R_LOCATOR = "r_locator";
    private static String FAM_89_TYPE = "type";
    private static String FAM_89_MEMORY = "memory";
    private static String FAM_89_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_89_ID = "id";
    private static String FAM_89_PROJECT = "project";
    private static String FAM_89_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_89_ADDRESS = "address";
    private static String FAM_89_FAMILY = "family";
    private static String FAM_89_CRC8 = "crc8";
    private static int FAM_89_LOCATOR_SIZE = 16;
    private static int FAM_89_R_ID_SIZE = 12;
    private static int FAM_89_ALIAS_SIZE = 256;
    private static int FAM_89_MAC_E_SIZE = 6;
    private static int FAM_89_R_ADDRESS_SIZE = 16;
    private static int FAM_89_MAC_FW_SIZE = 8;
    private static int FAM_89_R_LOCATOR_SIZE = 16;
    private static int FAM_89_TYPE_SIZE = 32;
    private static int FAM_89_MEMORY_SIZE = 128;
    private static int FAM_89_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_89_ID_SIZE = 12;
    private static int FAM_89_PROJECT_SIZE = 4;
    private static int FAM_89_PAGES_PAGE_ALL_SIZE = 128;
    private static int FAM_89_ADDRESS_SIZE = 16;
    private static int FAM_89_FAMILY_SIZE = 2;
    private static int FAM_89_CRC8_SIZE = 2;

    public OneWireContainer89() {
    }

    public OneWireContainer89(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_89_LOCATOR))
            return FAM_89_LOCATOR_SIZE;
        if (path.equals(FAM_89_R_ID))
            return FAM_89_R_ID_SIZE;
        if (path.equals(FAM_89_ALIAS))
            return FAM_89_ALIAS_SIZE;
        if (path.equals(FAM_89_MAC_E))
            return FAM_89_MAC_E_SIZE;
        if (path.equals(FAM_89_R_ADDRESS))
            return FAM_89_R_ADDRESS_SIZE;
        if (path.equals(FAM_89_MAC_FW))
            return FAM_89_MAC_FW_SIZE;
        if (path.equals(FAM_89_R_LOCATOR))
            return FAM_89_R_LOCATOR_SIZE;
        if (path.equals(FAM_89_TYPE))
            return FAM_89_TYPE_SIZE;
        if (path.equals(FAM_89_MEMORY))
            return FAM_89_MEMORY_SIZE;
        if (path.equals(FAM_89_PAGES_PAGE_0))
            return FAM_89_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_89_ID))
            return FAM_89_ID_SIZE;
        if (path.equals(FAM_89_PROJECT))
            return FAM_89_PROJECT_SIZE;
        if (path.equals(FAM_89_PAGES_PAGE_ALL))
            return FAM_89_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_89_ADDRESS))
            return FAM_89_ADDRESS_SIZE;
        if (path.equals(FAM_89_FAMILY))
            return FAM_89_FAMILY_SIZE;
        if (path.equals(FAM_89_CRC8)) {
            return FAM_89_CRC8_SIZE;
        }
        return -1;
    }
}