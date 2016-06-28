package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainerFF extends OneWireDevice {
    private static String FAM_FF_SCREEN40 = "screen40";
    private static String FAM_FF_LINE16_ALL = "line16.ALL";
    private static String FAM_FF_R_ADDRESS = "r_address";
    private static String FAM_FF_SCREEN20 = "screen20";
    private static String FAM_FF_DATA = "data";
    private static String FAM_FF_LINE40_0 = "line40.0";
    private static String FAM_FF_TYPE = "type";
    private static String FAM_FF_VERSION = "version";
    private static String FAM_FF_LCDON = "LCDon";
    private static String FAM_FF_ID = "id";
    private static String FAM_FF_FAMILY = "family";
    private static String FAM_FF_CRC8 = "crc8";
    private static String FAM_FF_GPIO_BYTE = "gpio.BYTE";
    private static String FAM_FF_GPIO_0 = "gpio.0";
    private static String FAM_FF_LOCATOR = "locator";
    private static String FAM_FF_LINE40_ALL = "line40.ALL";
    private static String FAM_FF_R_ID = "r_id";
    private static String FAM_FF_CUMULATIVE_0 = "cumulative.0";
    private static String FAM_FF_ALIAS = "alias";
    private static String FAM_FF_LINE20_0 = "line20.0";
    private static String FAM_FF_GPIO_ALL = "gpio.ALL";
    private static String FAM_FF_CUMULATIVE_ALL = "cumulative.ALL";
    private static String FAM_FF_R_LOCATOR = "r_locator";
    private static String FAM_FF_LINE20_ALL = "line20.ALL";
    private static String FAM_FF_MEMORY = "memory";
    private static String FAM_FF_REGISTER = "register";
    private static String FAM_FF_COUNTERS_ALL = "counters.ALL";
    private static String FAM_FF_LINE16_0 = "line16.0";
    private static String FAM_FF_COUNTERS_0 = "counters.0";
    private static String FAM_FF_BACKLIGHT = "backlight";
    private static String FAM_FF_ADDRESS = "address";
    private static String FAM_FF_SCREEN16 = "screen16";
    private static int FAM_FF_SCREEN40_SIZE = 128;
    private static int FAM_FF_LINE16_ALL_SIZE = 67;
    private static int FAM_FF_R_ADDRESS_SIZE = 16;
    private static int FAM_FF_SCREEN20_SIZE = 128;
    private static int FAM_FF_DATA_SIZE = 12;
    private static int FAM_FF_LINE40_0_SIZE = 40;
    private static int FAM_FF_TYPE_SIZE = 32;
    private static int FAM_FF_VERSION_SIZE = 16;
    private static int FAM_FF_LCDON_SIZE = 1;
    private static int FAM_FF_ID_SIZE = 12;
    private static int FAM_FF_FAMILY_SIZE = 2;
    private static int FAM_FF_CRC8_SIZE = 2;
    private static int FAM_FF_GPIO_BYTE_SIZE = 12;
    private static int FAM_FF_GPIO_0_SIZE = 1;
    private static int FAM_FF_LOCATOR_SIZE = 16;
    private static int FAM_FF_LINE40_ALL_SIZE = 81;
    private static int FAM_FF_R_ID_SIZE = 12;
    private static int FAM_FF_CUMULATIVE_0_SIZE = 12;
    private static int FAM_FF_ALIAS_SIZE = 256;
    private static int FAM_FF_LINE20_0_SIZE = 20;
    private static int FAM_FF_GPIO_ALL_SIZE = 7;
    private static int FAM_FF_CUMULATIVE_ALL_SIZE = 51;
    private static int FAM_FF_R_LOCATOR_SIZE = 16;
    private static int FAM_FF_LINE20_ALL_SIZE = 83;
    private static int FAM_FF_MEMORY_SIZE = 112;
    private static int FAM_FF_REGISTER_SIZE = 12;
    private static int FAM_FF_COUNTERS_ALL_SIZE = 51;
    private static int FAM_FF_LINE16_0_SIZE = 16;
    private static int FAM_FF_COUNTERS_0_SIZE = 12;
    private static int FAM_FF_BACKLIGHT_SIZE = 1;
    private static int FAM_FF_ADDRESS_SIZE = 16;
    private static int FAM_FF_SCREEN16_SIZE = 128;

    public OneWireContainerFF() {
    }

    public OneWireContainerFF(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_FF_SCREEN40))
            return FAM_FF_SCREEN40_SIZE;
        if (path.equals(FAM_FF_LINE16_ALL))
            return FAM_FF_LINE16_ALL_SIZE;
        if (path.equals(FAM_FF_R_ADDRESS))
            return FAM_FF_R_ADDRESS_SIZE;
        if (path.equals(FAM_FF_SCREEN20))
            return FAM_FF_SCREEN20_SIZE;
        if (path.equals(FAM_FF_DATA))
            return FAM_FF_DATA_SIZE;
        if (path.equals(FAM_FF_LINE40_0))
            return FAM_FF_LINE40_0_SIZE;
        if (path.equals(FAM_FF_TYPE))
            return FAM_FF_TYPE_SIZE;
        if (path.equals(FAM_FF_VERSION))
            return FAM_FF_VERSION_SIZE;
        if (path.equals(FAM_FF_LCDON))
            return FAM_FF_LCDON_SIZE;
        if (path.equals(FAM_FF_ID))
            return FAM_FF_ID_SIZE;
        if (path.equals(FAM_FF_FAMILY))
            return FAM_FF_FAMILY_SIZE;
        if (path.equals(FAM_FF_CRC8))
            return FAM_FF_CRC8_SIZE;
        if (path.equals(FAM_FF_GPIO_BYTE))
            return FAM_FF_GPIO_BYTE_SIZE;
        if (path.equals(FAM_FF_GPIO_0))
            return FAM_FF_GPIO_0_SIZE;
        if (path.equals(FAM_FF_LOCATOR))
            return FAM_FF_LOCATOR_SIZE;
        if (path.equals(FAM_FF_LINE40_ALL))
            return FAM_FF_LINE40_ALL_SIZE;
        if (path.equals(FAM_FF_R_ID))
            return FAM_FF_R_ID_SIZE;
        if (path.equals(FAM_FF_CUMULATIVE_0))
            return FAM_FF_CUMULATIVE_0_SIZE;
        if (path.equals(FAM_FF_ALIAS))
            return FAM_FF_ALIAS_SIZE;
        if (path.equals(FAM_FF_LINE20_0))
            return FAM_FF_LINE20_0_SIZE;
        if (path.equals(FAM_FF_GPIO_ALL))
            return FAM_FF_GPIO_ALL_SIZE;
        if (path.equals(FAM_FF_CUMULATIVE_ALL))
            return FAM_FF_CUMULATIVE_ALL_SIZE;
        if (path.equals(FAM_FF_R_LOCATOR))
            return FAM_FF_R_LOCATOR_SIZE;
        if (path.equals(FAM_FF_LINE20_ALL))
            return FAM_FF_LINE20_ALL_SIZE;
        if (path.equals(FAM_FF_MEMORY))
            return FAM_FF_MEMORY_SIZE;
        if (path.equals(FAM_FF_REGISTER))
            return FAM_FF_REGISTER_SIZE;
        if (path.equals(FAM_FF_COUNTERS_ALL))
            return FAM_FF_COUNTERS_ALL_SIZE;
        if (path.equals(FAM_FF_LINE16_0))
            return FAM_FF_LINE16_0_SIZE;
        if (path.equals(FAM_FF_COUNTERS_0))
            return FAM_FF_COUNTERS_0_SIZE;
        if (path.equals(FAM_FF_BACKLIGHT))
            return FAM_FF_BACKLIGHT_SIZE;
        if (path.equals(FAM_FF_ADDRESS))
            return FAM_FF_ADDRESS_SIZE;
        if (path.equals(FAM_FF_SCREEN16)) {
            return FAM_FF_SCREEN16_SIZE;
        }
        return -1;
    }
}