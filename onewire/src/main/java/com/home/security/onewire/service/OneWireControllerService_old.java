package com.home.security.onewire.service;//package se.lth.cs.palcom.onewire.service;
//
//import ist.palcom.resource.descriptor.Command;
//import ist.palcom.resource.descriptor.DeviceID;
//import ist.palcom.resource.descriptor.ListAddress;
//import ist.palcom.resource.descriptor.Param;
//import ist.palcom.resource.descriptor.ServiceID;
//import java.io.PrintStream;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Properties;
//import java.util.Set;
//import se.lth.cs.palcom.communication.connection.Readable;
//import se.lth.cs.palcom.communication.connection.Writable;
//import se.lth.cs.palcom.device.AbstractDevice;
//import se.lth.cs.palcom.discovery.announce.AnnouncementManager;
//import se.lth.cs.palcom.logging.Logger;
//import se.lth.cs.palcom.logging.SystemOutSink;
//import se.lth.cs.palcom.onewire.OneWireController;
//import se.lth.cs.palcom.onewire.OneWireEventListener;
//import se.lth.cs.palcom.onewire.container.OneWireContainer01;
//import se.lth.cs.palcom.onewire.container.OneWireDevice;
//import se.lth.cs.palcom.onewire.container.OneWireHumidityContainer;
//import se.lth.cs.palcom.onewire.container.OneWirePressureContainer;
//import se.lth.cs.palcom.onewire.container.OneWireSwitchContainer;
//import se.lth.cs.palcom.onewire.container.OneWireTemperatureContainer;
//import se.lth.cs.palcom.onewire.container.OneWireVoltageSensorContainer;
//import se.lth.cs.palcom.onewire.event.OneWireDeviceChangedEvent;
//import se.lth.cs.palcom.onewire.event.OneWireEvent;
//import se.lth.cs.palcom.onewire.event.OneWireValueAlarmEvent;
//import se.lth.cs.palcom.service.AbstractSimpleService;
//import se.lth.cs.palcom.service.command.CommandServiceProtocol;
//import se.lth.cs.palcom.service.distribution.UnicastDistribution;
//
//public class OneWireControllerService extends AbstractSimpleService
//  implements OneWireEventListener
//{
//  private static final DeviceID creatingDeviceId = new DeviceID("C:02efa25b-c5e2-4a63-9096-c32daa1c8c4b");
//  private static final String COM_IN_SET_OW_SERVER_ADDRESS = "set OW server";
//  private static final String COM_IN_SET_KNOWN_DEVICES = "set known devices";
//  private static final String COM_IN_SET_DEVICE_UPDATE_INTERVAL = "set update interval";
//  private static final String COM_IN_GET_OW_SERVER_ADDRESS = "get OW server";
//  private static final String COM_IN_GET_KNOWN_DEVICES = "get known devices";
//  private static final String COM_IN_GET_DEVICE_UPDATE_INTERVAL = "get update interval";
//  private static final String COM_OUT_OW_SERVER_ADDRESS = "OW server address";
//  private static final String COM_OUT_DEVICE_UPDATE_INTERVAL = "update interval";
//  private static final String COM_OUT_KNOWN_DEVICES = "known devices";
//  private static final String PAR_OW_SERVER_ADDRESS = "OW server address";
//  private static final String PAR_KNOWN_DEVICES = "known devices";
//  private static final String PAR_UPDATE_INTERVAL = "update interval";
//  private static final String NS_ONEWIRE = "onewire";
//  private static final String NS_KNOWN_DEVICES = "onewire.devices";
//  private static final String CONF_OW_SERVER = "ow_server";
//  private static final String CONF_OW_SERVER_PORT = "ow_server_port";
//  private static final String CONF_DEVICE_UPDATE_INTERVAL = "device_update_interval";
//  private static final String CONF_VALUE_UPDATE_INTERVAL = "value_update_interval";
//  private static final String CONF_OW_SERVER_DEFAULT = "127.0.0.1";
//  private static final String CONF_OW_SERVER_PORT_DEFAULT = "4304";
//  private static final String CONF_DEVICE_UPDATE_INTERVAL_DEFAULT = "10000";
//  private static final String CONF_VALUE_UPDATE_INTERVAL_DEFAULT = "1000";
//  private static final String ONEWIRE_LIST_NAME = "1-wire services";
//  private int switchServiceSeqNbr = 1;
//  private int temperatureServiceSeqNbr = 1;
//  private int voltageServiceSeqNbr = 1;
//  private int genericServiceSeqNbr = 1;
//  private int humidityServiceSeqNbr = 1;
//  private int pressureServiceSeqNbr = 1;
//  private IButtonReaderService ibuttonReaderService;
//  private OneWireController oneWireController;
//  private HashMap<String, OneWireService> oneWireServices;
//  private DeviceID parentDeviceId;
//  private ListAddress onewireServiceGroup;
//
//  public OneWireControllerService(AbstractDevice device)
//  {
//    super(device, new ServiceID(creatingDeviceId, "OneWireControllerService",
//      creatingDeviceId, "OneWireControllerService"), "pCmProtocol", "v0.1",
//      "OneWireControllerService", "1", "", new UnicastDistribution(false));
//    this.parentDeviceId = this.container.getDeviceID();
//    this.oneWireServices = new HashMap();
//    createCommands();
//    if (Logger.defaultSink.accept(0))
//    {
//      Logger.defaultSink.changeLevel(1);
//    }
//    this.container.setDefaultConfigProperties("onewire", getDefaultProperties());
//  }
//
//  private static Properties getDefaultProperties() {
//    Properties prop = new Properties();
//    prop.setProperty("device_update_interval", "10000");
//    prop.setProperty("ow_server", "127.0.0.1");
//    prop.setProperty("ow_server_port", "4304");
//    prop.setProperty("value_update_interval", "1000");
//    return prop;
//  }
//
//  private HashMap<String, String> getKnownDevices() {
//    HashMap knownDevices = new HashMap();
//    String[] keys = this.container.getConfigKeys("onewire.devices");
//    for (String key : keys)
//    {
//      if ((key.length() == 15) && (key.charAt(2) == '.'))
//      {
//        try {
//          String family = key.substring(0, 2);
//          String id = key.substring(3);
//          Long.parseLong(family, 16);
//          Long.parseLong(id, 16);
//        }
//        catch (NumberFormatException e) {
//          Logger.log("Malformed onewire <family>.<id> : " + key + " , not added to known devices.",
//            9, 3);
//          continue;
//        }
//        knownDevices.put(key, this.container.getConfigProperty("onewire.devices", key));
//      }
//    }
//    return knownDevices;
//  }
//
//  private void addKnownDevices(String[] keyValueLines) {
//    for (int i = 0; i < keyValueLines.length; i++) {
//      String[] keyValue = keyValueLines[i].split("=", 2);
//      if (keyValue.length != 2) {
//        Logger.log("Malformed onewire <family>.<id>=<human-readable name> : " + keyValueLines[i] +
//          " , not added to known devices.", 9, 3);
//      }
//      else
//        this.container.setConfigProperty("onewire.devices", keyValue[0].trim(), keyValue[1].trim());
//    }
//  }
//
//  private void createCommands() {
//    addCommand("get update interval",
//      "Get the interval for checking after new 1-wire services, in milliseconds. The default is 10000 milliseconds.",
//      "in", null);
//    addCommand("get known devices",
//      "Get the list of known devices and there human-readable aliases.", "in", null);
//    addCommand("get OW server", "The OW server adress. Default is localhost.",
//      "in", null);
//    addCommand("set update interval",
//      "Set the interval for checking after new 1-wire services, in milliseconds. The default is 10000 milliseconds.",
//      "in",
//      new String[] { "update interval" });
//    addCommand("set known devices",
//      "Add to the list of known devices and there human-readable aliases. Example:\n10.ABCDEF123456 = Temperature in bedroom\n26.465165ACDF23 = Humidity in bathroom",
//      "in",
//      new String[] { "known devices" });
//    addCommand("set OW server", "The OW server adress. Default is localhost.",
//      "in", new String[] { "OW server address" });
//    addCommand("update interval", "", "out",
//      new String[] { "update interval" });
//    addCommand("known devices", "", "out", new String[] { "known devices" });
//    addCommand("OW server address", "", "out",
//      new String[] { "OW server address" });
//  }
//
//  private void addCommand(String name, String help, String direction, String[] params) {
//    Command command = new Command(name, name, direction, help);
//    for (int i = 0; (params != null) && (i < params.length); i++) {
//      Param p = new Param(params[i], "text/plain");
//      command.addParam(p);
//    }
//    getProtocolHandler().addCommand(command);
//  }
//
//  private void connectToServer() {
//    String serverIp = this.container.getConfigProperty("onewire", "ow_server");
//    int port = Integer.parseInt(this.container.getConfigProperty("onewire", "ow_server_port"));
//    long deviceUpdate = Long.parseLong(
//      this.container.getConfigProperty("onewire", "device_update_interval"));
//    long valueUpdate = Long.parseLong(
//      this.container.getConfigProperty("onewire", "value_update_interval"));
//    if (this.oneWireController != null) {
//      this.oneWireController.stop();
//      this.oneWireController.setDeviceUpdateInterval(deviceUpdate);
//      this.oneWireController.setValueUpdateInterval(valueUpdate);
//    } else {
//      this.oneWireController = new OneWireController(this, deviceUpdate, valueUpdate, null);
//    }
//    this.oneWireController.start(serverIp, port);
//  }
//
//  public void start()
//  {
//    setStatus((byte)89, "Reading connected 1-wire services ... wait");
//    connectToServer();
//    setStatus((byte)71);
//    super.start();
//  }
//
//  public void stop()
//  {
//    if (this.ibuttonReaderService != null) {
//      this.ibuttonReaderService.stop();
//    }
//    if (this.oneWireController != null) {
//      this.oneWireController.stop();
//    }
//    if ((this.oneWireServices != null) && (!this.oneWireServices.isEmpty())) {
//      Set keys = this.oneWireServices.keySet();
//      Iterator itr = keys.iterator();
//      while (itr.hasNext()) {
//        String key = (String)itr.next();
//        OneWireService service = (OneWireService)this.oneWireServices.get(key);
//        if (service != null) {
//          Logger.log("Stopping service: " + key + "...", 9, 2);
//          service.stop();
//        }
//      }
//    }
//    super.stop();
//  }
//
//  public void unregister()
//  {
//    if ((this.oneWireServices != null) && (!this.oneWireServices.isEmpty())) {
//      Set keys = this.oneWireServices.keySet();
//      Iterator itr = keys.iterator();
//      while (itr.hasNext()) {
//        String key = (String)itr.next();
//        OneWireService service = (OneWireService)this.oneWireServices.get(key);
//        if (service != null) {
//          service.unregister();
//        }
//      }
//    }
//    if (this.onewireServiceGroup != null)
//      this.container.getAnnouncementManager().unregisterService(this.onewireServiceGroup);
//    else {
//      System.out.println("OneWireControllerService.unregister() onewireServiceGroup == null");
//    }
//    super.unregister();
//  }
//
//  private void sendCommand(Writable conn, Command command) {
//    Logger.log("OneWireControllerService.sendCommand() command: " + command.getID(), 9, 1);
//    command.invoke(conn);
//  }
//
//  protected void invoked(Readable conn, Command command)
//  {
//    Logger.log(getName() + " received command: " + command.getID(), 9, 1);
//    if (command.getID().equals("get update interval")) {
//      Command outCommand = getProtocolHandler().findCommand("update interval");
//      Param param = outCommand.findParam("update interval");
//      param.setData(this.container.getConfigProperty("onewire", "device_update_interval").getBytes());
//      sendCommand((Writable)conn, outCommand);
//    } else if (command.getID().equals("get known devices")) {
//      Command outCommand = getProtocolHandler().findCommand("known devices");
//      Param param = outCommand.findParam("known devices");
//      String knownDevices = "";
//      Set keys = getKnownDevices().keySet();
//      for (String key : keys) {
//        knownDevices = knownDevices + key + " = " + this.container.getConfigProperty("onewire.devices", key) + "\n";
//      }
//      param.setData(knownDevices.getBytes());
//      sendCommand((Writable)conn, outCommand);
//    } else if (command.getID().equals("get OW server")) {
//      Command outCommand = getProtocolHandler().findCommand("OW server address");
//      Param param = outCommand.findParam("OW server address");
//      param.setData(this.container.getConfigProperty("onewire", "ow_server").getBytes());
//      sendCommand((Writable)conn, outCommand);
//    } else if (command.getID().equals("set update interval")) {
//      Param p = command.findParam("update interval");
//      if ((p == null) || (p.getData() == null)) {
//        Logger.log("Command set update interval has no parameter set.",
//          9, 4);
//        return;
//      }
//      try
//      {
//        ui = Long.parseLong(new String(p.getData()));
//      }
//      catch (Exception e)
//      {
//        long ui;
//        Logger.log("Error while parsing update interval: " + e, 9,
//          4);
//        return;
//      }
//      long ui;
//      if (ui != Long.parseLong(this.container.getConfigProperty("onewire", "device_update_interval"))) {
//        this.container.setConfigProperty("onewire", "device_update_interval", new String(p.getData()));
//        if (this.oneWireController != null)
//          this.oneWireController.setDeviceUpdateInterval(ui);
//      }
//    }
//    else if (command.getID().equals("set known devices")) {
//      Param p = command.findParam("known devices");
//      if ((p == null) || (p.getData() == null)) {
//        Logger.log("Command set known devices has no parameter set.",
//          9, 4);
//        return;
//      }
//      String[] knownDevices = new String(p.getData()).split("\n");
//      addKnownDevices(knownDevices);
//    } else if (command.getID().equals("set OW server")) {
//      Param p = command.findParam("OW server address");
//      if ((p == null) || (p.getData() == null)) {
//        Logger.log("Command set OW server has no parameter set.",
//          9, 4);
//        return;
//      }
//      String owServerAddress = new String(p.getData());
//      this.container.setConfigProperty("onewire", "ow_server", owServerAddress);
//      connectToServer();
//    } else {
//      Logger.log(getName() + " received an unknown command: " + command.getID(), 9, 3);
//    }
//  }
//
//  private void removeOneWireService(String key) {
//    OneWireService service = (OneWireService)this.oneWireServices.get(key);
//    if (service != null) {
//      Logger.log("Removing service: " + key + "...", 9, 2);
//      service.unregister();
//      service.stop();
//      this.oneWireServices.remove(key);
//      Logger.log("Service: " + key + " removed", 9, 2);
//    }
//  }
//
//  private void addOneWireService(String key, OneWireService service) {
//    Logger.log("Adding service: " + key, 9, 2);
//    if (this.onewireServiceGroup == null) {
//      this.onewireServiceGroup = this.container.getAnnouncementManager().registerServiceList("1-wire services",
//        (byte)72);
//    }
//    this.oneWireServices.put(key, service);
//    service.register(this.onewireServiceGroup);
//    service.setStatus((byte)71);
//    service.start();
//  }
//
//  public void update(OneWireEvent e)
//  {
//    if ((e instanceof OneWireDeviceChangedEvent)) {
//      OneWireDeviceChangedEvent event = (OneWireDeviceChangedEvent)e;
//      if (event.getEventType() == 0) {
//        String alias = "";
//        OneWireDevice device = event.getDevice();
//        if ((device instanceof OneWireContainer01)) {
//          OneWireContainer01 ibutton = (OneWireContainer01)device;
//          if (this.ibuttonReaderService == null) {
//            this.ibuttonReaderService = new IButtonReaderService(this.container);
//            if (this.onewireServiceGroup == null) {
//              this.onewireServiceGroup = this.container.getAnnouncementManager().registerServiceList(
//                "1-wire services", (byte)72);
//            }
//            this.ibuttonReaderService.register(this.onewireServiceGroup);
//            this.ibuttonReaderService.setStatus((byte)71);
//            this.ibuttonReaderService.start();
//          }
//          this.ibuttonReaderService.handleDeviceAppeared(ibutton);
//          return;
//        }
//
//        ServiceID serviceId = new ServiceID(this.parentDeviceId, device.getAddress(), this.parentDeviceId,
//          device.getAddress());
//        OneWireService service;
//        OneWireService service;
//        if (device.getAlias() != null) {
//          service = new OneWireService(this.container, serviceId, device.getAlias(), "",
//            this.oneWireController, device);
//        }
//        else
//        {
//          OneWireService service;
//          if (getKnownDevices().containsKey(device.getFamily() + "." + device.getId())) {
//            alias = (String)getKnownDevices().get(device.getFamily() + "." + device.getId());
//            service = new OneWireService(this.container, serviceId, alias, "", this.oneWireController,
//              device);
//          } else {
//            if ((device instanceof OneWireTemperatureContainer)) {
//              alias = alias + "Temperature_" + this.temperatureServiceSeqNbr++;
//            }
//            if ((device instanceof OneWirePressureContainer)) {
//              if (alias.length() > 0)
//                alias = alias + "_Pressure_" + this.pressureServiceSeqNbr++;
//              else {
//                alias = alias + "Pressure_" + this.pressureServiceSeqNbr++;
//              }
//            }
//            if ((device instanceof OneWireHumidityContainer)) {
//              if (alias.length() > 0)
//                alias = alias + "_Humidity_" + this.humidityServiceSeqNbr++;
//              else {
//                alias = alias + "Humidity_" + this.humidityServiceSeqNbr++;
//              }
//            }
//            if ((device instanceof OneWireSwitchContainer)) {
//              if (alias.length() > 0)
//                alias = alias + "_Switch_" + this.switchServiceSeqNbr++;
//              else {
//                alias = alias + "Switch_" + this.switchServiceSeqNbr++;
//              }
//            }
//            if ((device instanceof OneWireVoltageSensorContainer)) {
//              if (alias.length() > 0)
//                alias = alias + "_VoltageSensor_" + this.voltageServiceSeqNbr++;
//              else {
//                alias = alias + "VoltageSensor_" + this.voltageServiceSeqNbr++;
//              }
//            }
//            if (alias.length() == 0) {
//              alias = "Generic_" + this.genericServiceSeqNbr++;
//            }
//            service = new OneWireService(this.container, serviceId, alias, "", this.oneWireController,
//              device);
//          }
//        }
//        addOneWireService(device.getAddress(), service);
//      } else if (event.getEventType() == 1) {
//        OneWireDevice device = event.getDevice();
//        if (((device instanceof OneWireContainer01)) && (this.ibuttonReaderService != null)) {
//          this.ibuttonReaderService.handleDeviceRemoved((OneWireContainer01)device);
//        }
//        if ((device instanceof OneWireTemperatureContainer)) {
//          this.temperatureServiceSeqNbr -= 1;
//        }
//        if ((device instanceof OneWirePressureContainer)) {
//          this.pressureServiceSeqNbr -= 1;
//        }
//        if ((device instanceof OneWireHumidityContainer)) {
//          this.humidityServiceSeqNbr -= 1;
//        }
//        if ((device instanceof OneWireSwitchContainer)) {
//          this.switchServiceSeqNbr -= 1;
//        }
//        removeOneWireService(device.getAddress());
//      }
//    } else if ((e instanceof OneWireValueAlarmEvent)) {
//      OneWireValueAlarmEvent event = (OneWireValueAlarmEvent)e;
//      Logger.log("Got OneWireValueChangedEvent in ControllerService !?: " +
//        event.getFileName() + " " + event.getNewValue(), 9, 3);
//    }
//  }
//}