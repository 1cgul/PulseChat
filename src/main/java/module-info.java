module com.example.hackathon {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.websocket.api;
    requires org.java_websocket;


    opens com.example.hackathon to javafx.fxml;
    exports com.example.hackathon;
}