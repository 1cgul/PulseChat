package com.example.hackathon;

import com.example.hackathon.websocket.Websocket;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URISyntaxException;

public class MainScreenController {

    @FXML
    private TextArea chatBox;
    @FXML
    private Button sendBtn;
    @FXML
    private TextField tf_msg;

    private Websocket websocketClient;

    @FXML
    public void initialize() {
        try {
            websocketClient = new Websocket("ws://localhost:8080"); // Replace with your server URL
            websocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSendButtonClick() {
        String message = tf_msg.getText();
        websocketClient.send(message);
        tf_msg.clear();
    }

    private void appendMessage(String message) {
        Platform.runLater(() -> chatBox.appendText(message + "\n"));
    }
}
