package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer29 extends OneWireDevice
        implements OneWireSwitchContainer {
    private static String FAM_29_LCD_M_MESSAGE = "LCD_M/message";
    private static String FAM_29_R_ADDRESS = "r_address";
    private static String FAM_29_PIO_0 = "PIO.0";
    private static String FAM_29_LCD_H_SCREEN = "LCD_H/screen";
    private static String FAM_29_POR = "por";
    private static String FAM_29_LCD_M_SCREEN = "LCD_M/screen";
    private static String FAM_29_LCD_M_HOME = "LCD_M/home";
    private static String FAM_29_TYPE = "type";
    private static String FAM_29_SENSED_0 = "sensed.0";
    private static String FAM_29_LCD_H_SCREENYX = "LCD_H/screenyx";
    private static String FAM_29_ID = "id";
    private static String FAM_29_LATCH_0 = "latch.0";
    private static String FAM_29_LATCH_ALL = "latch.ALL";
    private static String FAM_29_LCD_H_ONOFF = "LCD_H/onoff";
    private static String FAM_29_FAMILY = "family";
    private static String FAM_29_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_29_CRC8 = "crc8";
    private static String FAM_29_POWER = "power";
    private static String FAM_29_LOCATOR = "locator";
    private static String FAM_29_R_ID = "r_id";
    private static String FAM_29_PIO_BYTE = "PIO.BYTE";
    private static String FAM_29_ALIAS = "alias";
    private static String FAM_29_PIO_ALL = "PIO.ALL";
    private static String FAM_29_LATCH_BYTE = "latch.BYTE";
    private static String FAM_29_LCD_M_CLEAR = "LCD_M/clear";
    private static String FAM_29_R_LOCATOR = "r_locator";
    private static String FAM_29_LCD_H_MESSAGE = "LCD_H/message";
    private static String FAM_29_LCD_H_HOME = "LCD_H/home";
    private static String FAM_29_SENSED_ALL = "sensed.ALL";
    private static String FAM_29_ADDRESS = "address";
    private static String FAM_29_SET_ALARM = "set_alarm";
    private static String FAM_29_LCD_H_CLEAR = "LCD_H/clear";
    private static String FAM_29_STROBE = "strobe";
    private static int FAM_29_LCD_M_MESSAGE_SIZE = 128;
    private static int FAM_29_R_ADDRESS_SIZE = 16;
    private static int FAM_29_PIO_0_SIZE = 1;
    private static int FAM_29_LCD_H_SCREEN_SIZE = 128;
    private static int FAM_29_POR_SIZE = 1;
    private static int FAM_29_LCD_M_SCREEN_SIZE = 128;
    private static int FAM_29_LCD_M_HOME_SIZE = 1;
    private static int FAM_29_TYPE_SIZE = 32;
    private static int FAM_29_SENSED_0_SIZE = 1;
    private static int FAM_29_LCD_H_SCREENYX_SIZE = 128;
    private static int FAM_29_ID_SIZE = 12;
    private static int FAM_29_LATCH_0_SIZE = 1;
    private static int FAM_29_LATCH_ALL_SIZE = 15;
    private static int FAM_29_LCD_H_ONOFF_SIZE = 12;
    private static int FAM_29_FAMILY_SIZE = 2;
    private static int FAM_29_SENSED_BYTE_SIZE = 12;
    private static int FAM_29_CRC8_SIZE = 2;
    private static int FAM_29_POWER_SIZE = 1;
    private static int FAM_29_LOCATOR_SIZE = 16;
    private static int FAM_29_R_ID_SIZE = 12;
    private static int FAM_29_PIO_BYTE_SIZE = 12;
    private static int FAM_29_ALIAS_SIZE = 256;
    private static int FAM_29_PIO_ALL_SIZE = 15;
    private static int FAM_29_LATCH_BYTE_SIZE = 12;
    private static int FAM_29_LCD_M_CLEAR_SIZE = 1;
    private static int FAM_29_R_LOCATOR_SIZE = 16;
    private static int FAM_29_LCD_H_MESSAGE_SIZE = 128;
    private static int FAM_29_LCD_H_HOME_SIZE = 1;
    private static int FAM_29_SENSED_ALL_SIZE = 15;
    private static int FAM_29_ADDRESS_SIZE = 16;
    private static int FAM_29_SET_ALARM_SIZE = 12;
    private static int FAM_29_LCD_H_CLEAR_SIZE = 1;
    private static int FAM_29_STROBE_SIZE = 1;

    public OneWireContainer29() {
    }

    public OneWireContainer29(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_29_LCD_M_MESSAGE))
            return FAM_29_LCD_M_MESSAGE_SIZE;
        if (path.equals(FAM_29_R_ADDRESS))
            return FAM_29_R_ADDRESS_SIZE;
        if (path.equals(FAM_29_PIO_0))
            return FAM_29_PIO_0_SIZE;
        if (path.equals(FAM_29_LCD_H_SCREEN))
            return FAM_29_LCD_H_SCREEN_SIZE;
        if (path.equals(FAM_29_POR))
            return FAM_29_POR_SIZE;
        if (path.equals(FAM_29_LCD_M_SCREEN))
            return FAM_29_LCD_M_SCREEN_SIZE;
        if (path.equals(FAM_29_LCD_M_HOME))
            return FAM_29_LCD_M_HOME_SIZE;
        if (path.equals(FAM_29_TYPE))
            return FAM_29_TYPE_SIZE;
        if (path.equals(FAM_29_SENSED_0))
            return FAM_29_SENSED_0_SIZE;
        if (path.equals(FAM_29_LCD_H_SCREENYX))
            return FAM_29_LCD_H_SCREENYX_SIZE;
        if (path.equals(FAM_29_ID))
            return FAM_29_ID_SIZE;
        if (path.equals(FAM_29_LATCH_0))
            return FAM_29_LATCH_0_SIZE;
        if (path.equals(FAM_29_LATCH_ALL))
            return FAM_29_LATCH_ALL_SIZE;
        if (path.equals(FAM_29_LCD_H_ONOFF))
            return FAM_29_LCD_H_ONOFF_SIZE;
        if (path.equals(FAM_29_FAMILY))
            return FAM_29_FAMILY_SIZE;
        if (path.equals(FAM_29_SENSED_BYTE))
            return FAM_29_SENSED_BYTE_SIZE;
        if (path.equals(FAM_29_CRC8))
            return FAM_29_CRC8_SIZE;
        if (path.equals(FAM_29_POWER))
            return FAM_29_POWER_SIZE;
        if (path.equals(FAM_29_LOCATOR))
            return FAM_29_LOCATOR_SIZE;
        if (path.equals(FAM_29_R_ID))
            return FAM_29_R_ID_SIZE;
        if (path.equals(FAM_29_PIO_BYTE))
            return FAM_29_PIO_BYTE_SIZE;
        if (path.equals(FAM_29_ALIAS))
            return FAM_29_ALIAS_SIZE;
        if (path.equals(FAM_29_PIO_ALL))
            return FAM_29_PIO_ALL_SIZE;
        if (path.equals(FAM_29_LATCH_BYTE))
            return FAM_29_LATCH_BYTE_SIZE;
        if (path.equals(FAM_29_LCD_M_CLEAR))
            return FAM_29_LCD_M_CLEAR_SIZE;
        if (path.equals(FAM_29_R_LOCATOR))
            return FAM_29_R_LOCATOR_SIZE;
        if (path.equals(FAM_29_LCD_H_MESSAGE))
            return FAM_29_LCD_H_MESSAGE_SIZE;
        if (path.equals(FAM_29_LCD_H_HOME))
            return FAM_29_LCD_H_HOME_SIZE;
        if (path.equals(FAM_29_SENSED_ALL))
            return FAM_29_SENSED_ALL_SIZE;
        if (path.equals(FAM_29_ADDRESS))
            return FAM_29_ADDRESS_SIZE;
        if (path.equals(FAM_29_SET_ALARM))
            return FAM_29_SET_ALARM_SIZE;
        if (path.equals(FAM_29_LCD_H_CLEAR))
            return FAM_29_LCD_H_CLEAR_SIZE;
        if (path.equals(FAM_29_STROBE)) {
            return FAM_29_STROBE_SIZE;
        }
        return -1;
    }

    public boolean isOn()
            throws IOException {
        String response = readValue("sensed.BYTE", true);
        if (response != null) {
            int value = Integer.parseInt(response);
            return value != 0;
        }
        return false;
    }

    public void turnAllOn()
            throws IOException {
        writeValue("PIO.BYTE", "3");
    }

    public void turnAllOff()
            throws IOException {
        writeValue("PIO.BYTE", "0");
    }
}