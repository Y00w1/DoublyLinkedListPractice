module com.example.historical {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.historical to javafx.fxml;
    exports com.example.historical;
}