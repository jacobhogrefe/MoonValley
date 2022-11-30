package Maps.Biomes;

import java.util.ArrayList;
import GameObject.Rectangle;
import Level.Map;
import Level.MusicState;
import Level.Player;
import Level.Trigger;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.SimpleTextScript;
import Scripts.SmartMapTeleportScript;
import Scripts.MushroomMap.EnterMushroomHouseScript;
import Tilesets.MushroomTileset;
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
public class BiomeShrooms extends Map {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.MAGNIFYING_GLASS;

    public BiomeShrooms() {
        super("mushroom_map.txt", new MushroomTileset(),3);
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                return Player.MapEntityManager.getSavedMap(5);
            case TOP:
                return null;
            case BOTTOM:
                return null;
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
                return BiomeStart.REQUIRED_ITEM;
            case TOP:
                return null;
            case BOTTOM:
                return null;
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
    public void loadScripts() { 
        getMapTile(15, 7).setInteractScript(new EnterMushroomHouseScript());
        getMapTile(12, 12).setInteractScript(new SimpleTextScript("Shiitake's garden of dancing mushrooms."));
        getMapTile(17, 8).setInteractScript(new SimpleTextScript("Shiitake's house"));
    } 
    
    @Override
    public MusicState getMusicState() {
        return MusicState.MUSHROOM;
    }
}