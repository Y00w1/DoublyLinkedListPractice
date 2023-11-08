module com.example.queuestackexamp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.queuestackexamp to javafx.fxml;
    exports com.example.queuestackexamp;
    exports com.example.queuestackexamp.controller;
    opens com.example.queuestackexamp.controller to javafx.fxml;
}