package com.example.hackathon.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class Websocket {
    @OnMessage
    public String handleMessage(String message) {
        System.out.println("New Text Message Received");
        return message;
    }
}