package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;
import com.home.security.onewire.util.DateUtils;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class OneWireContainer04 extends OneWireDevice
        implements OneWireClockContainer {
    private static String FAM_04_R_ADDRESS = "r_address";
    private static String FAM_04_TRIGGER_DATE = "trigger/date";
    private static String FAM_04_TYPE = "type";
    private static String FAM_04_DATE = "date";
    private static String FAM_04_RUNNING = "running";
    private static String FAM_04_INTERVAL_DATE = "interval/date";
    private static String FAM_04_ID = "id";
    private static String FAM_04_TRIGGER_INTERVAL_UDATE = "trigger/interval_udate";
    private static String FAM_04_FAMILY = "family";
    private static String FAM_04_READONLY_CLOCK = "readonly/clock";
    private static String FAM_04_CRC8 = "crc8";
    private static String FAM_04_LOCATOR = "locator";
    private static String FAM_04_CYCLE = "cycle";
    private static String FAM_04_TRIGGER_CYCLE = "trigger/cycle";
    private static String FAM_04_R_ID = "r_id";
    private static String FAM_04_ALIAS = "alias";
    private static String FAM_04_R_LOCATOR = "r_locator";
    private static String FAM_04_READONLY_INTERVAL = "readonly/interval";
    private static String FAM_04_MEMORY = "memory";
    private static String FAM_04_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_04_READONLY_MEMORY = "readonly/memory";
    private static String FAM_04_ALARM = "alarm";
    private static String FAM_04_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_04_START = "start";
    private static String FAM_04_ADDRESS = "address";
    private static String FAM_04_SET_ALARM = "set_alarm";
    private static String FAM_04_READONLY_CYCLE = "readonly/cycle";
    private static String FAM_04_AUTO = "auto";
    private static String FAM_04_TRIGGER_INTERVAL_DATE = "trigger/interval_date";
    private static String FAM_04_UDATE = "udate";
    private static String FAM_04_DELAY = "delay";
    private static String FAM_04_TRIGGER_UDATE = "trigger/udate";
    private static String FAM_04_INTERVAL_UDATE = "interval/udate";
    private static int FAM_04_R_ADDRESS_SIZE = 16;
    private static int FAM_04_TRIGGER_DATE_SIZE = 24;
    private static int FAM_04_TYPE_SIZE = 32;
    private static int FAM_04_DATE_SIZE = 24;
    private static int FAM_04_RUNNING_SIZE = 1;
    private static int FAM_04_INTERVAL_DATE_SIZE = 24;
    private static int FAM_04_ID_SIZE = 12;
    private static int FAM_04_TRIGGER_INTERVAL_UDATE_SIZE = 12;
    private static int FAM_04_FAMILY_SIZE = 2;
    private static int FAM_04_READONLY_CLOCK_SIZE = 1;
    private static int FAM_04_CRC8_SIZE = 2;
    private static int FAM_04_LOCATOR_SIZE = 16;
    private static int FAM_04_CYCLE_SIZE = 12;
    private static int FAM_04_TRIGGER_CYCLE_SIZE = 12;
    private static int FAM_04_R_ID_SIZE = 12;
    private static int FAM_04_ALIAS_SIZE = 256;
    private static int FAM_04_R_LOCATOR_SIZE = 16;
    private static int FAM_04_READONLY_INTERVAL_SIZE = 1;
    private static int FAM_04_MEMORY_SIZE = 512;
    private static int FAM_04_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_04_READONLY_MEMORY_SIZE = 1;
    private static int FAM_04_ALARM_SIZE = 12;
    private static int FAM_04_PAGES_PAGE_ALL_SIZE = 512;
    private static int FAM_04_START_SIZE = 1;
    private static int FAM_04_ADDRESS_SIZE = 16;
    private static int FAM_04_SET_ALARM_SIZE = 12;
    private static int FAM_04_READONLY_CYCLE_SIZE = 1;
    private static int FAM_04_AUTO_SIZE = 1;
    private static int FAM_04_TRIGGER_INTERVAL_DATE_SIZE = 24;
    private static int FAM_04_UDATE_SIZE = 12;
    private static int FAM_04_DELAY_SIZE = 1;
    private static int FAM_04_TRIGGER_UDATE_SIZE = 12;
    private static int FAM_04_INTERVAL_UDATE_SIZE = 12;

    public OneWireContainer04() {
    }

    public OneWireContainer04(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_04_R_ADDRESS))
            return FAM_04_R_ADDRESS_SIZE;
        if (path.equals(FAM_04_TRIGGER_DATE))
            return FAM_04_TRIGGER_DATE_SIZE;
        if (path.equals(FAM_04_TYPE))
            return FAM_04_TYPE_SIZE;
        if (path.equals(FAM_04_DATE))
            return FAM_04_DATE_SIZE;
        if (path.equals(FAM_04_RUNNING))
            return FAM_04_RUNNING_SIZE;
        if (path.equals(FAM_04_INTERVAL_DATE))
            return FAM_04_INTERVAL_DATE_SIZE;
        if (path.equals(FAM_04_ID))
            return FAM_04_ID_SIZE;
        if (path.equals(FAM_04_TRIGGER_INTERVAL_UDATE))
            return FAM_04_TRIGGER_INTERVAL_UDATE_SIZE;
        if (path.equals(FAM_04_FAMILY))
            return FAM_04_FAMILY_SIZE;
        if (path.equals(FAM_04_READONLY_CLOCK))
            return FAM_04_READONLY_CLOCK_SIZE;
        if (path.equals(FAM_04_CRC8))
            return FAM_04_CRC8_SIZE;
        if (path.equals(FAM_04_LOCATOR))
            return FAM_04_LOCATOR_SIZE;
        if (path.equals(FAM_04_CYCLE))
            return FAM_04_CYCLE_SIZE;
        if (path.equals(FAM_04_TRIGGER_CYCLE))
            return FAM_04_TRIGGER_CYCLE_SIZE;
        if (path.equals(FAM_04_R_ID))
            return FAM_04_R_ID_SIZE;
        if (path.equals(FAM_04_ALIAS))
            return FAM_04_ALIAS_SIZE;
        if (path.equals(FAM_04_R_LOCATOR))
            return FAM_04_R_LOCATOR_SIZE;
        if (path.equals(FAM_04_READONLY_INTERVAL))
            return FAM_04_READONLY_INTERVAL_SIZE;
        if (path.equals(FAM_04_MEMORY))
            return FAM_04_MEMORY_SIZE;
        if (path.equals(FAM_04_PAGES_PAGE_0))
            return FAM_04_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_04_READONLY_MEMORY))
            return FAM_04_READONLY_MEMORY_SIZE;
        if (path.equals(FAM_04_ALARM))
            return FAM_04_ALARM_SIZE;
        if (path.equals(FAM_04_PAGES_PAGE_ALL))
            return FAM_04_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_04_START))
            return FAM_04_START_SIZE;
        if (path.equals(FAM_04_ADDRESS))
            return FAM_04_ADDRESS_SIZE;
        if (path.equals(FAM_04_SET_ALARM))
            return FAM_04_SET_ALARM_SIZE;
        if (path.equals(FAM_04_READONLY_CYCLE))
            return FAM_04_READONLY_CYCLE_SIZE;
        if (path.equals(FAM_04_AUTO))
            return FAM_04_AUTO_SIZE;
        if (path.equals(FAM_04_TRIGGER_INTERVAL_DATE))
            return FAM_04_TRIGGER_INTERVAL_DATE_SIZE;
        if (path.equals(FAM_04_UDATE))
            return FAM_04_UDATE_SIZE;
        if (path.equals(FAM_04_DELAY))
            return FAM_04_DELAY_SIZE;
        if (path.equals(FAM_04_TRIGGER_UDATE))
            return FAM_04_TRIGGER_UDATE_SIZE;
        if (path.equals(FAM_04_INTERVAL_UDATE)) {
            return FAM_04_INTERVAL_UDATE_SIZE;
        }
        return -1;
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