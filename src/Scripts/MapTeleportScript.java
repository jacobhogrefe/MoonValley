package Scripts;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import Game.Game;
import Level.Map;
import Level.Script;
import Level.ScriptState;

/**
 * @author hle0
 * 
 * A Script that teleports a player to another map, optionally at a different X or Y coordinate on another map.
 */
public class MapTeleportScript extends Script {
    public Supplier<Map> mapCreator;
    public OptionalDouble toX;
    public OptionalDouble toY;

    protected Map toMap;

    public MapTeleportScript(Supplier<Map> mapCreator, OptionalDouble toX, OptionalDouble toY) {
        super();

        this.mapCreator = mapCreator;
        this.toX = toX;
        this.toY = toY;
    }

    @Override
    protected void setup() {
        // nothing lol
    }

    @Override
    protected void cleanup() {
        // nothing lol
    }

    protected float getToX() {
        return (float) this.toX.orElse(this.getPlayer().getX());
    }

    protected float getToY() {
        return (float) this.toY.orElse(this.getPlayer().getY());
    }

    @Override
    protected ScriptState execute() {
        this.toMap = this.mapCreator.get();

        if (this.toMap == null)
            return ScriptState.COMPLETED;
        
        Game.getRunningInstance()
            .getScreenCoordinator()
            .getPlayLevelScreen()
            .teleport(
                this.toMap,
                this.getToX(),
                this.getToY()
            );

        return ScriptState.COMPLETED;
    }
}
