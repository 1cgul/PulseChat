package com.example.hackathon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainScreenController {

    @FXML
    private TextArea chatBox;

    @FXML
    private Button sendBtn;

    @FXML
    private TextField tf_msg;

    @FXML
    void sendMessage(ActionEvent event) {
        chatBox.setText(chatBox.getText() + "\n" + App.currentUser + ": " + tf_msg.getText());
        System.out.println(chatBox.getText() + "\n" + App.currentUser + ": " + tf_msg.getText());
        tf_msg.setText("");
    }
}


