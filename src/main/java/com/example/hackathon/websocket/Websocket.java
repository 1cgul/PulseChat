package com.example.hackathon.websocket;

import com.example.hackathon.User;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Consumer;

public class Websocket extends WebSocketClient {
    private Consumer<User> onUserConnected;
    private Consumer<User> onUserDisconnected;
    public interface MessageHandler {
        void handleMessage(String message);
    }

    public Websocket(String url) throws URISyntaxException {
        super(new URI(url));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to the server");
    }
    private MessageHandler messageHandler;

    public void setMessageHandler(MessageHandler handler) {
        this.messageHandler = handler;
    }

    @Override
    public void onMessage(String message) {
        if (messageHandler != null) {
            messageHandler.handleMessage(message);
        }
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
