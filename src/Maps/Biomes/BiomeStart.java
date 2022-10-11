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
        super("Biomes/start.txt", new CommonTileset(), null);
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                this.getLevelMusic().pause();
                this.getLevelMusic().restart();
                return () -> new BiomeShrooms();
            case RIGHT:
                this.getLevelMusic().pause();
                this.getLevelMusic().restart();
                return () -> new BiomeDesert();
            case TOP:
                this.getLevelMusic().pause();
                this.getLevelMusic().restart();
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
