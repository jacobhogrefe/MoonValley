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
public class BiomeSpooky extends AbstractLoopingMap {
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
}
