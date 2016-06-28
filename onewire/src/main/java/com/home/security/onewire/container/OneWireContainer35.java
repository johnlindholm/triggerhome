package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer35 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_35_TYPEE_RANGE_LOW = "typeE/range_low";
    private static String FAM_35_R_ADDRESS = "r_address";
    private static String FAM_35_VBIAS = "vbias";
    private static String FAM_35_POR = "por";
    private static String FAM_35_TYPEJ_RANGE_LOW = "typeJ/range_low";
    private static String FAM_35_TYPE = "type";
    private static String FAM_35_TEMPERATURE = "temperature";
    private static String FAM_35_VIS_AVG = "vis_avg";
    private static String FAM_35_TYPEE_TEMPERATURE = "typeE/temperature";
    private static String FAM_35_FAMILY = "family";
    private static String FAM_35_TYPER_RANGE_LOW = "typeR/range_low";
    private static String FAM_35_TYPEK_RANGE_LOW = "typeK/range_low";
    private static String FAM_35_TYPEB_RANGE_HIGH = "typeB/range_high";
    private static String FAM_35_TYPEJ_TEMPERATURE = "typeJ/temperature";
    private static String FAM_35_TYPEB_RANGE_LOW = "typeB/range_low";
    private static String FAM_35_TYPER_RANGE_HIGH = "typeR/range_high";
    private static String FAM_35_LOCATOR = "locator";
    private static String FAM_35_ALARM_SET = "alarm_set";
    private static String FAM_35_R_ID = "r_id";
    private static String FAM_35_IOS = "ios";
    private static String FAM_35_TYPET_RANGE_LOW = "typeT/range_low";
    private static String FAM_35_TYPEN_RANGE_HIGH = "typeN/range_high";
    private static String FAM_35_VIS = "vis";
    private static String FAM_35_TYPER_TEMPERATURE = "typeR/temperature";
    private static String FAM_35_TYPES_TEMPERATURE = "typeS/temperature";
    private static String FAM_35_TYPEK_RANGE_HIGH = "typeK/range_high";
    private static String FAM_35_TYPEB_TEMPERATURE = "typeB/temperature";
    private static String FAM_35_VOLT = "volt";
    private static String FAM_35_PMOD = "pmod";
    private static String FAM_35_SENSED = "sensed";
    private static String FAM_35_DEFAULTPMOD = "defaultpmod";
    private static String FAM_35_TYPEE_RANGE_HIGH = "typeE/range_high";
    private static String FAM_35_UBEN = "uben";
    private static String FAM_35_UVEN = "uven";
    private static String FAM_35_VOLTHOURS = "volthours";
    private static String FAM_35_RNAOP = "rnaop";
    private static String FAM_35_LOCK_ALL = "lock.ALL";
    private static String FAM_35_ID = "id";
    private static String FAM_35_LOCK_0 = "lock.0";
    private static String FAM_35_PIO = "PIO";
    private static String FAM_35_CRC8 = "crc8";
    private static String FAM_35_PIE1 = "pie1";
    private static String FAM_35_PIE0 = "pie0";
    private static String FAM_35_TYPET_RANGE_HIGH = "typeT/range_high";
    private static String FAM_35_TYPEK_TEMPERATURE = "typeK/temperature";
    private static String FAM_35_ALIAS = "alias";
    private static String FAM_35_R_LOCATOR = "r_locator";
    private static String FAM_35_OVD = "ovd";
    private static String FAM_35_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_35_MEMORY = "memory";
    private static String FAM_35_TYPET_TEMPERATURE = "typeT/temperature";
    private static String FAM_35_TYPES_RANGE_HIGH = "typeS/range_high";
    private static String FAM_35_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_35_ADDRESS = "address";
    private static String FAM_35_TYPES_RANGE_LOW = "typeS/range_low";
    private static String FAM_35_TYPEJ_RANGE_HIGH = "typeJ/range_high";
    private static String FAM_35_TYPEN_RANGE_LOW = "typeN/range_low";
    private static String FAM_35_TYPEN_TEMPERATURE = "typeN/temperature";
    private static int FAM_35_TYPEE_RANGE_LOW_SIZE = 12;
    private static int FAM_35_R_ADDRESS_SIZE = 16;
    private static int FAM_35_VBIAS_SIZE = 12;
    private static int FAM_35_POR_SIZE = 1;
    private static int FAM_35_TYPEJ_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPE_SIZE = 32;
    private static int FAM_35_TEMPERATURE_SIZE = 12;
    private static int FAM_35_VIS_AVG_SIZE = 12;
    private static int FAM_35_TYPEE_TEMPERATURE_SIZE = 12;
    private static int FAM_35_FAMILY_SIZE = 2;
    private static int FAM_35_TYPER_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPEK_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPEB_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_TYPEJ_TEMPERATURE_SIZE = 12;
    private static int FAM_35_TYPEB_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPER_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_LOCATOR_SIZE = 16;
    private static int FAM_35_ALARM_SET_SIZE = 12;
    private static int FAM_35_R_ID_SIZE = 12;
    private static int FAM_35_IOS_SIZE = 1;
    private static int FAM_35_TYPET_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPEN_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_VIS_SIZE = 12;
    private static int FAM_35_TYPER_TEMPERATURE_SIZE = 12;
    private static int FAM_35_TYPES_TEMPERATURE_SIZE = 12;
    private static int FAM_35_TYPEK_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_TYPEB_TEMPERATURE_SIZE = 12;
    private static int FAM_35_VOLT_SIZE = 12;
    private static int FAM_35_PMOD_SIZE = 1;
    private static int FAM_35_SENSED_SIZE = 1;
    private static int FAM_35_DEFAULTPMOD_SIZE = 1;
    private static int FAM_35_TYPEE_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_UBEN_SIZE = 1;
    private static int FAM_35_UVEN_SIZE = 1;
    private static int FAM_35_VOLTHOURS_SIZE = 12;
    private static int FAM_35_RNAOP_SIZE = 1;
    private static int FAM_35_LOCK_ALL_SIZE = 5;
    private static int FAM_35_ID_SIZE = 12;
    private static int FAM_35_LOCK_0_SIZE = 1;
    private static int FAM_35_PIO_SIZE = 1;
    private static int FAM_35_CRC8_SIZE = 2;
    private static int FAM_35_PIE1_SIZE = 1;
    private static int FAM_35_PIE0_SIZE = 1;
    private static int FAM_35_TYPET_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_TYPEK_TEMPERATURE_SIZE = 12;
    private static int FAM_35_ALIAS_SIZE = 256;
    private static int FAM_35_R_LOCATOR_SIZE = 16;
    private static int FAM_35_OVD_SIZE = 1;
    private static int FAM_35_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_35_MEMORY_SIZE = 256;
    private static int FAM_35_TYPET_TEMPERATURE_SIZE = 12;
    private static int FAM_35_TYPES_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_PAGES_PAGE_ALL_SIZE = 96;
    private static int FAM_35_ADDRESS_SIZE = 16;
    private static int FAM_35_TYPES_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPEJ_RANGE_HIGH_SIZE = 12;
    private static int FAM_35_TYPEN_RANGE_LOW_SIZE = 12;
    private static int FAM_35_TYPEN_TEMPERATURE_SIZE = 12;

    public OneWireContainer35() {
    }

    public OneWireContainer35(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_35_TYPEE_RANGE_LOW))
            return FAM_35_TYPEE_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_R_ADDRESS))
            return FAM_35_R_ADDRESS_SIZE;
        if (path.equals(FAM_35_VBIAS))
            return FAM_35_VBIAS_SIZE;
        if (path.equals(FAM_35_POR))
            return FAM_35_POR_SIZE;
        if (path.equals(FAM_35_TYPEJ_RANGE_LOW))
            return FAM_35_TYPEJ_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPE))
            return FAM_35_TYPE_SIZE;
        if (path.equals(FAM_35_TEMPERATURE))
            return FAM_35_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_VIS_AVG))
            return FAM_35_VIS_AVG_SIZE;
        if (path.equals(FAM_35_TYPEE_TEMPERATURE))
            return FAM_35_TYPEE_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_FAMILY))
            return FAM_35_FAMILY_SIZE;
        if (path.equals(FAM_35_TYPER_RANGE_LOW))
            return FAM_35_TYPER_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPEK_RANGE_LOW))
            return FAM_35_TYPEK_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPEB_RANGE_HIGH))
            return FAM_35_TYPEB_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_TYPEJ_TEMPERATURE))
            return FAM_35_TYPEJ_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_TYPEB_RANGE_LOW))
            return FAM_35_TYPEB_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPER_RANGE_HIGH))
            return FAM_35_TYPER_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_LOCATOR))
            return FAM_35_LOCATOR_SIZE;
        if (path.equals(FAM_35_ALARM_SET))
            return FAM_35_ALARM_SET_SIZE;
        if (path.equals(FAM_35_R_ID))
            return FAM_35_R_ID_SIZE;
        if (path.equals(FAM_35_IOS))
            return FAM_35_IOS_SIZE;
        if (path.equals(FAM_35_TYPET_RANGE_LOW))
            return FAM_35_TYPET_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPEN_RANGE_HIGH))
            return FAM_35_TYPEN_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_VIS))
            return FAM_35_VIS_SIZE;
        if (path.equals(FAM_35_TYPER_TEMPERATURE))
            return FAM_35_TYPER_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_TYPES_TEMPERATURE))
            return FAM_35_TYPES_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_TYPEK_RANGE_HIGH))
            return FAM_35_TYPEK_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_TYPEB_TEMPERATURE))
            return FAM_35_TYPEB_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_VOLT))
            return FAM_35_VOLT_SIZE;
        if (path.equals(FAM_35_PMOD))
            return FAM_35_PMOD_SIZE;
        if (path.equals(FAM_35_SENSED))
            return FAM_35_SENSED_SIZE;
        if (path.equals(FAM_35_DEFAULTPMOD))
            return FAM_35_DEFAULTPMOD_SIZE;
        if (path.equals(FAM_35_TYPEE_RANGE_HIGH))
            return FAM_35_TYPEE_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_UBEN))
            return FAM_35_UBEN_SIZE;
        if (path.equals(FAM_35_UVEN))
            return FAM_35_UVEN_SIZE;
        if (path.equals(FAM_35_VOLTHOURS))
            return FAM_35_VOLTHOURS_SIZE;
        if (path.equals(FAM_35_RNAOP))
            return FAM_35_RNAOP_SIZE;
        if (path.equals(FAM_35_LOCK_ALL))
            return FAM_35_LOCK_ALL_SIZE;
        if (path.equals(FAM_35_ID))
            return FAM_35_ID_SIZE;
        if (path.equals(FAM_35_LOCK_0))
            return FAM_35_LOCK_0_SIZE;
        if (path.equals(FAM_35_PIO))
            return FAM_35_PIO_SIZE;
        if (path.equals(FAM_35_CRC8))
            return FAM_35_CRC8_SIZE;
        if (path.equals(FAM_35_PIE1))
            return FAM_35_PIE1_SIZE;
        if (path.equals(FAM_35_PIE0))
            return FAM_35_PIE0_SIZE;
        if (path.equals(FAM_35_TYPET_RANGE_HIGH))
            return FAM_35_TYPET_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_TYPEK_TEMPERATURE))
            return FAM_35_TYPEK_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_ALIAS))
            return FAM_35_ALIAS_SIZE;
        if (path.equals(FAM_35_R_LOCATOR))
            return FAM_35_R_LOCATOR_SIZE;
        if (path.equals(FAM_35_OVD))
            return FAM_35_OVD_SIZE;
        if (path.equals(FAM_35_PAGES_PAGE_0))
            return FAM_35_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_35_MEMORY))
            return FAM_35_MEMORY_SIZE;
        if (path.equals(FAM_35_TYPET_TEMPERATURE))
            return FAM_35_TYPET_TEMPERATURE_SIZE;
        if (path.equals(FAM_35_TYPES_RANGE_HIGH))
            return FAM_35_TYPES_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_PAGES_PAGE_ALL))
            return FAM_35_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_35_ADDRESS))
            return FAM_35_ADDRESS_SIZE;
        if (path.equals(FAM_35_TYPES_RANGE_LOW))
            return FAM_35_TYPES_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPEJ_RANGE_HIGH))
            return FAM_35_TYPEJ_RANGE_HIGH_SIZE;
        if (path.equals(FAM_35_TYPEN_RANGE_LOW))
            return FAM_35_TYPEN_RANGE_LOW_SIZE;
        if (path.equals(FAM_35_TYPEN_TEMPERATURE)) {
            return FAM_35_TYPEN_TEMPERATURE_SIZE;
        }
        return -1;
    }

    public String getTemperature()
            throws IOException {
        return readValue("temperature", true);
    }

    public boolean hasTemperatureResolution() {
        return false;
    }

    public String getTemperatureHigh()
            throws IOException {
        if (!hasTemperatureResolution()) return null;
        return readValue("temphigh", true);
    }

    public void setTemperatureHigh(String temphigh)
            throws IOException {
        if (!hasTemperatureResolution()) return;
        writeValue("temphigh", temphigh);
    }

    public String getTemperatureLow()
            throws IOException {
        if (!hasTemperatureResolution()) return null;
        return readValue("templow", true);
    }

    public void setTemperatureLow(String templow)
            throws IOException {
        if (!hasTemperatureResolution()) return;
        writeValue("templow", templow);
    }
}