package Utils;

import java.io.File;
import javax.sound.sampled.*;
import Engine.Config;

public class Sound implements LineListener {

    protected boolean playCompleted, doesSoundLoop;
    protected Clip soundClip;

    /* ALL SOUNDS SHOULD BE PLACED IN THE SOUND FOLDER
     * Sound class that does all the heavy work in loading and playing a sound within the game.
     * Contains methods to play, pause, close, and restart the current sound
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
            //System.out.println("Sound file: " + "\"" + soundFileName + "\" was not found!");
        }
    }

    //checks if the current sound playing has stopped
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
        } else if (soundClip != null && doesSoundLoop) {
            soundClip.loop(Clip.LOOP_CONTINUOUSLY);
            soundClip.start();
        }
    }

    //closes the soundclip freeing up memory currently in use by it
    public void close() {
        if (soundClip != null) {
            soundClip.stop();
            soundClip.close();
        }
    }

    //pauses the current sound playing
    public void pause() {
        if (soundClip != null) {
            soundClip.stop();
        }
    }

    //sets the position of the sound to the beginning (useful for looping sounds that need to be restarted)
    public void restart() {
        if (soundClip != null) {
            soundClip.setMicrosecondPosition(0);
        }
    }

    //pauses and retsarts the current sound
    public void stop() {
        if (soundClip != null) {
            soundClip.stop();
            soundClip.setMicrosecondPosition(0);
        }
    }

    //checks if the soundclip is currently playing using the LineListener update method
    public boolean isPlayComplete() {
        return playCompleted;
    }
}
