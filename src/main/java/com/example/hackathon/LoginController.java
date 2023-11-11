package com.example.hackathon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
    public void initialize(){
        tf_username.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    onChatButtonClick();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    protected void onChatButtonClick() throws IOException {
        if(tf_username.getLength() >= 3){
            App.currentUser = tf_username.getText();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main-screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            scene.getStylesheets().add(getClass().getResource("/styling/dracula.css").toExternalForm());

            // Get the stage from a known component
            Stage stage = (Stage) tf_username.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            errorLabel.setText("Your username needs to be greater than 3 characters!");
        }
    }

}