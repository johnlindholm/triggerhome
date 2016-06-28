package com.home.security.onewire.container;

import com.home.security.core.protocol.annotation.ServiceMethod;
import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer12 extends OneWireDevice
        implements OneWireSwitchContainer {
    private static String FAM_12_LATCH_A = "latch.A";
    private static String FAM_12_R_ADDRESS = "r_address";
    private static String FAM_12_TAI8570_PRESSURE = "TAI8570/pressure";
    private static String FAM_12_TYPE = "type";
    private static String FAM_12_ID = "id";
    private static String FAM_12_FLIPFLOP_ALL = "flipflop.ALL";
    private static String FAM_12_LATCH_ALL = "latch.ALL";
    private static String FAM_12_FAMILY = "family";
    private static String FAM_12_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_12_CRC8 = "crc8";
    private static String FAM_12_POWER = "power";
    private static String FAM_12_FLIPFLOP_A = "flipflop.A";
    private static String FAM_12_TAI8570_TEMPERATURE = "TAI8570/temperature";
    private static String FAM_12_LOCATOR = "locator";
    private static String FAM_12_TAI8570_SIBLING = "TAI8570/sibling";
    private static String FAM_12_FLIPFLOP_BYTE = "flipflop.BYTE";
    private static String FAM_12_R_ID = "r_id";
    private static String FAM_12_PIO_BYTE = "PIO.BYTE";
    private static String FAM_12_ALIAS = "alias";
    private static String FAM_12_PIO_ALL = "PIO.ALL";
    private static String FAM_12_LATCH_BYTE = "latch.BYTE";
    private static String FAM_12_CHANNELS = "channels";
    private static String FAM_12_R_LOCATOR = "r_locator";
    private static String FAM_12_MEMORY = "memory";
    private static String FAM_12_PAGES_PAGE_0 = "pages/page.0";
    private static String FAM_12_PIO_A = "PIO.A";
    private static String FAM_12_PAGES_PAGE_ALL = "pages/page.ALL";
    private static String FAM_12_SENSED_ALL = "sensed.ALL";
    private static String FAM_12_ADDRESS = "address";
    private static String FAM_12_SET_ALARM = "set_alarm";
    private static String FAM_12_SENSED_A = "sensed.A";
    private static String FAM_12_T8A_VOLT_0 = "T8A/volt.0";
    private static String FAM_12_T8A_VOLT_ALL = "T8A/volt.ALL";
    private static int FAM_12_LATCH_A_SIZE = 1;
    private static int FAM_12_R_ADDRESS_SIZE = 16;
    private static int FAM_12_TAI8570_PRESSURE_SIZE = 12;
    private static int FAM_12_TYPE_SIZE = 32;
    private static int FAM_12_ID_SIZE = 12;
    private static int FAM_12_FLIPFLOP_ALL_SIZE = 3;
    private static int FAM_12_LATCH_ALL_SIZE = 3;
    private static int FAM_12_FAMILY_SIZE = 2;
    private static int FAM_12_SENSED_BYTE_SIZE = 12;
    private static int FAM_12_CRC8_SIZE = 2;
    private static int FAM_12_POWER_SIZE = 1;
    private static int FAM_12_FLIPFLOP_A_SIZE = 1;
    private static int FAM_12_TAI8570_TEMPERATURE_SIZE = 12;
    private static int FAM_12_LOCATOR_SIZE = 16;
    private static int FAM_12_TAI8570_SIBLING_SIZE = 16;
    private static int FAM_12_FLIPFLOP_BYTE_SIZE = 12;
    private static int FAM_12_R_ID_SIZE = 12;
    private static int FAM_12_PIO_BYTE_SIZE = 12;
    private static int FAM_12_ALIAS_SIZE = 256;
    private static int FAM_12_PIO_ALL_SIZE = 3;
    private static int FAM_12_LATCH_BYTE_SIZE = 12;
    private static int FAM_12_CHANNELS_SIZE = 12;
    private static int FAM_12_R_LOCATOR_SIZE = 16;
    private static int FAM_12_MEMORY_SIZE = 128;
    private static int FAM_12_PAGES_PAGE_0_SIZE = 32;
    private static int FAM_12_PIO_A_SIZE = 1;
    private static int FAM_12_PAGES_PAGE_ALL_SIZE = 128;
    private static int FAM_12_SENSED_ALL_SIZE = 3;
    private static int FAM_12_ADDRESS_SIZE = 16;
    private static int FAM_12_SET_ALARM_SIZE = 12;
    private static int FAM_12_SENSED_A_SIZE = 1;
    private static int FAM_12_T8A_VOLT_0_SIZE = 12;
    private static int FAM_12_T8A_VOLT_ALL_SIZE = 103;

    public OneWireContainer12() {
    }

    public OneWireContainer12(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_12_LATCH_A))
            return FAM_12_LATCH_A_SIZE;
        if (path.equals(FAM_12_R_ADDRESS))
            return FAM_12_R_ADDRESS_SIZE;
        if (path.equals(FAM_12_TAI8570_PRESSURE))
            return FAM_12_TAI8570_PRESSURE_SIZE;
        if (path.equals(FAM_12_TYPE))
            return FAM_12_TYPE_SIZE;
        if (path.equals(FAM_12_ID))
            return FAM_12_ID_SIZE;
        if (path.equals(FAM_12_FLIPFLOP_ALL))
            return FAM_12_FLIPFLOP_ALL_SIZE;
        if (path.equals(FAM_12_LATCH_ALL))
            return FAM_12_LATCH_ALL_SIZE;
        if (path.equals(FAM_12_FAMILY))
            return FAM_12_FAMILY_SIZE;
        if (path.equals(FAM_12_SENSED_BYTE))
            return FAM_12_SENSED_BYTE_SIZE;
        if (path.equals(FAM_12_CRC8))
            return FAM_12_CRC8_SIZE;
        if (path.equals(FAM_12_POWER))
            return FAM_12_POWER_SIZE;
        if (path.equals(FAM_12_FLIPFLOP_A))
            return FAM_12_FLIPFLOP_A_SIZE;
        if (path.equals(FAM_12_TAI8570_TEMPERATURE))
            return FAM_12_TAI8570_TEMPERATURE_SIZE;
        if (path.equals(FAM_12_LOCATOR))
            return FAM_12_LOCATOR_SIZE;
        if (path.equals(FAM_12_TAI8570_SIBLING))
            return FAM_12_TAI8570_SIBLING_SIZE;
        if (path.equals(FAM_12_FLIPFLOP_BYTE))
            return FAM_12_FLIPFLOP_BYTE_SIZE;
        if (path.equals(FAM_12_R_ID))
            return FAM_12_R_ID_SIZE;
        if (path.equals(FAM_12_PIO_BYTE))
            return FAM_12_PIO_BYTE_SIZE;
        if (path.equals(FAM_12_ALIAS))
            return FAM_12_ALIAS_SIZE;
        if (path.equals(FAM_12_PIO_ALL))
            return FAM_12_PIO_ALL_SIZE;
        if (path.equals(FAM_12_LATCH_BYTE))
            return FAM_12_LATCH_BYTE_SIZE;
        if (path.equals(FAM_12_CHANNELS))
            return FAM_12_CHANNELS_SIZE;
        if (path.equals(FAM_12_R_LOCATOR))
            return FAM_12_R_LOCATOR_SIZE;
        if (path.equals(FAM_12_MEMORY))
            return FAM_12_MEMORY_SIZE;
        if (path.equals(FAM_12_PAGES_PAGE_0))
            return FAM_12_PAGES_PAGE_0_SIZE;
        if (path.equals(FAM_12_PIO_A))
            return FAM_12_PIO_A_SIZE;
        if (path.equals(FAM_12_PAGES_PAGE_ALL))
            return FAM_12_PAGES_PAGE_ALL_SIZE;
        if (path.equals(FAM_12_SENSED_ALL))
            return FAM_12_SENSED_ALL_SIZE;
        if (path.equals(FAM_12_ADDRESS))
            return FAM_12_ADDRESS_SIZE;
        if (path.equals(FAM_12_SET_ALARM))
            return FAM_12_SET_ALARM_SIZE;
        if (path.equals(FAM_12_SENSED_A))
            return FAM_12_SENSED_A_SIZE;
        if (path.equals(FAM_12_T8A_VOLT_0))
            return FAM_12_T8A_VOLT_0_SIZE;
        if (path.equals(FAM_12_T8A_VOLT_ALL)) {
            return FAM_12_T8A_VOLT_ALL_SIZE;
        }
        return -1;
    }

    @ServiceMethod(name = "isOn", returnParamNames = "isOn")
    public boolean isOn()
            throws IOException {
        String response = readValue("sensed.BYTE", true);
        if (response != null) {
            int value = Integer.parseInt(response);
            return value != 0;
        }
        return false;
    }

    @ServiceMethod(name = "turnAllOn")
    public void turnAllOn()
            throws IOException {
        writeValue("PIO.BYTE", "3");
    }

    @ServiceMethod(name = "turnAllOff")
    public void turnAllOff()
            throws IOException {
        writeValue("PIO.BYTE", "0");
    }
}