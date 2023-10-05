module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires json.simple;
    requires org.apache.commons.lang3;
    requires one.util.streamex;
    opens com.example.demo to javafx.fxml;

    exports com.example.demo;
}