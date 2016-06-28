package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer32 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_32_TYPEE_RANGE_LOW = "typeE/range_low";
    private static String FAM_32_R_ADDRESS = "r_address";
    private static String FAM_32_VBIAS = "vbias";
    private static String FAM_32_TYPEJ_RANGE_LOW = "typeJ/range_low";
    private static String FAM_32_TYPE = "type";
    private static String FAM_32_TEMPERATURE = "temperature";
    private static String FAM_32_VIS_AVG = "vis_avg";
    private static String FAM_32_TYPEE_TEMPERATURE = "typeE/temperature";
    private static String FAM_32_FAMILY = "family";
    private static String FAM_32_TYPER_RANGE_LOW = "typeR/range_low";
    private static String FAM_32_TYPEK_RANGE_LOW = "typeK/range_low";
    private static String FAM_32_TYPEB_RANGE_HIGH = "typeB/range_high";
    private static String FAM_32_TYPEJ_TEMPERATURE = "typeJ/temperature";
    private static String FAM_32_TYPEB_RANGE_LOW = "typeB/range_low";
    private static String FAM_32_TYPER_RANGE_HIGH = "typeR/range_high";
    private static String FAM_32_DC = "dc";
    private static String FAM_32_LOCATOR = "locator";
    private static String FAM_32_R_ID = "r_id";
    private static String FAM_32_AEF = "aef";
    private static String FAM_32_UVF = "uvf";
    private static String FAM_32_TYPET_RANGE_LOW = "typeT/range_low";
    private static String FAM_32_TYPEN_RANGE_HIGH = "typeN/range_high";
    private static String FAM_32_VIS = "vis";
    private static String FAM_32_TYPER_TEMPERATURE = "typeR/temperature";
    private static String FAM_32_TYPES_TEMPERATURE = "typeS/temperature";
    private static String FAM_32_PORF = "porf";
    private static String FAM_32_TYPEK_RANGE_HIGH = "typeK/range_high";
    private static String FAM_32_TYPEB_TEMPERATURE = "typeB/temperature";
    private static String FAM_32_VOLT = "volt";
    private static String FAM_32_PMOD = "pmod";
    private static String FAM_32_SENSED = "sensed";
    private static String FAM_32_TYPEE_RANGE_HIGH = "typeE/range_high";
    private static String FAM_32_UVEN = "uven";
    private static String FAM_32_VOLTHOURS = "volthours";
    private static String FAM_32_RNAOP = "rnaop";
    private static String FAM_32_LOCK_ALL = "lock.ALL";
    private static String FAM_32_ID = "id";
    private static String FAM_32_LOCK_0 = "lock.0";
    private static String FAM_32_CHGTF = "chgtf";
    private static String FAM_32_PIO = "PIO";
    private static String FAM_32_CRC8 = "crc8";
    private static String FAM_32_TYPET_RANGE_HIGH = "typeT/range_high";
    private static String FAM_32_TYPEK_TEMPERATURE = "typeK/temperature";
    private static String FAM_32_ALIAS = "alias";
    private static String FAM_32_R_LOCATOR = "r_locator";
    private static String FAM_32_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_32_MEMORY = "memory";
    private static String FAM_32_TYPET_TEMPERATURE = "typeT/temperature";
    private static String FAM_32_TYPES_RANGE_HIGH = "typeS/range_high";
    private static String FAM_32_SEF = "sef";
    private static String FAM_32_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_32_NBEN = "nben";
    private static String FAM_32_ADDRESS = "address";
    private static String FAM_32_TYPES_RANGE_LOW = "typeS/range_low";
    private static String FAM_32_LEARNF = "learnf";
    private static String FAM_32_TYPEJ_RANGE_HIGH = "typeJ/range_high";
    private static String FAM_32_TYPEN_RANGE_LOW = "typeN/range_low";
    private static String FAM_32_TYPEN_TEMPERATURE = "typeN/temperature";
    private static int FAM_32_TYPEE_RANGE_LOW_SIZE = 12;
    private static int FAM_32_R_ADDRESS_SIZE = 16;
    private static int FAM_32_VBIAS_SIZE = 12;
    private static int FAM_32_TYPEJ_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPE_SIZE = 32;
    private static int FAM_32_TEMPERATURE_SIZE = 12;
    private static int FAM_32_VIS_AVG_SIZE = 12;
    private static int FAM_32_TYPEE_TEMPERATURE_SIZE = 12;
    private static int FAM_32_FAMILY_SIZE = 2;
    private static int FAM_32_TYPER_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPEK_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPEB_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_TYPEJ_TEMPERATURE_SIZE = 12;
    private static int FAM_32_TYPEB_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPER_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_DC_SIZE = 1;
    private static int FAM_32_LOCATOR_SIZE = 16;
    private static int FAM_32_R_ID_SIZE = 12;
    private static int FAM_32_AEF_SIZE = 1;
    private static int FAM_32_UVF_SIZE = 1;
    private static int FAM_32_TYPET_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPEN_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_VIS_SIZE = 12;
    private static int FAM_32_TYPER_TEMPERATURE_SIZE = 12;
    private static int FAM_32_TYPES_TEMPERATURE_SIZE = 12;
    private static int FAM_32_PORF_SIZE = 1;
    private static int FAM_32_TYPEK_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_TYPEB_TEMPERATURE_SIZE = 12;
    private static int FAM_32_VOLT_SIZE = 12;
    private static int FAM_32_PMOD_SIZE = 1;
    private static int FAM_32_SENSED_SIZE = 1;
    private static int FAM_32_TYPEE_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_UVEN_SIZE = 1;
    private static int FAM_32_VOLTHOURS_SIZE = 12;
    private static int FAM_32_RNAOP_SIZE = 1;
    private static int FAM_32_LOCK_ALL_SIZE = 3;
    private static int FAM_32_ID_SIZE = 12;
    private static int FAM_32_LOCK_0_SIZE = 1;
    private static int FAM_32_CHGTF_SIZE = 1;
    private static int FAM_32_PIO_SIZE = 1;
    private static int FAM_32_CRC8_SIZE = 2;
    private static int FAM_32_TYPET_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_TYPEK_TEMPERATURE_SIZE = 12;
    private static int FAM_32_ALIAS_SIZE = 256;
    private static int FAM_32_R_LOCATOR_SIZE = 16;
    private static int FAM_32_PAGES_PAGE_0_SIZE = 16;
    private static int FAM_32_MEMORY_SIZE = 256;
    private static int FAM_32_TYPET_TEMPERATURE_SIZE = 12;
    private static int FAM_32_TYPES_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_SEF_SIZE = 1;
    private static int FAM_32_PAGES_PAGE_ALL_SIZE = 32;
    private static int FAM_32_NBEN_SIZE = 1;
    private static int FAM_32_ADDRESS_SIZE = 16;
    private static int FAM_32_TYPES_RANGE_LOW_SIZE = 12;
    private static int FAM_32_LEARNF_SIZE = 1;
    private static int FAM_32_TYPEJ_RANGE_HIGH_SIZE = 12;
    private static int FAM_32_TYPEN_RANGE_LOW_SIZE = 12;
    private static int FAM_32_TYPEN_TEMPERATURE_SIZE = 12;

    public OneWireContainer32() {
    }

    public OneWireContainer32(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_32_TYPEE_RANGE_LOW))
            return FAM_32_TYPEE_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_R_ADDRESS))
            return FAM_32_R_ADDRESS_SIZE;
        if (path.equals(FAM_32_VBIAS))
            return FAM_32_VBIAS_SIZE;
        if (path.equals(FAM_32_TYPEJ_RANGE_LOW))
            return FAM_32_TYPEJ_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPE))
            return FAM_32_TYPE_SIZE;
        if (path.equals(FAM_32_TEMPERATURE))
            return FAM_32_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_VIS_AVG))
            return FAM_32_VIS_AVG_SIZE;
        if (path.equals(FAM_32_TYPEE_TEMPERATURE))
            return FAM_32_TYPEE_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_FAMILY))
            return FAM_32_FAMILY_SIZE;
        if (path.equals(FAM_32_TYPER_RANGE_LOW))
            return FAM_32_TYPER_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPEK_RANGE_LOW))
            return FAM_32_TYPEK_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPEB_RANGE_HIGH))
            return FAM_32_TYPEB_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_TYPEJ_TEMPERATURE))
            return FAM_32_TYPEJ_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_TYPEB_RANGE_LOW))
            return FAM_32_TYPEB_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPER_RANGE_HIGH))
            return FAM_32_TYPER_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_DC))
            return FAM_32_DC_SIZE;
        if (path.equals(FAM_32_LOCATOR))
            return FAM_32_LOCATOR_SIZE;
        if (path.equals(FAM_32_R_ID))
            return FAM_32_R_ID_SIZE;
        if (path.equals(FAM_32_AEF))
            return FAM_32_AEF_SIZE;
        if (path.equals(FAM_32_UVF))
            return FAM_32_UVF_SIZE;
        if (path.equals(FAM_32_TYPET_RANGE_LOW))
            return FAM_32_TYPET_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPEN_RANGE_HIGH))
            return FAM_32_TYPEN_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_VIS))
            return FAM_32_VIS_SIZE;
        if (path.equals(FAM_32_TYPER_TEMPERATURE))
            return FAM_32_TYPER_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_TYPES_TEMPERATURE))
            return FAM_32_TYPES_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_PORF))
            return FAM_32_PORF_SIZE;
        if (path.equals(FAM_32_TYPEK_RANGE_HIGH))
            return FAM_32_TYPEK_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_TYPEB_TEMPERATURE))
            return FAM_32_TYPEB_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_VOLT))
            return FAM_32_VOLT_SIZE;
        if (path.equals(FAM_32_PMOD))
            return FAM_32_PMOD_SIZE;
        if (path.equals(FAM_32_SENSED))
            return FAM_32_SENSED_SIZE;
        if (path.equals(FAM_32_TYPEE_RANGE_HIGH))
            return FAM_32_TYPEE_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_UVEN))
            return FAM_32_UVEN_SIZE;
        if (path.equals(FAM_32_VOLTHOURS))
            return FAM_32_VOLTHOURS_SIZE;
        if (path.equals(FAM_32_RNAOP))
            return FAM_32_RNAOP_SIZE;
        if (path.equals(FAM_32_LOCK_ALL))
            return FAM_32_LOCK_ALL_SIZE;
        if (path.equals(FAM_32_ID))
            return FAM_32_ID_SIZE;
        if (path.equals(FAM_32_LOCK_0))
            return FAM_32_LOCK_0_SIZE;
        if (path.equals(FAM_32_CHGTF))
            return FAM_32_CHGTF_SIZE;
        if (path.equals(FAM_32_PIO))
            return FAM_32_PIO_SIZE;
        if (path.equals(FAM_32_CRC8))
            return FAM_32_CRC8_SIZE;
        if (path.equals(FAM_32_TYPET_RANGE_HIGH))
            return FAM_32_TYPET_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_TYPEK_TEMPERATURE))
            return FAM_32_TYPEK_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_ALIAS))
            return FAM_32_ALIAS_SIZE;
        if (path.equals(FAM_32_R_LOCATOR))
            return FAM_32_R_LOCATOR_SIZE;
        if (path.equals(FAM_32_PAGES_PAGE_0))
            return FAM_32_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_32_MEMORY))
            return FAM_32_MEMORY_SIZE;
        if (path.equals(FAM_32_TYPET_TEMPERATURE))
            return FAM_32_TYPET_TEMPERATURE_SIZE;
        if (path.equals(FAM_32_TYPES_RANGE_HIGH))
            return FAM_32_TYPES_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_SEF))
            return FAM_32_SEF_SIZE;
        if (path.equals(FAM_32_PAGES_PAGE_ALL))
            return FAM_32_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_32_NBEN))
            return FAM_32_NBEN_SIZE;
        if (path.equals(FAM_32_ADDRESS))
            return FAM_32_ADDRESS_SIZE;
        if (path.equals(FAM_32_TYPES_RANGE_LOW))
            return FAM_32_TYPES_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_LEARNF))
            return FAM_32_LEARNF_SIZE;
        if (path.equals(FAM_32_TYPEJ_RANGE_HIGH))
            return FAM_32_TYPEJ_RANGE_HIGH_SIZE;
        if (path.equals(FAM_32_TYPEN_RANGE_LOW))
            return FAM_32_TYPEN_RANGE_LOW_SIZE;
        if (path.equals(FAM_32_TYPEN_TEMPERATURE)) {
            return FAM_32_TYPEN_TEMPERATURE_SIZE;
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