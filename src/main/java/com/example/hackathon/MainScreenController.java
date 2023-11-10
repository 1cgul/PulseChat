package com.example.hackathon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class MainScreenController {

    @FXML
    private TextArea chatBox;
    @FXML
    private Button sendBtn;
    @FXML
    private TextField tf_msg;

    private WebSocketClient webSocketClient;

    public MainScreenController() {
        initializeWebSocketClient();
    }

    private void initializeWebSocketClient() {
        try {
            webSocketClient = new WebSocketClient(new URI("ws://localhost:8080/chat")) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("Connected to server");
                }

                @Override
                public void onMessage(String message) {
                    chatBox.appendText("\n" + message);
                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("Disconnected from server");
                }

                @Override
                public void onError(Exception e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }
            };
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sendMessage(javafx.event.ActionEvent event) {
        if (webSocketClient != null && webSocketClient.isOpen()) {
            webSocketClient.send(App.currentUser + ": " + tf_msg.getText());
            tf_msg.setText("");
        } else {
            chatBox.appendText("\nUnable to send message. Not connected to server.");
        }
    }
}
