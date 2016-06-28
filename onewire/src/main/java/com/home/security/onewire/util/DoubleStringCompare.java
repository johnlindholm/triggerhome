package com.home.security.onewire.util;

public class DoubleStringCompare {
    public static int compare(String doubleStr1, String doubleStr2) {
        doubleStr1 = doubleStr1.trim();
        doubleStr2 = doubleStr2.trim();
        int index;
        int d1;
        int i1;
        if ((index = doubleStr1.indexOf('.')) != -1) {
            i1 = Integer.parseInt(doubleStr1.substring(0, index));
            d1 = Integer.parseInt(doubleStr1.substring(index + 1));
        } else {
            i1 = Integer.parseInt(doubleStr1);
            d1 = 0;
        }
        int i2;
        int d2;
        if ((index = doubleStr2.indexOf('.')) != -1) {
            i2 = Integer.parseInt(doubleStr2.substring(0, index));
            d2 = Integer.parseInt(doubleStr2.substring(index + 1));
        } else {
            i2 = Integer.parseInt(doubleStr2);
            d2 = 0;
        }
        if (i1 > i2) {
            return 1;
        }
        if (i2 > i1) {
            return -1;
        }
        if (i1 == i2) {
            if (d1 > d2) {
                return 1;
            }
            if (d2 > d1) {
                return -1;
            }
        }
        return 0;
    }
}