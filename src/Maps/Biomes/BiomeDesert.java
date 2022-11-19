package Maps.Biomes;

import java.util.ArrayList;
import java.util.function.Supplier;

import Level.Map;
import Level.MapEntityManager;
import Level.MusicState;
import Level.NPC;
import Level.Player;
import Maps.AbstractLoopingMap;
import NPCs.Cattle;
import NPCs.Dinosaur;
import NPCs.RanchOwner;
import NPCs.Walrus;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.SimpleTextScript;
import Scripts.DesertMap.EnterSaloonScript;
import Scripts.DesertMap.OwnerScript;
import Scripts.MushroomMap.EnterMushroomHouseScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.EnterDinoHouseScript;
import Scripts.TestMap.EnterHouseScript;
import Scripts.TestMap.EnterWalrusHouseScript;
import Scripts.TestMap.TreeScript;
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
    public static final EnterSaloonScript enterSaloon = new EnterSaloonScript();

    public BiomeDesert() {
        super("Biomes/desert.txt", new DesertTileset(),0);
    }
    
    @Override
    public void loadScripts() {  
        getMapTile(17, 25).setInteractScript(enterSaloon);
        getMapTile(18, 25).setInteractScript(enterSaloon);
    } 

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return Player.MapEntityManager.getSavedMap(5);
            case RIGHT:
                return null;
            case TOP:
                return Player.MapEntityManager.getSavedMap(2);
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
        RanchOwner doug = new RanchOwner(7,getMapTile(5, 20).getLocation());
        doug.setInteractScript(new OwnerScript());
        npcs.add(doug);


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