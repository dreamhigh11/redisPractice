package com.sun.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/test")
    @SendTo("/topic/receiveMessage")
    public String receiveMessage(String message) {
        // Handle the message and return a response.
        return "Received: " + message;
    }
}
