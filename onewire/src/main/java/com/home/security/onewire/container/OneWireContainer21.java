package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer21 extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_21_HISTOGRAM_ELEMENTS = "histogram/elements";
    private static String FAM_21_SET_ALARM_TEMPHIGH = "set_alarm/temphigh";
    private static String FAM_21_MISSION_UDATE = "mission/udate";
    private static String FAM_21_R_ADDRESS = "r_address";
    private static String FAM_21_OVERTEMP_DATE_0 = "overtemp/date.0";
    private static String FAM_21_ABOUT_RESOLUTION = "about/resolution";
    private static String FAM_21_LOG_UDATE_ALL = "log/udate.ALL";
    private static String FAM_21_TYPE = "type";
    private static String FAM_21_TEMPERATURE = "temperature";
    private static String FAM_21_OVERTEMP_ELEMENTS = "overtemp/elements";
    private static String FAM_21_LOG_TEMPERATURE_ALL = "log/temperature.ALL";
    private static String FAM_21_LOG_DATE_0 = "log/date.0";
    private static String FAM_21_FAMILY = "family";
    private static String FAM_21_HISTOGRAM_COUNTS_ALL = "histogram/counts.ALL";
    private static String FAM_21_UNDERTEMP_DATE_ALL = "undertemp/date.ALL";
    private static String FAM_21_ALARM_TRIGGER = "alarm_trigger";
    private static String FAM_21_MISSION_FREQUENCY = "mission/frequency";
    private static String FAM_21_OVERTEMP_COUNT_0 = "overtemp/count.0";
    private static String FAM_21_HISTOGRAM_TEMPERATURE_ALL = "histogram/temperature.ALL";
    private static String FAM_21_MISSION_SAMPLES = "mission/samples";
    private static String FAM_21_LOCATOR = "locator";
    private static String FAM_21_UNDERTEMP_COUNT_0 = "undertemp/count.0";
    private static String FAM_21_SET_ALARM_TEMPLOW = "set_alarm/templow";
    private static String FAM_21_R_ID = "r_id";
    private static String FAM_21_OVERTEMP_END_0 = "overtemp/end.0";
    private static String FAM_21_ALARM_DOW = "alarm_dow";
    private static String FAM_21_MISSION_TEMPHIGH = "mission/temphigh";
    private static String FAM_21_ALARM_STATE = "alarm_state";
    private static String FAM_21_MISSION_DELAY = "mission/delay";
    private static String FAM_21_SET_ALARM_DATE = "set_alarm/date";
    private static String FAM_21_LOG_DATE_ALL = "log/date.ALL";
    private static String FAM_21_CLOCK_DATE = "clock/date";
    private static String FAM_21_ABOUT_TEMPLOW = "about/templow";
    private static String FAM_21_MISSION_EASYSTART = "mission/easystart";
    private static String FAM_21_OVERTEMP_END_ALL = "overtemp/end.ALL";
    private static String FAM_21_UNDERTEMP_UDATE_0 = "undertemp/udate.0";
    private static String FAM_21_ABOUT_SAMPLES = "about/samples";
    private static String FAM_21_MISSION_ROLLOVER = "mission/rollover";
    private static String FAM_21_MISSION_SAMPLING = "mission/sampling";
    private static String FAM_21_UNDERTEMP_UDATE_ALL = "undertemp/udate.ALL";
    private static String FAM_21_UNDERTEMP_END_0 = "undertemp/end.0";
    private static String FAM_21_CLOCK_RUNNING = "clock/running";
    private static String FAM_21_ID = "id";
    private static String FAM_21_MISSION_RUNNING = "mission/running";
    private static String FAM_21_MISSION_DATE = "mission/date";
    private static String FAM_21_ABOUT_TEMPHIGH = "about/temphigh";
    private static String FAM_21_OVERTEMP_DATE_ALL = "overtemp/date.ALL";
    private static String FAM_21_ABOUT_MEASURING = "about/measuring";
    private static String FAM_21_CRC8 = "crc8";
    private static String FAM_21_OVERTEMP_TEMPERATURE = "overtemp/temperature";
    private static String FAM_21_OVERTEMP_COUNT_ALL = "overtemp/count.ALL";
    private static String FAM_21_UNDERTEMP_ELEMENTS = "undertemp/elements";
    private static String FAM_21_OVERTEMP_UDATE_ALL = "overtemp/udate.ALL";
    private static String FAM_21_ABOUT_VERSION = "about/version";
    private static String FAM_21_MISSION_TEMPLOW = "mission/templow";
    private static String FAM_21_ALARM_SECOND = "alarm_second";
    private static String FAM_21_HISTOGRAM_COUNTS_0 = "histogram/counts.0";
    private static String FAM_21_ALIAS = "alias";
    private static String FAM_21_CLOCK_UDATE = "clock/udate";
    private static String FAM_21_ALARM_MINUTE = "alarm_minute";
    private static String FAM_21_HISTOGRAM_GAP = "histogram/gap";
    private static String FAM_21_R_LOCATOR = "r_locator";
    private static String FAM_21_ALARM_HOUR = "alarm_hour";
    private static String FAM_21_UNDERTEMP_END_ALL = "undertemp/end.ALL";
    private static String FAM_21_UNDERTEMP_COUNT_ALL = "undertemp/count.ALL";
    private static String FAM_21_HISTOGRAM_TEMPERATURE_0 = "histogram/temperature.0";
    private static String FAM_21_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_21_MEMORY = "memory";
    private static String FAM_21_SET_ALARM_TRIGGER = "set_alarm/trigger";
    private static String FAM_21_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_21_ADDRESS = "address";
    private static String FAM_21_LOG_TEMPERATURE_0 = "log/temperature.0";
    private static String FAM_21_MISSION_ENABLE = "mission/enable";
    private static String FAM_21_LOG_UDATE_0 = "log/udate.0";
    private static String FAM_21_OVERTEMP_UDATE_0 = "overtemp/udate.0";
    private static String FAM_21_UNDERTEMP_DATE_0 = "undertemp/date.0";
    private static String FAM_21_LOG_ELEMENTS = "log/elements";
    private static String FAM_21_UNDERTEMP_TEMPERATURE = "undertemp/temperature";
    private static int FAM_21_HISTOGRAM_ELEMENTS_SIZE = 12;
    private static int FAM_21_SET_ALARM_TEMPHIGH_SIZE = 1;
    private static int FAM_21_MISSION_UDATE_SIZE = 12;
    private static int FAM_21_R_ADDRESS_SIZE = 16;
    private static int FAM_21_OVERTEMP_DATE_0_SIZE = 24;
    private static int FAM_21_ABOUT_RESOLUTION_SIZE = 12;
    private static int FAM_21_LOG_UDATE_ALL_SIZE = 26623;
    private static int FAM_21_TYPE_SIZE = 32;
    private static int FAM_21_TEMPERATURE_SIZE = 12;
    private static int FAM_21_OVERTEMP_ELEMENTS_SIZE = 12;
    private static int FAM_21_LOG_TEMPERATURE_ALL_SIZE = 26623;
    private static int FAM_21_LOG_DATE_0_SIZE = 24;
    private static int FAM_21_FAMILY_SIZE = 2;
    private static int FAM_21_HISTOGRAM_COUNTS_ALL_SIZE = 818;
    private static int FAM_21_UNDERTEMP_DATE_ALL_SIZE = 299;
    private static int FAM_21_ALARM_TRIGGER_SIZE = 12;
    private static int FAM_21_MISSION_FREQUENCY_SIZE = 12;
    private static int FAM_21_OVERTEMP_COUNT_0_SIZE = 12;
    private static int FAM_21_HISTOGRAM_TEMPERATURE_ALL_SIZE = 818;
    private static int FAM_21_MISSION_SAMPLES_SIZE = 12;
    private static int FAM_21_LOCATOR_SIZE = 16;
    private static int FAM_21_UNDERTEMP_COUNT_0_SIZE = 12;
    private static int FAM_21_SET_ALARM_TEMPLOW_SIZE = 1;
    private static int FAM_21_R_ID_SIZE = 12;
    private static int FAM_21_OVERTEMP_END_0_SIZE = 24;
    private static int FAM_21_ALARM_DOW_SIZE = 12;
    private static int FAM_21_MISSION_TEMPHIGH_SIZE = 1;
    private static int FAM_21_ALARM_STATE_SIZE = 12;
    private static int FAM_21_MISSION_DELAY_SIZE = 12;
    private static int FAM_21_SET_ALARM_DATE_SIZE = 1;
    private static int FAM_21_LOG_DATE_ALL_SIZE = 51199;
    private static int FAM_21_CLOCK_DATE_SIZE = 24;
    private static int FAM_21_ABOUT_TEMPLOW_SIZE = 12;
    private static int FAM_21_MISSION_EASYSTART_SIZE = 12;
    private static int FAM_21_OVERTEMP_END_ALL_SIZE = 299;
    private static int FAM_21_UNDERTEMP_UDATE_0_SIZE = 12;
    private static int FAM_21_ABOUT_SAMPLES_SIZE = 12;
    private static int FAM_21_MISSION_ROLLOVER_SIZE = 1;
    private static int FAM_21_MISSION_SAMPLING_SIZE = 1;
    private static int FAM_21_UNDERTEMP_UDATE_ALL_SIZE = 155;
    private static int FAM_21_UNDERTEMP_END_0_SIZE = 24;
    private static int FAM_21_CLOCK_RUNNING_SIZE = 1;
    private static int FAM_21_ID_SIZE = 12;
    private static int FAM_21_MISSION_RUNNING_SIZE = 1;
    private static int FAM_21_MISSION_DATE_SIZE = 24;
    private static int FAM_21_ABOUT_TEMPHIGH_SIZE = 12;
    private static int FAM_21_OVERTEMP_DATE_ALL_SIZE = 299;
    private static int FAM_21_ABOUT_MEASURING_SIZE = 1;
    private static int FAM_21_CRC8_SIZE = 2;
    private static int FAM_21_OVERTEMP_TEMPERATURE_SIZE = 12;
    private static int FAM_21_OVERTEMP_COUNT_ALL_SIZE = 155;
    private static int FAM_21_UNDERTEMP_ELEMENTS_SIZE = 12;
    private static int FAM_21_OVERTEMP_UDATE_ALL_SIZE = 155;
    private static int FAM_21_ABOUT_VERSION_SIZE = 11;
    private static int FAM_21_MISSION_TEMPLOW_SIZE = 1;
    private static int FAM_21_ALARM_SECOND_SIZE = 12;
    private static int FAM_21_HISTOGRAM_COUNTS_0_SIZE = 12;
    private static int FAM_21_ALIAS_SIZE = 256;
    private static int FAM_21_CLOCK_UDATE_SIZE = 12;
    private static int FAM_21_ALARM_MINUTE_SIZE = 12;
    private static int FAM_21_HISTOGRAM_GAP_SIZE = 12;
    private static int FAM_21_R_LOCATOR_SIZE = 16;
    private static int FAM_21_ALARM_HOUR_SIZE = 12;
    private static int FAM_21_UNDERTEMP_END_ALL_SIZE = 299;
    private static int FAM_21_UNDERTEMP_COUNT_ALL_SIZE = 155;
    private static int FAM_21_HISTOGRAM_TEMPERATURE_0_SIZE = 12;
    private static int FAM_21_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_21_MEMORY_SIZE = 512;
    private static int FAM_21_SET_ALARM_TRIGGER_SIZE = 1;
    private static int FAM_21_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_21_ADDRESS_SIZE = 16;
    private static int FAM_21_LOG_TEMPERATURE_0_SIZE = 12;
    private static int FAM_21_MISSION_ENABLE_SIZE = 1;
    private static int FAM_21_LOG_UDATE_0_SIZE = 12;
    private static int FAM_21_OVERTEMP_UDATE_0_SIZE = 12;
    private static int FAM_21_UNDERTEMP_DATE_0_SIZE = 24;
    private static int FAM_21_LOG_ELEMENTS_SIZE = 12;
    private static int FAM_21_UNDERTEMP_TEMPERATURE_SIZE = 12;

    public OneWireContainer21() {
    }

    public OneWireContainer21(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_21_HISTOGRAM_ELEMENTS))
            return FAM_21_HISTOGRAM_ELEMENTS_SIZE;
        if (path.equals(FAM_21_SET_ALARM_TEMPHIGH))
            return FAM_21_SET_ALARM_TEMPHIGH_SIZE;
        if (path.equals(FAM_21_MISSION_UDATE))
            return FAM_21_MISSION_UDATE_SIZE;
        if (path.equals(FAM_21_R_ADDRESS))
            return FAM_21_R_ADDRESS_SIZE;
        if (path.equals(FAM_21_OVERTEMP_DATE_0))
            return FAM_21_OVERTEMP_DATE_0_SIZE;
        if (path.equals(FAM_21_ABOUT_RESOLUTION))
            return FAM_21_ABOUT_RESOLUTION_SIZE;
        if (path.equals(FAM_21_LOG_UDATE_ALL))
            return FAM_21_LOG_UDATE_ALL_SIZE;
        if (path.equals(FAM_21_TYPE))
            return FAM_21_TYPE_SIZE;
        if (path.equals(FAM_21_TEMPERATURE))
            return FAM_21_TEMPERATURE_SIZE;
        if (path.equals(FAM_21_OVERTEMP_ELEMENTS))
            return FAM_21_OVERTEMP_ELEMENTS_SIZE;
        if (path.equals(FAM_21_LOG_TEMPERATURE_ALL))
            return FAM_21_LOG_TEMPERATURE_ALL_SIZE;
        if (path.equals(FAM_21_LOG_DATE_0))
            return FAM_21_LOG_DATE_0_SIZE;
        if (path.equals(FAM_21_FAMILY))
            return FAM_21_FAMILY_SIZE;
        if (path.equals(FAM_21_HISTOGRAM_COUNTS_ALL))
            return FAM_21_HISTOGRAM_COUNTS_ALL_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_DATE_ALL))
            return FAM_21_UNDERTEMP_DATE_ALL_SIZE;
        if (path.equals(FAM_21_ALARM_TRIGGER))
            return FAM_21_ALARM_TRIGGER_SIZE;
        if (path.equals(FAM_21_MISSION_FREQUENCY))
            return FAM_21_MISSION_FREQUENCY_SIZE;
        if (path.equals(FAM_21_OVERTEMP_COUNT_0))
            return FAM_21_OVERTEMP_COUNT_0_SIZE;
        if (path.equals(FAM_21_HISTOGRAM_TEMPERATURE_ALL))
            return FAM_21_HISTOGRAM_TEMPERATURE_ALL_SIZE;
        if (path.equals(FAM_21_MISSION_SAMPLES))
            return FAM_21_MISSION_SAMPLES_SIZE;
        if (path.equals(FAM_21_LOCATOR))
            return FAM_21_LOCATOR_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_COUNT_0))
            return FAM_21_UNDERTEMP_COUNT_0_SIZE;
        if (path.equals(FAM_21_SET_ALARM_TEMPLOW))
            return FAM_21_SET_ALARM_TEMPLOW_SIZE;
        if (path.equals(FAM_21_R_ID))
            return FAM_21_R_ID_SIZE;
        if (path.equals(FAM_21_OVERTEMP_END_0))
            return FAM_21_OVERTEMP_END_0_SIZE;
        if (path.equals(FAM_21_ALARM_DOW))
            return FAM_21_ALARM_DOW_SIZE;
        if (path.equals(FAM_21_MISSION_TEMPHIGH))
            return FAM_21_MISSION_TEMPHIGH_SIZE;
        if (path.equals(FAM_21_ALARM_STATE))
            return FAM_21_ALARM_STATE_SIZE;
        if (path.equals(FAM_21_MISSION_DELAY))
            return FAM_21_MISSION_DELAY_SIZE;
        if (path.equals(FAM_21_SET_ALARM_DATE))
            return FAM_21_SET_ALARM_DATE_SIZE;
        if (path.equals(FAM_21_LOG_DATE_ALL))
            return FAM_21_LOG_DATE_ALL_SIZE;
        if (path.equals(FAM_21_CLOCK_DATE))
            return FAM_21_CLOCK_DATE_SIZE;
        if (path.equals(FAM_21_ABOUT_TEMPLOW))
            return FAM_21_ABOUT_TEMPLOW_SIZE;
        if (path.equals(FAM_21_MISSION_EASYSTART))
            return FAM_21_MISSION_EASYSTART_SIZE;
        if (path.equals(FAM_21_OVERTEMP_END_ALL))
            return FAM_21_OVERTEMP_END_ALL_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_UDATE_0))
            return FAM_21_UNDERTEMP_UDATE_0_SIZE;
        if (path.equals(FAM_21_ABOUT_SAMPLES))
            return FAM_21_ABOUT_SAMPLES_SIZE;
        if (path.equals(FAM_21_MISSION_ROLLOVER))
            return FAM_21_MISSION_ROLLOVER_SIZE;
        if (path.equals(FAM_21_MISSION_SAMPLING))
            return FAM_21_MISSION_SAMPLING_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_UDATE_ALL))
            return FAM_21_UNDERTEMP_UDATE_ALL_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_END_0))
            return FAM_21_UNDERTEMP_END_0_SIZE;
        if (path.equals(FAM_21_CLOCK_RUNNING))
            return FAM_21_CLOCK_RUNNING_SIZE;
        if (path.equals(FAM_21_ID))
            return FAM_21_ID_SIZE;
        if (path.equals(FAM_21_MISSION_RUNNING))
            return FAM_21_MISSION_RUNNING_SIZE;
        if (path.equals(FAM_21_MISSION_DATE))
            return FAM_21_MISSION_DATE_SIZE;
        if (path.equals(FAM_21_ABOUT_TEMPHIGH))
            return FAM_21_ABOUT_TEMPHIGH_SIZE;
        if (path.equals(FAM_21_OVERTEMP_DATE_ALL))
            return FAM_21_OVERTEMP_DATE_ALL_SIZE;
        if (path.equals(FAM_21_ABOUT_MEASURING))
            return FAM_21_ABOUT_MEASURING_SIZE;
        if (path.equals(FAM_21_CRC8))
            return FAM_21_CRC8_SIZE;
        if (path.equals(FAM_21_OVERTEMP_TEMPERATURE))
            return FAM_21_OVERTEMP_TEMPERATURE_SIZE;
        if (path.equals(FAM_21_OVERTEMP_COUNT_ALL))
            return FAM_21_OVERTEMP_COUNT_ALL_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_ELEMENTS))
            return FAM_21_UNDERTEMP_ELEMENTS_SIZE;
        if (path.equals(FAM_21_OVERTEMP_UDATE_ALL))
            return FAM_21_OVERTEMP_UDATE_ALL_SIZE;
        if (path.equals(FAM_21_ABOUT_VERSION))
            return FAM_21_ABOUT_VERSION_SIZE;
        if (path.equals(FAM_21_MISSION_TEMPLOW))
            return FAM_21_MISSION_TEMPLOW_SIZE;
        if (path.equals(FAM_21_ALARM_SECOND))
            return FAM_21_ALARM_SECOND_SIZE;
        if (path.equals(FAM_21_HISTOGRAM_COUNTS_0))
            return FAM_21_HISTOGRAM_COUNTS_0_SIZE;
        if (path.equals(FAM_21_ALIAS))
            return FAM_21_ALIAS_SIZE;
        if (path.equals(FAM_21_CLOCK_UDATE))
            return FAM_21_CLOCK_UDATE_SIZE;
        if (path.equals(FAM_21_ALARM_MINUTE))
            return FAM_21_ALARM_MINUTE_SIZE;
        if (path.equals(FAM_21_HISTOGRAM_GAP))
            return FAM_21_HISTOGRAM_GAP_SIZE;
        if (path.equals(FAM_21_R_LOCATOR))
            return FAM_21_R_LOCATOR_SIZE;
        if (path.equals(FAM_21_ALARM_HOUR))
            return FAM_21_ALARM_HOUR_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_END_ALL))
            return FAM_21_UNDERTEMP_END_ALL_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_COUNT_ALL))
            return FAM_21_UNDERTEMP_COUNT_ALL_SIZE;
        if (path.equals(FAM_21_HISTOGRAM_TEMPERATURE_0))
            return FAM_21_HISTOGRAM_TEMPERATURE_0_SIZE;
        if (path.equals(FAM_21_PAGES_PAGE_0))
            return FAM_21_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_21_MEMORY))
            return FAM_21_MEMORY_SIZE;
        if (path.equals(FAM_21_SET_ALARM_TRIGGER))
            return FAM_21_SET_ALARM_TRIGGER_SIZE;
        if (path.equals(FAM_21_PAGES_PAGE_ALL))
            return FAM_21_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_21_ADDRESS))
            return FAM_21_ADDRESS_SIZE;
        if (path.equals(FAM_21_LOG_TEMPERATURE_0))
            return FAM_21_LOG_TEMPERATURE_0_SIZE;
        if (path.equals(FAM_21_MISSION_ENABLE))
            return FAM_21_MISSION_ENABLE_SIZE;
        if (path.equals(FAM_21_LOG_UDATE_0))
            return FAM_21_LOG_UDATE_0_SIZE;
        if (path.equals(FAM_21_OVERTEMP_UDATE_0))
            return FAM_21_OVERTEMP_UDATE_0_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_DATE_0))
            return FAM_21_UNDERTEMP_DATE_0_SIZE;
        if (path.equals(FAM_21_LOG_ELEMENTS))
            return FAM_21_LOG_ELEMENTS_SIZE;
        if (path.equals(FAM_21_UNDERTEMP_TEMPERATURE)) {
            return FAM_21_UNDERTEMP_TEMPERATURE_SIZE;
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