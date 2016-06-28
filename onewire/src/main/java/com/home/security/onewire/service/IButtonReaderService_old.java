package com.home.security.onewire.service;//package se.lth.cs.palcom.onewire.service;
//
//import ist.palcom.resource.descriptor.Command;
//import ist.palcom.resource.descriptor.Param;
//import ist.palcom.resource.descriptor.ServiceID;
//import java.io.IOException;
//import se.lth.cs.palcom.common.NoSuchDeviceException;
//import se.lth.cs.palcom.communication.connection.Connection;
//import se.lth.cs.palcom.communication.connection.DynamicConnection;
//import se.lth.cs.palcom.communication.connection.Readable;
//import se.lth.cs.palcom.device.AbstractDevice;
//import se.lth.cs.palcom.logging.Logger;
//import se.lth.cs.palcom.onewire.container.OneWireContainer01;
//import se.lth.cs.palcom.service.AbstractSimpleService;
//import se.lth.cs.palcom.service.command.CommandServiceProtocol;
//import se.lth.cs.palcom.service.distribution.UnicastDistribution;
//
//public class IButtonReaderService extends AbstractSimpleService
//{
//  private static String COM_OUT_DEVICE_APPEARED = "iButton appeared";
//  private static String COM_OUT_DEVICE_REMOVED = "iButton removed";
//  private static String COM_OUT_STATUS = "status";
//
//  private static String PARAM_ID = "id";
//  private static String PARAM_MESSAGE = "message";
//  private static final String STATUS_CONNECTED = "connected to iButton";
//  private static final String STATUS_NOT_CONNECTED = "no iButton connected";
//  private String currentStatus = "no iButton connected";
//
//  public IButtonReaderService(AbstractDevice parentDevice)
//  {
//    super(parentDevice, new ServiceID(parentDevice.getDeviceID(), "ibr", parentDevice.getDeviceID(), "ibr"),
//      "pCmProtocol", "v0.001", "iButtonReader", "1", "", new UnicastDistribution(false));
//    createCommand(COM_OUT_DEVICE_APPEARED, "", new String[] { PARAM_ID }, "out");
//    createCommand(COM_OUT_DEVICE_REMOVED, "", new String[] { PARAM_ID }, "out");
//    createCommand(COM_OUT_STATUS, "", new String[] { PARAM_MESSAGE }, "out");
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
//  public void handleDeviceAppeared(OneWireContainer01 device)
//  {
//    this.currentStatus = "connected to iButton";
//    String id = device.getR_id();
//    Command out = getProtocolHandler().findCommand(COM_OUT_DEVICE_APPEARED, "out");
//    Param param = out.findParam(PARAM_ID);
//    param.setData(id.getBytes());
//    sendToAll(out);
//    out = getProtocolHandler().findCommand(COM_OUT_STATUS, "out");
//    param = out.findParam(PARAM_MESSAGE);
//    param.setData(this.currentStatus.getBytes());
//    sendToAll(out);
//  }
//
//  public void handleDeviceRemoved(OneWireContainer01 device)
//  {
//    this.currentStatus = "no iButton connected";
//    String id = device.getR_id();
//    Command out = getProtocolHandler().findCommand(COM_OUT_DEVICE_REMOVED, "out");
//    Param param = out.findParam(PARAM_ID);
//    param.setData(id.getBytes());
//    sendToAll(out);
//    out = getProtocolHandler().findCommand(COM_OUT_STATUS, "out");
//    param = out.findParam(PARAM_MESSAGE);
//    param.setData(this.currentStatus.getBytes());
//    sendToAll(out);
//  }
//
//  protected void connectionAccepted(Connection conn) {
//    Logger.log(getName() + " connectionAccepted", 9, 1);
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
//  protected void invoked(Readable conn, Command command)
//  {
//    Logger.log(getName() + " received unknown command: " + command.getID(), 9, 3);
//  }
//}