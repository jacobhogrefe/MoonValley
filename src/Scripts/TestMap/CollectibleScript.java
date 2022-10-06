package Scripts.TestMap;

import Level.ScriptState;
import Scripts.SimpleTextScript;
import java.io.*;
import javax.sound.sampled.*;
import Engine.Config;

public class CollectibleScript extends SimpleTextScript implements LineListener {

    protected File collectible = new File(Config.SOUNDS_PATH + "collectible.wav");
    protected File keyCollectible = new File(Config.SOUNDS_PATH + "keyCollectible.wav");
    protected Clip collectibleClip;
    protected Clip keyCollectibleClip;
    protected String textItem;
    protected boolean playCompleted;
    protected boolean isKeyCollectible;

    public CollectibleScript(String text, boolean isKeyCollectible) {
        super("You have found a " + text + "!");
        textItem = "You have found a " + text + "!";
        this.isKeyCollectible = isKeyCollectible;
    }

    //determines if the playback of the sound has completed
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP) {
            playCompleted = true;
        }
    }

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue(textItem);
        //loads and plays correct audio clip depending on if it is a key collectible or not
        if (isKeyCollectible) {
            try {
                AudioInputStream keyStream = AudioSystem.getAudioInputStream(keyCollectible);
                AudioFormat keyFormat = keyStream.getFormat();
                DataLine.Info keyInfo = new DataLine.Info(Clip.class, keyFormat);
                keyCollectibleClip = (Clip) AudioSystem.getLine(keyInfo);
                keyCollectibleClip.addLineListener(this);
                keyCollectibleClip.open(keyStream);
                keyCollectibleClip.start();
            } catch (Exception e) {
                System.out.println("Sound file not found!!");
            }
        } else {
            try {
                AudioInputStream collectibleStream = AudioSystem.getAudioInputStream(collectible);
                AudioFormat collectibleFormat = collectibleStream.getFormat();
                DataLine.Info collectibleInfo = new DataLine.Info(Clip.class, collectibleFormat);
                collectibleClip = (Clip) AudioSystem.getLine(collectibleInfo);
                collectibleClip.addLineListener(this);
                collectibleClip.open(collectibleStream);
                collectibleClip.start();
            } catch (Exception e) {
                System.out.println("Sound file not found!!");
            }
        }
    }
}
