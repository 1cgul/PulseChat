package com.example.hackathon.websocket;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;

public class MyWebSocketServer extends WebSocketServer {

    public MyWebSocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        String userJoinedMessage = conn.getRemoteSocketAddress().getAddress().getHostAddress() + " joined the chatroom!";
        broadcast(userJoinedMessage);
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {

    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        for (WebSocket client : getConnections()) {
            client.send(message);
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {

    }

}

