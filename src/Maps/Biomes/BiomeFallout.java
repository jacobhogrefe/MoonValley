package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
import Maps.AbstractLoopingMap;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Tilesets.CommonTileset;
import Tilesets.Tilesets;
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
        super("Biomes/fallout.txt", Tilesets.MINECRAFT_TILESET, null);
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                this.getLevelMusic().pause();
                this.getLevelMusic().restart();
                return () -> new BiomeSpooky();
            case TOP:
                this.getLevelMusic().pause();
                return null;
            case BOTTOM:
                this.getLevelMusic().restart();
                return () -> new BiomeShrooms();
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
}
