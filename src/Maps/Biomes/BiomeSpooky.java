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
import Tilesets.BiomeSpookyTilesets;
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
public class BiomeSpooky extends Map {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.PUMPKIN;

    public BiomeSpooky() {
        super("Biomes/spooky.txt", new BiomeSpookyTilesets(), 4);
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return Player.MapEntityManager.getSavedMap(1);
            case RIGHT:
                return Player.MapEntityManager.getSavedMap(2);
            case TOP:
                return null;
            case BOTTOM:
                return Player.MapEntityManager.getSavedMap(0);
            default:
                return null;
        }
    }

    @Override
    public Item getRequiredItem(Side edge) {
        switch (edge) {
            case LEFT:
                return BiomeFallout.REQUIRED_ITEM;
            case RIGHT:
                return BiomeMountains.REQUIRED_ITEM;
            case TOP:
                return null;
            case BOTTOM:
                return BiomeStart.REQUIRED_ITEM;
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
        return MusicState.SPOOKY;
    }
}