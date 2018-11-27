package com.amayadream.webchat.websocket;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * NAME   :  WebChat/com.amayadream.webchat.websocket
 * Author :  Amayadream
 * Date   :  2016.01.12 17:10
 * TODO   :
 */
public class HttpSessionConfigurator extends SpringConfigurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response){
        HttpSession httpSession = (HttpSession)request.getHttpSession();
        config.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
