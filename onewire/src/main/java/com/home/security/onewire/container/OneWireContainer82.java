package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer82 extends OneWireDevice {
    private static String FAM_82_SETTINGS_PASSWORD_ALL = "settings/password.ALL";
    private static String FAM_82_PAGES_IDENT_ALL = "pages/ident.ALL";
    private static String FAM_82_R_ADDRESS = "r_address";
    private static String FAM_82_TYPE = "type";
    private static String FAM_82_ID = "id";
    private static String FAM_82_FAMILY = "family";
    private static String FAM_82_SETTINGS_CHANGE_PASSWORD_ALL = "settings/change_password.ALL";
    private static String FAM_82_SETTINGS_PASSWORD_0 = "settings/password.0";
    private static String FAM_82_CRC8 = "crc8";
    private static String FAM_82_PAGES_PASSWORD_0 = "pages/password.0";
    private static String FAM_82_LOCATOR = "locator";
    private static String FAM_82_PAGES_PASSWORD_ALL = "pages/password.ALL";
    private static String FAM_82_R_ID = "r_id";
    private static String FAM_82_PAGES_IDENT_0 = "pages/ident.0";
    private static String FAM_82_ALIAS = "alias";
    private static String FAM_82_SETTINGS_RESET_PASSWORD_ALL = "settings/reset_password.ALL";
    private static String FAM_82_SETTINGS_CHANGE_PASSWORD_0 = "settings/change_password.0";
    private static String FAM_82_R_LOCATOR = "r_locator";
    private static String FAM_82_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_82_MEMORY = "memory";
    private static String FAM_82_SETTINGS_PAGE_ALL = "settings/page.ALL";
    private static String FAM_82_SETTINGS_PAGE_0 = "settings/page.0";
    private static String FAM_82_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_82_SETTINGS_IDENT_0 = "settings/ident.0";
    private static String FAM_82_ADDRESS = "address";
    private static String FAM_82_SETTINGS_IDENT_ALL = "settings/ident.ALL";
    private static String FAM_82_SETTINGS_RESET_PASSWORD_0 = "settings/reset_password.0";
    private static int FAM_82_SETTINGS_PASSWORD_ALL_SIZE = 24;
    private static int FAM_82_PAGES_IDENT_ALL_SIZE = 24;
    private static int FAM_82_R_ADDRESS_SIZE = 16;
    private static int FAM_82_TYPE_SIZE = 32;
    private static int FAM_82_ID_SIZE = 12;
    private static int FAM_82_FAMILY_SIZE = 2;
    private static int FAM_82_SETTINGS_CHANGE_PASSWORD_ALL_SIZE = 24;
    private static int FAM_82_SETTINGS_PASSWORD_0_SIZE = 8;
    private static int FAM_82_CRC8_SIZE = 2;
    private static int FAM_82_PAGES_PASSWORD_0_SIZE = 8;
    private static int FAM_82_LOCATOR_SIZE = 16;
    private static int FAM_82_PAGES_PASSWORD_ALL_SIZE = 24;
    private static int FAM_82_R_ID_SIZE = 12;
    private static int FAM_82_PAGES_IDENT_0_SIZE = 8;
    private static int FAM_82_ALIAS_SIZE = 256;
    private static int FAM_82_SETTINGS_RESET_PASSWORD_ALL_SIZE = 24;
    private static int FAM_82_SETTINGS_CHANGE_PASSWORD_0_SIZE = 8;
    private static int FAM_82_R_LOCATOR_SIZE = 16;
    private static int FAM_82_PAGES_PAGE_0_SIZE = 48;
    private static int FAM_82_MEMORY_SIZE = 144;
    private static int FAM_82_SETTINGS_PAGE_ALL_SIZE = 144;
    private static int FAM_82_SETTINGS_PAGE_0_SIZE = 48;
    private static int FAM_82_PAGES_PAGE_ALL_SIZE = 144;
    private static int FAM_82_SETTINGS_IDENT_0_SIZE = 8;
    private static int FAM_82_ADDRESS_SIZE = 16;
    private static int FAM_82_SETTINGS_IDENT_ALL_SIZE = 24;
    private static int FAM_82_SETTINGS_RESET_PASSWORD_0_SIZE = 8;

    public OneWireContainer82() {
    }

    public OneWireContainer82(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_82_SETTINGS_PASSWORD_ALL))
            return FAM_82_SETTINGS_PASSWORD_ALL_SIZE;
        if (path.equals(FAM_82_PAGES_IDENT_ALL))
            return FAM_82_PAGES_IDENT_ALL_SIZE;
        if (path.equals(FAM_82_R_ADDRESS))
            return FAM_82_R_ADDRESS_SIZE;
        if (path.equals(FAM_82_TYPE))
            return FAM_82_TYPE_SIZE;
        if (path.equals(FAM_82_ID))
            return FAM_82_ID_SIZE;
        if (path.equals(FAM_82_FAMILY))
            return FAM_82_FAMILY_SIZE;
        if (path.equals(FAM_82_SETTINGS_CHANGE_PASSWORD_ALL))
            return FAM_82_SETTINGS_CHANGE_PASSWORD_ALL_SIZE;
        if (path.equals(FAM_82_SETTINGS_PASSWORD_0))
            return FAM_82_SETTINGS_PASSWORD_0_SIZE;
        if (path.equals(FAM_82_CRC8))
            return FAM_82_CRC8_SIZE;
        if (path.equals(FAM_82_PAGES_PASSWORD_0))
            return FAM_82_PAGES_PASSWORD_0_SIZE;
        if (path.equals(FAM_82_LOCATOR))
            return FAM_82_LOCATOR_SIZE;
        if (path.equals(FAM_82_PAGES_PASSWORD_ALL))
            return FAM_82_PAGES_PASSWORD_ALL_SIZE;
        if (path.equals(FAM_82_R_ID))
            return FAM_82_R_ID_SIZE;
        if (path.equals(FAM_82_PAGES_IDENT_0))
            return FAM_82_PAGES_IDENT_0_SIZE;
        if (path.equals(FAM_82_ALIAS))
            return FAM_82_ALIAS_SIZE;
        if (path.equals(FAM_82_SETTINGS_RESET_PASSWORD_ALL))
            return FAM_82_SETTINGS_RESET_PASSWORD_ALL_SIZE;
        if (path.equals(FAM_82_SETTINGS_CHANGE_PASSWORD_0))
            return FAM_82_SETTINGS_CHANGE_PASSWORD_0_SIZE;
        if (path.equals(FAM_82_R_LOCATOR))
            return FAM_82_R_LOCATOR_SIZE;
        if (path.equals(FAM_82_PAGES_PAGE_0))
            return FAM_82_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_82_MEMORY))
            return FAM_82_MEMORY_SIZE;
        if (path.equals(FAM_82_SETTINGS_PAGE_ALL))
            return FAM_82_SETTINGS_PAGE_ALL_SIZE;
        if (path.equals(FAM_82_SETTINGS_PAGE_0))
            return FAM_82_SETTINGS_PAGE_0_SIZE;
        if (path.equals(FAM_82_PAGES_PAGE_ALL))
            return FAM_82_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_82_SETTINGS_IDENT_0))
            return FAM_82_SETTINGS_IDENT_0_SIZE;
        if (path.equals(FAM_82_ADDRESS))
            return FAM_82_ADDRESS_SIZE;
        if (path.equals(FAM_82_SETTINGS_IDENT_ALL))
            return FAM_82_SETTINGS_IDENT_ALL_SIZE;
        if (path.equals(FAM_82_SETTINGS_RESET_PASSWORD_0)) {
            return FAM_82_SETTINGS_RESET_PASSWORD_0_SIZE;
        }
        return -1;
    }
}