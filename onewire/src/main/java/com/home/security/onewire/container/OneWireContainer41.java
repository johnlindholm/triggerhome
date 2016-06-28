package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer41 extends OneWireDevice
        implements OneWireTemperatureContainer, OneWireHumidityContainer {
    private static String FAM_41_LOCATOR = "locator";
    private static String FAM_41_R_ID = "r_id";
    private static String FAM_41_R_ADDRESS = "r_address";
    private static String FAM_41_ALIAS = "alias";
    private static String FAM_41_MISSION_SAMPLINGHUMIDITY = "mission/samplinghumidity";
    private static String FAM_41_CLOCK_UDATE = "clock/udate";
    private static String FAM_41_MISSION_SAMPLINGTEMP = "mission/samplingtemp";
    private static String FAM_41_MISSION_ROLLOVER = "mission/rollover";
    private static String FAM_41_R_LOCATOR = "r_locator";
    private static String FAM_41_TYPE = "type";
    private static String FAM_41_MISSION_DELAY = "mission/delay";
    private static String FAM_41_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_41_TEMPERATURE = "temperature";
    private static String FAM_41_CLOCK_RUNNING = "clock/running";
    private static String FAM_41_ID = "id";
    private static String FAM_41_MISSION_RUNNING = "mission/running";
    private static String FAM_41_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_41_HUMIDITY = "humidity";
    private static String FAM_41_ADDRESS = "address";
    private static String FAM_41_CLOCK_DATE = "clock/date";
    private static String FAM_41_FAMILY = "family";
    private static String FAM_41_CRC8 = "crc8";
    private static int FAM_41_LOCATOR_SIZE = 16;
    private static int FAM_41_R_ID_SIZE = 12;
    private static int FAM_41_R_ADDRESS_SIZE = 16;
    private static int FAM_41_ALIAS_SIZE = 256;
    private static int FAM_41_MISSION_SAMPLINGHUMIDITY_SIZE = 1;
    private static int FAM_41_CLOCK_UDATE_SIZE = 12;
    private static int FAM_41_MISSION_SAMPLINGTEMP_SIZE = 1;
    private static int FAM_41_MISSION_ROLLOVER_SIZE = 1;
    private static int FAM_41_R_LOCATOR_SIZE = 16;
    private static int FAM_41_TYPE_SIZE = 32;
    private static int FAM_41_MISSION_DELAY_SIZE = 12;
    private static int FAM_41_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_41_TEMPERATURE_SIZE = 12;
    private static int FAM_41_CLOCK_RUNNING_SIZE = 1;
    private static int FAM_41_ID_SIZE = 12;
    private static int FAM_41_MISSION_RUNNING_SIZE = 1;
    private static int FAM_41_PAGES_PAGE_ALL_SIZE = 576;
    private static int FAM_41_HUMIDITY_SIZE = 12;
    private static int FAM_41_ADDRESS_SIZE = 16;
    private static int FAM_41_CLOCK_DATE_SIZE = 24;
    private static int FAM_41_FAMILY_SIZE = 2;
    private static int FAM_41_CRC8_SIZE = 2;

    public OneWireContainer41() {
    }

    public OneWireContainer41(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_41_LOCATOR))
            return FAM_41_LOCATOR_SIZE;
        if (path.equals(FAM_41_R_ID))
            return FAM_41_R_ID_SIZE;
        if (path.equals(FAM_41_R_ADDRESS))
            return FAM_41_R_ADDRESS_SIZE;
        if (path.equals(FAM_41_ALIAS))
            return FAM_41_ALIAS_SIZE;
        if (path.equals(FAM_41_MISSION_SAMPLINGHUMIDITY))
            return FAM_41_MISSION_SAMPLINGHUMIDITY_SIZE;
        if (path.equals(FAM_41_CLOCK_UDATE))
            return FAM_41_CLOCK_UDATE_SIZE;
        if (path.equals(FAM_41_MISSION_SAMPLINGTEMP))
            return FAM_41_MISSION_SAMPLINGTEMP_SIZE;
        if (path.equals(FAM_41_MISSION_ROLLOVER))
            return FAM_41_MISSION_ROLLOVER_SIZE;
        if (path.equals(FAM_41_R_LOCATOR))
            return FAM_41_R_LOCATOR_SIZE;
        if (path.equals(FAM_41_TYPE))
            return FAM_41_TYPE_SIZE;
        if (path.equals(FAM_41_MISSION_DELAY))
            return FAM_41_MISSION_DELAY_SIZE;
        if (path.equals(FAM_41_PAGES_PAGE_0))
            return FAM_41_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_41_TEMPERATURE))
            return FAM_41_TEMPERATURE_SIZE;
        if (path.equals(FAM_41_CLOCK_RUNNING))
            return FAM_41_CLOCK_RUNNING_SIZE;
        if (path.equals(FAM_41_ID))
            return FAM_41_ID_SIZE;
        if (path.equals(FAM_41_MISSION_RUNNING))
            return FAM_41_MISSION_RUNNING_SIZE;
        if (path.equals(FAM_41_PAGES_PAGE_ALL))
            return FAM_41_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_41_HUMIDITY))
            return FAM_41_HUMIDITY_SIZE;
        if (path.equals(FAM_41_ADDRESS))
            return FAM_41_ADDRESS_SIZE;
        if (path.equals(FAM_41_CLOCK_DATE))
            return FAM_41_CLOCK_DATE_SIZE;
        if (path.equals(FAM_41_FAMILY))
            return FAM_41_FAMILY_SIZE;
        if (path.equals(FAM_41_CRC8)) {
            return FAM_41_CRC8_SIZE;
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

    public String getHumidity()
            throws IOException {
        return readValue("humidity", true);
    }
}