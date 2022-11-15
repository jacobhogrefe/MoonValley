package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
import Level.MapEntityManager;
import Level.MusicState;
import Maps.AbstractLoopingMap;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Tilesets.CommonTileset;
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
public class BiomeFallout extends AbstractLoopingMap {
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
                return MapEntityManager.entitymanager.getSavedMap(4);
            case TOP:
                return null;
            case BOTTOM:
                return MapEntityManager.entitymanager.getSavedMap(3);
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
    public MusicState getMusicState() {
        return MusicState.TOXIC;
    }
}