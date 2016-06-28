package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

public class OneWireContainerFC extends OneWireDevice {
    private static String FAM_FC_910_ALARM = "910/alarm";
    private static String FAM_FC_910_PIOC = "910/pioc";
    private static String FAM_FC_910_OUTC = "910/outc";
    private static String FAM_FC_R_ADDRESS = "r_address";
    private static String FAM_FC_910_ADCTOTP = "910/adctotp";
    private static String FAM_FC_910_PERIOD2 = "910/period2";
    private static String FAM_FC_910_OUT = "910/out";
    private static String FAM_FC_910_PERIOD1 = "910/period1";
    private static String FAM_FC_910_RESETCNT = "910/resetcnt";
    private static String FAM_FC_TYPE = "type";
    private static String FAM_FC_EEPROM_ERASE_ALL = "eeprom/erase.ALL";
    private static String FAM_FC_910_ALAN = "910/alan";
    private static String FAM_FC_FIRMWARE_FUNCTION = "firmware/function";
    private static String FAM_FC_910_CNTC = "910/cntc";
    private static String FAM_FC_910_TPM2C = "910/tpm2c";
    private static String FAM_FC_910_CNT = "910/cnt";
    private static String FAM_FC_910_ALAP = "910/alap";
    private static String FAM_FC_FAMILY = "family";
    private static String FAM_FC_910_ADCC = "910/adcc";
    private static String FAM_FC_EEPROM_PAGE_0 = "eeprom/page.0";
    private static String FAM_FC_EEPROM_ERASE_0 = "eeprom/erase.0";
    private static String FAM_FC_LOCATOR = "locator";
    private static String FAM_FC_R_ID = "r_id";
    private static String FAM_FC_LOCALTYPE = "localtype";
    private static String FAM_FC_910_TPM1C = "910/tpm1c";
    private static String FAM_FC_910_MAXCPS = "910/maxcps";
    private static String FAM_FC_910_OVRUNCNT = "910/ovruncnt";
    private static String FAM_FC_910_USERE = "910/usere";
    private static String FAM_FC_910_USERD = "910/userd";
    private static String FAM_FC_910_USERC = "910/userc";
    private static String FAM_FC_910_DATE = "910/date";
    private static String FAM_FC_910_USERB = "910/userb";
    private static String FAM_FC_910_USERI = "910/useri";
    private static String FAM_FC_910_USERH = "910/userh";
    private static String FAM_FC_910_STALLEDCNT = "910/stalledcnt";
    private static String FAM_FC_910_USERG = "910/userg";
    private static String FAM_FC_910_USERF = "910/userf";
    private static String FAM_FC_910_USERM = "910/userm";
    private static String FAM_FC_910_USERL = "910/userl";
    private static String FAM_FC_910_USERK = "910/userk";
    private static String FAM_FC_910_ADCTOTN = "910/adctotn";
    private static String FAM_FC_910_USERJ = "910/userj";
    private static String FAM_FC_910_DUTY1 = "910/duty1";
    private static String FAM_FC_910_USERP = "910/userp";
    private static String FAM_FC_910_DUTY2 = "910/duty2";
    private static String FAM_FC_910_USERO = "910/usero";
    private static String FAM_FC_910_DUTY3 = "910/duty3";
    private static String FAM_FC_910_UDATE = "910/udate";
    private static String FAM_FC_910_USERN = "910/usern";
    private static String FAM_FC_910_DUTY4 = "910/duty4";
    private static String FAM_FC_EEPROM_MEMORY = "eeprom/memory";
    private static String FAM_FC_910_ADCAN = "910/adcan";
    private static String FAM_FC_910_COUNT = "910/count";
    private static String FAM_FC_DEVICE_TYPE = "device_type";
    private static String FAM_FC_BOOTSTRAP_VERSION = "bootstrap_version";
    private static String FAM_FC_910_RTCC = "910/rtcc";
    private static String FAM_FC_910_MAXAN = "910/maxan";
    private static String FAM_FC_910_USERA = "910/usera";
    private static String FAM_FC_910_MAXAP = "910/maxap";
    private static String FAM_FC_910_ADCAP = "910/adcap";
    private static String FAM_FC_VERSION = "version";
    private static String FAM_FC_ID = "id";
    private static String FAM_FC_910_PC1 = "910/pc1";
    private static String FAM_FC_910_PC0 = "910/pc0";
    private static String FAM_FC_910_CPS = "910/cps";
    private static String FAM_FC_910_ALCT = "910/alct";
    private static String FAM_FC_910_ADC = "910/adc";
    private static String FAM_FC_COMMAND = "command";
    private static String FAM_FC_910_ALCPS = "910/alcps";
    private static String FAM_FC_CRC8 = "crc8";
    private static String FAM_FC_910_ALARMC = "910/alarmc";
    private static String FAM_FC_910_PC3 = "910/pc3";
    private static String FAM_FC_910_PC2 = "910/pc2";
    private static String FAM_FC_ALIAS = "alias";
    private static String FAM_FC_WRITEBYTE = "writebyte";
    private static String FAM_FC_R_LOCATOR = "r_locator";
    private static String FAM_FC_MEMORY = "memory";
    private static String FAM_FC_DEVICE_VERSION = "device_version";
    private static String FAM_FC_ADDRESS = "address";
    private static String FAM_FC_EEPROM_PAGE_ALL = "eeprom/page.ALL";
    private static String FAM_FC_910_PIO = "910/pio";
    private static String FAM_FC_CHIP_TYPE = "chip_type";
    private static String FAM_FC_910_SELECTCNT = "910/selectcnt";
    private static int FAM_FC_910_ALARM_SIZE = 12;
    private static int FAM_FC_910_PIOC_SIZE = 12;
    private static int FAM_FC_910_OUTC_SIZE = 12;
    private static int FAM_FC_R_ADDRESS_SIZE = 16;
    private static int FAM_FC_910_ADCTOTP_SIZE = 12;
    private static int FAM_FC_910_PERIOD2_SIZE = 12;
    private static int FAM_FC_910_OUT_SIZE = 12;
    private static int FAM_FC_910_PERIOD1_SIZE = 12;
    private static int FAM_FC_910_RESETCNT_SIZE = 12;
    private static int FAM_FC_TYPE_SIZE = 32;
    private static int FAM_FC_EEPROM_ERASE_ALL_SIZE = 3;
    private static int FAM_FC_910_ALAN_SIZE = 12;
    private static int FAM_FC_FIRMWARE_FUNCTION_SIZE = 4096;
    private static int FAM_FC_910_CNTC_SIZE = 12;
    private static int FAM_FC_910_TPM2C_SIZE = 12;
    private static int FAM_FC_910_CNT_SIZE = 12;
    private static int FAM_FC_910_ALAP_SIZE = 12;
    private static int FAM_FC_FAMILY_SIZE = 2;
    private static int FAM_FC_910_ADCC_SIZE = 12;
    private static int FAM_FC_EEPROM_PAGE_0_SIZE = 512;
    private static int FAM_FC_EEPROM_ERASE_0_SIZE = 1;
    private static int FAM_FC_LOCATOR_SIZE = 16;
    private static int FAM_FC_R_ID_SIZE = 12;
    private static int FAM_FC_LOCALTYPE_SIZE = 5;
    private static int FAM_FC_910_TPM1C_SIZE = 12;
    private static int FAM_FC_910_MAXCPS_SIZE = 12;
    private static int FAM_FC_910_OVRUNCNT_SIZE = 12;
    private static int FAM_FC_910_USERE_SIZE = 12;
    private static int FAM_FC_910_USERD_SIZE = 12;
    private static int FAM_FC_910_USERC_SIZE = 12;
    private static int FAM_FC_910_DATE_SIZE = 24;
    private static int FAM_FC_910_USERB_SIZE = 12;
    private static int FAM_FC_910_USERI_SIZE = 12;
    private static int FAM_FC_910_USERH_SIZE = 12;
    private static int FAM_FC_910_STALLEDCNT_SIZE = 12;
    private static int FAM_FC_910_USERG_SIZE = 12;
    private static int FAM_FC_910_USERF_SIZE = 12;
    private static int FAM_FC_910_USERM_SIZE = 12;
    private static int FAM_FC_910_USERL_SIZE = 12;
    private static int FAM_FC_910_USERK_SIZE = 12;
    private static int FAM_FC_910_ADCTOTN_SIZE = 12;
    private static int FAM_FC_910_USERJ_SIZE = 12;
    private static int FAM_FC_910_DUTY1_SIZE = 12;
    private static int FAM_FC_910_USERP_SIZE = 12;
    private static int FAM_FC_910_DUTY2_SIZE = 12;
    private static int FAM_FC_910_USERO_SIZE = 12;
    private static int FAM_FC_910_DUTY3_SIZE = 12;
    private static int FAM_FC_910_UDATE_SIZE = 12;
    private static int FAM_FC_910_USERN_SIZE = 12;
    private static int FAM_FC_910_DUTY4_SIZE = 12;
    private static int FAM_FC_EEPROM_MEMORY_SIZE = 1024;
    private static int FAM_FC_910_ADCAN_SIZE = 12;
    private static int FAM_FC_910_COUNT_SIZE = 12;
    private static int FAM_FC_DEVICE_TYPE_SIZE = 12;
    private static int FAM_FC_BOOTSTRAP_VERSION_SIZE = 12;
    private static int FAM_FC_910_RTCC_SIZE = 12;
    private static int FAM_FC_910_MAXAN_SIZE = 12;
    private static int FAM_FC_910_USERA_SIZE = 12;
    private static int FAM_FC_910_MAXAP_SIZE = 12;
    private static int FAM_FC_910_ADCAP_SIZE = 12;
    private static int FAM_FC_VERSION_SIZE = 5;
    private static int FAM_FC_ID_SIZE = 12;
    private static int FAM_FC_910_PC1_SIZE = 12;
    private static int FAM_FC_910_PC0_SIZE = 12;
    private static int FAM_FC_910_CPS_SIZE = 12;
    private static int FAM_FC_910_ALCT_SIZE = 12;
    private static int FAM_FC_910_ADC_SIZE = 12;
    private static int FAM_FC_COMMAND_SIZE = 255;
    private static int FAM_FC_910_ALCPS_SIZE = 12;
    private static int FAM_FC_CRC8_SIZE = 2;
    private static int FAM_FC_910_ALARMC_SIZE = 12;
    private static int FAM_FC_910_PC3_SIZE = 12;
    private static int FAM_FC_910_PC2_SIZE = 12;
    private static int FAM_FC_ALIAS_SIZE = 256;
    private static int FAM_FC_WRITEBYTE_SIZE = 12;
    private static int FAM_FC_R_LOCATOR_SIZE = 16;
    private static int FAM_FC_MEMORY_SIZE = 128;
    private static int FAM_FC_DEVICE_VERSION_SIZE = 12;
    private static int FAM_FC_ADDRESS_SIZE = 16;
    private static int FAM_FC_EEPROM_PAGE_ALL_SIZE = 1024;
    private static int FAM_FC_910_PIO_SIZE = 12;
    private static int FAM_FC_CHIP_TYPE_SIZE = 12;
    private static int FAM_FC_910_SELECTCNT_SIZE = 12;

    public OneWireContainerFC() {
    }

    public OneWireContainerFC(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_FC_910_ALARM))
            return FAM_FC_910_ALARM_SIZE;
        if (path.equals(FAM_FC_910_PIOC))
            return FAM_FC_910_PIOC_SIZE;
        if (path.equals(FAM_FC_910_OUTC))
            return FAM_FC_910_OUTC_SIZE;
        if (path.equals(FAM_FC_R_ADDRESS))
            return FAM_FC_R_ADDRESS_SIZE;
        if (path.equals(FAM_FC_910_ADCTOTP))
            return FAM_FC_910_ADCTOTP_SIZE;
        if (path.equals(FAM_FC_910_PERIOD2))
            return FAM_FC_910_PERIOD2_SIZE;
        if (path.equals(FAM_FC_910_OUT))
            return FAM_FC_910_OUT_SIZE;
        if (path.equals(FAM_FC_910_PERIOD1))
            return FAM_FC_910_PERIOD1_SIZE;
        if (path.equals(FAM_FC_910_RESETCNT))
            return FAM_FC_910_RESETCNT_SIZE;
        if (path.equals(FAM_FC_TYPE))
            return FAM_FC_TYPE_SIZE;
        if (path.equals(FAM_FC_EEPROM_ERASE_ALL))
            return FAM_FC_EEPROM_ERASE_ALL_SIZE;
        if (path.equals(FAM_FC_910_ALAN))
            return FAM_FC_910_ALAN_SIZE;
        if (path.equals(FAM_FC_FIRMWARE_FUNCTION))
            return FAM_FC_FIRMWARE_FUNCTION_SIZE;
        if (path.equals(FAM_FC_910_CNTC))
            return FAM_FC_910_CNTC_SIZE;
        if (path.equals(FAM_FC_910_TPM2C))
            return FAM_FC_910_TPM2C_SIZE;
        if (path.equals(FAM_FC_910_CNT))
            return FAM_FC_910_CNT_SIZE;
        if (path.equals(FAM_FC_910_ALAP))
            return FAM_FC_910_ALAP_SIZE;
        if (path.equals(FAM_FC_FAMILY))
            return FAM_FC_FAMILY_SIZE;
        if (path.equals(FAM_FC_910_ADCC))
            return FAM_FC_910_ADCC_SIZE;
        if (path.equals(FAM_FC_EEPROM_PAGE_0))
            return FAM_FC_EEPROM_PAGE_0_SIZE;
        if (path.equals(FAM_FC_EEPROM_ERASE_0))
            return FAM_FC_EEPROM_ERASE_0_SIZE;
        if (path.equals(FAM_FC_LOCATOR))
            return FAM_FC_LOCATOR_SIZE;
        if (path.equals(FAM_FC_R_ID))
            return FAM_FC_R_ID_SIZE;
        if (path.equals(FAM_FC_LOCALTYPE))
            return FAM_FC_LOCALTYPE_SIZE;
        if (path.equals(FAM_FC_910_TPM1C))
            return FAM_FC_910_TPM1C_SIZE;
        if (path.equals(FAM_FC_910_MAXCPS))
            return FAM_FC_910_MAXCPS_SIZE;
        if (path.equals(FAM_FC_910_OVRUNCNT))
            return FAM_FC_910_OVRUNCNT_SIZE;
        if (path.equals(FAM_FC_910_USERE))
            return FAM_FC_910_USERE_SIZE;
        if (path.equals(FAM_FC_910_USERD))
            return FAM_FC_910_USERD_SIZE;
        if (path.equals(FAM_FC_910_USERC))
            return FAM_FC_910_USERC_SIZE;
        if (path.equals(FAM_FC_910_DATE))
            return FAM_FC_910_DATE_SIZE;
        if (path.equals(FAM_FC_910_USERB))
            return FAM_FC_910_USERB_SIZE;
        if (path.equals(FAM_FC_910_USERI))
            return FAM_FC_910_USERI_SIZE;
        if (path.equals(FAM_FC_910_USERH))
            return FAM_FC_910_USERH_SIZE;
        if (path.equals(FAM_FC_910_STALLEDCNT))
            return FAM_FC_910_STALLEDCNT_SIZE;
        if (path.equals(FAM_FC_910_USERG))
            return FAM_FC_910_USERG_SIZE;
        if (path.equals(FAM_FC_910_USERF))
            return FAM_FC_910_USERF_SIZE;
        if (path.equals(FAM_FC_910_USERM))
            return FAM_FC_910_USERM_SIZE;
        if (path.equals(FAM_FC_910_USERL))
            return FAM_FC_910_USERL_SIZE;
        if (path.equals(FAM_FC_910_USERK))
            return FAM_FC_910_USERK_SIZE;
        if (path.equals(FAM_FC_910_ADCTOTN))
            return FAM_FC_910_ADCTOTN_SIZE;
        if (path.equals(FAM_FC_910_USERJ))
            return FAM_FC_910_USERJ_SIZE;
        if (path.equals(FAM_FC_910_DUTY1))
            return FAM_FC_910_DUTY1_SIZE;
        if (path.equals(FAM_FC_910_USERP))
            return FAM_FC_910_USERP_SIZE;
        if (path.equals(FAM_FC_910_DUTY2))
            return FAM_FC_910_DUTY2_SIZE;
        if (path.equals(FAM_FC_910_USERO))
            return FAM_FC_910_USERO_SIZE;
        if (path.equals(FAM_FC_910_DUTY3))
            return FAM_FC_910_DUTY3_SIZE;
        if (path.equals(FAM_FC_910_UDATE))
            return FAM_FC_910_UDATE_SIZE;
        if (path.equals(FAM_FC_910_USERN))
            return FAM_FC_910_USERN_SIZE;
        if (path.equals(FAM_FC_910_DUTY4))
            return FAM_FC_910_DUTY4_SIZE;
        if (path.equals(FAM_FC_EEPROM_MEMORY))
            return FAM_FC_EEPROM_MEMORY_SIZE;
        if (path.equals(FAM_FC_910_ADCAN))
            return FAM_FC_910_ADCAN_SIZE;
        if (path.equals(FAM_FC_910_COUNT))
            return FAM_FC_910_COUNT_SIZE;
        if (path.equals(FAM_FC_DEVICE_TYPE))
            return FAM_FC_DEVICE_TYPE_SIZE;
        if (path.equals(FAM_FC_BOOTSTRAP_VERSION))
            return FAM_FC_BOOTSTRAP_VERSION_SIZE;
        if (path.equals(FAM_FC_910_RTCC))
            return FAM_FC_910_RTCC_SIZE;
        if (path.equals(FAM_FC_910_MAXAN))
            return FAM_FC_910_MAXAN_SIZE;
        if (path.equals(FAM_FC_910_USERA))
            return FAM_FC_910_USERA_SIZE;
        if (path.equals(FAM_FC_910_MAXAP))
            return FAM_FC_910_MAXAP_SIZE;
        if (path.equals(FAM_FC_910_ADCAP))
            return FAM_FC_910_ADCAP_SIZE;
        if (path.equals(FAM_FC_VERSION))
            return FAM_FC_VERSION_SIZE;
        if (path.equals(FAM_FC_ID))
            return FAM_FC_ID_SIZE;
        if (path.equals(FAM_FC_910_PC1))
            return FAM_FC_910_PC1_SIZE;
        if (path.equals(FAM_FC_910_PC0))
            return FAM_FC_910_PC0_SIZE;
        if (path.equals(FAM_FC_910_CPS))
            return FAM_FC_910_CPS_SIZE;
        if (path.equals(FAM_FC_910_ALCT))
            return FAM_FC_910_ALCT_SIZE;
        if (path.equals(FAM_FC_910_ADC))
            return FAM_FC_910_ADC_SIZE;
        if (path.equals(FAM_FC_COMMAND))
            return FAM_FC_COMMAND_SIZE;
        if (path.equals(FAM_FC_910_ALCPS))
            return FAM_FC_910_ALCPS_SIZE;
        if (path.equals(FAM_FC_CRC8))
            return FAM_FC_CRC8_SIZE;
        if (path.equals(FAM_FC_910_ALARMC))
            return FAM_FC_910_ALARMC_SIZE;
        if (path.equals(FAM_FC_910_PC3))
            return FAM_FC_910_PC3_SIZE;
        if (path.equals(FAM_FC_910_PC2))
            return FAM_FC_910_PC2_SIZE;
        if (path.equals(FAM_FC_ALIAS))
            return FAM_FC_ALIAS_SIZE;
        if (path.equals(FAM_FC_WRITEBYTE))
            return FAM_FC_WRITEBYTE_SIZE;
        if (path.equals(FAM_FC_R_LOCATOR))
            return FAM_FC_R_LOCATOR_SIZE;
        if (path.equals(FAM_FC_MEMORY))
            return FAM_FC_MEMORY_SIZE;
        if (path.equals(FAM_FC_DEVICE_VERSION))
            return FAM_FC_DEVICE_VERSION_SIZE;
        if (path.equals(FAM_FC_ADDRESS))
            return FAM_FC_ADDRESS_SIZE;
        if (path.equals(FAM_FC_EEPROM_PAGE_ALL))
            return FAM_FC_EEPROM_PAGE_ALL_SIZE;
        if (path.equals(FAM_FC_910_PIO))
            return FAM_FC_910_PIO_SIZE;
        if (path.equals(FAM_FC_CHIP_TYPE))
            return FAM_FC_CHIP_TYPE_SIZE;
        if (path.equals(FAM_FC_910_SELECTCNT)) {
            return FAM_FC_910_SELECTCNT_SIZE;
        }
        return -1;
    }
}