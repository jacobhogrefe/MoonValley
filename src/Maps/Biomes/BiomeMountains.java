package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
import Level.MusicState;
import Maps.AbstractLoopingMap;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
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
public class BiomeMountains extends AbstractLoopingMap {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.GRAPPLING_HOOK;

    public BiomeMountains() {
        super("Biomes/mountains.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return () -> new BiomeSpooky();
            case RIGHT:
                return null;
            case TOP:
                return null;
            case BOTTOM:
                return () -> new BiomeDesert();
            default:
                return null;
        }
    }

    @Override
    public Item getRequiredItem(Side edge) {
        switch (edge) {
            case LEFT:
                return BiomeSpooky.REQUIRED_ITEM;
            case RIGHT:
                return null;
            case TOP:
                return null;
            case BOTTOM:
                return BiomeDesert.REQUIRED_ITEM;
            default:
                return null;
        }
    }

    public MusicState getMusicState() {
        return MusicState.MOUNTAINS;
    }
}