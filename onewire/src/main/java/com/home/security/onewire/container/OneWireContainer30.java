package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer30 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_30_TYPEE_RANGE_LOW = "typeE/range_low";
    private static String FAM_30_CURRENTBIAS = "currentbias";
    private static String FAM_30_R_ADDRESS = "r_address";
    private static String FAM_30_VBIAS = "vbias";
    private static String FAM_30_TYPEJ_RANGE_LOW = "typeJ/range_low";
    private static String FAM_30_TYPE = "type";
    private static String FAM_30_TEMPERATURE = "temperature";
    private static String FAM_30_TYPEE_TEMPERATURE = "typeE/temperature";
    private static String FAM_30_FAMILY = "family";
    private static String FAM_30_TYPER_RANGE_LOW = "typeR/range_low";
    private static String FAM_30_MSTR = "mstr";
    private static String FAM_30_TYPEK_RANGE_LOW = "typeK/range_low";
    private static String FAM_30_TYPEB_RANGE_HIGH = "typeB/range_high";
    private static String FAM_30_TYPEJ_TEMPERATURE = "typeJ/temperature";
    private static String FAM_30_TYPER_RANGE_HIGH = "typeR/range_high";
    private static String FAM_30_TYPEB_RANGE_LOW = "typeB/range_low";
    private static String FAM_30_DC = "dc";
    private static String FAM_30_LOCATOR = "locator";
    private static String FAM_30_OV = "ov";
    private static String FAM_30_R_ID = "r_id";
    private static String FAM_30_AMPHOURS = "amphours";
    private static String FAM_30_TYPET_RANGE_LOW = "typeT/range_low";
    private static String FAM_30_TYPEN_RANGE_HIGH = "typeN/range_high";
    private static String FAM_30_VIS = "vis";
    private static String FAM_30_TYPER_TEMPERATURE = "typeR/temperature";
    private static String FAM_30_TYPES_TEMPERATURE = "typeS/temperature";
    private static String FAM_30_CE = "ce";
    private static String FAM_30_TYPEK_RANGE_HIGH = "typeK/range_high";
    private static String FAM_30_CC = "cc";
    private static String FAM_30_TYPEB_TEMPERATURE = "typeB/temperature";
    private static String FAM_30_VOLT = "volt";
    private static String FAM_30_PMOD = "pmod";
    private static String FAM_30_SENSED = "sensed";
    private static String FAM_30_DEFAULTPMOD = "defaultpmod";
    private static String FAM_30_TYPEE_RANGE_HIGH = "typeE/range_high";
    private static String FAM_30_VOLTHOURS = "volthours";
    private static String FAM_30_LOCK_ALL = "lock.ALL";
    private static String FAM_30_ID = "id";
    private static String FAM_30_DE = "de";
    private static String FAM_30_LOCK_0 = "lock.0";
    private static String FAM_30_UV = "uv";
    private static String FAM_30_CURRENT = "current";
    private static String FAM_30_PIO = "PIO";
    private static String FAM_30_CRC8 = "crc8";
    private static String FAM_30_SWEN = "swen";
    private static String FAM_30_TYPET_RANGE_HIGH = "typeT/range_high";
    private static String FAM_30_TYPEK_TEMPERATURE = "typeK/temperature";
    private static String FAM_30_ALIAS = "alias";
    private static String FAM_30_R_LOCATOR = "r_locator";
    private static String FAM_30_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_30_MEMORY = "memory";
    private static String FAM_30_TYPET_TEMPERATURE = "typeT/temperature";
    private static String FAM_30_TYPES_RANGE_HIGH = "typeS/range_high";
    private static String FAM_30_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_30_ADDRESS = "address";
    private static String FAM_30_DOC = "doc";
    private static String FAM_30_DEFAULTSWEN = "defaultswen";
    private static String FAM_30_TYPES_RANGE_LOW = "typeS/range_low";
    private static String FAM_30_COC = "coc";
    private static String FAM_30_TYPEJ_RANGE_HIGH = "typeJ/range_high";
    private static String FAM_30_TYPEN_RANGE_LOW = "typeN/range_low";
    private static String FAM_30_TYPEN_TEMPERATURE = "typeN/temperature";
    private static String FAM_30_PS = "ps";
    private static int FAM_30_TYPEE_RANGE_LOW_SIZE = 12;
    private static int FAM_30_CURRENTBIAS_SIZE = 12;
    private static int FAM_30_R_ADDRESS_SIZE = 16;
    private static int FAM_30_VBIAS_SIZE = 12;
    private static int FAM_30_TYPEJ_RANGE_LOW_SIZE = 12;
    private static int FAM_30_TYPE_SIZE = 32;
    private static int FAM_30_TEMPERATURE_SIZE = 12;
    private static int FAM_30_TYPEE_TEMPERATURE_SIZE = 12;
    private static int FAM_30_FAMILY_SIZE = 2;
    private static int FAM_30_TYPER_RANGE_LOW_SIZE = 12;
    private static int FAM_30_MSTR_SIZE = 1;
    private static int FAM_30_TYPEK_RANGE_LOW_SIZE = 12;
    private static int FAM_30_TYPEB_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_TYPEJ_TEMPERATURE_SIZE = 12;
    private static int FAM_30_TYPER_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_TYPEB_RANGE_LOW_SIZE = 12;
    private static int FAM_30_DC_SIZE = 1;
    private static int FAM_30_LOCATOR_SIZE = 16;
    private static int FAM_30_OV_SIZE = 1;
    private static int FAM_30_R_ID_SIZE = 12;
    private static int FAM_30_AMPHOURS_SIZE = 12;
    private static int FAM_30_TYPET_RANGE_LOW_SIZE = 12;
    private static int FAM_30_TYPEN_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_VIS_SIZE = 12;
    private static int FAM_30_TYPER_TEMPERATURE_SIZE = 12;
    private static int FAM_30_TYPES_TEMPERATURE_SIZE = 12;
    private static int FAM_30_CE_SIZE = 1;
    private static int FAM_30_TYPEK_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_CC_SIZE = 1;
    private static int FAM_30_TYPEB_TEMPERATURE_SIZE = 12;
    private static int FAM_30_VOLT_SIZE = 12;
    private static int FAM_30_PMOD_SIZE = 1;
    private static int FAM_30_SENSED_SIZE = 1;
    private static int FAM_30_DEFAULTPMOD_SIZE = 1;
    private static int FAM_30_TYPEE_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_VOLTHOURS_SIZE = 12;
    private static int FAM_30_LOCK_ALL_SIZE = 3;
    private static int FAM_30_ID_SIZE = 12;
    private static int FAM_30_DE_SIZE = 1;
    private static int FAM_30_LOCK_0_SIZE = 1;
    private static int FAM_30_UV_SIZE = 1;
    private static int FAM_30_CURRENT_SIZE = 12;
    private static int FAM_30_PIO_SIZE = 1;
    private static int FAM_30_CRC8_SIZE = 2;
    private static int FAM_30_SWEN_SIZE = 1;
    private static int FAM_30_TYPET_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_TYPEK_TEMPERATURE_SIZE = 12;
    private static int FAM_30_ALIAS_SIZE = 256;
    private static int FAM_30_R_LOCATOR_SIZE = 16;
    private static int FAM_30_PAGES_PAGE_0_SIZE = 16;
    private static int FAM_30_MEMORY_SIZE = 256;
    private static int FAM_30_TYPET_TEMPERATURE_SIZE = 12;
    private static int FAM_30_TYPES_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_PAGES_PAGE_ALL_SIZE = 32;
    private static int FAM_30_ADDRESS_SIZE = 16;
    private static int FAM_30_DOC_SIZE = 1;
    private static int FAM_30_DEFAULTSWEN_SIZE = 1;
    private static int FAM_30_TYPES_RANGE_LOW_SIZE = 12;
    private static int FAM_30_COC_SIZE = 1;
    private static int FAM_30_TYPEJ_RANGE_HIGH_SIZE = 12;
    private static int FAM_30_TYPEN_RANGE_LOW_SIZE = 12;
    private static int FAM_30_TYPEN_TEMPERATURE_SIZE = 12;
    private static int FAM_30_PS_SIZE = 1;

    public OneWireContainer30() {
    }

    public OneWireContainer30(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_30_TYPEE_RANGE_LOW))
            return FAM_30_TYPEE_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_CURRENTBIAS))
            return FAM_30_CURRENTBIAS_SIZE;
        if (path.equals(FAM_30_R_ADDRESS))
            return FAM_30_R_ADDRESS_SIZE;
        if (path.equals(FAM_30_VBIAS))
            return FAM_30_VBIAS_SIZE;
        if (path.equals(FAM_30_TYPEJ_RANGE_LOW))
            return FAM_30_TYPEJ_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_TYPE))
            return FAM_30_TYPE_SIZE;
        if (path.equals(FAM_30_TEMPERATURE))
            return FAM_30_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_TYPEE_TEMPERATURE))
            return FAM_30_TYPEE_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_FAMILY))
            return FAM_30_FAMILY_SIZE;
        if (path.equals(FAM_30_TYPER_RANGE_LOW))
            return FAM_30_TYPER_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_MSTR))
            return FAM_30_MSTR_SIZE;
        if (path.equals(FAM_30_TYPEK_RANGE_LOW))
            return FAM_30_TYPEK_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_TYPEB_RANGE_HIGH))
            return FAM_30_TYPEB_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_TYPEJ_TEMPERATURE))
            return FAM_30_TYPEJ_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_TYPER_RANGE_HIGH))
            return FAM_30_TYPER_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_TYPEB_RANGE_LOW))
            return FAM_30_TYPEB_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_DC))
            return FAM_30_DC_SIZE;
        if (path.equals(FAM_30_LOCATOR))
            return FAM_30_LOCATOR_SIZE;
        if (path.equals(FAM_30_OV))
            return FAM_30_OV_SIZE;
        if (path.equals(FAM_30_R_ID))
            return FAM_30_R_ID_SIZE;
        if (path.equals(FAM_30_AMPHOURS))
            return FAM_30_AMPHOURS_SIZE;
        if (path.equals(FAM_30_TYPET_RANGE_LOW))
            return FAM_30_TYPET_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_TYPEN_RANGE_HIGH))
            return FAM_30_TYPEN_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_VIS))
            return FAM_30_VIS_SIZE;
        if (path.equals(FAM_30_TYPER_TEMPERATURE))
            return FAM_30_TYPER_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_TYPES_TEMPERATURE))
            return FAM_30_TYPES_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_CE))
            return FAM_30_CE_SIZE;
        if (path.equals(FAM_30_TYPEK_RANGE_HIGH))
            return FAM_30_TYPEK_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_CC))
            return FAM_30_CC_SIZE;
        if (path.equals(FAM_30_TYPEB_TEMPERATURE))
            return FAM_30_TYPEB_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_VOLT))
            return FAM_30_VOLT_SIZE;
        if (path.equals(FAM_30_PMOD))
            return FAM_30_PMOD_SIZE;
        if (path.equals(FAM_30_SENSED))
            return FAM_30_SENSED_SIZE;
        if (path.equals(FAM_30_DEFAULTPMOD))
            return FAM_30_DEFAULTPMOD_SIZE;
        if (path.equals(FAM_30_TYPEE_RANGE_HIGH))
            return FAM_30_TYPEE_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_VOLTHOURS))
            return FAM_30_VOLTHOURS_SIZE;
        if (path.equals(FAM_30_LOCK_ALL))
            return FAM_30_LOCK_ALL_SIZE;
        if (path.equals(FAM_30_ID))
            return FAM_30_ID_SIZE;
        if (path.equals(FAM_30_DE))
            return FAM_30_DE_SIZE;
        if (path.equals(FAM_30_LOCK_0))
            return FAM_30_LOCK_0_SIZE;
        if (path.equals(FAM_30_UV))
            return FAM_30_UV_SIZE;
        if (path.equals(FAM_30_CURRENT))
            return FAM_30_CURRENT_SIZE;
        if (path.equals(FAM_30_PIO))
            return FAM_30_PIO_SIZE;
        if (path.equals(FAM_30_CRC8))
            return FAM_30_CRC8_SIZE;
        if (path.equals(FAM_30_SWEN))
            return FAM_30_SWEN_SIZE;
        if (path.equals(FAM_30_TYPET_RANGE_HIGH))
            return FAM_30_TYPET_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_TYPEK_TEMPERATURE))
            return FAM_30_TYPEK_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_ALIAS))
            return FAM_30_ALIAS_SIZE;
        if (path.equals(FAM_30_R_LOCATOR))
            return FAM_30_R_LOCATOR_SIZE;
        if (path.equals(FAM_30_PAGES_PAGE_0))
            return FAM_30_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_30_MEMORY))
            return FAM_30_MEMORY_SIZE;
        if (path.equals(FAM_30_TYPET_TEMPERATURE))
            return FAM_30_TYPET_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_TYPES_RANGE_HIGH))
            return FAM_30_TYPES_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_PAGES_PAGE_ALL))
            return FAM_30_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_30_ADDRESS))
            return FAM_30_ADDRESS_SIZE;
        if (path.equals(FAM_30_DOC))
            return FAM_30_DOC_SIZE;
        if (path.equals(FAM_30_DEFAULTSWEN))
            return FAM_30_DEFAULTSWEN_SIZE;
        if (path.equals(FAM_30_TYPES_RANGE_LOW))
            return FAM_30_TYPES_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_COC))
            return FAM_30_COC_SIZE;
        if (path.equals(FAM_30_TYPEJ_RANGE_HIGH))
            return FAM_30_TYPEJ_RANGE_HIGH_SIZE;
        if (path.equals(FAM_30_TYPEN_RANGE_LOW))
            return FAM_30_TYPEN_RANGE_LOW_SIZE;
        if (path.equals(FAM_30_TYPEN_TEMPERATURE))
            return FAM_30_TYPEN_TEMPERATURE_SIZE;
        if (path.equals(FAM_30_PS)) {
            return FAM_30_PS_SIZE;
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