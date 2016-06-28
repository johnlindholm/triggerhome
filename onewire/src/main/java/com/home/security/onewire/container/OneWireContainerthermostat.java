package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainerthermostat extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_THERMOSTAT_TEMPHIGHFLAG = "temphighflag";
    private static String FAM_THERMOSTAT_TEMPLOWFLAG = "templowflag";
    private static String FAM_THERMOSTAT_TEMPHIGH = "temphigh";
    private static String FAM_THERMOSTAT_THERMOSTATMODE = "thermostatmode";
    private static String FAM_THERMOSTAT_POLARITY = "polarity";
    private static String FAM_THERMOSTAT_1SHOT = "1shot";
    private static String FAM_THERMOSTAT_TYPE = "type";
    private static String FAM_THERMOSTAT_TEMPLOW = "templow";
    private static String FAM_THERMOSTAT_TEMPERATURE = "temperature";
    private static int FAM_THERMOSTAT_TEMPHIGHFLAG_SIZE = 1;
    private static int FAM_THERMOSTAT_TEMPLOWFLAG_SIZE = 1;
    private static int FAM_THERMOSTAT_TEMPHIGH_SIZE = 12;
    private static int FAM_THERMOSTAT_THERMOSTATMODE_SIZE = 1;
    private static int FAM_THERMOSTAT_POLARITY_SIZE = 1;
    private static int FAM_THERMOSTAT_1SHOT_SIZE = 1;
    private static int FAM_THERMOSTAT_TYPE_SIZE = 32;
    private static int FAM_THERMOSTAT_TEMPLOW_SIZE = 12;
    private static int FAM_THERMOSTAT_TEMPERATURE_SIZE = 12;

    public OneWireContainerthermostat() {
    }

    public OneWireContainerthermostat(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_THERMOSTAT_TEMPHIGHFLAG))
            return FAM_THERMOSTAT_TEMPHIGHFLAG_SIZE;
        if (path.equals(FAM_THERMOSTAT_TEMPLOWFLAG))
            return FAM_THERMOSTAT_TEMPLOWFLAG_SIZE;
        if (path.equals(FAM_THERMOSTAT_TEMPHIGH))
            return FAM_THERMOSTAT_TEMPHIGH_SIZE;
        if (path.equals(FAM_THERMOSTAT_THERMOSTATMODE))
            return FAM_THERMOSTAT_THERMOSTATMODE_SIZE;
        if (path.equals(FAM_THERMOSTAT_POLARITY))
            return FAM_THERMOSTAT_POLARITY_SIZE;
        if (path.equals(FAM_THERMOSTAT_1SHOT))
            return FAM_THERMOSTAT_1SHOT_SIZE;
        if (path.equals(FAM_THERMOSTAT_TYPE))
            return FAM_THERMOSTAT_TYPE_SIZE;
        if (path.equals(FAM_THERMOSTAT_TEMPLOW))
            return FAM_THERMOSTAT_TEMPLOW_SIZE;
        if (path.equals(FAM_THERMOSTAT_TEMPERATURE)) {
            return FAM_THERMOSTAT_TEMPERATURE_SIZE;
        }
        return -1;
    }

    public String getTemperature()
            throws IOException {
        return readValue("temperature", true);
    }

    public boolean hasTemperatureResolution() {
        return true;
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
}