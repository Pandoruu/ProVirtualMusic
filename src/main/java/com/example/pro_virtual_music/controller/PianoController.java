package com.example.pro_virtual_music.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class PianoController {
/*
    @FXML
    private Button a3;

    @FXML
    private Button a4;

    @FXML
    private Button a5;

    @FXML
    private Button as3;

    @FXML
    private Button as4;

    @FXML
    private Button as5;

    @FXML
    private Button b3;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button c3;

    @FXML
    private Button c4;

    @FXML
    private Button c5;

    @FXML
    private Button cs3;

    @FXML
    private Button cs4;

    @FXML
    private Button cs5;

    @FXML
    private Button d3;

    @FXML
    private Button d4;

    @FXML
    private Button d5;

    @FXML
    private Button ds3;

    @FXML
    private Button ds4;

    @FXML
    private Button ds5;

    @FXML
    private Button e3;

    @FXML
    private Button e4;

    @FXML
    private Button e5;

    @FXML
    private Button f3;

    @FXML
    private Button f4;

    @FXML
    private Button f5;

    @FXML
    private Button fs3;

    @FXML
    private Button fs4;

    @FXML
    private Button fs5;

    @FXML
    private Button g3;

    @FXML
    private Button g4;

    @FXML
    private Button g5;

    @FXML
    private Button gs3;

    @FXML
    private Button gs4;

    @FXML
    private Button gs5;
*/
    @FXML
    void play(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonID = button.getId();
        URL path = this.getClass().getResource("/com/example/pro_virtual_music/Audio/" + buttonID + ".mp3");
        if(path == null){
            System.out.println("File " + buttonID + " not found!");
            return;
        }
        AudioClip note = new AudioClip(path.toString());
        note.play();
    }
}