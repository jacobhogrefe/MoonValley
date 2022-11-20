package Maps.Biomes;

import java.util.ArrayList;
import GameObject.Rectangle;
import Level.Map;
import Level.MusicState;
import Level.Player;
import Level.Trigger;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.SmartMapTeleportScript;
import Tilesets.FalloutTileset;
import Utils.Side;

/**
 * Layout:
 * 
 * +------------+------------+------------+
 * |            |            |            |
 * |  Fallout   <   Spooky   >  Mountains |
 * |            |            |            |
 * +-----^------+-----^------+------^-----+
 * |            |            |            |
 * |  Shrooms   <   Start    >   Desert   |
 * |            |            |            |
 * +------------+------------+------------+
 */
public class BiomeFallout extends Map {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.GAS_MASK;

    public BiomeFallout() {
        super("Biomes/fallout.txt", new FalloutTileset(),1);
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                return Player.MapEntityManager.getSavedMap(4);
            case TOP:
                return null;
            case BOTTOM:
                return Player.MapEntityManager.getSavedMap(3);
            default:
                return null;
        }
    }

    @Override
    public Item getRequiredItem(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                return BiomeSpooky.REQUIRED_ITEM;
            case TOP:
                return null;
            case BOTTOM:
                return BiomeShrooms.REQUIRED_ITEM;
            default:
                return null;
        }
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = super.loadTriggers();
        for (Side edge : Side.values()) {
            Rectangle bounds = edge.getBorderWithWidth(this.getIntersectRectangle(), 16);
            Trigger trigger = new Trigger(
                (int) bounds.getX(),
                (int) bounds.getY(),
                bounds.getWidth(),
                bounds.getHeight(),
                new SmartMapTeleportScript(() -> this.createBorderingMap(edge), edge, this.getRequiredItem(edge))
            );

            triggers.add(trigger);
        }
        return triggers;
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.TOXIC;
    }
}