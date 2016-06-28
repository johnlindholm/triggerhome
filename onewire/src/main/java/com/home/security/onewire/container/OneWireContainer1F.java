package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainer1F extends OneWireDevice
        implements OneWireSwitchContainer {
    private static String FAM_1F_AUX_SIMULTANEOUS_PRESENT_DS2400 = "aux/simultaneous/present_ds2400";
    private static String FAM_1F_EVENT_BYTE = "event.BYTE";
    private static String FAM_1F_R_ADDRESS = "r_address";
    private static String FAM_1F_MAIN_THERMOSTAT_TEMPLOWFLAG = "main/thermostat/templowflag";
    private static String FAM_1F_TYPE = "type";
    private static String FAM_1F_MAIN_SIMULTANEOUS_PRESENT = "main/simultaneous/present";
    private static String FAM_1F_MAIN_SIMULTANEOUS_SINGLE_DS2400 = "main/simultaneous/single_ds2400";
    private static String FAM_1F_AUX_THERMOSTAT_TEMPHIGHFLAG = "aux/thermostat/temphighflag";
    private static String FAM_1F_FAMILY = "family";
    private static String FAM_1F_SENSED_BYTE = "sensed.BYTE";
    private static String FAM_1F_DISCHARGE = "discharge";
    private static String FAM_1F_AUX_THERMOSTAT_TEMPERATURE = "aux/thermostat/temperature";
    private static String FAM_1F_AUX_THERMOSTAT_TYPE = "aux/thermostat/type";
    private static String FAM_1F_BRANCH_BYTE = "branch.BYTE";
    private static String FAM_1F_CONTROL = "control";
    private static String FAM_1F_LOCATOR = "locator";
    private static String FAM_1F_R_ID = "r_id";
    private static String FAM_1F_EVENT_ALL = "event.ALL";
    private static String FAM_1F_CLEAREVENT = "clearevent";
    private static String FAM_1F_BRANCH_0 = "branch.0";
    private static String FAM_1F_MAIN_SIMULTANEOUS_SINGLE = "main/simultaneous/single";
    private static String FAM_1F_MAIN_THERMOSTAT_TEMPERATURE = "main/thermostat/temperature";
    private static String FAM_1F_MAIN_THERMOSTAT_TEMPHIGH = "main/thermostat/temphigh";
    private static String FAM_1F_SENSED_ALL = "sensed.ALL";
    private static String FAM_1F_MAIN_THERMOSTAT_POLARITY = "main/thermostat/polarity";
    private static String FAM_1F_AUX_THERMOSTAT_POLARITY = "aux/thermostat/polarity";
    private static String FAM_1F_MAIN_THERMOSTAT_TEMPHIGHFLAG = "main/thermostat/temphighflag";
    private static String FAM_1F_MAIN_THERMOSTAT_TYPE = "main/thermostat/type";
    private static String FAM_1F_AUX_THERMOSTAT_TEMPLOWFLAG = "aux/thermostat/templowflag";
    private static String FAM_1F_SENSED_0 = "sensed.0";
    private static String FAM_1F_ID = "id";
    private static String FAM_1F_BRANCH_ALL = "branch.ALL";
    private static String FAM_1F_AUX_SIMULTANEOUS_SINGLE_DS2400 = "aux/simultaneous/single_ds2400";
    private static String FAM_1F_AUX_THERMOSTAT_1SHOT = "aux/thermostat/1shot";
    private static String FAM_1F_AUX_SIMULTANEOUS_VOLTAGE = "aux/simultaneous/voltage";
    private static String FAM_1F_CRC8 = "crc8";
    private static String FAM_1F_EVENT_0 = "event.0";
    private static String FAM_1F_MAIN_SIMULTANEOUS_TEMPERATURE = "main/simultaneous/temperature";
    private static String FAM_1F_AUX_THERMOSTAT_TEMPLOW = "aux/thermostat/templow";
    private static String FAM_1F_MAIN_THERMOSTAT_THERMOSTATMODE = "main/thermostat/thermostatmode";
    private static String FAM_1F_ALIAS = "alias";
    private static String FAM_1F_AUX_THERMOSTAT_TEMPHIGH = "aux/thermostat/temphigh";
    private static String FAM_1F_MAIN_SIMULTANEOUS_PRESENT_DS2400 = "main/simultaneous/present_ds2400";
    private static String FAM_1F_R_LOCATOR = "r_locator";
    private static String FAM_1F_AUX_THERMOSTAT_THERMOSTATMODE = "aux/thermostat/thermostatmode";
    private static String FAM_1F_MAIN_SIMULTANEOUS_VOLTAGE = "main/simultaneous/voltage";
    private static String FAM_1F_MAIN_THERMOSTAT_TEMPLOW = "main/thermostat/templow";
    private static String FAM_1F_AUX_SIMULTANEOUS_TEMPERATURE = "aux/simultaneous/temperature";
    private static String FAM_1F_MAIN_THERMOSTAT_1SHOT = "main/thermostat/1shot";
    private static String FAM_1F_ADDRESS = "address";
    private static String FAM_1F_AUX_SIMULTANEOUS_SINGLE = "aux/simultaneous/single";
    private static String FAM_1F_AUX_SIMULTANEOUS_PRESENT = "aux/simultaneous/present";
    private static int FAM_1F_AUX_SIMULTANEOUS_PRESENT_DS2400_SIZE = 1;
    private static int FAM_1F_EVENT_BYTE_SIZE = 12;
    private static int FAM_1F_R_ADDRESS_SIZE = 16;
    private static int FAM_1F_MAIN_THERMOSTAT_TEMPLOWFLAG_SIZE = 1;
    private static int FAM_1F_TYPE_SIZE = 32;
    private static int FAM_1F_MAIN_SIMULTANEOUS_PRESENT_SIZE = 1;
    private static int FAM_1F_MAIN_SIMULTANEOUS_SINGLE_DS2400_SIZE = 18;
    private static int FAM_1F_AUX_THERMOSTAT_TEMPHIGHFLAG_SIZE = 1;
    private static int FAM_1F_FAMILY_SIZE = 2;
    private static int FAM_1F_SENSED_BYTE_SIZE = 12;
    private static int FAM_1F_DISCHARGE_SIZE = 1;
    private static int FAM_1F_AUX_THERMOSTAT_TEMPERATURE_SIZE = 12;
    private static int FAM_1F_AUX_THERMOSTAT_TYPE_SIZE = 32;
    private static int FAM_1F_BRANCH_BYTE_SIZE = 12;
    private static int FAM_1F_CONTROL_SIZE = 12;
    private static int FAM_1F_LOCATOR_SIZE = 16;
    private static int FAM_1F_R_ID_SIZE = 12;
    private static int FAM_1F_EVENT_ALL_SIZE = 3;
    private static int FAM_1F_CLEAREVENT_SIZE = 1;
    private static int FAM_1F_BRANCH_0_SIZE = 1;
    private static int FAM_1F_MAIN_SIMULTANEOUS_SINGLE_SIZE = 18;
    private static int FAM_1F_MAIN_THERMOSTAT_TEMPERATURE_SIZE = 12;
    private static int FAM_1F_MAIN_THERMOSTAT_TEMPHIGH_SIZE = 12;
    private static int FAM_1F_SENSED_ALL_SIZE = 3;
    private static int FAM_1F_MAIN_THERMOSTAT_POLARITY_SIZE = 1;
    private static int FAM_1F_AUX_THERMOSTAT_POLARITY_SIZE = 1;
    private static int FAM_1F_MAIN_THERMOSTAT_TEMPHIGHFLAG_SIZE = 1;
    private static int FAM_1F_MAIN_THERMOSTAT_TYPE_SIZE = 32;
    private static int FAM_1F_AUX_THERMOSTAT_TEMPLOWFLAG_SIZE = 1;
    private static int FAM_1F_SENSED_0_SIZE = 1;
    private static int FAM_1F_ID_SIZE = 12;
    private static int FAM_1F_BRANCH_ALL_SIZE = 3;
    private static int FAM_1F_AUX_SIMULTANEOUS_SINGLE_DS2400_SIZE = 18;
    private static int FAM_1F_AUX_THERMOSTAT_1SHOT_SIZE = 1;
    private static int FAM_1F_AUX_SIMULTANEOUS_VOLTAGE_SIZE = 1;
    private static int FAM_1F_CRC8_SIZE = 2;
    private static int FAM_1F_EVENT_0_SIZE = 1;
    private static int FAM_1F_MAIN_SIMULTANEOUS_TEMPERATURE_SIZE = 1;
    private static int FAM_1F_AUX_THERMOSTAT_TEMPLOW_SIZE = 12;
    private static int FAM_1F_MAIN_THERMOSTAT_THERMOSTATMODE_SIZE = 1;
    private static int FAM_1F_ALIAS_SIZE = 256;
    private static int FAM_1F_AUX_THERMOSTAT_TEMPHIGH_SIZE = 12;
    private static int FAM_1F_MAIN_SIMULTANEOUS_PRESENT_DS2400_SIZE = 1;
    private static int FAM_1F_R_LOCATOR_SIZE = 16;
    private static int FAM_1F_AUX_THERMOSTAT_THERMOSTATMODE_SIZE = 1;
    private static int FAM_1F_MAIN_SIMULTANEOUS_VOLTAGE_SIZE = 1;
    private static int FAM_1F_MAIN_THERMOSTAT_TEMPLOW_SIZE = 12;
    private static int FAM_1F_AUX_SIMULTANEOUS_TEMPERATURE_SIZE = 1;
    private static int FAM_1F_MAIN_THERMOSTAT_1SHOT_SIZE = 1;
    private static int FAM_1F_ADDRESS_SIZE = 16;
    private static int FAM_1F_AUX_SIMULTANEOUS_SINGLE_SIZE = 18;
    private static int FAM_1F_AUX_SIMULTANEOUS_PRESENT_SIZE = 1;

    public OneWireContainer1F() {
    }

    public OneWireContainer1F(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_PRESENT_DS2400))
            return FAM_1F_AUX_SIMULTANEOUS_PRESENT_DS2400_SIZE;
        if (path.equals(FAM_1F_EVENT_BYTE))
            return FAM_1F_EVENT_BYTE_SIZE;
        if (path.equals(FAM_1F_R_ADDRESS))
            return FAM_1F_R_ADDRESS_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TEMPLOWFLAG))
            return FAM_1F_MAIN_THERMOSTAT_TEMPLOWFLAG_SIZE;
        if (path.equals(FAM_1F_TYPE))
            return FAM_1F_TYPE_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_PRESENT))
            return FAM_1F_MAIN_SIMULTANEOUS_PRESENT_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_SINGLE_DS2400))
            return FAM_1F_MAIN_SIMULTANEOUS_SINGLE_DS2400_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TEMPHIGHFLAG))
            return FAM_1F_AUX_THERMOSTAT_TEMPHIGHFLAG_SIZE;
        if (path.equals(FAM_1F_FAMILY))
            return FAM_1F_FAMILY_SIZE;
        if (path.equals(FAM_1F_SENSED_BYTE))
            return FAM_1F_SENSED_BYTE_SIZE;
        if (path.equals(FAM_1F_DISCHARGE))
            return FAM_1F_DISCHARGE_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TEMPERATURE))
            return FAM_1F_AUX_THERMOSTAT_TEMPERATURE_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TYPE))
            return FAM_1F_AUX_THERMOSTAT_TYPE_SIZE;
        if (path.equals(FAM_1F_BRANCH_BYTE))
            return FAM_1F_BRANCH_BYTE_SIZE;
        if (path.equals(FAM_1F_CONTROL))
            return FAM_1F_CONTROL_SIZE;
        if (path.equals(FAM_1F_LOCATOR))
            return FAM_1F_LOCATOR_SIZE;
        if (path.equals(FAM_1F_R_ID))
            return FAM_1F_R_ID_SIZE;
        if (path.equals(FAM_1F_EVENT_ALL))
            return FAM_1F_EVENT_ALL_SIZE;
        if (path.equals(FAM_1F_CLEAREVENT))
            return FAM_1F_CLEAREVENT_SIZE;
        if (path.equals(FAM_1F_BRANCH_0))
            return FAM_1F_BRANCH_0_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_SINGLE))
            return FAM_1F_MAIN_SIMULTANEOUS_SINGLE_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TEMPERATURE))
            return FAM_1F_MAIN_THERMOSTAT_TEMPERATURE_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TEMPHIGH))
            return FAM_1F_MAIN_THERMOSTAT_TEMPHIGH_SIZE;
        if (path.equals(FAM_1F_SENSED_ALL))
            return FAM_1F_SENSED_ALL_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_POLARITY))
            return FAM_1F_MAIN_THERMOSTAT_POLARITY_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_POLARITY))
            return FAM_1F_AUX_THERMOSTAT_POLARITY_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TEMPHIGHFLAG))
            return FAM_1F_MAIN_THERMOSTAT_TEMPHIGHFLAG_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TYPE))
            return FAM_1F_MAIN_THERMOSTAT_TYPE_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TEMPLOWFLAG))
            return FAM_1F_AUX_THERMOSTAT_TEMPLOWFLAG_SIZE;
        if (path.equals(FAM_1F_SENSED_0))
            return FAM_1F_SENSED_0_SIZE;
        if (path.equals(FAM_1F_ID))
            return FAM_1F_ID_SIZE;
        if (path.equals(FAM_1F_BRANCH_ALL))
            return FAM_1F_BRANCH_ALL_SIZE;
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_SINGLE_DS2400))
            return FAM_1F_AUX_SIMULTANEOUS_SINGLE_DS2400_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_1SHOT))
            return FAM_1F_AUX_THERMOSTAT_1SHOT_SIZE;
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_VOLTAGE))
            return FAM_1F_AUX_SIMULTANEOUS_VOLTAGE_SIZE;
        if (path.equals(FAM_1F_CRC8))
            return FAM_1F_CRC8_SIZE;
        if (path.equals(FAM_1F_EVENT_0))
            return FAM_1F_EVENT_0_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_TEMPERATURE))
            return FAM_1F_MAIN_SIMULTANEOUS_TEMPERATURE_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TEMPLOW))
            return FAM_1F_AUX_THERMOSTAT_TEMPLOW_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_THERMOSTATMODE))
            return FAM_1F_MAIN_THERMOSTAT_THERMOSTATMODE_SIZE;
        if (path.equals(FAM_1F_ALIAS))
            return FAM_1F_ALIAS_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_TEMPHIGH))
            return FAM_1F_AUX_THERMOSTAT_TEMPHIGH_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_PRESENT_DS2400))
            return FAM_1F_MAIN_SIMULTANEOUS_PRESENT_DS2400_SIZE;
        if (path.equals(FAM_1F_R_LOCATOR))
            return FAM_1F_R_LOCATOR_SIZE;
        if (path.equals(FAM_1F_AUX_THERMOSTAT_THERMOSTATMODE))
            return FAM_1F_AUX_THERMOSTAT_THERMOSTATMODE_SIZE;
        if (path.equals(FAM_1F_MAIN_SIMULTANEOUS_VOLTAGE))
            return FAM_1F_MAIN_SIMULTANEOUS_VOLTAGE_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_TEMPLOW))
            return FAM_1F_MAIN_THERMOSTAT_TEMPLOW_SIZE;
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_TEMPERATURE))
            return FAM_1F_AUX_SIMULTANEOUS_TEMPERATURE_SIZE;
        if (path.equals(FAM_1F_MAIN_THERMOSTAT_1SHOT))
            return FAM_1F_MAIN_THERMOSTAT_1SHOT_SIZE;
        if (path.equals(FAM_1F_ADDRESS))
            return FAM_1F_ADDRESS_SIZE;
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_SINGLE))
            return FAM_1F_AUX_SIMULTANEOUS_SINGLE_SIZE;
        if (path.equals(FAM_1F_AUX_SIMULTANEOUS_PRESENT)) {
            return FAM_1F_AUX_SIMULTANEOUS_PRESENT_SIZE;
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