package Utils;

import java.io.File;
import javax.sound.sampled.*;
import Engine.Config;

public class Sound implements LineListener {

    protected boolean playCompleted, doesSoundLoop;
    protected Clip soundClip;

    /* ALL SOUNDS SHOULD BE PLACED IN THE SOUND FOLDER
     * Sound class that does all the heavy work in loading and playing a sound within the game
     */
    public Sound(String soundFileName, boolean doesSoundLoop) {
        this.doesSoundLoop = doesSoundLoop;
        try {
            File soundFile = new File(Config.SOUNDS_PATH + soundFileName);
            AudioInputStream soundStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat soundFormat = soundStream.getFormat();
            DataLine.Info soundInfo = new DataLine.Info(Clip.class, soundFormat);
            soundClip = (Clip) AudioSystem.getLine(soundInfo);
            soundClip.addLineListener(this);
            soundClip.open(soundStream);
        } catch (Exception e) {
            System.out.println("Sound file: " + "\"" + soundFileName + "\" was not found!");
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP && !doesSoundLoop) {
            playCompleted = true;
        }
    }

    //plays the sound stored in the sound object
    public void play() {
        if (soundClip != null && !doesSoundLoop) {
            soundClip.start();
        } else if (doesSoundLoop) {
            soundClip.loop(Clip.LOOP_CONTINUOUSLY);
            soundClip.start();
        }
    }

    //closes the soundclip freeing up memory currently in use by it
    public void close() {
        if (soundClip != null) {
            soundClip.close();
        }
    }

    //pauses the current sound playing
    public void pause() {
        if (soundClip != null) {
            soundClip.stop();
        }
    }

    //checks if the soundclip is currently playing using the LineListener update method
    public boolean isPlayComplete() {
        return playCompleted;
    }
}
