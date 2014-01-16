package gameoflife.model;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

    private Clip sound;
    private String soundPath;

    public String getSoundPath() {
        return soundPath;
    }

    public Sound(String soundPath) {
        this.soundPath = soundPath;
        try {
            sound = AudioSystem.getClip();
            sound.open(AudioSystem.getAudioInputStream(new File(soundPath)));
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
        }
    }

    public void play() {
        sound.start();
    }

    public void loop() {
        sound.loop(Integer.MAX_VALUE);
    }

    public void pause() {
        sound.stop();
    }

    public void reload() {
        sound.close();
        try {
            sound.open(AudioSystem.getAudioInputStream(new File(soundPath)));
            sound.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
        }

    }

    public void changeSound(String soundPath) {
        if (!this.soundPath.equals(soundPath)) {
            sound.close();
            try {
                sound.open(AudioSystem.getAudioInputStream(new File(soundPath)));
                this.soundPath = soundPath;
                sound.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            }
        }
    }
}
