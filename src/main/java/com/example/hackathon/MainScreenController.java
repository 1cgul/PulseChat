package com.example.hackathon;

import com.example.hackathon.websocket.Websocket;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URISyntaxException;

public class MainScreenController {

    @FXML
    private TextArea chatBox;
    @FXML
    private Button sendBtn;
    @FXML
    private TextField tf_msg;
    @FXML
    private TableView tv_userList;

    private Websocket websocketClient;

    @FXML
    public void initialize() {
        tv_userList.setPlaceholder(new Text(""));
        try {
            websocketClient = new Websocket("ws://localhost:8080"); // Replace with your server URL
            websocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        websocketClient.setMessageHandler(this::onMessageReceived);
    }
    private void onMessageReceived(String message) {
        Platform.runLater(() -> {
            chatBox.appendText(message + "\n"); // Assuming chatBox is your TextArea for the chat
        });
    }

    @FXML
    protected void onSendButtonClick() {
        String message = tf_msg.getText(); // Assuming tf_msg is your TextField for input
        if(!message.isEmpty() && websocketClient.isOpen()) { // Check if the client is connected
            websocketClient.send(App.currentUser + ": " + message);
            tf_msg.clear(); // Clear the input field
        }
    }


    private void appendMessage(String message) {
        Platform.runLater(() -> chatBox.appendText(message + "\n"));
    }
}
