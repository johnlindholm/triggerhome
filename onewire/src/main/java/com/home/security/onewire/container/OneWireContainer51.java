package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer51 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_51_TYPEE_RANGE_LOW = "typeE/range_low";
    private static String FAM_51_CURRENTBIAS = "currentbias";
    private static String FAM_51_R_ADDRESS = "r_address";
    private static String FAM_51_VBIAS = "vbias";
    private static String FAM_51_POR = "por";
    private static String FAM_51_TYPEJ_RANGE_LOW = "typeJ/range_low";
    private static String FAM_51_TYPE = "type";
    private static String FAM_51_TEMPERATURE = "temperature";
    private static String FAM_51_TYPEE_TEMPERATURE = "typeE/temperature";
    private static String FAM_51_FAMILY = "family";
    private static String FAM_51_TYPER_RANGE_LOW = "typeR/range_low";
    private static String FAM_51_TYPEK_RANGE_LOW = "typeK/range_low";
    private static String FAM_51_TYPEB_RANGE_HIGH = "typeB/range_high";
    private static String FAM_51_TYPEJ_TEMPERATURE = "typeJ/temperature";
    private static String FAM_51_TYPEB_RANGE_LOW = "typeB/range_low";
    private static String FAM_51_TYPER_RANGE_HIGH = "typeR/range_high";
    private static String FAM_51_LOCATOR = "locator";
    private static String FAM_51_R_ID = "r_id";
    private static String FAM_51_AMPHOURS = "amphours";
    private static String FAM_51_TYPEN_RANGE_HIGH = "typeN/range_high";
    private static String FAM_51_TYPET_RANGE_LOW = "typeT/range_low";
    private static String FAM_51_VIS = "vis";
    private static String FAM_51_TYPER_TEMPERATURE = "typeR/temperature";
    private static String FAM_51_TYPES_TEMPERATURE = "typeS/temperature";
    private static String FAM_51_TYPEK_RANGE_HIGH = "typeK/range_high";
    private static String FAM_51_TYPEB_TEMPERATURE = "typeB/temperature";
    private static String FAM_51_VOLT = "volt";
    private static String FAM_51_PMOD = "pmod";
    private static String FAM_51_SENSED = "sensed";
    private static String FAM_51_DEFAULTPMOD = "defaultpmod";
    private static String FAM_51_TYPEE_RANGE_HIGH = "typeE/range_high";
    private static String FAM_51_UVEN = "uven";
    private static String FAM_51_VOLTHOURS = "volthours";
    private static String FAM_51_LOCK_ALL = "lock.ALL";
    private static String FAM_51_ID = "id";
    private static String FAM_51_LOCK_0 = "lock.0";
    private static String FAM_51_CURRENT = "current";
    private static String FAM_51_PIO = "PIO";
    private static String FAM_51_CRC8 = "crc8";
    private static String FAM_51_TYPET_RANGE_HIGH = "typeT/range_high";
    private static String FAM_51_TYPEK_TEMPERATURE = "typeK/temperature";
    private static String FAM_51_ALIAS = "alias";
    private static String FAM_51_R_LOCATOR = "r_locator";
    private static String FAM_51_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_51_MEMORY = "memory";
    private static String FAM_51_TYPES_RANGE_HIGH = "typeS/range_high";
    private static String FAM_51_TYPET_TEMPERATURE = "typeT/temperature";
    private static String FAM_51_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_51_ADDRESS = "address";
    private static String FAM_51_TYPES_RANGE_LOW = "typeS/range_low";
    private static String FAM_51_TYPEJ_RANGE_HIGH = "typeJ/range_high";
    private static String FAM_51_TYPEN_RANGE_LOW = "typeN/range_low";
    private static String FAM_51_TYPEN_TEMPERATURE = "typeN/temperature";
    private static int FAM_51_TYPEE_RANGE_LOW_SIZE = 12;
    private static int FAM_51_CURRENTBIAS_SIZE = 12;
    private static int FAM_51_R_ADDRESS_SIZE = 16;
    private static int FAM_51_VBIAS_SIZE = 12;
    private static int FAM_51_POR_SIZE = 1;
    private static int FAM_51_TYPEJ_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPE_SIZE = 32;
    private static int FAM_51_TEMPERATURE_SIZE = 12;
    private static int FAM_51_TYPEE_TEMPERATURE_SIZE = 12;
    private static int FAM_51_FAMILY_SIZE = 2;
    private static int FAM_51_TYPER_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPEK_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPEB_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPEJ_TEMPERATURE_SIZE = 12;
    private static int FAM_51_TYPEB_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPER_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_LOCATOR_SIZE = 16;
    private static int FAM_51_R_ID_SIZE = 12;
    private static int FAM_51_AMPHOURS_SIZE = 12;
    private static int FAM_51_TYPEN_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPET_RANGE_LOW_SIZE = 12;
    private static int FAM_51_VIS_SIZE = 12;
    private static int FAM_51_TYPER_TEMPERATURE_SIZE = 12;
    private static int FAM_51_TYPES_TEMPERATURE_SIZE = 12;
    private static int FAM_51_TYPEK_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPEB_TEMPERATURE_SIZE = 12;
    private static int FAM_51_VOLT_SIZE = 12;
    private static int FAM_51_PMOD_SIZE = 1;
    private static int FAM_51_SENSED_SIZE = 1;
    private static int FAM_51_DEFAULTPMOD_SIZE = 1;
    private static int FAM_51_TYPEE_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_UVEN_SIZE = 1;
    private static int FAM_51_VOLTHOURS_SIZE = 12;
    private static int FAM_51_LOCK_ALL_SIZE = 3;
    private static int FAM_51_ID_SIZE = 12;
    private static int FAM_51_LOCK_0_SIZE = 1;
    private static int FAM_51_CURRENT_SIZE = 12;
    private static int FAM_51_PIO_SIZE = 1;
    private static int FAM_51_CRC8_SIZE = 2;
    private static int FAM_51_TYPET_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPEK_TEMPERATURE_SIZE = 12;
    private static int FAM_51_ALIAS_SIZE = 256;
    private static int FAM_51_R_LOCATOR_SIZE = 16;
    private static int FAM_51_PAGES_PAGE_0_SIZE = 16;
    private static int FAM_51_MEMORY_SIZE = 256;
    private static int FAM_51_TYPES_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPET_TEMPERATURE_SIZE = 12;
    private static int FAM_51_PAGES_PAGE_ALL_SIZE = 32;
    private static int FAM_51_ADDRESS_SIZE = 16;
    private static int FAM_51_TYPES_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPEJ_RANGE_HIGH_SIZE = 12;
    private static int FAM_51_TYPEN_RANGE_LOW_SIZE = 12;
    private static int FAM_51_TYPEN_TEMPERATURE_SIZE = 12;

    public OneWireContainer51() {
    }

    public OneWireContainer51(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_51_TYPEE_RANGE_LOW))
            return FAM_51_TYPEE_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_CURRENTBIAS))
            return FAM_51_CURRENTBIAS_SIZE;
        if (path.equals(FAM_51_R_ADDRESS))
            return FAM_51_R_ADDRESS_SIZE;
        if (path.equals(FAM_51_VBIAS))
            return FAM_51_VBIAS_SIZE;
        if (path.equals(FAM_51_POR))
            return FAM_51_POR_SIZE;
        if (path.equals(FAM_51_TYPEJ_RANGE_LOW))
            return FAM_51_TYPEJ_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPE))
            return FAM_51_TYPE_SIZE;
        if (path.equals(FAM_51_TEMPERATURE))
            return FAM_51_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_TYPEE_TEMPERATURE))
            return FAM_51_TYPEE_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_FAMILY))
            return FAM_51_FAMILY_SIZE;
        if (path.equals(FAM_51_TYPER_RANGE_LOW))
            return FAM_51_TYPER_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPEK_RANGE_LOW))
            return FAM_51_TYPEK_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPEB_RANGE_HIGH))
            return FAM_51_TYPEB_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPEJ_TEMPERATURE))
            return FAM_51_TYPEJ_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_TYPEB_RANGE_LOW))
            return FAM_51_TYPEB_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPER_RANGE_HIGH))
            return FAM_51_TYPER_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_LOCATOR))
            return FAM_51_LOCATOR_SIZE;
        if (path.equals(FAM_51_R_ID))
            return FAM_51_R_ID_SIZE;
        if (path.equals(FAM_51_AMPHOURS))
            return FAM_51_AMPHOURS_SIZE;
        if (path.equals(FAM_51_TYPEN_RANGE_HIGH))
            return FAM_51_TYPEN_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPET_RANGE_LOW))
            return FAM_51_TYPET_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_VIS))
            return FAM_51_VIS_SIZE;
        if (path.equals(FAM_51_TYPER_TEMPERATURE))
            return FAM_51_TYPER_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_TYPES_TEMPERATURE))
            return FAM_51_TYPES_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_TYPEK_RANGE_HIGH))
            return FAM_51_TYPEK_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPEB_TEMPERATURE))
            return FAM_51_TYPEB_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_VOLT))
            return FAM_51_VOLT_SIZE;
        if (path.equals(FAM_51_PMOD))
            return FAM_51_PMOD_SIZE;
        if (path.equals(FAM_51_SENSED))
            return FAM_51_SENSED_SIZE;
        if (path.equals(FAM_51_DEFAULTPMOD))
            return FAM_51_DEFAULTPMOD_SIZE;
        if (path.equals(FAM_51_TYPEE_RANGE_HIGH))
            return FAM_51_TYPEE_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_UVEN))
            return FAM_51_UVEN_SIZE;
        if (path.equals(FAM_51_VOLTHOURS))
            return FAM_51_VOLTHOURS_SIZE;
        if (path.equals(FAM_51_LOCK_ALL))
            return FAM_51_LOCK_ALL_SIZE;
        if (path.equals(FAM_51_ID))
            return FAM_51_ID_SIZE;
        if (path.equals(FAM_51_LOCK_0))
            return FAM_51_LOCK_0_SIZE;
        if (path.equals(FAM_51_CURRENT))
            return FAM_51_CURRENT_SIZE;
        if (path.equals(FAM_51_PIO))
            return FAM_51_PIO_SIZE;
        if (path.equals(FAM_51_CRC8))
            return FAM_51_CRC8_SIZE;
        if (path.equals(FAM_51_TYPET_RANGE_HIGH))
            return FAM_51_TYPET_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPEK_TEMPERATURE))
            return FAM_51_TYPEK_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_ALIAS))
            return FAM_51_ALIAS_SIZE;
        if (path.equals(FAM_51_R_LOCATOR))
            return FAM_51_R_LOCATOR_SIZE;
        if (path.equals(FAM_51_PAGES_PAGE_0))
            return FAM_51_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_51_MEMORY))
            return FAM_51_MEMORY_SIZE;
        if (path.equals(FAM_51_TYPES_RANGE_HIGH))
            return FAM_51_TYPES_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPET_TEMPERATURE))
            return FAM_51_TYPET_TEMPERATURE_SIZE;
        if (path.equals(FAM_51_PAGES_PAGE_ALL))
            return FAM_51_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_51_ADDRESS))
            return FAM_51_ADDRESS_SIZE;
        if (path.equals(FAM_51_TYPES_RANGE_LOW))
            return FAM_51_TYPES_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPEJ_RANGE_HIGH))
            return FAM_51_TYPEJ_RANGE_HIGH_SIZE;
        if (path.equals(FAM_51_TYPEN_RANGE_LOW))
            return FAM_51_TYPEN_RANGE_LOW_SIZE;
        if (path.equals(FAM_51_TYPEN_TEMPERATURE)) {
            return FAM_51_TYPEN_TEMPERATURE_SIZE;
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