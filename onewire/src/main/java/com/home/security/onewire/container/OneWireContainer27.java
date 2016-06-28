package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;
import com.home.security.onewire.util.DateUtils;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

public class OneWireContainer27 extends OneWireDevice
        implements OneWireClockContainer {
    private static String FAM_27_LOCATOR = "locator";
    private static String FAM_27_INTERVAL = "interval";
    private static String FAM_27_R_ID = "r_id";
    private static String FAM_27_ALIAS = "alias";
    private static String FAM_27_R_ADDRESS = "r_address";
    private static String FAM_27_ENABLE = "enable";
    private static String FAM_27_R_LOCATOR = "r_locator";
    private static String FAM_27_TYPE = "type";
    private static String FAM_27_DATE = "date";
    private static String FAM_27_RUNNING = "running";
    private static String FAM_27_ID = "id";
    private static String FAM_27_ADDRESS = "address";
    private static String FAM_27_FAMILY = "family";
    private static String FAM_27_ITIME = "itime";
    private static String FAM_27_CRC8 = "crc8";
    private static String FAM_27_UDATE = "udate";
    private static int FAM_27_LOCATOR_SIZE = 16;
    private static int FAM_27_INTERVAL_SIZE = 12;
    private static int FAM_27_R_ID_SIZE = 12;
    private static int FAM_27_ALIAS_SIZE = 256;
    private static int FAM_27_R_ADDRESS_SIZE = 16;
    private static int FAM_27_ENABLE_SIZE = 1;
    private static int FAM_27_R_LOCATOR_SIZE = 16;
    private static int FAM_27_TYPE_SIZE = 32;
    private static int FAM_27_DATE_SIZE = 24;
    private static int FAM_27_RUNNING_SIZE = 1;
    private static int FAM_27_ID_SIZE = 12;
    private static int FAM_27_ADDRESS_SIZE = 16;
    private static int FAM_27_FAMILY_SIZE = 2;
    private static int FAM_27_ITIME_SIZE = 12;
    private static int FAM_27_CRC8_SIZE = 2;
    private static int FAM_27_UDATE_SIZE = 12;

    public OneWireContainer27() {
    }

    public OneWireContainer27(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_27_LOCATOR))
            return FAM_27_LOCATOR_SIZE;
        if (path.equals(FAM_27_INTERVAL))
            return FAM_27_INTERVAL_SIZE;
        if (path.equals(FAM_27_R_ID))
            return FAM_27_R_ID_SIZE;
        if (path.equals(FAM_27_ALIAS))
            return FAM_27_ALIAS_SIZE;
        if (path.equals(FAM_27_R_ADDRESS))
            return FAM_27_R_ADDRESS_SIZE;
        if (path.equals(FAM_27_ENABLE))
            return FAM_27_ENABLE_SIZE;
        if (path.equals(FAM_27_R_LOCATOR))
            return FAM_27_R_LOCATOR_SIZE;
        if (path.equals(FAM_27_TYPE))
            return FAM_27_TYPE_SIZE;
        if (path.equals(FAM_27_DATE))
            return FAM_27_DATE_SIZE;
        if (path.equals(FAM_27_RUNNING))
            return FAM_27_RUNNING_SIZE;
        if (path.equals(FAM_27_ID))
            return FAM_27_ID_SIZE;
        if (path.equals(FAM_27_ADDRESS))
            return FAM_27_ADDRESS_SIZE;
        if (path.equals(FAM_27_FAMILY))
            return FAM_27_FAMILY_SIZE;
        if (path.equals(FAM_27_ITIME))
            return FAM_27_ITIME_SIZE;
        if (path.equals(FAM_27_CRC8))
            return FAM_27_CRC8_SIZE;
        if (path.equals(FAM_27_UDATE)) {
            return FAM_27_UDATE_SIZE;
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