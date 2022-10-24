package Maps.Biomes;

import java.util.ArrayList;
import java.util.function.Supplier;

import Level.Collectible;
import Level.EnhancedMapTile;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Trigger;
import Maps.AbstractLoopingMap;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Tilesets.MountainsTileset;
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
        super("Biomes/mountains.txt", new MountainsTileset());
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

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        return triggers;
    }

    @Override
    public ArrayList<Collectible> loadCollectables() {
        ArrayList<Collectible> collectibles = new ArrayList<>();
        return collectibles;
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.MOUNTAINS;
    }
}