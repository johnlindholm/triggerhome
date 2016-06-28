package com.home.security.core.service;

import com.home.security.core.protocol.message.HeartAttack;
import com.home.security.core.protocol.message.HeartBeat;

/**
 * Created by john on 2014-12-25.
 */
public interface HeartBeatService {

    public void handleHeartbeat(HeartBeat heartBeat);

    public void handleHeartattack(HeartAttack heartAttack);
}
