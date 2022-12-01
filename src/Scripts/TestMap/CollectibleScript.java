
package Scripts.TestMap;

import Level.MusicManager;
import Scripts.SimpleTextScript;
import Utils.Sound;

public class CollectibleScript extends SimpleTextScript {

    protected Sound sound;
    protected String textItem;

    public CollectibleScript(String text, boolean isKeyCollectible) {
        super("You have found a " + text + "!");
        textItem = "You have found a " + text + "!";
        sound = MusicManager.getCollectibleSound(isKeyCollectible);
    }

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue(textItem);
        MusicManager.getCurrentSound().pause();
        sound.play();
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        sound.stop();
        MusicManager.getCurrentSound().play();
    }
}