package com.home.security.onewire.container;

import com.home.security.onewire.OWFSClient;

import java.io.IOException;

public class OneWireContainersimultaneous extends OneWireDevice
        implements OneWireTemperatureContainer {
    private static String FAM_SIMULTANEOUS_PRESENT = "present";
    private static String FAM_SIMULTANEOUS_PRESENT_DS2400 = "present_ds2400";
    private static String FAM_SIMULTANEOUS_SINGLE = "single";
    private static String FAM_SIMULTANEOUS_VOLTAGE = "voltage";
    private static String FAM_SIMULTANEOUS_SINGLE_DS2400 = "single_ds2400";
    private static String FAM_SIMULTANEOUS_TEMPERATURE = "temperature";
    private static int FAM_SIMULTANEOUS_PRESENT_SIZE = 1;
    private static int FAM_SIMULTANEOUS_PRESENT_DS2400_SIZE = 1;
    private static int FAM_SIMULTANEOUS_SINGLE_SIZE = 18;
    private static int FAM_SIMULTANEOUS_VOLTAGE_SIZE = 1;
    private static int FAM_SIMULTANEOUS_SINGLE_DS2400_SIZE = 18;
    private static int FAM_SIMULTANEOUS_TEMPERATURE_SIZE = 1;

    public OneWireContainersimultaneous() {
    }

    public OneWireContainersimultaneous(OWFSClient owfsClient, String address, String alias, String crc8, String family, String id, String locator, String r_address, String r_id, String r_locator, String type) {
        super(owfsClient, address, alias, crc8, family, id, locator, r_address, r_id, r_locator, type);
    }

    public static int pathToSize(String path) {
        if (path.equals(FAM_SIMULTANEOUS_PRESENT))
            return FAM_SIMULTANEOUS_PRESENT_SIZE;
        if (path.equals(FAM_SIMULTANEOUS_PRESENT_DS2400))
            return FAM_SIMULTANEOUS_PRESENT_DS2400_SIZE;
        if (path.equals(FAM_SIMULTANEOUS_SINGLE))
            return FAM_SIMULTANEOUS_SINGLE_SIZE;
        if (path.equals(FAM_SIMULTANEOUS_VOLTAGE))
            return FAM_SIMULTANEOUS_VOLTAGE_SIZE;
        if (path.equals(FAM_SIMULTANEOUS_SINGLE_DS2400))
            return FAM_SIMULTANEOUS_SINGLE_DS2400_SIZE;
        if (path.equals(FAM_SIMULTANEOUS_TEMPERATURE)) {
            return FAM_SIMULTANEOUS_TEMPERATURE_SIZE;
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
}