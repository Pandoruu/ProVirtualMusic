package com.example.pro_virtual_music.Model;

import javafx.scene.media.AudioClip;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AudioModel {

    public AudioModel(){};

    public Map<String, AudioClip> soundMap = new HashMap<>();
    public void loadSound() {
        soundMap.put("q", getAudioClip("c3"));
        soundMap.put("w", getAudioClip("d3"));
        soundMap.put("e", getAudioClip("e3"));
        soundMap.put("r", getAudioClip("f3"));
        soundMap.put("t", getAudioClip("g3"));
        soundMap.put("y", getAudioClip("a3"));
        soundMap.put("u", getAudioClip("b3"));
        soundMap.put("i", getAudioClip("c4"));
        soundMap.put("o", getAudioClip("d4"));
        soundMap.put("p", getAudioClip("e4"));
        soundMap.put("[", getAudioClip("f4"));
        soundMap.put("a", getAudioClip("g4"));
        soundMap.put("s", getAudioClip("a4"));
        soundMap.put("d", getAudioClip("b4"));

        soundMap.put("f", getAudioClip("c5"));
        soundMap.put("g", getAudioClip("d5"));
        soundMap.put("h", getAudioClip("e5"));
        soundMap.put("j", getAudioClip("f5"));
        soundMap.put("k", getAudioClip("g5"));
        soundMap.put("l", getAudioClip("a5"));
        soundMap.put(";", getAudioClip("b5"));

        soundMap.put("'", getAudioClip("cs3"));
        soundMap.put("z", getAudioClip("ds3"));
        soundMap.put("x", getAudioClip("fs3"));
        soundMap.put("c", getAudioClip("gs3"));
        soundMap.put("v", getAudioClip("as3"));

        soundMap.put("b", getAudioClip("cs4"));
        soundMap.put("n", getAudioClip("ds4"));
        soundMap.put("m", getAudioClip("fs4"));
        soundMap.put(",", getAudioClip("gs4"));
        soundMap.put(".", getAudioClip("as4"));

        soundMap.put("1", getAudioClip("cs5"));
        soundMap.put("2", getAudioClip("ds5"));
        soundMap.put("3", getAudioClip("fs5"));
        soundMap.put("4", getAudioClip("gs5"));
        soundMap.put("5", getAudioClip("as5"));
    }

    public void play(String note) {
        AudioClip audioClip = getAudioClip(note);
        audioClip.play();
    }

    public AudioClip getAudioClip(String note) {
        URL path = getClass().getResource("/com/example/pro_virtual_music/Audio/" + note + ".mp3");
        assert path != null;
        return new AudioClip(path.toString());
    }
}
