package com.example.hackathon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Button chatBtn;
    @FXML
    private TextField tf_username;

    @FXML
    protected void onChatButtonClick() {

    }

    @FXML
    void Login(ActionEvent event) {
        User userToLogin = new User(tf_username.getText());

    }
}