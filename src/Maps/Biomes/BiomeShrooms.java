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
public class BiomeShrooms extends AbstractLoopingMap {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.MAGNIFYING_GLASS;

    public BiomeShrooms() {
        super("Biomes/shrooms.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                return () -> new BiomeStart();
            case TOP:
                return () -> new BiomeFallout();
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
                return BiomeFallout.REQUIRED_ITEM;
            case BOTTOM:
                return null;
            default:
                return null;
        }
    }   

    public MusicState getMusicState() {
        return MusicState.MUSHROOM;
    }
}
