package com.example.hackathon;

import com.example.hackathon.websocket.MyWebSocketServer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        scene.getStylesheets().add(getClass().getResource("/styling/dracula.css").toExternalForm());
        stage.setTitle("PulseChat");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        int port = 8080; // Set the port number
        MyWebSocketServer server = new MyWebSocketServer(port);
        server.start();
        System.out.println("WebSocket server started on port: " + port);

        launch();
    }
    public static String currentUser;

}