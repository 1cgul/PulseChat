package com.example.hackathon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/styling/dracula.css").toExternalForm());
        stage.setTitle("PulseChat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}