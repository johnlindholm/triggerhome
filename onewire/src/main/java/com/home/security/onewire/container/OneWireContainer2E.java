package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer2E extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_2E_TYPEE_RANGE_LOW = "typeE/range_low";
    private static String FAM_2E_CURRENTBIAS = "currentbias";
    private static String FAM_2E_R_ADDRESS = "r_address";
    private static String FAM_2E_VBIAS = "vbias";
    private static String FAM_2E_TYPEJ_RANGE_LOW = "typeJ/range_low";
    private static String FAM_2E_TYPE = "type";
    private static String FAM_2E_TEMPERATURE = "temperature";
    private static String FAM_2E_TYPEE_TEMPERATURE = "typeE/temperature";
    private static String FAM_2E_FAMILY = "family";
    private static String FAM_2E_TYPER_RANGE_LOW = "typeR/range_low";
    private static String FAM_2E_TYPEK_RANGE_LOW = "typeK/range_low";
    private static String FAM_2E_TYPEB_RANGE_HIGH = "typeB/range_high";
    private static String FAM_2E_TYPEJ_TEMPERATURE = "typeJ/temperature";
    private static String FAM_2E_REFRESH = "refresh";
    private static String FAM_2E_TYPEB_RANGE_LOW = "typeB/range_low";
    private static String FAM_2E_TYPER_RANGE_HIGH = "typeR/range_high";
    private static String FAM_2E_LOCATOR = "locator";
    private static String FAM_2E_R_ID = "r_id";
    private static String FAM_2E_CSTAT1 = "cstat1";
    private static String FAM_2E_CSTAT0 = "cstat0";
    private static String FAM_2E_AMPHOURS = "amphours";
    private static String FAM_2E_TYPET_RANGE_LOW = "typeT/range_low";
    private static String FAM_2E_TYPEN_RANGE_HIGH = "typeN/range_high";
    private static String FAM_2E_VIS = "vis";
    private static String FAM_2E_TYPER_TEMPERATURE = "typeR/temperature";
    private static String FAM_2E_TYPES_TEMPERATURE = "typeS/temperature";
    private static String FAM_2E_TYPEK_RANGE_HIGH = "typeK/range_high";
    private static String FAM_2E_TYPEB_TEMPERATURE = "typeB/temperature";
    private static String FAM_2E_VOLT = "volt";
    private static String FAM_2E_PMOD = "pmod";
    private static String FAM_2E_DEFAULTPMOD = "defaultpmod";
    private static String FAM_2E_TYPEE_RANGE_HIGH = "typeE/range_high";
    private static String FAM_2E_VOLTHOURS = "volthours";
    private static String FAM_2E_LOCK_ALL = "lock.ALL";
    private static String FAM_2E_ID = "id";
    private static String FAM_2E_LOCK_0 = "lock.0";
    private static String FAM_2E_TIMER = "timer";
    private static String FAM_2E_CURRENT = "current";
    private static String FAM_2E_CRC8 = "crc8";
    private static String FAM_2E_CINI = "cini";
    private static String FAM_2E_TYPET_RANGE_HIGH = "typeT/range_high";
    private static String FAM_2E_TYPEK_TEMPERATURE = "typeK/temperature";
    private static String FAM_2E_ALIAS = "alias";
    private static String FAM_2E_CTYPE = "ctype";
    private static String FAM_2E_R_LOCATOR = "r_locator";
    private static String FAM_2E_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_2E_MEMORY = "memory";
    private static String FAM_2E_TYPET_TEMPERATURE = "typeT/temperature";
    private static String FAM_2E_TYPES_RANGE_HIGH = "typeS/range_high";
    private static String FAM_2E_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_2E_CHARGE = "charge";
    private static String FAM_2E_ADDRESS = "address";
    private static String FAM_2E_TYPES_RANGE_LOW = "typeS/range_low";
    private static String FAM_2E_TYPEJ_RANGE_HIGH = "typeJ/range_high";
    private static String FAM_2E_TYPEN_RANGE_LOW = "typeN/range_low";
    private static String FAM_2E_TYPEN_TEMPERATURE = "typeN/temperature";
    private static int FAM_2E_TYPEE_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_CURRENTBIAS_SIZE = 12;
    private static int FAM_2E_R_ADDRESS_SIZE = 16;
    private static int FAM_2E_VBIAS_SIZE = 12;
    private static int FAM_2E_TYPEJ_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPE_SIZE = 32;
    private static int FAM_2E_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_TYPEE_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_FAMILY_SIZE = 2;
    private static int FAM_2E_TYPER_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPEK_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPEB_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_TYPEJ_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_REFRESH_SIZE = 1;
    private static int FAM_2E_TYPEB_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPER_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_LOCATOR_SIZE = 16;
    private static int FAM_2E_R_ID_SIZE = 12;
    private static int FAM_2E_CSTAT1_SIZE = 1;
    private static int FAM_2E_CSTAT0_SIZE = 1;
    private static int FAM_2E_AMPHOURS_SIZE = 12;
    private static int FAM_2E_TYPET_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPEN_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_VIS_SIZE = 12;
    private static int FAM_2E_TYPER_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_TYPES_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_TYPEK_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_TYPEB_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_VOLT_SIZE = 12;
    private static int FAM_2E_PMOD_SIZE = 1;
    private static int FAM_2E_DEFAULTPMOD_SIZE = 1;
    private static int FAM_2E_TYPEE_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_VOLTHOURS_SIZE = 12;
    private static int FAM_2E_LOCK_ALL_SIZE = 5;
    private static int FAM_2E_ID_SIZE = 12;
    private static int FAM_2E_LOCK_0_SIZE = 1;
    private static int FAM_2E_TIMER_SIZE = 12;
    private static int FAM_2E_CURRENT_SIZE = 12;
    private static int FAM_2E_CRC8_SIZE = 2;
    private static int FAM_2E_CINI_SIZE = 1;
    private static int FAM_2E_TYPET_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_TYPEK_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_ALIAS_SIZE = 256;
    private static int FAM_2E_CTYPE_SIZE = 1;
    private static int FAM_2E_R_LOCATOR_SIZE = 16;
    private static int FAM_2E_PAGES_PAGE_0_SIZE = 16;
    private static int FAM_2E_MEMORY_SIZE = 256;
    private static int FAM_2E_TYPET_TEMPERATURE_SIZE = 12;
    private static int FAM_2E_TYPES_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_PAGES_PAGE_ALL_SIZE = 48;
    private static int FAM_2E_CHARGE_SIZE = 1;
    private static int FAM_2E_ADDRESS_SIZE = 16;
    private static int FAM_2E_TYPES_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPEJ_RANGE_HIGH_SIZE = 12;
    private static int FAM_2E_TYPEN_RANGE_LOW_SIZE = 12;
    private static int FAM_2E_TYPEN_TEMPERATURE_SIZE = 12;

    public OneWireContainer2E() {
    }

    public OneWireContainer2E(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_2E_TYPEE_RANGE_LOW))
            return FAM_2E_TYPEE_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_CURRENTBIAS))
            return FAM_2E_CURRENTBIAS_SIZE;
        if (path.equals(FAM_2E_R_ADDRESS))
            return FAM_2E_R_ADDRESS_SIZE;
        if (path.equals(FAM_2E_VBIAS))
            return FAM_2E_VBIAS_SIZE;
        if (path.equals(FAM_2E_TYPEJ_RANGE_LOW))
            return FAM_2E_TYPEJ_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPE))
            return FAM_2E_TYPE_SIZE;
        if (path.equals(FAM_2E_TEMPERATURE))
            return FAM_2E_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_TYPEE_TEMPERATURE))
            return FAM_2E_TYPEE_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_FAMILY))
            return FAM_2E_FAMILY_SIZE;
        if (path.equals(FAM_2E_TYPER_RANGE_LOW))
            return FAM_2E_TYPER_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPEK_RANGE_LOW))
            return FAM_2E_TYPEK_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPEB_RANGE_HIGH))
            return FAM_2E_TYPEB_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_TYPEJ_TEMPERATURE))
            return FAM_2E_TYPEJ_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_REFRESH))
            return FAM_2E_REFRESH_SIZE;
        if (path.equals(FAM_2E_TYPEB_RANGE_LOW))
            return FAM_2E_TYPEB_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPER_RANGE_HIGH))
            return FAM_2E_TYPER_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_LOCATOR))
            return FAM_2E_LOCATOR_SIZE;
        if (path.equals(FAM_2E_R_ID))
            return FAM_2E_R_ID_SIZE;
        if (path.equals(FAM_2E_CSTAT1))
            return FAM_2E_CSTAT1_SIZE;
        if (path.equals(FAM_2E_CSTAT0))
            return FAM_2E_CSTAT0_SIZE;
        if (path.equals(FAM_2E_AMPHOURS))
            return FAM_2E_AMPHOURS_SIZE;
        if (path.equals(FAM_2E_TYPET_RANGE_LOW))
            return FAM_2E_TYPET_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPEN_RANGE_HIGH))
            return FAM_2E_TYPEN_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_VIS))
            return FAM_2E_VIS_SIZE;
        if (path.equals(FAM_2E_TYPER_TEMPERATURE))
            return FAM_2E_TYPER_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_TYPES_TEMPERATURE))
            return FAM_2E_TYPES_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_TYPEK_RANGE_HIGH))
            return FAM_2E_TYPEK_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_TYPEB_TEMPERATURE))
            return FAM_2E_TYPEB_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_VOLT))
            return FAM_2E_VOLT_SIZE;
        if (path.equals(FAM_2E_PMOD))
            return FAM_2E_PMOD_SIZE;
        if (path.equals(FAM_2E_DEFAULTPMOD))
            return FAM_2E_DEFAULTPMOD_SIZE;
        if (path.equals(FAM_2E_TYPEE_RANGE_HIGH))
            return FAM_2E_TYPEE_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_VOLTHOURS))
            return FAM_2E_VOLTHOURS_SIZE;
        if (path.equals(FAM_2E_LOCK_ALL))
            return FAM_2E_LOCK_ALL_SIZE;
        if (path.equals(FAM_2E_ID))
            return FAM_2E_ID_SIZE;
        if (path.equals(FAM_2E_LOCK_0))
            return FAM_2E_LOCK_0_SIZE;
        if (path.equals(FAM_2E_TIMER))
            return FAM_2E_TIMER_SIZE;
        if (path.equals(FAM_2E_CURRENT))
            return FAM_2E_CURRENT_SIZE;
        if (path.equals(FAM_2E_CRC8))
            return FAM_2E_CRC8_SIZE;
        if (path.equals(FAM_2E_CINI))
            return FAM_2E_CINI_SIZE;
        if (path.equals(FAM_2E_TYPET_RANGE_HIGH))
            return FAM_2E_TYPET_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_TYPEK_TEMPERATURE))
            return FAM_2E_TYPEK_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_ALIAS))
            return FAM_2E_ALIAS_SIZE;
        if (path.equals(FAM_2E_CTYPE))
            return FAM_2E_CTYPE_SIZE;
        if (path.equals(FAM_2E_R_LOCATOR))
            return FAM_2E_R_LOCATOR_SIZE;
        if (path.equals(FAM_2E_PAGES_PAGE_0))
            return FAM_2E_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_2E_MEMORY))
            return FAM_2E_MEMORY_SIZE;
        if (path.equals(FAM_2E_TYPET_TEMPERATURE))
            return FAM_2E_TYPET_TEMPERATURE_SIZE;
        if (path.equals(FAM_2E_TYPES_RANGE_HIGH))
            return FAM_2E_TYPES_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_PAGES_PAGE_ALL))
            return FAM_2E_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_2E_CHARGE))
            return FAM_2E_CHARGE_SIZE;
        if (path.equals(FAM_2E_ADDRESS))
            return FAM_2E_ADDRESS_SIZE;
        if (path.equals(FAM_2E_TYPES_RANGE_LOW))
            return FAM_2E_TYPES_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPEJ_RANGE_HIGH))
            return FAM_2E_TYPEJ_RANGE_HIGH_SIZE;
        if (path.equals(FAM_2E_TYPEN_RANGE_LOW))
            return FAM_2E_TYPEN_RANGE_LOW_SIZE;
        if (path.equals(FAM_2E_TYPEN_TEMPERATURE)) {
            return FAM_2E_TYPEN_TEMPERATURE_SIZE;
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