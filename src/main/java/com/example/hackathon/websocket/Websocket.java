package com.example.hackathon.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chat")
public class Websocket {
    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        sendMessageToAll("User connected: " + session.getId());
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        sendMessageToAll(session.getId() + ": " + message);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        sendMessageToAll("User disconnected: " + session.getId());
    }
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
    private void sendMessageToAll(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
