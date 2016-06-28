package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer1D extends OneWireDevice {
    private static String FAM_1D_LOCATOR = "locator";
    private static String FAM_1D_R_ID = "r_id";
    private static String FAM_1D_R_ADDRESS = "r_address";
    private static String FAM_1D_ALIAS = "alias";
    private static String FAM_1D_R_LOCATOR = "r_locator";
    private static String FAM_1D_TYPE = "type";
    private static String FAM_1D_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_1D_MEMORY = "memory";
    private static String FAM_1D_ID = "id";
    private static String FAM_1D_COUNTERS_ALL = "counters.ALL";
    private static String FAM_1D_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_1D_PAGES_COUNT_ALL = "pages/count.ALL";
    private static String FAM_1D_ADDRESS = "address";
    private static String FAM_1D_FAMILY = "family";
    private static String FAM_1D_PAGES_COUNT_0 = "pages/count.0";
    private static String FAM_1D_CRC8 = "crc8";
    private static String FAM_1D_MINCOUNT = "mincount";
    private static String FAM_1D_COUNTERS_A = "counters.A";
    private static int FAM_1D_LOCATOR_SIZE = 16;
    private static int FAM_1D_R_ID_SIZE = 12;
    private static int FAM_1D_R_ADDRESS_SIZE = 16;
    private static int FAM_1D_ALIAS_SIZE = 256;
    private static int FAM_1D_R_LOCATOR_SIZE = 16;
    private static int FAM_1D_TYPE_SIZE = 32;
    private static int FAM_1D_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_1D_MEMORY_SIZE = 512;
    private static int FAM_1D_ID_SIZE = 12;
    private static int FAM_1D_COUNTERS_ALL_SIZE = 25;
    private static int FAM_1D_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_1D_PAGES_COUNT_ALL_SIZE = 207;
    private static int FAM_1D_ADDRESS_SIZE = 16;
    private static int FAM_1D_FAMILY_SIZE = 2;
    private static int FAM_1D_PAGES_COUNT_0_SIZE = 12;
    private static int FAM_1D_CRC8_SIZE = 2;
    private static int FAM_1D_MINCOUNT_SIZE = 12;
    private static int FAM_1D_COUNTERS_A_SIZE = 12;

    public OneWireContainer1D() {
    }

    public OneWireContainer1D(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_1D_LOCATOR))
            return FAM_1D_LOCATOR_SIZE;
        if (path.equals(FAM_1D_R_ID))
            return FAM_1D_R_ID_SIZE;
        if (path.equals(FAM_1D_R_ADDRESS))
            return FAM_1D_R_ADDRESS_SIZE;
        if (path.equals(FAM_1D_ALIAS))
            return FAM_1D_ALIAS_SIZE;
        if (path.equals(FAM_1D_R_LOCATOR))
            return FAM_1D_R_LOCATOR_SIZE;
        if (path.equals(FAM_1D_TYPE))
            return FAM_1D_TYPE_SIZE;
        if (path.equals(FAM_1D_PAGES_PAGE_0))
            return FAM_1D_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_1D_MEMORY))
            return FAM_1D_MEMORY_SIZE;
        if (path.equals(FAM_1D_ID))
            return FAM_1D_ID_SIZE;
        if (path.equals(FAM_1D_COUNTERS_ALL))
            return FAM_1D_COUNTERS_ALL_SIZE;
        if (path.equals(FAM_1D_PAGES_PAGE_ALL))
            return FAM_1D_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_1D_PAGES_COUNT_ALL))
            return FAM_1D_PAGES_COUNT_ALL_SIZE;
        if (path.equals(FAM_1D_ADDRESS))
            return FAM_1D_ADDRESS_SIZE;
        if (path.equals(FAM_1D_FAMILY))
            return FAM_1D_FAMILY_SIZE;
        if (path.equals(FAM_1D_PAGES_COUNT_0))
            return FAM_1D_PAGES_COUNT_0_SIZE;
        if (path.equals(FAM_1D_CRC8))
            return FAM_1D_CRC8_SIZE;
        if (path.equals(FAM_1D_MINCOUNT))
            return FAM_1D_MINCOUNT_SIZE;
        if (path.equals(FAM_1D_COUNTERS_A)) {
            return FAM_1D_COUNTERS_A_SIZE;
        }
        return -1;
    }
}