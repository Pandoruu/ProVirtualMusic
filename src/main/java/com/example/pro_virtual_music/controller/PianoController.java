package com.example.pro_virtual_music.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import com.example.pro_virtual_music.Model.*;

public class PianoController {
    @FXML
    private BorderPane borderPane;

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

    private final AudioModel audioModel = new AudioModel();

    @FXML
    public void initialize() {
        Button[] keys = {a3, a4, a5, as3, as4, as5,
                b3, b4, b5, c3, c4, c5,
                cs3, cs4, cs5, d3, d4, d5,
                ds3, ds4, ds5, e3, e4, e5,
                f3, f4, f5, fs3, fs4, fs5,
                g3, g4, g5, gs3, gs4, gs5};

        for (Button key : keys) {
            if (key != null) {
                key.setOnAction(_ -> audioModel.play(key.getId()));
            }
        }

        audioModel.loadSound();
        borderPane.getCenter().setOnKeyPressed(this::keyPress);
    }

    public void keyPress(KeyEvent event) {
        String key = event.getText();
        if(audioModel.soundMap.containsKey(key)) {
            audioModel.soundMap.get(key).play();
        }
    }

}
