package Maps.Biomes;

import java.util.ArrayList;

import Level.Collectible;
import Level.EnhancedMapTile;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Trigger;
import Maps.AbstractLoopingMap;
import NPCs.Mario;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.BiomeMountains.MagicTreeHouse;
import Scripts.BiomeMountains.MarioScript;
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
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return new BiomeSpooky();
            case RIGHT:
                return null;
            case TOP:
                return null;
            case BOTTOM:
                return new BiomeDesert();
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
        Mario mario = new Mario(42, getMapTile(19,18).getLocation());
        mario.setInteractScript(new MarioScript());
        npcs.add(mario);
        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = super.loadTriggers();
        return triggers;
    }


    @Override
    public ArrayList<Collectible> loadCollectables() {
        ArrayList<Collectible> collectibles = new ArrayList<>();
        Collectible nintendoSwitch = new Collectible("nintendoSwitch.png", getMapTile(6,4).getLocation(), "Nintendo Switch", 13, false);
        Collectible ramen = new Collectible("ramen.png", getMapTile(22,17).getLocation(), "Ramen", 12, false);
        Collectible terminal = new Collectible("terminal.png", getMapTile(15,1).getLocation(), "Terminal", 11, false);
        Collectible yoshiCoin = new Collectible("yoshiCoin.png", getMapTile(9,19).getLocation(), "Yoshi Coin", 2, true);
        nintendoSwitch.setExistenceFlag("searchForSwitch");
        ramen.setExistenceFlag("searchForRamen");
        terminal.setExistenceFlag("searchForTerminal");
        yoshiCoin.setExistenceFlag("searchForYoshiCoin");
        collectibles.add(nintendoSwitch);
        collectibles.add(ramen);
        collectibles.add(terminal);
        collectibles.add(yoshiCoin);
        return collectibles;
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.MOUNTAINS;
    }
}