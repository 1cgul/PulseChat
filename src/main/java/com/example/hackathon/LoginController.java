package com.example.hackathon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button chatBtn;
    @FXML
    private TextField tf_username;
    @FXML
    private Label errorLabel;

    @FXML
    protected void onChatButtonClick(ActionEvent event) throws IOException {

        if(tf_username.getLength() >= 3){
            App.currentUser = tf_username.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            scene.getStylesheets().add(getClass().getResource("/styling/dracula.css").toExternalForm());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            errorLabel.setText("Your username needs to be greater than 3 characters!");
        }

    }

    @FXML
    void Login(ActionEvent event) {
        User userToLogin = new User(tf_username.getText());

    }
}