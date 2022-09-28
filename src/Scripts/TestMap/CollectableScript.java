package Scripts.TestMap;

import Level.ScriptState;
import Scripts.SimpleTextScript;

public class CollectableScript extends SimpleTextScript {

    public CollectableScript(String text) {
        super("You have found a " + text + "!");
    }
}
