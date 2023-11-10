module com.example.hackathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.websocket.api;


    opens com.example.hackathon to javafx.fxml;
    exports com.example.hackathon;
}