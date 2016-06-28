package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer31 extends OneWireDevice {
    private static String FAM_31_OT = "ot";
    private static String FAM_31_DC = "dc";
    private static String FAM_31_LOCATOR = "locator";
    private static String FAM_31_OV = "ov";
    private static String FAM_31_R_ID = "r_id";
    private static String FAM_31_R_ADDRESS = "r_address";
    private static String FAM_31_ALIAS = "alias";
    private static String FAM_31_R_LOCATOR = "r_locator";
    private static String FAM_31_TYPE = "type";
    private static String FAM_31_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_31_MEMORY = "memory";
    private static String FAM_31_LOCK_ALL = "lock.ALL";
    private static String FAM_31_PSF = "psf";
    private static String FAM_31_DE = "de";
    private static String FAM_31_ID = "id";
    private static String FAM_31_LOCK_0 = "lock.0";
    private static String FAM_31_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_31_ADDRESS = "address";
    private static String FAM_31_UV = "uv";
    private static String FAM_31_FAMILY = "family";
    private static String FAM_31_DOC = "doc";
    private static String FAM_31_CRC8 = "crc8";
    private static String FAM_31_CE = "ce";
    private static String FAM_31_CC = "cc";
    private static int FAM_31_OT_SIZE = 1;
    private static int FAM_31_DC_SIZE = 1;
    private static int FAM_31_LOCATOR_SIZE = 16;
    private static int FAM_31_OV_SIZE = 1;
    private static int FAM_31_R_ID_SIZE = 12;
    private static int FAM_31_R_ADDRESS_SIZE = 16;
    private static int FAM_31_ALIAS_SIZE = 256;
    private static int FAM_31_R_LOCATOR_SIZE = 16;
    private static int FAM_31_TYPE_SIZE = 32;
    private static int FAM_31_PAGES_PAGE_0_SIZE = 4;
    private static int FAM_31_MEMORY_SIZE = 256;
    private static int FAM_31_LOCK_ALL_SIZE = 3;
    private static int FAM_31_PSF_SIZE = 1;
    private static int FAM_31_DE_SIZE = 1;
    private static int FAM_31_ID_SIZE = 12;
    private static int FAM_31_LOCK_0_SIZE = 1;
    private static int FAM_31_PAGES_PAGE_ALL_SIZE = 8;
    private static int FAM_31_ADDRESS_SIZE = 16;
    private static int FAM_31_UV_SIZE = 1;
    private static int FAM_31_FAMILY_SIZE = 2;
    private static int FAM_31_DOC_SIZE = 1;
    private static int FAM_31_CRC8_SIZE = 2;
    private static int FAM_31_CE_SIZE = 1;
    private static int FAM_31_CC_SIZE = 1;

    public OneWireContainer31() {
    }

    public OneWireContainer31(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_31_OT))
            return FAM_31_OT_SIZE;
        if (path.equals(FAM_31_DC))
            return FAM_31_DC_SIZE;
        if (path.equals(FAM_31_LOCATOR))
            return FAM_31_LOCATOR_SIZE;
        if (path.equals(FAM_31_OV))
            return FAM_31_OV_SIZE;
        if (path.equals(FAM_31_R_ID))
            return FAM_31_R_ID_SIZE;
        if (path.equals(FAM_31_R_ADDRESS))
            return FAM_31_R_ADDRESS_SIZE;
        if (path.equals(FAM_31_ALIAS))
            return FAM_31_ALIAS_SIZE;
        if (path.equals(FAM_31_R_LOCATOR))
            return FAM_31_R_LOCATOR_SIZE;
        if (path.equals(FAM_31_TYPE))
            return FAM_31_TYPE_SIZE;
        if (path.equals(FAM_31_PAGES_PAGE_0))
            return FAM_31_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_31_MEMORY))
            return FAM_31_MEMORY_SIZE;
        if (path.equals(FAM_31_LOCK_ALL))
            return FAM_31_LOCK_ALL_SIZE;
        if (path.equals(FAM_31_PSF))
            return FAM_31_PSF_SIZE;
        if (path.equals(FAM_31_DE))
            return FAM_31_DE_SIZE;
        if (path.equals(FAM_31_ID))
            return FAM_31_ID_SIZE;
        if (path.equals(FAM_31_LOCK_0))
            return FAM_31_LOCK_0_SIZE;
        if (path.equals(FAM_31_PAGES_PAGE_ALL))
            return FAM_31_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_31_ADDRESS))
            return FAM_31_ADDRESS_SIZE;
        if (path.equals(FAM_31_UV))
            return FAM_31_UV_SIZE;
        if (path.equals(FAM_31_FAMILY))
            return FAM_31_FAMILY_SIZE;
        if (path.equals(FAM_31_DOC))
            return FAM_31_DOC_SIZE;
        if (path.equals(FAM_31_CRC8))
            return FAM_31_CRC8_SIZE;
        if (path.equals(FAM_31_CE))
            return FAM_31_CE_SIZE;
        if (path.equals(FAM_31_CC)) {
            return FAM_31_CC_SIZE;
        }
        return -1;
    }
}