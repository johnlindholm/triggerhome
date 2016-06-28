package com.home.security.onewire.util;

public class AddressUtils {
    public static int LENGTH_OF_ID = 12;

    public static int LENGTH_OF_FAMILY = 2;

    public static String idToReverseId(String id) {
        if (id.length() != 12) {
            return null;
        }
        String s1 = id.substring(0, 2);
        String s2 = id.substring(2, 4);
        String s3 = id.substring(4, 6);
        String s4 = id.substring(6, 8);
        String s5 = id.substring(8, 10);
        String s6 = id.substring(10, 12);
        return s6 + s5 + s4 + s3 + s2 + s1;
    }
}