package Maps.Biomes;

import java.util.ArrayList;
import java.util.function.Supplier;

import Level.Map;
import Level.MusicState;
import Level.NPC;
import Maps.AbstractLoopingMap;
import NPCs.Cattle;
import NPCs.Dinosaur;
import NPCs.Walrus;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.CommonTileset;
import Tilesets.DesertTileset;
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
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.WATER_CANTEEN;

    public BiomeDesert() {
        super("Biomes/desert.txt", new DesertTileset());
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return new BiomeStart();
            case RIGHT:
                return null;
            case TOP:
                return new BiomeMountains();
            case BOTTOM:
                return null;
            default:
                return null;
        }
    }
    
    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Cattle cattle1 = new Cattle(3, getMapTile(10, 10).getLocation());
        npcs.add(cattle1);


        return npcs;
    }

    @Override
    public Item getRequiredItem(Side edge) {
        switch (edge) {
            case LEFT:
                return BiomeStart.REQUIRED_ITEM;
            case RIGHT:
                return null;
            case TOP:
                return BiomeMountains.REQUIRED_ITEM;
            case BOTTOM:
                return null;
            default:
                return null;
        }
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.DESERT;
    }
}