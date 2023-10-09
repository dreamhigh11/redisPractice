package com.sun.chat.webSocket;


import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class WebSocketServer {

    @OnMessage
    public String onMessage(final String pText) {
        System.out.println(pText);
        return "Re: " + pText;
    }

}
