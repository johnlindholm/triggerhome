package com.home.security.core.comm;

import com.home.security.core.comm.assembly.AssemblyManagerService;
import com.home.security.core.comm.connection.BroadCastConnection;
import com.home.security.core.comm.connection.Connection;
import com.home.security.core.comm.connection.LocalConnection;
import com.home.security.core.comm.connection.TCPConnection;
import com.home.security.core.comm.discovery.DiscoveryManagerService;
import com.home.security.core.comm.util.BlockingResponseMap;
import com.home.security.core.protocol.exception.MessageParseException;
import com.home.security.core.protocol.message.*;
import com.home.security.core.protocol.utils.HostNameUtils;
import com.home.security.core.protocol.utils.MessageHelper;
import com.home.security.core.service.*;
import com.home.security.core.utils.HSProperties;
import com.home.security.core.utils.PropertyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by john on 2014-11-22.
 */
public class CommunicationManager {

    public final static int PORT = 5555;
    public final static int BROADCAST_PORT = 5556;
    public final static int HEARTBEAT_INTERVAL_DEFAULT = 5000;
    public final static String PROP_ASSEMBLY_MANAGER_SERVICE_ID = "PROP_ASSEMBLY_MANAGER_SERVICE_ID";
    private final static String PROP_HEARTBEAT_INTERVAL = "PROP_HEARTBEAT_INTERVAL";
    private static Logger logger = LogManager.getLogger(CommunicationManager.class.getName());
    private static InetAddress localAddress;
    private static InetAddress broadcastAddress;
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private ConnectionThread connectionThread;
    private HashMap<InetAddress, Connection> connectionMap = new HashMap<InetAddress, Connection>();
    private Universe universe = Universe.getUniverse();
    private ServiceLoader serviceLoader;
    private ArrayBlockingQueue<Message> outgoingMessageQueue = new ArrayBlockingQueue<Message>(1024);
    private HashMap<InetAddress, IncomingMessageThread> incomingMessageThreadMap = new HashMap<InetAddress, IncomingMessageThread>();
    private OutgoingMessageThread outgoingMessageThread;
    private HSProperties HSProperties;
    private DiscoveryManagerService discoveryManagerService;
    private AssemblyManagerService assemblyManagerService;

    private CommunicationManager() throws UnknownHostException {
        localAddress = HostNameUtils.getLocalHostLANAddress();
        broadcastAddress = HostNameUtils.getLANBroadcastAddress();
        try {
            HSProperties = HSProperties.getInstance();
        } catch (PropertyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        try {
            final CommunicationManager communicationManager = new CommunicationManager();
            final Thread mainThread = Thread.currentThread();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    communicationManager.stop();
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        //Ignore
                    }
                    logger.info("Server.run exiting...");
                }
            });
            communicationManager.start();
        } catch (UnknownHostException e) {
            logger.error("Unable to start server: " + e.getMessage());
            System.exit(1);
        } catch (PropertyException e) {
            logger.error("Unable to start server: " + e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            logger.error("Unable to start server: " + e.getMessage());
            System.exit(1);
        }
    }

    private void startNativeServices() throws IOException {
        try {
            String heartbeatIntervalStr = (String) HSProperties.get(PROP_HEARTBEAT_INTERVAL);
            if (heartbeatIntervalStr == null) {
                HSProperties.put(PROP_HEARTBEAT_INTERVAL, String.valueOf(HEARTBEAT_INTERVAL_DEFAULT));
                heartbeatIntervalStr = String.valueOf(HEARTBEAT_INTERVAL_DEFAULT);
            }
            long heartbeatInterval = Long.valueOf(heartbeatIntervalStr);
            ServiceId discoveryServiceServiceId = new ServiceId(UUID.nameUUIDFromBytes(localAddress.getAddress()));
            discoveryManagerService = DiscoveryManagerService.getInstance(this, discoveryServiceServiceId, heartbeatInterval, HostNameUtils.getLANBroadcastAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        universe.addService(discoveryManagerService);

        String assemblyManagerServiceIdStr = (String) HSProperties.get(PROP_ASSEMBLY_MANAGER_SERVICE_ID);
        ServiceId assemblyManagerServiceId = assemblyManagerServiceIdStr != null ?
                new ServiceId(UUID.fromString(assemblyManagerServiceIdStr)) : new ServiceId(UUID.randomUUID());
        assemblyManagerService = new AssemblyManagerService(this, assemblyManagerServiceId);
        universe.addService(assemblyManagerService);
        discoveryManagerService.start();
    }

    private void start() throws PropertyException, IOException {
        logger.info("Server.start");
        serviceLoader = ServiceLoader.getInstance(this);
        serviceLoader.start();
        serverSocket = new ServerSocket(PORT);
        connectionThread = new ConnectionThread(serverSocket);
        isRunning = true;
        outgoingMessageThread = new OutgoingMessageThread();
        outgoingMessageThread.start();
        connectionThread.start();
        startNativeServices();
    }

    private void stop() {
        logger.debug("Server.stop");
        discoveryManagerService.stop();
        universe.stop();

        logger.debug("Server.stop messages waiting to be sent: " + outgoingMessageQueue.size());
        boolean skipWaiting = false;
        long totTimeSlept = 0;
        while (!skipWaiting && !outgoingMessageQueue.isEmpty() && totTimeSlept < 2000) {
            try {
                logger.debug("Server.stop sleeping 50ms");
                Thread.sleep(50);
                totTimeSlept += 50;
            } catch (InterruptedException e) {
                skipWaiting = true;
            }
        }
        if (outgoingMessageQueue.size() > 0) {
            logger.warn("Server.stop messages skipped: " + outgoingMessageQueue.size());
        }

        serviceLoader.stop();
        isRunning = false;

        try {
            serverSocket.close();
        } catch (IOException e) {
        }
        connectionThread.interrupt();
        try {
            connectionThread.join();
        } catch (InterruptedException e) {
        }
        outgoingMessageThread.interrupt();
        try {
            outgoingMessageThread.join();
        } catch (InterruptedException e) {
        }

        for (Connection connection : connectionMap.values()) {
            connection.closeConnection();
        }
        for (IncomingMessageThread incomingMessageThread : incomingMessageThreadMap.values()) {
            incomingMessageThread.stopRunning();
            incomingMessageThread.interrupt();
            try {
                incomingMessageThread.join();
            } catch (InterruptedException e) {
            }
        }

    }

    private void registerLocalConnection(AbstractService service) {
        LocalConnection connection = new LocalConnection(service);
        connectionMap.put(localAddress, connection);
        IncomingMessageThread incomingMessageThread = new IncomingMessageThread(connection);
        incomingMessageThread.start();
        incomingMessageThreadMap.put(localAddress, incomingMessageThread);
        logger.debug("New local connection registered, service: " + service);
    }

    private void registerBroadcastConnection() throws SocketException, UnknownHostException {
        BroadCastConnection connection = new BroadCastConnection(broadcastAddress, BROADCAST_PORT);
        connectionMap.put(broadcastAddress, connection);
        IncomingMessageThread incomingMessageThread = new IncomingMessageThread(connection);
        incomingMessageThread.start();
        incomingMessageThreadMap.put(broadcastAddress, incomingMessageThread);
        logger.debug("New connection registered: " + broadcastAddress.getHostAddress());
    }

    private void registerRemoteConnection(Socket socket) throws IOException {
        logger.debug("registerRemoteConnection socket: " + socket.getInetAddress().getHostName());

        if (connectionMap.get(socket.getInetAddress()) != null) {
            //Already have a connection to this ip, close old and use new
            Connection connection = connectionMap.get(socket.getInetAddress());
            connection.closeConnection();
            IncomingMessageThread incomingMessageThread = incomingMessageThreadMap.remove(socket.getInetAddress());
            if (incomingMessageThread != null) {
                incomingMessageThread.stopRunning();
                incomingMessageThread.interrupt();
                try {
                    incomingMessageThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        TCPConnection connection = new TCPConnection(socket);
        connectionMap.put(socket.getInetAddress(), connection);
        IncomingMessageThread incomingMessageThread = new IncomingMessageThread(connection);
        incomingMessageThread.start();
        incomingMessageThreadMap.put(socket.getInetAddress(), incomingMessageThread);
        logger.debug("New connection registered: " + socket.getInetAddress().getHostAddress());
    }

    private boolean ensureConnection(Message outgoingMessage) {
        InetAddress destIp = outgoingMessage.getDestIp();
        if (!connectionMap.containsKey(destIp)) {
            //Check if local
            if (destIp.isLoopbackAddress() || destIp.getHostAddress().equals(localAddress.getHostAddress())) {
                ServiceId destServiceId = outgoingMessage.getDestServiceId();
                Service service = universe.getService(destServiceId.id);
                if (service != null) {
                    registerLocalConnection((AbstractService) service);
                } else {
                    logger.warn("Local service not started yet, serviceId: " + destServiceId);
                    return false;
                }
            } else if (destIp.getHostAddress().equals(broadcastAddress.getHostAddress())) {
                try {
                    registerBroadcastConnection();
                } catch (SocketException e) {
                    logger.error(e);
                    return false;
                } catch (UnknownHostException e) {
                    logger.error(e);
                    return false;
                }
            } else {
                try {
                    Socket socket = new Socket(destIp, PORT);
                    registerRemoteConnection(socket);
                } catch (IOException e) {
                    logger.error("Unable to connect to remote ip: " + destIp.getHostAddress());
                    return false;
                }
            }
        }
        return true;
    }

    public void sendNonBlockingMessage(Message message) {
        if (ensureConnection(message)) {
            outgoingMessageQueue.add(message);
        } else {
            logger.warn("Unable to ensure connection to " + message.getDestIp());
        }
    }

    public Response sendBlockingRequest(Request request) {
        if (ensureConnection(request)) {
            outgoingMessageQueue.add(request);
            IncomingMessageThread incomingMessageThread = incomingMessageThreadMap.get(request.getDestIp());
            return incomingMessageThread.getResponse(request);
        } else {
            logger.warn("Unable to ensure connection to " + request.getDestIp());
        }
        return MessageHelper.createErrorResponse("No connection to host!", request);
    }

    public Response sendBlockingRequest(Request request, long timeout) {
        if (ensureConnection(request)) {
            outgoingMessageQueue.add(request);
            IncomingMessageThread incomingMessageThread = incomingMessageThreadMap.get(request.getDestIp());
            return incomingMessageThread.getResponse(request, timeout);
        } else {
            logger.warn("Unable to ensure connection to " + request.getDestIp());
        }
        return MessageHelper.createErrorResponse("No connection to host!", request);
    }

    private class ConnectionThread extends Thread {

        private final ServerSocket serverSocket;

        public ConnectionThread(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        public void run() {
            logger.debug("Listening for connections...");
            while (!isInterrupted() && isRunning) {
                try {
                    Socket socket = serverSocket.accept();
                    registerRemoteConnection(socket);
                } catch (IOException e) {
                    logger.error(e);
                }
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
            }
            logger.debug(getId() + "_ConnectionThread.run exiting");
        }
    }

    private class OutgoingMessageThread extends Thread {
        public void run() {
            while (isRunning && !isInterrupted()) {
                Message message = null;
                try {
                    message = outgoingMessageQueue.take();
                } catch (InterruptedException e) {
                    continue;
                }
                Connection connection = connectionMap.get(message.getDestIp());
                if (connection == null) {
                    logger.error("No connection was found fore message with ip: " + message.getDestIp());
                }
                try {
                    connection.sendMessage(message);
                } catch (IOException e) {
                    logger.error(e);
                } catch (TransformerException e) {
                    logger.error(e);
                } catch (ParserConfigurationException e) {
                    logger.error(e);
                } catch (SAXException e) {
                    logger.error(e);
                }
            }
            logger.debug(getId() + "_OutgoingMessageThread.run exiting...");
        }
    }

    private class IncomingMessageThread extends Thread {

        private final Connection connection;
        private final BlockingResponseMap blockingResponseMap = new BlockingResponseMap();
        private boolean running = false;

        public IncomingMessageThread(Connection connection) {
            this.connection = connection;
        }

        public Response getResponse(Request request) {
            return blockingResponseMap.getResponse(request);
        }

        public Response getResponse(Request request, long timeout) {
            return blockingResponseMap.getResponse(request, timeout);
        }

        public void stopRunning() {
            running = false;
        }

        public void run() {
            running = true;
            while (running && isRunning && !isInterrupted()) {
                Message message = null;
                try {
                    message = connection.receiveMessage();
                } catch (SAXException e) {
                    e.printStackTrace();
                    continue;
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                    continue;
                } catch (MessageParseException e) {
                    e.printStackTrace();
                    continue;
                } catch (IOException e) {
                    if (!connection.isConnected()) {
                        for (Service remoteService : universe.getServices(connection.getAddress())) {
                            universe.removeService(remoteService.getServiceId().id);
                        }
                    }
                    continue;
                } catch (TransformerException e) {
                    e.printStackTrace();
                    continue;
                } catch (PropertyException e) {
                    e.printStackTrace();
                    continue;
                }
                Service service = universe.getService(message.getDestServiceId().id);
                if (message instanceof Request) {
                    Response response;
                    if (service == null) {
                        response = MessageHelper.createErrorResponse("Service not available", (Request) message);
                    } else {
                        response = ((AbstractService) service).handleRequest((Request) message);
                    }
                    try {
                        connection.sendMessage(response);
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (TransformerException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (!connection.isConnected()) {
                            for (Service remoteService : universe.getServices(connection.getAddress())) {
                                universe.removeService(remoteService.getServiceId().id);
                            }
                        }
                    }
                } else if (message instanceof Response) {
                    Response response = (Response) message;
                    if (blockingResponseMap.isThreadWaiting(response)) {
                        blockingResponseMap.addResponse(response);
                    } else if (service != null) {
                        //No thread is waiting for response, ie called sendBlockingRequest()
                        ((AbstractService) service).handleResponse(response);
                    }
                } else if (message instanceof HeartBeat && service instanceof HeartBeatService) {
                    ((HeartBeatService) service).handleHeartbeat((HeartBeat) message);
                } else if (message instanceof HeartAttack && service instanceof HeartBeatService) {
                    ((HeartBeatService) service).handleHeartattack((HeartAttack) message);
                } else if (message instanceof HeartBeat) {
                    discoveryManagerService.handleHeartbeat((HeartBeat) message);
                } else if (message instanceof HeartAttack) {
                    discoveryManagerService.handleHeartattack((HeartAttack) message);
                } else if (message instanceof Ping) {
                    try {
                        connection.sendMessage(new Ping(UUID.randomUUID(), System.currentTimeMillis(), message.getDestIp(), message.getSourceIp()));
                    } catch (ParserConfigurationException e) {
                        e.printStackTrace();
                    } catch (TransformerException e) {
                        e.printStackTrace();
                    } catch (SAXException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (!connection.isConnected()) {
                            for (Service remoteService : universe.getServices(connection.getAddress())) {
                                universe.removeService(remoteService.getServiceId().id);
                            }
                        }
                    }
                }
            }
            logger.debug(getId() + "_IncomingMessageThread.run exiting");
        }
    }
}
