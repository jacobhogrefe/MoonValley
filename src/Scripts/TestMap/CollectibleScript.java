
package Scripts.TestMap;

import Scripts.SimpleTextScript;
import Utils.Sound;

public class CollectibleScript extends SimpleTextScript {

    protected Sound sound;
    protected String textItem;

    public CollectibleScript(String text, boolean isKeyCollectible) {
        super("You have found a " + text + "!");
        textItem = "You have found a " + text + "!";
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
        getMap().getMusicManager().getCurrentSound().pause();
        sound.play();
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
        sound.close();
        getMap().getMusicManager().getCurrentSound().play();
    }
}