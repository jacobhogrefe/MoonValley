
package Scripts.TestMap;

import Level.MusicManager;
import Scripts.SimpleTextScript;
import Utils.Sound;

public class CollectibleScript extends SimpleTextScript {

    protected Sound sound;
    protected String textItem;
    protected MusicManager musicManager;

    public CollectibleScript(String text, boolean isKeyCollectible, MusicManager musicManager) {
        super("You have found a " + text + "!");
        textItem = "You have found a " + text + "!";
        this.musicManager = musicManager;
        if (isKeyCollectible) {
            sound = new Sound("keyCollectible.wav", false);
        } else {
            sound = new Sound("collectible.wav", false);
        }
    }

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue(textItem);
        musicManager.getCurrentSound().pause();
        sound.play();
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        sound.close();
        musicManager.getCurrentSound().play();
    }
}