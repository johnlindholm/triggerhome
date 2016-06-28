package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer37 extends OneWireDevice {
    private static String FAM_37_LOCATOR = "locator";
    private static String FAM_37_R_ID = "r_id";
    private static String FAM_37_SET_PASSWORD_FULL = "set_password/full";
    private static String FAM_37_ALIAS = "alias";
    private static String FAM_37_R_ADDRESS = "r_address";
    private static String FAM_37_USE_PASSWORD_FULL = "use_password/full";
    private static String FAM_37_R_LOCATOR = "r_locator";
    private static String FAM_37_TYPE = "type";
    private static String FAM_37_MEMORY = "memory";
    private static String FAM_37_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_37_VERSION = "version";
    private static String FAM_37_ID = "id";
    private static String FAM_37_SET_PASSWORD_READ = "set_password/read";
    private static String FAM_37_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_37_ADDRESS = "address";
    private static String FAM_37_USE_PASSWORD_READ = "use_password/read";
    private static String FAM_37_FAMILY = "family";
    private static String FAM_37_SET_PASSWORD_ENABLED = "set_password/enabled";
    private static String FAM_37_CRC8 = "crc8";
    private static int FAM_37_LOCATOR_SIZE = 16;
    private static int FAM_37_R_ID_SIZE = 12;
    private static int FAM_37_SET_PASSWORD_FULL_SIZE = 8;
    private static int FAM_37_ALIAS_SIZE = 256;
    private static int FAM_37_R_ADDRESS_SIZE = 16;
    private static int FAM_37_USE_PASSWORD_FULL_SIZE = 8;
    private static int FAM_37_R_LOCATOR_SIZE = 16;
    private static int FAM_37_TYPE_SIZE = 32;
    private static int FAM_37_MEMORY_SIZE = 32704;
    private static int FAM_37_PAGES_PAGE_0_SIZE = 64;
    private static int FAM_37_VERSION_SIZE = 12;
    private static int FAM_37_ID_SIZE = 12;
    private static int FAM_37_SET_PASSWORD_READ_SIZE = 8;
    private static int FAM_37_PAGES_PAGE_ALL_SIZE = 32704;
    private static int FAM_37_ADDRESS_SIZE = 16;
    private static int FAM_37_USE_PASSWORD_READ_SIZE = 8;
    private static int FAM_37_FAMILY_SIZE = 2;
    private static int FAM_37_SET_PASSWORD_ENABLED_SIZE = 1;
    private static int FAM_37_CRC8_SIZE = 2;

    public OneWireContainer37() {
    }

    public OneWireContainer37(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_37_LOCATOR))
            return FAM_37_LOCATOR_SIZE;
        if (path.equals(FAM_37_R_ID))
            return FAM_37_R_ID_SIZE;
        if (path.equals(FAM_37_SET_PASSWORD_FULL))
            return FAM_37_SET_PASSWORD_FULL_SIZE;
        if (path.equals(FAM_37_ALIAS))
            return FAM_37_ALIAS_SIZE;
        if (path.equals(FAM_37_R_ADDRESS))
            return FAM_37_R_ADDRESS_SIZE;
        if (path.equals(FAM_37_USE_PASSWORD_FULL))
            return FAM_37_USE_PASSWORD_FULL_SIZE;
        if (path.equals(FAM_37_R_LOCATOR))
            return FAM_37_R_LOCATOR_SIZE;
        if (path.equals(FAM_37_TYPE))
            return FAM_37_TYPE_SIZE;
        if (path.equals(FAM_37_MEMORY))
            return FAM_37_MEMORY_SIZE;
        if (path.equals(FAM_37_PAGES_PAGE_0))
            return FAM_37_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_37_VERSION))
            return FAM_37_VERSION_SIZE;
        if (path.equals(FAM_37_ID))
            return FAM_37_ID_SIZE;
        if (path.equals(FAM_37_SET_PASSWORD_READ))
            return FAM_37_SET_PASSWORD_READ_SIZE;
        if (path.equals(FAM_37_PAGES_PAGE_ALL))
            return FAM_37_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_37_ADDRESS))
            return FAM_37_ADDRESS_SIZE;
        if (path.equals(FAM_37_USE_PASSWORD_READ))
            return FAM_37_USE_PASSWORD_READ_SIZE;
        if (path.equals(FAM_37_FAMILY))
            return FAM_37_FAMILY_SIZE;
        if (path.equals(FAM_37_SET_PASSWORD_ENABLED))
            return FAM_37_SET_PASSWORD_ENABLED_SIZE;
        if (path.equals(FAM_37_CRC8)) {
            return FAM_37_CRC8_SIZE;
        }
        return -1;
    }
}