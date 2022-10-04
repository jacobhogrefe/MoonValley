package Scripts.TestMap;

import Level.ScriptState;
import Scripts.SimpleTextScript;
import java.io.*;
import javax.sound.sampled.*;
import Engine.Config;

public class CollectibleScript extends SimpleTextScript {

    public CollectibleScript(String text) {
        super("You have found a " + text + "!");
        File soundPath = new File(Config.SOUNDS_PATH + "collectibleSound.wav");
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(soundPath));
            clip.start();
        } catch (Exception e) {
            System.out.println("Sound file not found!!");
        }
    }
    
    
}
