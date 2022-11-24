module com.example.rgrinterface {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rgrinterface to javafx.fxml;
    exports com.example.rgrinterface;
}