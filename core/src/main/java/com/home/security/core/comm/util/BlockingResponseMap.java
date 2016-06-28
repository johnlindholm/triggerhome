package com.home.security.core.comm.util;

import com.home.security.core.protocol.message.Request;
import com.home.security.core.protocol.message.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by john on 2015-01-26.
 */
public class BlockingResponseMap {

    private HashMap<UUID, Response> requestIdResponseMap = new HashMap<UUID, Response>();
    private ArrayList<UUID> requestIdRegisteredList = new ArrayList<UUID>();

    public Response getResponse(Request request) {
        //Doesn't need to be threadsafe
        requestIdRegisteredList.add(request.getMessageId());

        synchronized (requestIdResponseMap) {
            while (requestIdResponseMap.get(request.getMessageId()) == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        requestIdRegisteredList.remove(request.getMessageId());
        return requestIdResponseMap.remove(request.getMessageId());
    }

    public Response getResponse(Request request, long timeout) {
        //Doesn't need to be threadsafe
        requestIdRegisteredList.add(request.getMessageId());
        synchronized (requestIdResponseMap) {
            long stopWaiting = System.currentTimeMillis() + timeout;
            while (System.currentTimeMillis() < stopWaiting && requestIdResponseMap.get(request.getMessageId()) == null) {
                try {
                    long timeToWait = stopWaiting - System.currentTimeMillis();
                    if (timeToWait > 0) {
                        wait(timeToWait);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        requestIdRegisteredList.remove(request.getMessageId());
        return requestIdResponseMap.remove(request.getMessageId());
    }

    public boolean isThreadWaiting(Response response) {
        return requestIdRegisteredList.contains(response.getRequestMessageId());
    }

    public void addResponse(Response response) {
        synchronized (requestIdResponseMap) {
            requestIdResponseMap.put(response.getRequestMessageId(), response);
            requestIdResponseMap.notifyAll();
        }
    }
}
