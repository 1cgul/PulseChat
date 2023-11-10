package com.example.hackathon.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class Websocket {

    // A set to store all the active sessions
    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("New connection opened");
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Connection closed");
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Error occurred: " + throwable.getMessage());
        sessions.remove(session);
    }

    @OnMessage
    public void handleMessage(String message, Session session) {
        System.out.println("New Text Message Received: " + message);
        broadcast(message);
    }

    // Broadcasting the message to all connected sessions
    private void broadcast(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                System.out.println("Failed to send message to session: " + e.getMessage());
            }
        }
    }
}