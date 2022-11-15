package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
import Level.MapEntityManager;
import Level.MusicState;
import Maps.AbstractLoopingMap;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Tilesets.BiomeSpookyTilesets;
import Tilesets.CommonTileset;
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
public class BiomeSpooky extends AbstractLoopingMap {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.PUMPKIN;

    public BiomeSpooky() {
        super("Biomes/spooky.txt", new BiomeSpookyTilesets(),4);
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return MapEntityManager.entitymanager.getSavedMap(1);
            case RIGHT:
                return MapEntityManager.entitymanager.getSavedMap(2);
            case TOP:
                return null;
            case BOTTOM:
                return MapEntityManager.entitymanager.getSavedMap(5);
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
    public MusicState getMusicState() {
        return MusicState.SPOOKY;
    }
}