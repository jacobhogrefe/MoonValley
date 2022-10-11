package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
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
public class BiomeSpooky extends AbstractLoopingMap {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.PUMPKIN;

    public BiomeSpooky() {
        super("Biomes/spooky.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return () -> new BiomeFallout();
            case RIGHT:
                return () -> new BiomeMountains();
            case TOP:
                return null;
            case BOTTOM:
                return () -> new BiomeStart();
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
}
