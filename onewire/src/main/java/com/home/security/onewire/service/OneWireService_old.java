package com.home.security.onewire.service;//package se.lth.cs.palcom.onewire.service;
//
//import ist.palcom.resource.descriptor.Command;
//import ist.palcom.resource.descriptor.Param;
//import ist.palcom.resource.descriptor.ServiceID;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Set;
//import se.lth.cs.palcom.common.NoSuchDeviceException;
//import se.lth.cs.palcom.communication.connection.Connection;
//import se.lth.cs.palcom.communication.connection.DynamicConnection;
//import se.lth.cs.palcom.communication.connection.Readable;
//import se.lth.cs.palcom.communication.connection.Writable;
//import se.lth.cs.palcom.device.AbstractDevice;
//import se.lth.cs.palcom.logging.Logger;
//import se.lth.cs.palcom.onewire.OneWireController;
//import se.lth.cs.palcom.onewire.OneWireEventListener;
//import se.lth.cs.palcom.onewire.container.OneWireDevice;
//import se.lth.cs.palcom.onewire.container.OneWireHumidityContainer;
//import se.lth.cs.palcom.onewire.container.OneWirePressureContainer;
//import se.lth.cs.palcom.onewire.container.OneWireSwitchContainer;
//import se.lth.cs.palcom.onewire.container.OneWireTemperatureContainer;
//import se.lth.cs.palcom.onewire.container.OneWireVoltageSensorContainer;
//import se.lth.cs.palcom.onewire.event.OneWireEvent;
//import se.lth.cs.palcom.onewire.event.OneWireValueAlarmEvent;
//import se.lth.cs.palcom.onewire.util.DoubleStringCompare;
//import se.lth.cs.palcom.onewire.util.OneWireDeviceConstants;
//import se.lth.cs.palcom.service.AbstractSimpleService;
//import se.lth.cs.palcom.service.command.CommandServiceProtocol;
//import se.lth.cs.palcom.service.distribution.UnicastDistribution;
//
//public class OneWireService extends AbstractSimpleService
//  implements OneWireEventListener
//{
//  private static final String COMMAND_IN_ALARM_ONCE_IF_HIGHER_HUMIDITY = "alarm once if humidity is higher";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_HIGHER_PRESSURE = "alarm once if pressure is higher";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_HIGHER_TEMP = "alarm once if temp is higher";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_HIGHER_VOLTAGE = "alarm once if voltage is higher";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_LOWER_HUMIDITY = "alarm once if humidity is lower";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_LOWER_PRESSURE = "alarm once if pressure is lower";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_LOWER_TEMP = "alarm once if temp is lower";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_LOWER_VOLTAGE = "alarm once if voltage is lower";
//  private static final String COMMAND_IN_ALARM_ONCE_IF_SWITCH_ON = "alarm once if switch is on";
//  private static final String COMMAND_IN_CLEAR_ALARM_HUMIDITY = "clear alarm humidity";
//  private static final String COMMAND_IN_CLEAR_ALARM_PRESSURE = "clear alarm pressure";
//  private static final String COMMAND_IN_CLEAR_ALARM_SWITCH = "clear alarm switch";
//  private static final String COMMAND_IN_CLEAR_ALARM_TEMP = "clear alarm temp";
//  private static final String COMMAND_IN_CLEAR_ALARM_VOLTAGE = "clear alarm voltage";
//  private static final String COMMAND_IN_GET_ALARMS_CHANGE_HUMIDITY = "get alarms on changing humidity";
//  private static final String COMMAND_IN_GET_ALARMS_CHANGE_PRESSURE = "get alarms on changing pressure";
//  private static final String COMMAND_IN_GET_ALARMS_CHANGE_TEMP = "get alarms on changing temperature";
//  private static final String COMMAND_IN_GET_ALARMS_CHANGE_VOLTAGE = "get alarms on changed voltage";
//  private static final String COMMAND_IN_GET_ALARMS_DECLINING_HUMIDITY = "get alarms on declining humidity";
//  private static final String COMMAND_IN_GET_ALARMS_DECLINING_PRESSURE = "get alarms on declining pressure";
//  private static final String COMMAND_IN_GET_ALARMS_DECLINING_TEMP = "get alarms on declining temp";
//  private static final String COMMAND_IN_GET_ALARMS_DECLINING_VOLTAGE = "get alarms on declining voltage";
//  private static final String COMMAND_IN_GET_ALARMS_RISING_HUMIDITY = "get alarms on rising humidity";
//  private static final String COMMAND_IN_GET_ALARMS_RISING_PRESSURE = "get alarms on rising pressure";
//  private static final String COMMAND_IN_GET_ALARMS_RISING_TEMP = "get alarms on rising temp";
//  private static final String COMMAND_IN_GET_ALARMS_RISING_VOLTAGE = "get alarms on rising voltage";
//  private static final String COMMAND_IN_GET_HUMIDITY = "get humidity";
//  private static final String COMMAND_IN_GET_PRESSURE = "get pressure";
//  private static final String COMMAND_IN_GET_SWITCH_VALUE = "get switch value";
//  private static final String COMMAND_IN_GET_TEMP = "get temperature";
//  private static final String COMMAND_IN_GET_TEMP_HIGH = "get temperature high";
//  private static final String COMMAND_IN_GET_TEMP_LOW = "get temperature low";
//  private static final String COMMAND_IN_GET_VOLTAGE = "get voltage";
//  private static final String COMMAND_IN_GET_ID = "get id";
//  private static final String COMMAND_IN_GET_TYPE = "get type";
//  private static final String COMMAND_IN_SET_ALARM_CHANGE_HUMIDITY = "set alarm on change humidity";
//  private static final String COMMAND_IN_SET_ALARM_CHANGE_PRESSURE = "set alarm on change pressure";
//  private static final String COMMAND_IN_SET_ALARM_CHANGE_SWITCH = "set alarm on change switch";
//  private static final String COMMAND_IN_SET_ALARM_CHANGE_TEMP = "set alarm on change temp";
//  private static final String COMMAND_IN_SET_ALARM_CHANGE_VOLTAGE = "set alarm on changed voltage";
//  private static final String COMMAND_IN_SET_ALARM_DECLINING_HUMIDITY = "set alarm on declining humidity";
//  private static final String COMMAND_IN_SET_ALARM_DECLINING_PRESSURE = "set alarm on declining pressure";
//  private static final String COMMAND_IN_SET_ALARM_DECLINING_TEMP = "set alarm on declining temp";
//  private static final String COMMAND_IN_SET_ALARM_DECLINING_VOLTAGE = "set alarm on declining voltage";
//  private static final String COMMAND_IN_SET_ALARM_OFF_SWITCH = "set alarm on OFF switch";
//  private static final String COMMAND_IN_SET_ALARM_ON_SWITCH = "set alarm on ON switch";
//  private static final String COMMAND_IN_SET_ALARM_RISING_HUMIDITY = "set alarm on rising humidity";
//  private static final String COMMAND_IN_SET_ALARM_RISING_PRESSURE = "set alarm on rising pressure";
//  private static final String COMMAND_IN_SET_ALARM_RISING_TEMP = "set alarm on rising temp";
//  private static final String COMMAND_IN_SET_ALARM_RISING_VOLTAGE = "set alarm on rising voltage";
//  private static final String COMMAND_IN_SET_TEMP_HIGH = "set temperature high";
//  private static final String COMMAND_IN_SET_TEMP_LOW = "set temperature low";
//  private static final String COMMAND_IN_TURN_ALL_SWITCHES_OFF = "turn all off";
//  private static final String COMMAND_IN_TURN_ALL_SWITCHES_ON = "turn all on";
//  private static final String COMMAND_OUT_ID = "id";
//  private static final String COMMAND_OUT_TYPE = "type";
//  private static final String COMMAND_OUT_ALARM_VOLTAGE_ONCE = "alarm voltage once";
//  private static final String COMMAND_OUT_ALARM_VOLTAGE_CHANGED = "alarm voltage changed";
//  private static final String COMMAND_OUT_ALARM_VOLTAGE_RISING = "alarm voltage rising";
//  private static final String COMMAND_OUT_ALARM_VOLTAGE_DECLINING = "alarm voltage declining";
//  private static final String COMMAND_OUT_ALARM_HUMIDITY_ONCE = "alarm humidity once";
//  private static final String COMMAND_OUT_ALARM_HUMIDITY_RISING = "alarm humidity rising";
//  private static final String COMMAND_OUT_ALARM_HUMIDITY_DECLINING = "alarm humidity declining";
//  private static final String COMMAND_OUT_ALARM_HUMIDITY_CHANGE = "alarm humidity change";
//  private static final String COMMAND_OUT_ALARM_PRESSURE_ONCE = "alarm pressure once";
//  private static final String COMMAND_OUT_ALARM_PRESSURE_RISING = "alarm pressure rising";
//  private static final String COMMAND_OUT_ALARM_PRESSURE_DECLINING = "alarm pressure declining";
//  private static final String COMMAND_OUT_ALARM_PRESSURE_CHANGE = "alarm pressure change";
//  private static final String COMMAND_OUT_ALARM_SWITCH = "alarm switch";
//  private static final String COMMAND_OUT_ALARM_TEMP_ONCE = "alarm temp once";
//  private static final String COMMAND_OUT_ALARM_TEMP_RISING = "alarm temp rising";
//  private static final String COMMAND_OUT_ALARM_TEMP_DECLINING = "alarm temp declining";
//  private static final String COMMAND_OUT_ALARM_TEMP_CHANGE = "alarm temp change";
//  private static final String COMMAND_OUT_ALARMS_HUMIDITY = "humidity alarms";
//  private static final String COMMAND_OUT_ALARMS_PRESSURE = "pressure alarms";
//  private static final String COMMAND_OUT_ALARMS_TEMP = "temp alarms";
//  private static final String COMMAND_OUT_ALARMS_VOLTAGE = "voltage alarms";
//  private static final String COMMAND_OUT_HUMIDITY = "humidity";
//  private static final String COMMAND_OUT_ON_OFF = "on or off";
//  private static final String COMMAND_OUT_PRESSURE = "pressure";
//  private static final String COMMAND_OUT_TEMP = "temperature";
//  private static final String COMMAND_OUT_VOLTAGE = "voltage";
//  private static final String HUMIDITY = "humidity";
//  private static final String PARAM_ALARMS = "alarms";
//  private static final String PARAM_BOUNDRY = "boundry";
//  private static final String PARAM_TEMP = "temp";
//  private static final String PARAM_ID = "id";
//  private static final String PARAM_TYPE = "type";
//  private static final String PARAM_VALUE = "value";
//  private static final String PRESSURE = "pressure";
//  private static final String SWITCH = "switch";
//  private static final String TEMP = "temp";
//  private static final String VOLTAGE = "voltage";
//  private ArrayList<Connection> connections;
//  private HashMap<Integer, Writable> humidityAlarmIdConnMap;
//  private HashMap<Integer, AlarmValue> humidityAlarmsMap;
//  private OneWireController oneWireController;
//  private OneWireDevice owDevice;
//  private HashMap<Integer, Writable> pressureAlarmIdConnMap;
//  private HashMap<Integer, AlarmValue> pressureAlarmsMap;
//  private HashMap<Integer, Writable> switchAlarmIdConnMap;
//  private ArrayList<Integer> switchAlarms;
//  private HashMap<Integer, Writable> tempAlarmIdConnMap;
//  private HashMap<Integer, AlarmValue> tempAlarmsMap;
//  private HashMap<Integer, Writable> voltageAlarmIdConnMap;
//  private HashMap<Integer, AlarmValue> voltageAlarmsMap;
//  private String onewireDeviceId;
//  private String onewireDeviceType;
//
//  public OneWireService(AbstractDevice parentDevice, ServiceID id, String name, String help, OneWireController oneWireController, OneWireDevice owDevice)
//  {
//    super(parentDevice, id, "pCmProtocol", "v0.001", name, "1", help, new UnicastDistribution(false));
//    this.oneWireController = oneWireController;
//    this.owDevice = owDevice;
//    this.onewireDeviceId = (owDevice.getFamily() + "." + owDevice.getId());
//    this.onewireDeviceType = owDevice.getType();
//    this.connections = new ArrayList();
//    createCommands();
//  }
//
//  public void update(OneWireEvent event)
//  {
//    if ((event instanceof OneWireValueAlarmEvent)) {
//      OneWireValueAlarmEvent aEvent = (OneWireValueAlarmEvent)event;
//      Logger.log("OneWireService: received event: file:" + aEvent.getFileName() + ", " +
//        "value:" + aEvent.getNewValue() + ", type:" + aEvent.getAlarmType(),
//        9, 1);
//      if (this.connections.isEmpty()) {
//        return;
//      }
//      if (aEvent.getFileName().equals(OneWireDeviceConstants.FILENAME_HUMIDITY)) {
//        Command command = null;
//        if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_CHANGE)
//          command = getProtocolHandler().findCommand("alarm humidity change",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_DECLINING)
//          command = getProtocolHandler().findCommand("alarm humidity declining",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_RISING) {
//          command = getProtocolHandler().findCommand("alarm humidity rising",
//            "out");
//        }
//        Param param = command.findParam("value");
//        param.setData(aEvent.getNewValue().getBytes());
//        Writable conn = (Writable)this.humidityAlarmIdConnMap.get(Integer.valueOf(aEvent.getId()));
//        sendTo(conn, command);
//      } else if (aEvent.getFileName().equals(OneWireDeviceConstants.FILENAME_PRESSURE)) {
//        Command command = null;
//        if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_CHANGE)
//          command = getProtocolHandler().findCommand("alarm pressure change",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_DECLINING)
//          command = getProtocolHandler().findCommand("alarm pressure declining",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_RISING) {
//          command = getProtocolHandler().findCommand("alarm pressure rising",
//            "out");
//        }
//        Param param = command.findParam("value");
//        param.setData(aEvent.getNewValue().getBytes());
//        Writable conn = (Writable)this.pressureAlarmIdConnMap.get(Integer.valueOf(aEvent.getId()));
//        sendTo(conn, command);
//      } else if (aEvent.getFileName().equals(OneWireDeviceConstants.FILENAME_SWITCH)) {
//        Command command = getProtocolHandler().findCommand("alarm switch",
//          "out");
//        Param param = command.findParam("value");
//        if (aEvent.getNewValue().trim().equals("0"))
//          param.setData("OFF".getBytes());
//        else {
//          param.setData("ON".getBytes());
//        }
//        Writable conn = (Writable)this.switchAlarmIdConnMap.get(Integer.valueOf(aEvent.getId()));
//        sendTo(conn, command);
//      } else if (aEvent.getFileName().equals(OneWireDeviceConstants.FILENAME_TEMPERATURE)) {
//        Command command = null;
//        if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_CHANGE)
//          command = getProtocolHandler().findCommand("alarm temp change",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_DECLINING)
//          command = getProtocolHandler().findCommand("alarm temp declining",
//            "out");
//        else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_RISING) {
//          command = getProtocolHandler().findCommand("alarm temp rising",
//            "out");
//        }
//        Param param = command.findParam("value");
//        param.setData(aEvent.getNewValue().getBytes());
//        Writable conn = (Writable)this.tempAlarmIdConnMap.get(Integer.valueOf(aEvent.getId()));
//        sendTo(conn, command);
//      } else if (aEvent.getFileName().equals(OneWireDeviceConstants.FILENAME_VOLTAGE)) {
//        Command command = null;
//        if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_RISING) {
//          command = getProtocolHandler().findCommand("alarm voltage rising",
//            "out");
//          Param param = command.findParam("value");
//          param.setData(aEvent.getNewValue().getBytes());
//        } else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_DECLINING) {
//          command = getProtocolHandler().findCommand("alarm voltage declining",
//            "out");
//          Param param = command.findParam("value");
//          param.setData(aEvent.getNewValue().getBytes());
//        } else if (aEvent.getAlarmType() == OneWireValueAlarmEvent.ON_CHANGE) {
//          command = getProtocolHandler().findCommand("alarm voltage changed",
//            "out");
//          Param param = command.findParam("value");
//          param.setData(aEvent.getNewValue().getBytes());
//        }
//        Writable conn = (Writable)this.voltageAlarmIdConnMap.get(Integer.valueOf(aEvent.getId()));
//        sendTo(conn, command);
//      }
//    }
//  }
//
//  private void createCommand(String name, String help, String[] params, String direction) {
//    Command command = new Command(name, help, direction);
//    if ((params != null) && (params.length > 0)) {
//      for (int i = 0; i < params.length; i++) {
//        Param param = new Param(params[i], "text/plain");
//        command.addParam(param);
//      }
//    }
//    getProtocolHandler().addCommand(command);
//  }
//
//  private void createCommands() {
//    createCommand("get id", "", null, "in");
//    createCommand("get type", "", null, "in");
//    createCommand("id", "", new String[] { "id" }, "out");
//    createCommand("type", "", new String[] { "type" }, "out");
//    if ((this.owDevice instanceof OneWireTemperatureContainer)) {
//      this.tempAlarmsMap = new HashMap();
//      this.tempAlarmIdConnMap = new HashMap();
//      String alarmHelp = "Register for alarms on a sensor. The parameter is <rising | declining> <alarm temp>. For example \"r 100\" will alarm when temperature rises to 100 degrees centigrade. \"declining\"=\"d\"";
//
//      createCommand("set alarm on rising temp", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on declining temp", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on change temp", alarmHelp, null, "in");
//      createCommand("alarm temp once", "the current temperature", new String[] { "value" },
//        "out");
//      createCommand("alarm temp rising", "the current temperature", new String[] { "value" },
//        "out");
//      createCommand("alarm temp declining", "the current temperature", new String[] { "value" },
//        "out");
//      createCommand("alarm temp change", "the current temperature", new String[] { "value" },
//        "out");
//      createCommand("clear alarm temp", "clears all temp alarms", null, "in");
//      createCommand("temperature", "returns the temperature value read",
//        new String[] { "value" }, "out");
//      createCommand("get temperature", "returns a command with the temperature in C", null,
//        "in");
//      createCommand("get alarms on rising temp", "returns the alarms set", null,
//        "in");
//      createCommand("get alarms on declining temp", "returns the alarms set", null,
//        "in");
//      createCommand("temp alarms", "the alarms set", new String[] { "alarms" },
//        "out");
//      createCommand("alarm once if temp is higher",
//        "triggers an alarm if the current temp is higher then the given",
//        new String[] { "value" }, "in");
//      createCommand("alarm once if temp is lower",
//        "triggers an alarm if the current temp is lower then the given",
//        new String[] { "value" }, "in");
//      if (((OneWireTemperatureContainer)this.owDevice).hasTemperatureResolution()) {
//        createCommand("get temperature low", "returns a command with the temperature in C", null,
//          "in");
//        createCommand("get temperature high", "returns a command with the temperature in C", null,
//          "in");
//        createCommand("set temperature low", "sets the minimum temperature",
//          new String[] { "temp" }, "in");
//        createCommand("set temperature high", "sets the maximum temperature",
//          new String[] { "temp" }, "in");
//      }
//    }
//    if ((this.owDevice instanceof OneWirePressureContainer)) {
//      this.pressureAlarmsMap = new HashMap();
//      this.pressureAlarmIdConnMap = new HashMap();
//      String alarmHelp = "Register for alarms on a sensor. The parameter is <rising | declining> <pressure>. For example \"r 1000\" will alarm when pressure rises to 1000 milli bar. \"declining\"=\"d\"";
//
//      createCommand("set alarm on rising pressure", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on declining pressure", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on change pressure", alarmHelp, null, "in");
//      createCommand("alarm pressure once", "the current pressure", new String[] { "value" },
//        "out");
//      createCommand("alarm pressure rising", "the current pressure", new String[] { "value" },
//        "out");
//      createCommand("alarm pressure declining", "the current pressure", new String[] { "value" },
//        "out");
//      createCommand("alarm pressure change", "the current pressure", new String[] { "value" },
//        "out");
//      createCommand("clear alarm pressure", "clears all pressure alarms", null,
//        "in");
//      createCommand("pressure", "returns the pressure value read",
//        new String[] { "value" }, "out");
//      createCommand("get pressure", "returns a command with the pressure in mbar", null,
//        "in");
//      createCommand("get alarms on rising pressure", "returns the alarms set", null,
//        "in");
//      createCommand("get alarms on declining pressure", "returns the alarms set", null,
//        "in");
//      createCommand("pressure alarms", "the alarms set", new String[] { "alarms" },
//        "out");
//      createCommand("alarm once if pressure is higher",
//        "triggers an alarm if the current pressure is higher then the given",
//        new String[] { "value" }, "in");
//      createCommand("alarm once if pressure is lower",
//        "triggers an alarm if the current pressure is lower then the given",
//        new String[] { "value" }, "in");
//    }
//    if ((this.owDevice instanceof OneWireHumidityContainer)) {
//      this.humidityAlarmsMap = new HashMap();
//      this.humidityAlarmIdConnMap = new HashMap();
//      String alarmHelp = "Register for alarms on a sensor. The parameter is <rising | declining> <alarm temp>. For example \"r 80\" will alarm when temperature rises to 80% relative humidity. \"declining\"=\"d\"";
//
//      createCommand("set alarm on rising humidity", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on declining humidity", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on change humidity", alarmHelp, null, "in");
//      createCommand("alarm humidity once", "the current relative humidity",
//        new String[] { "value" }, "out");
//      createCommand("alarm humidity rising", "the current relative humidity",
//        new String[] { "value" }, "out");
//      createCommand("alarm humidity declining", "the current relative humidity",
//        new String[] { "value" }, "out");
//      createCommand("alarm humidity change", "the current relative humidity",
//        new String[] { "value" }, "out");
//      createCommand("clear alarm humidity", "clears all humidity alarms", null,
//        "in");
//      createCommand("humidity", "returns the humidity value read",
//        new String[] { "value" }, "out");
//      createCommand("get humidity", "returns a command with the relative humidity", null,
//        "in");
//      createCommand("get alarms on rising humidity", "returns the alarms set", null,
//        "in");
//      createCommand("get alarms on declining humidity", "returns the alarms set", null,
//        "in");
//      createCommand("humidity alarms", "the alarms set", new String[] { "alarms" },
//        "out");
//      createCommand("alarm once if humidity is higher",
//        "triggers an alarm if the current humidity is higher then the given",
//        new String[] { "value" }, "in");
//      createCommand("alarm once if humidity is lower",
//        "triggers an alarm if the current humidity is lower then the given",
//        new String[] { "value" }, "in");
//    }
//    if ((this.owDevice instanceof OneWireSwitchContainer)) {
//      this.switchAlarms = new ArrayList();
//      this.switchAlarmIdConnMap = new HashMap();
//      String alarmHelp = "Register for alarms on a sensor. ";
//      createCommand("set alarm on ON switch", alarmHelp, null, "in");
//      createCommand("set alarm on OFF switch", alarmHelp, null, "in");
//      createCommand("set alarm on change switch", alarmHelp, null, "in");
//      createCommand("alarm switch", "the current value", new String[] { "value" },
//        "out");
//      createCommand("clear alarm switch", "removes existing switch alarm", null,
//        "in");
//      createCommand("get switch value", "returns the value read", null, "in");
//      createCommand("on or off", "the value ON or OFF", new String[] { "value" },
//        "out");
//      createCommand("alarm once if switch is on", "triggers an alarm if the switch is on", null,
//        "in");
//      createCommand("turn all on", "turns on all IO", null, "in");
//      createCommand("turn all off", "turns off all IO", null, "in");
//    }
//    if ((this.owDevice instanceof OneWireVoltageSensorContainer)) {
//      this.voltageAlarmsMap = new HashMap();
//      this.voltageAlarmIdConnMap = new HashMap();
//      String alarmHelp = "Register for alarms on a sensor. The parameter is <rising | declining> <alarm voltage>. For example \"r 3.5\" will alarm when voltage rises to 3.5. \"declining\"=\"d\"";
//
//      createCommand("set alarm on rising voltage", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on declining voltage", alarmHelp, new String[] { "boundry" },
//        "in");
//      createCommand("set alarm on changed voltage", alarmHelp, null, "in");
//      createCommand("alarm voltage once", "the current voltage",
//        new String[] { "value" }, "out");
//      createCommand("alarm voltage rising", "the current voltage",
//        new String[] { "value" }, "out");
//      createCommand("alarm voltage declining", "the current voltage",
//        new String[] { "value" }, "out");
//      createCommand("alarm voltage changed", "the current voltage",
//        new String[] { "value" }, "out");
//
//      createCommand("clear alarm voltage", "clears all voltage alarms", null,
//        "in");
//      createCommand("voltage", "returns the voltage value read",
//        new String[] { "value" }, "out");
//      createCommand("get voltage", "returns a command with the voltage", null,
//        "in");
//      createCommand("get alarms on rising voltage", "returns the alarms set", null,
//        "in");
//      createCommand("get alarms on declining voltage", "returns the alarms set", null,
//        "in");
//      createCommand("voltage alarms", "the alarms set", new String[] { "alarms" },
//        "out");
//      createCommand("alarm once if voltage is higher",
//        "triggers an alarm if the current voltage is higher then the given",
//        new String[] { "value" }, "in");
//      createCommand("alarm once if voltage is lower",
//        "triggers an alarm if the current voltage is lower then the given",
//        new String[] { "value" }, "in");
//    }
//  }
//
//  private ArrayList<String> getBoundryValues(String sensorType, int alarmType) {
//    Collection collection = null;
//    if (sensorType.equals("humidity"))
//      collection = this.humidityAlarmsMap.values();
//    else if (sensorType.equals("pressure"))
//      collection = this.pressureAlarmsMap.values();
//    else if (sensorType.equals("temp"))
//      collection = this.tempAlarmsMap.values();
//    else if (sensorType.equals("voltage"))
//      collection = this.voltageAlarmsMap.values();
//    else {
//      return null;
//    }
//    ArrayList boundries = new ArrayList();
//    Iterator itr = collection.iterator();
//    while (itr.hasNext()) {
//      AlarmValue value = (AlarmValue)itr.next();
//      if (value.type == alarmType) {
//        boundries.add(value.boundry);
//      }
//    }
//    return boundries;
//  }
//
//  private void registerForAlarm(Command inCommand, String fileName, int cond, String sensorType, Writable connection)
//  {
//    int type = -1;
//    String boundryStr = null;
//    if (cond == OneWireValueAlarmEvent.ON_RISING) {
//      if (inCommand.getID().equals("set alarm on ON switch")) {
//        boundryStr = "1";
//      } else {
//        Param p = inCommand.findParam("boundry");
//        boundryStr = new String(p.getData()).trim();
//      }
//      type = OneWireValueAlarmEvent.ON_RISING;
//    } else if (cond == OneWireValueAlarmEvent.ON_DECLINING) {
//      if (inCommand.getID().equals("set alarm on OFF switch")) {
//        boundryStr = "0";
//      } else {
//        Param p = inCommand.findParam("boundry");
//        boundryStr = new String(p.getData()).trim();
//      }
//      type = OneWireValueAlarmEvent.ON_DECLINING;
//    } else if (cond == OneWireValueAlarmEvent.ON_CHANGE) {
//      type = OneWireValueAlarmEvent.ON_CHANGE;
//    } else {
//      Logger.log("Unknown alarm type: " + cond, 9, 3);
//      return;
//    }
//    int id = this.oneWireController.registerForAlarm(this, this.owDevice, fileName, type, boundryStr);
//    if (sensorType.equals("humidity")) {
//      this.humidityAlarmsMap.put(Integer.valueOf(id), new AlarmValue(type, boundryStr));
//      this.humidityAlarmIdConnMap.put(Integer.valueOf(id), connection);
//    } else if (sensorType.equals("pressure")) {
//      this.pressureAlarmsMap.put(Integer.valueOf(id), new AlarmValue(type, boundryStr));
//      this.pressureAlarmIdConnMap.put(Integer.valueOf(id), connection);
//    } else if (sensorType.equals("temp")) {
//      this.tempAlarmsMap.put(Integer.valueOf(id), new AlarmValue(type, boundryStr));
//      this.tempAlarmIdConnMap.put(Integer.valueOf(id), connection);
//    } else if (sensorType.equals("switch")) {
//      this.switchAlarms.add(Integer.valueOf(id));
//      this.switchAlarmIdConnMap.put(Integer.valueOf(id), connection);
//    } else if (sensorType.equals("voltage")) {
//      this.voltageAlarmsMap.put(Integer.valueOf(id), new AlarmValue(type, boundryStr));
//      this.voltageAlarmIdConnMap.put(Integer.valueOf(id), connection);
//    }
//  }
//
//  private void removeAllAlarms(String sensorType) {
//    Set ids = null;
//    String fileName = null;
//    if (sensorType.equals("humidity")) {
//      ids = this.humidityAlarmsMap.keySet();
//      fileName = OneWireDeviceConstants.FILENAME_HUMIDITY;
//      Iterator itr = ids.iterator();
//      while (itr.hasNext()) {
//        this.oneWireController.unregisterAlarm(this, this.owDevice, fileName, ((Integer)itr.next()).intValue());
//      }
//      this.humidityAlarmsMap.clear();
//      this.humidityAlarmIdConnMap.clear();
//    } else if (sensorType.equals("pressure")) {
//      ids = this.pressureAlarmsMap.keySet();
//      fileName = OneWireDeviceConstants.FILENAME_PRESSURE;
//      Iterator itr = ids.iterator();
//      while (itr.hasNext()) {
//        this.oneWireController.unregisterAlarm(this, this.owDevice, fileName, ((Integer)itr.next()).intValue());
//      }
//      this.pressureAlarmsMap.clear();
//      this.pressureAlarmIdConnMap.clear();
//    } else if (sensorType.equals("temp")) {
//      ids = this.tempAlarmsMap.keySet();
//      fileName = OneWireDeviceConstants.FILENAME_TEMPERATURE;
//      Iterator itr = ids.iterator();
//      while (itr.hasNext()) {
//        this.oneWireController.unregisterAlarm(this, this.owDevice, fileName, ((Integer)itr.next()).intValue());
//      }
//      this.tempAlarmsMap.clear();
//      this.tempAlarmIdConnMap.clear();
//    } else if (sensorType.equals("voltage")) {
//      ids = this.voltageAlarmsMap.keySet();
//      fileName = OneWireDeviceConstants.FILENAME_VOLTAGE;
//      Iterator itr = ids.iterator();
//      while (itr.hasNext()) {
//        this.oneWireController.unregisterAlarm(this, this.owDevice, fileName, ((Integer)itr.next()).intValue());
//      }
//      this.voltageAlarmsMap.clear();
//      this.voltageAlarmIdConnMap.clear();
//    } else if (sensorType.equals("switch")) {
//      fileName = OneWireDeviceConstants.FILENAME_SWITCH;
//      for (int i = 0; i < this.switchAlarms.size(); i++) {
//        int id = ((Integer)this.switchAlarms.get(i)).intValue();
//        this.oneWireController.unregisterAlarm(this, this.owDevice, fileName, id);
//      }
//      this.switchAlarms.clear();
//      this.switchAlarmIdConnMap.clear();
//    }
//  }
//
//  protected void connectionAccepted(Connection conn) {
//    Logger.log(getName() + " connectionAccepted", 9, 1);
//    conn = (DynamicConnection)conn;
//  }
//
//  protected void connectionClosed(Connection conn) {
//    Logger.log(getName() + " connectionClosed", 9, 1);
//  }
//
//  protected void connectionRequested(DynamicConnection conn) {
//    Logger.log(getName() + " connectionRequested", 9, 1);
//    try {
//      conn.accept();
//      this.connections.add(conn);
//    } catch (IllegalStateException e) {
//      Logger.log("Unable to accept requested connection because of an invalid connection state",
//        9, 4);
//    } catch (NoSuchDeviceException e) {
//      Logger.log("Device disappeared while accepting connection", 9,
//        3);
//    } catch (IOException e) {
//      Logger.log("IOException while accepting connection", 9, 4);
//    }
//  }
//
//  protected void invoked(Readable connection, Command inCommand)
//  {
//    Logger.log(getName() + ": received command: " + inCommand.getID(), 9, 1);
//    if ("get id".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("id", "out");
//      Param p = outCommand.findParam("id");
//      p.setData(this.onewireDeviceId.getBytes());
//      sendTo((Writable)connection, outCommand);
//    } else if ("get type".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("type", "out");
//      Param p = outCommand.findParam("type");
//      p.setData(this.onewireDeviceType.getBytes());
//      sendTo((Writable)connection, outCommand);
//    } else if ("get temperature".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("temperature", "out");
//      Param p = outCommand.findParam("value");
//      try {
//        p.setData(((OneWireTemperatureContainer)this.owDevice).getTemperature().getBytes());
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      sendTo((Writable)connection, outCommand);
//    } else if ("get temperature low".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("temperature", "out");
//      Param p = outCommand.findParam("value");
//      try {
//        p.setData(((OneWireTemperatureContainer)this.owDevice).getTemperatureLow().getBytes());
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      sendTo((Writable)connection, outCommand);
//    } else if ("get temperature high".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("temperature", "out");
//      Param p = outCommand.findParam("value");
//      try {
//        p.setData(((OneWireTemperatureContainer)this.owDevice).getTemperatureHigh().getBytes());
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      sendTo((Writable)connection, outCommand);
//    } else if ("set temperature low".equals(inCommand.getID())) {
//      Param inParam = inCommand.findParam("temp");
//      String temp = new String(inParam.getData());
//      try {
//        ((OneWireTemperatureContainer)this.owDevice).setTemperatureLow(temp);
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//    } else if ("set temperature high".equals(inCommand.getID())) {
//      Param inParam = inCommand.findParam("temp");
//      String temp = new String(inParam.getData());
//      try {
//        ((OneWireTemperatureContainer)this.owDevice).setTemperatureHigh(temp);
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//    } else if ("get pressure".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler()
//        .findCommand("pressure", "out");
//      Param p = outCommand.findParam("value");
//      try {
//        p.setData(((OneWirePressureContainer)this.owDevice).getPressure().getBytes());
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      sendTo((Writable)connection, outCommand);
//    } else if ("get humidity".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler()
//        .findCommand("humidity", "out");
//      Param p = outCommand.findParam("value");
//      try {
//        p.setData(((OneWireHumidityContainer)this.owDevice).getHumidity().getBytes());
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      sendTo((Writable)connection, outCommand);
//    } else if ("get switch value".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("on or off", "out");
//      Param p = outCommand.findParam("value");
//      String response = null;
//      try {
//        if (((OneWireSwitchContainer)this.owDevice).isOn())
//          response = "ON";
//        else
//          response = "OFF";
//      }
//      catch (IOException e)
//      {
//        e.printStackTrace();
//      }
//      p.setData(response.getBytes());
//      sendTo((Writable)connection, outCommand);
//    } else if ("set alarm on change humidity".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_HUMIDITY,
//        OneWireValueAlarmEvent.ON_CHANGE, "humidity", (Writable)connection);
//    } else if ("set alarm on change pressure".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_PRESSURE,
//        OneWireValueAlarmEvent.ON_CHANGE, "pressure", (Writable)connection);
//    } else if ("set alarm on change switch".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_SWITCH,
//        OneWireValueAlarmEvent.ON_CHANGE, "switch", (Writable)connection);
//    } else if ("set alarm on change temp".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_TEMPERATURE,
//        OneWireValueAlarmEvent.ON_CHANGE, "temp", (Writable)connection);
//    } else if ("set alarm on declining humidity".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_HUMIDITY,
//        OneWireValueAlarmEvent.ON_DECLINING, "humidity", (Writable)connection);
//    } else if ("set alarm on declining pressure".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_PRESSURE,
//        OneWireValueAlarmEvent.ON_DECLINING, "pressure", (Writable)connection);
//    } else if ("set alarm on declining temp".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_TEMPERATURE,
//        OneWireValueAlarmEvent.ON_DECLINING, "temp", (Writable)connection);
//    } else if ("set alarm on OFF switch".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_SWITCH,
//        OneWireValueAlarmEvent.ON_DECLINING, "switch", (Writable)connection);
//    } else if ("set alarm on ON switch".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_SWITCH,
//        OneWireValueAlarmEvent.ON_RISING, "switch", (Writable)connection);
//    } else if ("set alarm on rising humidity".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_HUMIDITY,
//        OneWireValueAlarmEvent.ON_RISING, "humidity", (Writable)connection);
//    } else if ("set alarm on rising pressure".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_PRESSURE,
//        OneWireValueAlarmEvent.ON_RISING, "pressure", (Writable)connection);
//    } else if ("set alarm on rising temp".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_TEMPERATURE,
//        OneWireValueAlarmEvent.ON_RISING, "temp", (Writable)connection);
//    } else if ("clear alarm humidity".equals(inCommand.getID())) {
//      removeAllAlarms("humidity");
//    } else if ("clear alarm pressure".equals(inCommand.getID())) {
//      removeAllAlarms("pressure");
//    } else if ("clear alarm switch".equals(inCommand.getID())) {
//      removeAllAlarms("switch");
//    } else if ("clear alarm temp".equals(inCommand.getID())) {
//      removeAllAlarms("temp");
//    } else if ("get alarms on declining humidity".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("humidity", OneWireValueAlarmEvent.ON_DECLINING);
//      Command out = getProtocolHandler().findCommand("humidity alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on rising humidity".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("humidity", OneWireValueAlarmEvent.ON_RISING);
//      Command out = getProtocolHandler().findCommand("humidity alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on declining pressure".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("pressure", OneWireValueAlarmEvent.ON_DECLINING);
//      Command out = getProtocolHandler().findCommand("pressure alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on rising pressure".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("pressure", OneWireValueAlarmEvent.ON_RISING);
//      Command out = getProtocolHandler().findCommand("pressure alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on declining temp".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("temp", OneWireValueAlarmEvent.ON_DECLINING);
//      Command out = getProtocolHandler().findCommand("temp alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on rising temp".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("temp", OneWireValueAlarmEvent.ON_RISING);
//      Command out = getProtocolHandler().findCommand("temp alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on changing humidity".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("humidity", OneWireValueAlarmEvent.ON_CHANGE);
//      Command out = getProtocolHandler().findCommand("humidity alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on changing pressure".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("temp", OneWireValueAlarmEvent.ON_CHANGE);
//      Command out = getProtocolHandler().findCommand("pressure alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on changing temperature".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("temp", OneWireValueAlarmEvent.ON_CHANGE);
//      Command out = getProtocolHandler().findCommand("temp alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("alarm once if temp is higher".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String temp = null;
//      try {
//        temp = ((OneWireTemperatureContainer)this.owDevice).getTemperature();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (temp == null) {
//        Logger.log("temp == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(temp, boundry) > 0) {
//        Command out = getProtocolHandler().findCommand("alarm temp once");
//        param = out.findParam("value");
//        param.setData(temp.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if humidity is higher".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String humidity = null;
//      try {
//        humidity = ((OneWireHumidityContainer)this.owDevice).getHumidity();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (humidity == null) {
//        Logger.log("humidity == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(humidity, boundry) > 0) {
//        Command out = getProtocolHandler().findCommand("alarm humidity once");
//        param = out.findParam("value");
//        param.setData(humidity.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if pressure is higher".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String pressure = null;
//      try {
//        pressure = ((OneWirePressureContainer)this.owDevice).getPressure();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (pressure == null) {
//        Logger.log("pressure == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(pressure, boundry) > 0) {
//        Command out = getProtocolHandler().findCommand("alarm pressure once");
//        param = out.findParam("value");
//        param.setData(pressure.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if temp is lower".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String temp = null;
//      try {
//        temp = ((OneWireTemperatureContainer)this.owDevice).getTemperature();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (temp == null) {
//        Logger.log("temp == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(temp, boundry) < 0) {
//        Command out = getProtocolHandler().findCommand("alarm temp once");
//        param = out.findParam("value");
//        param.setData(temp.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if humidity is lower".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String humidity = null;
//      try {
//        humidity = ((OneWireHumidityContainer)this.owDevice).getHumidity();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (humidity == null) {
//        Logger.log("humidity == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(humidity, boundry) < 0) {
//        Command out = getProtocolHandler().findCommand("alarm humidity once");
//        param = out.findParam("value");
//        param.setData(humidity.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if pressure is lower".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String pressure = null;
//      try {
//        pressure = ((OneWirePressureContainer)this.owDevice).getPressure();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (pressure == null) {
//        Logger.log("pressure == null", 9, 3);
//        return;
//      }
//      if (DoubleStringCompare.compare(pressure, boundry) < 0) {
//        Command out = getProtocolHandler().findCommand("alarm pressure once");
//        param = out.findParam("value");
//        param.setData(pressure.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if switch is on".equals(inCommand.getID())) {
//      try {
//        if (!((OneWireSwitchContainer)this.owDevice).isOn()) return;
//        Command out = getProtocolHandler().findCommand("on or off");
//        Param param = out.findParam("value");
//        String ON = "ON";
//        param.setData(ON.getBytes());
//        sendTo((Writable)connection, out);
//      }
//      catch (IOException e)
//      {
//        e.printStackTrace();
//      }
//    } else if ("alarm once if voltage is higher".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String voltage = null;
//      try {
//        voltage = ((OneWireVoltageSensorContainer)this.owDevice).getVoltageAll();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (voltage == null) {
//        Logger.log("voltage == null", 9, 3);
//        return;
//      }
//
//      voltage = voltage.split(",")[0].trim();
//
//      if (DoubleStringCompare.compare(voltage, boundry) > 0) {
//        Command out = getProtocolHandler().findCommand("alarm voltage once");
//        param = out.findParam("value");
//        param.setData(voltage.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("alarm once if voltage is lower".equals(inCommand.getID())) {
//      Param param = inCommand.findParam("value");
//      if (param.getData() == null) {
//        Logger.log("param.getData() == null", 9, 3);
//        return;
//      }
//      String boundry = new String(param.getData());
//      String voltage = null;
//      try {
//        voltage = ((OneWireVoltageSensorContainer)this.owDevice).getVoltageAll();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (voltage == null) {
//        Logger.log("voltage == null", 9, 3);
//        return;
//      }
//
//      voltage = voltage.split(",")[0].trim();
//
//      if (DoubleStringCompare.compare(voltage, boundry) < 0) {
//        Command out = getProtocolHandler().findCommand("alarm voltage once");
//        param = out.findParam("value");
//        param.setData(voltage.getBytes());
//        sendTo((Writable)connection, out);
//      }
//    } else if ("clear alarm voltage".equals(inCommand.getID())) {
//      removeAllAlarms("voltage");
//    } else if ("get alarms on changed voltage".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("voltage", OneWireValueAlarmEvent.ON_CHANGE);
//      Command out = getProtocolHandler().findCommand("voltage alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on declining voltage".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("voltage", OneWireValueAlarmEvent.ON_DECLINING);
//      Command out = getProtocolHandler().findCommand("voltage alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get alarms on rising voltage".equals(inCommand.getID())) {
//      ArrayList alarms = getBoundryValues("voltage", OneWireValueAlarmEvent.ON_RISING);
//      Command out = getProtocolHandler().findCommand("voltage alarms");
//      Param param = out.findParam("alarms");
//      String alarmsStr = "";
//      for (int i = 0; i < alarms.size(); i++) {
//        if (i + 1 < alarms.size())
//          alarmsStr = alarmsStr + (String)alarms.get(i) + ", ";
//        else {
//          alarmsStr = alarmsStr + (String)alarms.get(i);
//        }
//      }
//      param.setData(alarmsStr.getBytes());
//      sendTo((Writable)connection, out);
//    } else if ("get voltage".equals(inCommand.getID())) {
//      Command outCommand = getProtocolHandler().findCommand("voltage", "out");
//      Param p = outCommand.findParam("value");
//      String voltage = null;
//      try {
//        voltage = ((OneWireVoltageSensorContainer)this.owDevice).getVoltageAll();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//      if (voltage == null) {
//        Logger.log("voltage == null", 9, 3);
//        return;
//      }
//
//      voltage = voltage.split(",")[0].trim();
//      p.setData(voltage.getBytes());
//      sendTo((Writable)connection, outCommand);
//    } else if ("set alarm on changed voltage".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_VOLTAGE,
//        OneWireValueAlarmEvent.ON_CHANGE, "voltage", (Writable)connection);
//    } else if ("set alarm on declining voltage".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_VOLTAGE,
//        OneWireValueAlarmEvent.ON_DECLINING, "voltage", (Writable)connection);
//    } else if ("set alarm on rising voltage".equals(inCommand.getID())) {
//      registerForAlarm(inCommand, OneWireDeviceConstants.FILENAME_VOLTAGE,
//        OneWireValueAlarmEvent.ON_RISING, "voltage", (Writable)connection);
//    } else if ("turn all on".equals(inCommand.getID())) {
//      try {
//        ((OneWireSwitchContainer)this.owDevice).turnAllOn();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//    } else if ("turn all off".equals(inCommand.getID())) {
//      try {
//        ((OneWireSwitchContainer)this.owDevice).turnAllOff();
//      }
//      catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }
//
//  private class AlarmValue {
//    String boundry;
//    int type;
//
//    public AlarmValue(int type, String boundry) {
//      this.type = type;
//      this.boundry = boundry;
//    }
//  }
//}