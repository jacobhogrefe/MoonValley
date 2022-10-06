package Scripts.TestMap;

import Scripts.SimpleTextScript;
import Utils.Sound;

public class CollectibleScript extends SimpleTextScript {

    protected Sound keyCollectible = new Sound("keyCollectible.wav", false);
    protected Sound collectible = new Sound("keyCollectible.wav", false);
    protected String textItem;
    protected boolean playCompleted;
    protected boolean isKeyCollectible;

    public CollectibleScript(String text, boolean isKeyCollectible) {
        super("You have found a " + text + "!");
        textItem = "You have found a " + text + "!";
        this.isKeyCollectible = isKeyCollectible;
    }

    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();
        addTextToTextboxQueue(textItem);
        //loads and plays correct audio clip depending on if it is a key collectible or not
        if (isKeyCollectible) {
            keyCollectible.play();
        } else {
            collectible.play();
        }
    }
}
