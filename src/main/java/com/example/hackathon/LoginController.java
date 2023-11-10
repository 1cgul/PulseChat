package com.example.hackathon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameTxt;

    @FXML
    void Login(ActionEvent event) {
        User userToLogin = new User(usernameTxt.getText());
    }

}
