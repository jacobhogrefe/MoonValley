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
public class BiomeDesert extends AbstractLoopingMap {
    public BiomeDesert() {
        super("Biomes/desert.txt", new CommonTileset());
    }

    @Override
    public Supplier<Map> getBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return () -> new BiomeStart();
            case RIGHT:
                return null;
            case TOP:
                return () -> new BiomeMountains();
            case BOTTOM:
                return null;
            default:
                return null;
        }
    }
}
