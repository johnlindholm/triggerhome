package com.home.security.onewire.util;

public class DateUtils {
    public static int dayStringToCalendarInt(String day) {
        day = day.toUpperCase();
        if ((day.equals("MON")) || (day.equals("MONDAY"))) {
            return 2;
        }
        if ((day.equals("TUE")) || (day.equals("TUESDAY"))) {
            return 3;
        }
        if ((day.equals("WED")) || (day.equals("WEDNESDAY"))) {
            return 4;
        }
        if ((day.equals("THU")) || (day.equals("THURSDAY"))) {
            return 5;
        }
        if ((day.equals("FRI")) || (day.equals("FRIDAY"))) {
            return 6;
        }
        if ((day.equals("SAT")) || (day.equals("SATURDAY"))) {
            return 7;
        }
        if ((day.equals("SUN")) || (day.equals("SUNDAY"))) {
            return 1;
        }
        return -1;
    }

    public static int monthStringToCalendarInt(String month) {
        month = month.toUpperCase();
        if ((month.equals("JAN")) || (month.equals(Integer.valueOf(0)))) {
            return 0;
        }
        if ((month.equals("FEB")) || (month.equals(Integer.valueOf(1)))) {
            return 1;
        }
        if ((month.equals("MAR")) || (month.equals(Integer.valueOf(2)))) {
            return 2;
        }
        if ((month.equals("APR")) || (month.equals(Integer.valueOf(3)))) {
            return 3;
        }
        if ((month.equals("MAY")) || (month.equals(Integer.valueOf(4)))) {
            return 4;
        }
        if ((month.equals("JUN")) || (month.equals(Integer.valueOf(5)))) {
            return 5;
        }
        if ((month.equals("JUL")) || (month.equals(Integer.valueOf(6)))) {
            return 6;
        }
        if ((month.equals("AUG")) || (month.equals(Integer.valueOf(7)))) {
            return 7;
        }
        if ((month.equals("SEP")) || (month.equals(Integer.valueOf(8)))) {
            return 8;
        }
        if ((month.equals("OCT")) || (month.equals(Integer.valueOf(9)))) {
            return 9;
        }
        if ((month.equals("NOV")) || (month.equals(Integer.valueOf(10)))) {
            return 10;
        }
        if ((month.equals("DEC")) || (month.equals(Integer.valueOf(11)))) {
            return 11;
        }
        return -1;
    }
}