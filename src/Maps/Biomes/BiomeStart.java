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
public class BiomeStart extends AbstractLoopingMap {
    public static final Item REQUIRED_ITEM = null;

    public BiomeStart() {
        super("Biomes/start.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return () -> new BiomeShrooms();
            case RIGHT:
                return () -> new BiomeDesert();
            case TOP:
                return () -> new BiomeSpooky();
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
                return BiomeShrooms.REQUIRED_ITEM;
            case RIGHT:
                return BiomeDesert.REQUIRED_ITEM;
            case TOP:
                return BiomeSpooky.REQUIRED_ITEM;
            case BOTTOM:
                return null;
            default:
                return null;
        }
    }
}
