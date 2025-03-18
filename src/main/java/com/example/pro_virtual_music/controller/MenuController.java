package com.example.pro_virtual_music.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private MenuItem drumButton;

    @FXML
    private MenuButton menuButton;

    @FXML
    private MenuItem pianoButton;

    @FXML
    public void onPianoButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/pro_virtual_music/piano-view.fxml"));
            Parent root = loader.load();

            Stage currentStage = (Stage) menuButton.getScene().getWindow();
            currentStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}