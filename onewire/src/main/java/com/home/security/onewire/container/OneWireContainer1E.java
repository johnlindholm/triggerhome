package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;
import com.home.security.onewire.util.DateUtils;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class OneWireContainer1E extends OneWireDevice
        implements OneWireTemperatureContainer, OneWireClockContainer {
    private static String FAM_1E_ENDCHARGE_DATE = "endcharge/date";
    private static String FAM_1E_R_ADDRESS = "r_address";
    private static String FAM_1E_CA = "CA";
    private static String FAM_1E_DATE = "date";
    private static String FAM_1E_TYPE = "type";
    private static String FAM_1E_TEMPERATURE = "temperature";
    private static String FAM_1E_ID = "id";
    private static String FAM_1E_VAD = "VAD";
    private static String FAM_1E_FAMILY = "family";
    private static String FAM_1E_CRC8 = "crc8";
    private static String FAM_1E_VDD = "VDD";
    private static String FAM_1E_DISCONNECT_UDATE = "disconnect/udate";
    private static String FAM_1E_DISCONNECT_DATE = "disconnect/date";
    private static String FAM_1E_LOCATOR = "locator";
    private static String FAM_1E_R_ID = "r_id";
    private static String FAM_1E_ALIAS = "alias";
    private static String FAM_1E_IAD = "IAD";
    private static String FAM_1E_R_LOCATOR = "r_locator";
    private static String FAM_1E_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_1E_VIS = "vis";
    private static String FAM_1E_ENDCHARGE_UDATE = "endcharge/udate";
    private static String FAM_1E_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_1E_ADDRESS = "address";
    private static String FAM_1E_EE = "EE";
    private static String FAM_1E_UDATE = "udate";
    private static int FAM_1E_ENDCHARGE_DATE_SIZE = 24;
    private static int FAM_1E_R_ADDRESS_SIZE = 16;
    private static int FAM_1E_CA_SIZE = 1;
    private static int FAM_1E_DATE_SIZE = 24;
    private static int FAM_1E_TYPE_SIZE = 32;
    private static int FAM_1E_TEMPERATURE_SIZE = 12;
    private static int FAM_1E_ID_SIZE = 12;
    private static int FAM_1E_VAD_SIZE = 12;
    private static int FAM_1E_FAMILY_SIZE = 2;
    private static int FAM_1E_CRC8_SIZE = 2;
    private static int FAM_1E_VDD_SIZE = 12;
    private static int FAM_1E_DISCONNECT_UDATE_SIZE = 12;
    private static int FAM_1E_DISCONNECT_DATE_SIZE = 24;
    private static int FAM_1E_LOCATOR_SIZE = 16;
    private static int FAM_1E_R_ID_SIZE = 12;
    private static int FAM_1E_ALIAS_SIZE = 256;
    private static int FAM_1E_IAD_SIZE = 1;
    private static int FAM_1E_R_LOCATOR_SIZE = 16;
    private static int FAM_1E_PAGES_PAGE_0_SIZE = 8;
    private static int FAM_1E_VIS_SIZE = 12;
    private static int FAM_1E_ENDCHARGE_UDATE_SIZE = 12;
    private static int FAM_1E_PAGES_PAGE_ALL_SIZE = 64;
    private static int FAM_1E_ADDRESS_SIZE = 16;
    private static int FAM_1E_EE_SIZE = 1;
    private static int FAM_1E_UDATE_SIZE = 12;

    public OneWireContainer1E() {
    }

    public OneWireContainer1E(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_1E_ENDCHARGE_DATE))
            return FAM_1E_ENDCHARGE_DATE_SIZE;
        if (path.equals(FAM_1E_R_ADDRESS))
            return FAM_1E_R_ADDRESS_SIZE;
        if (path.equals(FAM_1E_CA))
            return FAM_1E_CA_SIZE;
        if (path.equals(FAM_1E_DATE))
            return FAM_1E_DATE_SIZE;
        if (path.equals(FAM_1E_TYPE))
            return FAM_1E_TYPE_SIZE;
        if (path.equals(FAM_1E_TEMPERATURE))
            return FAM_1E_TEMPERATURE_SIZE;
        if (path.equals(FAM_1E_ID))
            return FAM_1E_ID_SIZE;
        if (path.equals(FAM_1E_VAD))
            return FAM_1E_VAD_SIZE;
        if (path.equals(FAM_1E_FAMILY))
            return FAM_1E_FAMILY_SIZE;
        if (path.equals(FAM_1E_CRC8))
            return FAM_1E_CRC8_SIZE;
        if (path.equals(FAM_1E_VDD))
            return FAM_1E_VDD_SIZE;
        if (path.equals(FAM_1E_DISCONNECT_UDATE))
            return FAM_1E_DISCONNECT_UDATE_SIZE;
        if (path.equals(FAM_1E_DISCONNECT_DATE))
            return FAM_1E_DISCONNECT_DATE_SIZE;
        if (path.equals(FAM_1E_LOCATOR))
            return FAM_1E_LOCATOR_SIZE;
        if (path.equals(FAM_1E_R_ID))
            return FAM_1E_R_ID_SIZE;
        if (path.equals(FAM_1E_ALIAS))
            return FAM_1E_ALIAS_SIZE;
        if (path.equals(FAM_1E_IAD))
            return FAM_1E_IAD_SIZE;
        if (path.equals(FAM_1E_R_LOCATOR))
            return FAM_1E_R_LOCATOR_SIZE;
        if (path.equals(FAM_1E_PAGES_PAGE_0))
            return FAM_1E_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_1E_VIS))
            return FAM_1E_VIS_SIZE;
        if (path.equals(FAM_1E_ENDCHARGE_UDATE))
            return FAM_1E_ENDCHARGE_UDATE_SIZE;
        if (path.equals(FAM_1E_PAGES_PAGE_ALL))
            return FAM_1E_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_1E_ADDRESS))
            return FAM_1E_ADDRESS_SIZE;
        if (path.equals(FAM_1E_EE))
            return FAM_1E_EE_SIZE;
        if (path.equals(FAM_1E_UDATE)) {
            return FAM_1E_UDATE_SIZE;
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