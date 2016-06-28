package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainer36 extends OneWireDevice {
    private static String FAM_36_SMOD = "smod";
    private static String FAM_36_LOCATOR = "locator";
    private static String FAM_36_R_ID = "r_id";
    private static String FAM_36_VIS_B = "vis_B";
    private static String FAM_36_ALIAS = "alias";
    private static String FAM_36_R_ADDRESS = "r_address";
    private static String FAM_36_R_LOCATOR = "r_locator";
    private static String FAM_36_TYPE = "type";
    private static String FAM_36_VOLTHOURS = "volthours";
    private static String FAM_36_MEMORY = "memory";
    private static String FAM_36_VIS = "vis";
    private static String FAM_36_ID = "id";
    private static String FAM_36_ADDRESS = "address";
    private static String FAM_36_FAMILY = "family";
    private static String FAM_36_PIO = "PIO";
    private static String FAM_36_CRC8 = "crc8";
    private static int FAM_36_SMOD_SIZE = 1;
    private static int FAM_36_LOCATOR_SIZE = 16;
    private static int FAM_36_R_ID_SIZE = 12;
    private static int FAM_36_VIS_B_SIZE = 12;
    private static int FAM_36_ALIAS_SIZE = 256;
    private static int FAM_36_R_ADDRESS_SIZE = 16;
    private static int FAM_36_R_LOCATOR_SIZE = 16;
    private static int FAM_36_TYPE_SIZE = 32;
    private static int FAM_36_VOLTHOURS_SIZE = 12;
    private static int FAM_36_MEMORY_SIZE = 256;
    private static int FAM_36_VIS_SIZE = 12;
    private static int FAM_36_ID_SIZE = 12;
    private static int FAM_36_ADDRESS_SIZE = 16;
    private static int FAM_36_FAMILY_SIZE = 2;
    private static int FAM_36_PIO_SIZE = 1;
    private static int FAM_36_CRC8_SIZE = 2;

    public OneWireContainer36() {
    }

    public OneWireContainer36(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_36_SMOD))
            return FAM_36_SMOD_SIZE;
        if (path.equals(FAM_36_LOCATOR))
            return FAM_36_LOCATOR_SIZE;
        if (path.equals(FAM_36_R_ID))
            return FAM_36_R_ID_SIZE;
        if (path.equals(FAM_36_VIS_B))
            return FAM_36_VIS_B_SIZE;
        if (path.equals(FAM_36_ALIAS))
            return FAM_36_ALIAS_SIZE;
        if (path.equals(FAM_36_R_ADDRESS))
            return FAM_36_R_ADDRESS_SIZE;
        if (path.equals(FAM_36_R_LOCATOR))
            return FAM_36_R_LOCATOR_SIZE;
        if (path.equals(FAM_36_TYPE))
            return FAM_36_TYPE_SIZE;
        if (path.equals(FAM_36_VOLTHOURS))
            return FAM_36_VOLTHOURS_SIZE;
        if (path.equals(FAM_36_MEMORY))
            return FAM_36_MEMORY_SIZE;
        if (path.equals(FAM_36_VIS))
            return FAM_36_VIS_SIZE;
        if (path.equals(FAM_36_ID))
            return FAM_36_ID_SIZE;
        if (path.equals(FAM_36_ADDRESS))
            return FAM_36_ADDRESS_SIZE;
        if (path.equals(FAM_36_FAMILY))
            return FAM_36_FAMILY_SIZE;
        if (path.equals(FAM_36_PIO))
            return FAM_36_PIO_SIZE;
        if (path.equals(FAM_36_CRC8)) {
            return FAM_36_CRC8_SIZE;
        }
        return -1;
    }
}