module com.example.colorchooserlab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.colorchooserlab to javafx.fxml;
    exports com.example.colorchooserlab;
}