package com.example.hackathon.websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class Websocket extends WebSocketClient {

    public Websocket(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to the server");
    }

    @Override
    public void onMessage(String message) {
        // Handle incoming messages
        System.out.println("Received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Disconnected from the server");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("An error occurred:" + ex.getMessage());
    }
}
