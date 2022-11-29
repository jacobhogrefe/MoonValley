package Scripts.BiomeMountains;

import Level.Script;
import Level.ScriptState;
import Level.Trigger;

public class FlagScript extends Script<Trigger> {

    protected String flagToSet;
    protected boolean setFlag;

    public FlagScript(String flagToSet, boolean setFlag) {
        this.flagToSet = flagToSet;
        this.setFlag = setFlag;
    }

    @Override
    protected void setup() {}

    @Override
    protected void cleanup() {}

    @Override
    protected ScriptState execute() {
        if (setFlag) {
            setFlag(flagToSet);
        } else {
            unsetFlag(flagToSet);
        }
        return ScriptState.COMPLETED;
    }
    
}
