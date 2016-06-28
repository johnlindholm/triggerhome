package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer20 extends OneWireDevice
        implements OneWireVoltageSensorContainer {
    private static String FAM_20_VOLT_A = "volt.A";
    private static String FAM_20_SET_ALARM_VOLT2HIGH_ALL = "set_alarm/volt2high.ALL";
    private static String FAM_20_R_ADDRESS = "r_address";
    private static String FAM_20_SET_ALARM_LOW_A = "set_alarm/low.A";
    private static String FAM_20_ALARM_LOW_A = "alarm/low.A";
    private static String FAM_20_TYPE = "type";
    private static String FAM_20_ALARM_HIGH_ALL = "alarm/high.ALL";
    private static String FAM_20_SET_ALARM_VOLTLOW_A = "set_alarm/voltlow.A";
    private static String FAM_20_ID = "id";
    private static String FAM_20_CO2_VDD = "CO2/Vdd";
    private static String FAM_20_SET_ALARM_HIGH_A = "set_alarm/high.A";
    private static String FAM_20_SET_ALARM_HIGH_ALL = "set_alarm/high.ALL";
    private static String FAM_20_FAMILY = "family";
    private static String FAM_20_CRC8 = "crc8";
    private static String FAM_20_POWER = "power";
    private static String FAM_20_LOCATOR = "locator";
    private static String FAM_20_SET_ALARM_LOW_ALL = "set_alarm/low.ALL";
    private static String FAM_20_CO2_PPM = "CO2/ppm";
    private static String FAM_20_R_ID = "r_id";
    private static String FAM_20_ALIAS = "alias";
    private static String FAM_20_SET_ALARM_UNSET = "set_alarm/unset";
    private static String FAM_20_ALARM_LOW_ALL = "alarm/low.ALL";
    private static String FAM_20_SET_ALARM_VOLTHIGH_A = "set_alarm/volthigh.A";
    private static String FAM_20_PIO_ALL = "PIO.ALL";
    private static String FAM_20_SET_ALARM_VOLT2HIGH_A = "set_alarm/volt2high.A";
    private static String FAM_20_SET_ALARM_VOLTLOW_ALL = "set_alarm/voltlow.ALL";
    private static String FAM_20_VOLT2_A = "volt2.A";
    private static String FAM_20_R_LOCATOR = "r_locator";
    private static String FAM_20_MEMORY = "memory";
    private static String FAM_20_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_20_SET_ALARM_VOLT2LOW_A = "set_alarm/volt2low.A";
    private static String FAM_20_PIO_A = "PIO.A";
    private static String FAM_20_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_20_ADDRESS = "address";
    private static String FAM_20_CO2_STATUS = "CO2/status";
    private static String FAM_20_VOLT2_ALL = "volt2.ALL";
    private static String FAM_20_VOLT_ALL = "volt.ALL";
    private static String FAM_20_SET_ALARM_VOLTHIGH_ALL = "set_alarm/volthigh.ALL";
    private static String FAM_20_ALARM_HIGH_A = "alarm/high.A";
    private static String FAM_20_SET_ALARM_VOLT2LOW_ALL = "set_alarm/volt2low.ALL";
    private static int FAM_20_VOLT_A_SIZE = 12;
    private static int FAM_20_SET_ALARM_VOLT2HIGH_ALL_SIZE = 51;
    private static int FAM_20_R_ADDRESS_SIZE = 16;
    private static int FAM_20_SET_ALARM_LOW_A_SIZE = 1;
    private static int FAM_20_ALARM_LOW_A_SIZE = 1;
    private static int FAM_20_TYPE_SIZE = 32;
    private static int FAM_20_ALARM_HIGH_ALL_SIZE = 7;
    private static int FAM_20_SET_ALARM_VOLTLOW_A_SIZE = 12;
    private static int FAM_20_ID_SIZE = 12;
    private static int FAM_20_CO2_VDD_SIZE = 1;
    private static int FAM_20_SET_ALARM_HIGH_A_SIZE = 1;
    private static int FAM_20_SET_ALARM_HIGH_ALL_SIZE = 7;
    private static int FAM_20_FAMILY_SIZE = 2;
    private static int FAM_20_CRC8_SIZE = 2;
    private static int FAM_20_POWER_SIZE = 1;
    private static int FAM_20_LOCATOR_SIZE = 16;
    private static int FAM_20_SET_ALARM_LOW_ALL_SIZE = 7;
    private static int FAM_20_CO2_PPM_SIZE = 12;
    private static int FAM_20_R_ID_SIZE = 12;
    private static int FAM_20_ALIAS_SIZE = 256;
    private static int FAM_20_SET_ALARM_UNSET_SIZE = 1;
    private static int FAM_20_ALARM_LOW_ALL_SIZE = 7;
    private static int FAM_20_SET_ALARM_VOLTHIGH_A_SIZE = 12;
    private static int FAM_20_PIO_ALL_SIZE = 7;
    private static int FAM_20_SET_ALARM_VOLT2HIGH_A_SIZE = 12;
    private static int FAM_20_SET_ALARM_VOLTLOW_ALL_SIZE = 51;
    private static int FAM_20_VOLT2_A_SIZE = 12;
    private static int FAM_20_R_LOCATOR_SIZE = 16;
    private static int FAM_20_MEMORY_SIZE = 32;
    private static int FAM_20_PAGES_PAGE_0_SIZE = 8;
    private static int FAM_20_SET_ALARM_VOLT2LOW_A_SIZE = 12;
    private static int FAM_20_PIO_A_SIZE = 1;
    private static int FAM_20_PAGES_PAGE_ALL_SIZE = 32;
    private static int FAM_20_ADDRESS_SIZE = 16;
    private static int FAM_20_CO2_STATUS_SIZE = 12;
    private static int FAM_20_VOLT2_ALL_SIZE = 51;
    private static int FAM_20_VOLT_ALL_SIZE = 51;
    private static int FAM_20_SET_ALARM_VOLTHIGH_ALL_SIZE = 51;
    private static int FAM_20_ALARM_HIGH_A_SIZE = 1;
    private static int FAM_20_SET_ALARM_VOLT2LOW_ALL_SIZE = 51;

    public OneWireContainer20() {
    }

    public OneWireContainer20(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_20_VOLT_A))
            return FAM_20_VOLT_A_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLT2HIGH_ALL))
            return FAM_20_SET_ALARM_VOLT2HIGH_ALL_SIZE;
        if (path.equals(FAM_20_R_ADDRESS))
            return FAM_20_R_ADDRESS_SIZE;
        if (path.equals(FAM_20_SET_ALARM_LOW_A))
            return FAM_20_SET_ALARM_LOW_A_SIZE;
        if (path.equals(FAM_20_ALARM_LOW_A))
            return FAM_20_ALARM_LOW_A_SIZE;
        if (path.equals(FAM_20_TYPE))
            return FAM_20_TYPE_SIZE;
        if (path.equals(FAM_20_ALARM_HIGH_ALL))
            return FAM_20_ALARM_HIGH_ALL_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLTLOW_A))
            return FAM_20_SET_ALARM_VOLTLOW_A_SIZE;
        if (path.equals(FAM_20_ID))
            return FAM_20_ID_SIZE;
        if (path.equals(FAM_20_CO2_VDD))
            return FAM_20_CO2_VDD_SIZE;
        if (path.equals(FAM_20_SET_ALARM_HIGH_A))
            return FAM_20_SET_ALARM_HIGH_A_SIZE;
        if (path.equals(FAM_20_SET_ALARM_HIGH_ALL))
            return FAM_20_SET_ALARM_HIGH_ALL_SIZE;
        if (path.equals(FAM_20_FAMILY))
            return FAM_20_FAMILY_SIZE;
        if (path.equals(FAM_20_CRC8))
            return FAM_20_CRC8_SIZE;
        if (path.equals(FAM_20_POWER))
            return FAM_20_POWER_SIZE;
        if (path.equals(FAM_20_LOCATOR))
            return FAM_20_LOCATOR_SIZE;
        if (path.equals(FAM_20_SET_ALARM_LOW_ALL))
            return FAM_20_SET_ALARM_LOW_ALL_SIZE;
        if (path.equals(FAM_20_CO2_PPM))
            return FAM_20_CO2_PPM_SIZE;
        if (path.equals(FAM_20_R_ID))
            return FAM_20_R_ID_SIZE;
        if (path.equals(FAM_20_ALIAS))
            return FAM_20_ALIAS_SIZE;
        if (path.equals(FAM_20_SET_ALARM_UNSET))
            return FAM_20_SET_ALARM_UNSET_SIZE;
        if (path.equals(FAM_20_ALARM_LOW_ALL))
            return FAM_20_ALARM_LOW_ALL_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLTHIGH_A))
            return FAM_20_SET_ALARM_VOLTHIGH_A_SIZE;
        if (path.equals(FAM_20_PIO_ALL))
            return FAM_20_PIO_ALL_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLT2HIGH_A))
            return FAM_20_SET_ALARM_VOLT2HIGH_A_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLTLOW_ALL))
            return FAM_20_SET_ALARM_VOLTLOW_ALL_SIZE;
        if (path.equals(FAM_20_VOLT2_A))
            return FAM_20_VOLT2_A_SIZE;
        if (path.equals(FAM_20_R_LOCATOR))
            return FAM_20_R_LOCATOR_SIZE;
        if (path.equals(FAM_20_MEMORY))
            return FAM_20_MEMORY_SIZE;
        if (path.equals(FAM_20_PAGES_PAGE_0))
            return FAM_20_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLT2LOW_A))
            return FAM_20_SET_ALARM_VOLT2LOW_A_SIZE;
        if (path.equals(FAM_20_PIO_A))
            return FAM_20_PIO_A_SIZE;
        if (path.equals(FAM_20_PAGES_PAGE_ALL))
            return FAM_20_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_20_ADDRESS))
            return FAM_20_ADDRESS_SIZE;
        if (path.equals(FAM_20_CO2_STATUS))
            return FAM_20_CO2_STATUS_SIZE;
        if (path.equals(FAM_20_VOLT2_ALL))
            return FAM_20_VOLT2_ALL_SIZE;
        if (path.equals(FAM_20_VOLT_ALL))
            return FAM_20_VOLT_ALL_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLTHIGH_ALL))
            return FAM_20_SET_ALARM_VOLTHIGH_ALL_SIZE;
        if (path.equals(FAM_20_ALARM_HIGH_A))
            return FAM_20_ALARM_HIGH_A_SIZE;
        if (path.equals(FAM_20_SET_ALARM_VOLT2LOW_ALL)) {
            return FAM_20_SET_ALARM_VOLT2LOW_ALL_SIZE;
        }
        return -1;
    }

    public String getVoltageAll()
            throws IOException {
        return readValue("volt.ALL", true);
    }
}