module com.example.loginregister {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.pro_virtual_music to javafx.fxml;
    exports com.example.pro_virtual_music;
    exports com.example.pro_virtual_music.controller;
    opens com.example.pro_virtual_music.controller to javafx.fxml;
}