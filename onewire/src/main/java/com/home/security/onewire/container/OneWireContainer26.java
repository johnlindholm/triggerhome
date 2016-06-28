package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;
import com.home.security.onewire.util.DateUtils;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class OneWireContainer26 extends OneWireDevice
        implements OneWireTemperatureContainer, OneWireHumidityContainer, OneWireClockContainer {
    private static String FAM_26_R_ADDRESS = "r_address";
    private static String FAM_26_ENDCHARGE_DATE = "endcharge/date";
    private static String FAM_26_CA = "CA";
    private static String FAM_26_TYPE = "type";
    private static String FAM_26_DATE = "date";
    private static String FAM_26_TEMPERATURE = "temperature";
    private static String FAM_26_B1_R1_A_GAIN = "B1-R1-A/gain";
    private static String FAM_26_ID = "id";
    private static String FAM_26_MULTISENSOR_TYPE = "MultiSensor/type";
    private static String FAM_26_VAD = "VAD";
    private static String FAM_26_FAMILY = "family";
    private static String FAM_26_CRC8 = "crc8";
    private static String FAM_26_S3_R1_A_CURRENT = "S3-R1-A/current";
    private static String FAM_26_OFFSET = "offset";
    private static String FAM_26_S3_R1_A_ILLUMINANCE = "S3-R1-A/illuminance";
    private static String FAM_26_S3_R1_A_GAIN = "S3-R1-A/gain";
    private static String FAM_26_VDD = "VDD";
    private static String FAM_26_LOCATOR = "locator";
    private static String FAM_26_DISCONNECT_DATE = "disconnect/date";
    private static String FAM_26_DISCONNECT_UDATE = "disconnect/udate";
    private static String FAM_26_R_ID = "r_id";
    private static String FAM_26_ALIAS = "alias";
    private static String FAM_26_HIH3600_HUMIDITY = "HIH3600/humidity";
    private static String FAM_26_IAD = "IAD";
    private static String FAM_26_R_LOCATOR = "r_locator";
    private static String FAM_26_HIH4000_HUMIDITY = "HIH4000/humidity";
    private static String FAM_26_B1_R1_A_OFFSET = "B1-R1-A/offset";
    private static String FAM_26_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_26_HTM1735_HUMIDITY = "HTM1735/humidity";
    private static String FAM_26_VIS = "vis";
    private static String FAM_26_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_26_B1_R1_A_PRESSURE = "B1-R1-A/pressure";
    private static String FAM_26_ENDCHARGE_UDATE = "endcharge/udate";
    private static String FAM_26_HUMIDITY = "humidity";
    private static String FAM_26_ADDRESS = "address";
    private static String FAM_26_UDATE = "udate";
    private static String FAM_26_EE = "EE";
    private static int FAM_26_R_ADDRESS_SIZE = 16;
    private static int FAM_26_ENDCHARGE_DATE_SIZE = 24;
    private static int FAM_26_CA_SIZE = 1;
    private static int FAM_26_TYPE_SIZE = 32;
    private static int FAM_26_DATE_SIZE = 24;
    private static int FAM_26_TEMPERATURE_SIZE = 12;
    private static int FAM_26_B1_R1_A_GAIN_SIZE = 12;
    private static int FAM_26_ID_SIZE = 12;
    private static int FAM_26_MULTISENSOR_TYPE_SIZE = 12;
    private static int FAM_26_VAD_SIZE = 12;
    private static int FAM_26_FAMILY_SIZE = 2;
    private static int FAM_26_CRC8_SIZE = 2;
    private static int FAM_26_S3_R1_A_CURRENT_SIZE = 12;
    private static int FAM_26_OFFSET_SIZE = 12;
    private static int FAM_26_S3_R1_A_ILLUMINANCE_SIZE = 12;
    private static int FAM_26_S3_R1_A_GAIN_SIZE = 12;
    private static int FAM_26_VDD_SIZE = 12;
    private static int FAM_26_LOCATOR_SIZE = 16;
    private static int FAM_26_DISCONNECT_DATE_SIZE = 24;
    private static int FAM_26_DISCONNECT_UDATE_SIZE = 12;
    private static int FAM_26_R_ID_SIZE = 12;
    private static int FAM_26_ALIAS_SIZE = 256;
    private static int FAM_26_HIH3600_HUMIDITY_SIZE = 12;
    private static int FAM_26_IAD_SIZE = 1;
    private static int FAM_26_R_LOCATOR_SIZE = 16;
    private static int FAM_26_HIH4000_HUMIDITY_SIZE = 12;
    private static int FAM_26_B1_R1_A_OFFSET_SIZE = 12;
    private static int FAM_26_PAGES_PAGE_0_SIZE = 8;
    private static int FAM_26_HTM1735_HUMIDITY_SIZE = 12;
    private static int FAM_26_VIS_SIZE = 12;
    private static int FAM_26_PAGES_PAGE_ALL_SIZE = 64;
    private static int FAM_26_B1_R1_A_PRESSURE_SIZE = 12;
    private static int FAM_26_ENDCHARGE_UDATE_SIZE = 12;
    private static int FAM_26_HUMIDITY_SIZE = 12;
    private static int FAM_26_ADDRESS_SIZE = 16;
    private static int FAM_26_UDATE_SIZE = 12;
    private static int FAM_26_EE_SIZE = 1;

    public OneWireContainer26() {
    }

    public OneWireContainer26(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_26_R_ADDRESS))
            return FAM_26_R_ADDRESS_SIZE;
        if (path.equals(FAM_26_ENDCHARGE_DATE))
            return FAM_26_ENDCHARGE_DATE_SIZE;
        if (path.equals(FAM_26_CA))
            return FAM_26_CA_SIZE;
        if (path.equals(FAM_26_TYPE))
            return FAM_26_TYPE_SIZE;
        if (path.equals(FAM_26_DATE))
            return FAM_26_DATE_SIZE;
        if (path.equals(FAM_26_TEMPERATURE))
            return FAM_26_TEMPERATURE_SIZE;
        if (path.equals(FAM_26_B1_R1_A_GAIN))
            return FAM_26_B1_R1_A_GAIN_SIZE;
        if (path.equals(FAM_26_ID))
            return FAM_26_ID_SIZE;
        if (path.equals(FAM_26_MULTISENSOR_TYPE))
            return FAM_26_MULTISENSOR_TYPE_SIZE;
        if (path.equals(FAM_26_VAD))
            return FAM_26_VAD_SIZE;
        if (path.equals(FAM_26_FAMILY))
            return FAM_26_FAMILY_SIZE;
        if (path.equals(FAM_26_CRC8))
            return FAM_26_CRC8_SIZE;
        if (path.equals(FAM_26_S3_R1_A_CURRENT))
            return FAM_26_S3_R1_A_CURRENT_SIZE;
        if (path.equals(FAM_26_OFFSET))
            return FAM_26_OFFSET_SIZE;
        if (path.equals(FAM_26_S3_R1_A_ILLUMINANCE))
            return FAM_26_S3_R1_A_ILLUMINANCE_SIZE;
        if (path.equals(FAM_26_S3_R1_A_GAIN))
            return FAM_26_S3_R1_A_GAIN_SIZE;
        if (path.equals(FAM_26_VDD))
            return FAM_26_VDD_SIZE;
        if (path.equals(FAM_26_LOCATOR))
            return FAM_26_LOCATOR_SIZE;
        if (path.equals(FAM_26_DISCONNECT_DATE))
            return FAM_26_DISCONNECT_DATE_SIZE;
        if (path.equals(FAM_26_DISCONNECT_UDATE))
            return FAM_26_DISCONNECT_UDATE_SIZE;
        if (path.equals(FAM_26_R_ID))
            return FAM_26_R_ID_SIZE;
        if (path.equals(FAM_26_ALIAS))
            return FAM_26_ALIAS_SIZE;
        if (path.equals(FAM_26_HIH3600_HUMIDITY))
            return FAM_26_HIH3600_HUMIDITY_SIZE;
        if (path.equals(FAM_26_IAD))
            return FAM_26_IAD_SIZE;
        if (path.equals(FAM_26_R_LOCATOR))
            return FAM_26_R_LOCATOR_SIZE;
        if (path.equals(FAM_26_HIH4000_HUMIDITY))
            return FAM_26_HIH4000_HUMIDITY_SIZE;
        if (path.equals(FAM_26_B1_R1_A_OFFSET))
            return FAM_26_B1_R1_A_OFFSET_SIZE;
        if (path.equals(FAM_26_PAGES_PAGE_0))
            return FAM_26_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_26_HTM1735_HUMIDITY))
            return FAM_26_HTM1735_HUMIDITY_SIZE;
        if (path.equals(FAM_26_VIS))
            return FAM_26_VIS_SIZE;
        if (path.equals(FAM_26_PAGES_PAGE_ALL))
            return FAM_26_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_26_B1_R1_A_PRESSURE))
            return FAM_26_B1_R1_A_PRESSURE_SIZE;
        if (path.equals(FAM_26_ENDCHARGE_UDATE))
            return FAM_26_ENDCHARGE_UDATE_SIZE;
        if (path.equals(FAM_26_HUMIDITY))
            return FAM_26_HUMIDITY_SIZE;
        if (path.equals(FAM_26_ADDRESS))
            return FAM_26_ADDRESS_SIZE;
        if (path.equals(FAM_26_UDATE))
            return FAM_26_UDATE_SIZE;
        if (path.equals(FAM_26_EE)) {
            return FAM_26_EE_SIZE;
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

    public Date getDate()
            throws IOException {
        String response = readValue("date", true);
        if (response == null) return null;
        String[] ss = response.split(" ");
        if ((ss == null) || (ss.length <= 0) || (ss.length != 6)) return null;
        int year = Integer.parseInt(ss[5]);
        int month = DateUtils.monthStringToCalendarInt(ss[1]);
        int date = Integer.parseInt(ss[3]);
        ss = ss[4].split(":");
        int hour = Integer.parseInt(ss[0]);
        int minute = Integer.parseInt(ss[1]);
        int second = Integer.parseInt(ss[2]);
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.set(year, month, date, hour, minute, second);
        return calendar.getTime();
    }
}