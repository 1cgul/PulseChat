module com.example.hackathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires Java.WebSocket;


    opens com.example.hackathon to javafx.fxml;
    exports com.example.hackathon;
}