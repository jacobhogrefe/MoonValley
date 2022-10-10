package Maps.Biomes;

import java.util.function.Supplier;

import Level.Map;
import Maps.AbstractLoopingMap;
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
public class BiomeFallout extends AbstractLoopingMap {
    public BiomeFallout() {
        super("Biomes/fallout.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return null;
            case RIGHT:
                return () -> new BiomeSpooky();
            case TOP:
                return null;
            case BOTTOM:
                return () -> new BiomeShrooms();
            default:
                return null;
        }
    }
}
