package Maps.Biomes;

import java.util.ArrayList;
import EnhancedMapTiles.Rock;
import GameObject.Rectangle;
import Level.Collectible;
import Level.EnhancedMapTile;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Dinosaur;
import Registry.ItemRegistry.Item;
import Scripts.SimpleTextScript;
import Scripts.SmartMapTeleportScript;
import Scripts.TestMap.DinoScript2;
import Scripts.TestMap.EnterDinoHouseScript;
import Scripts.TestMap.EnterHouseScript;
import Scripts.TestMap.EnterWalrusHouseScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.checkHouseScript;
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
public class BiomeStart extends Map {
    public static final Item REQUIRED_ITEM = null;

    public BiomeStart() {
        super("Biomes/start.txt", new CommonTileset(),5);
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return Player.MapEntityManager.getSavedMap(3);
            case RIGHT:
                return Player.MapEntityManager.getSavedMap(0);
            case TOP:
                return Player.MapEntityManager.getSavedMap(4);
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

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        enhancedMapTiles.add(new Rock(getMapTile(2, 7).getLocation()));
        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript2());
        npcs.add(dinosaur);

        return npcs;
    }

    @Override
    protected ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = super.loadTriggers();

        for (Side edge : Side.values()) {
            Rectangle bounds = edge.getBorderWithWidth(this.getIntersectRectangle(), 16);
            Trigger trigger = new Trigger(
                (int) bounds.getX(),
                (int) bounds.getY(),
                bounds.getWidth(),
                bounds.getHeight(),
                new SmartMapTeleportScript(() -> this.createBorderingMap(edge), edge, this.getRequiredItem(edge))
            );

            triggers.add(trigger);
        }
        triggers.add(new Trigger(816, 960, 48, 48, new checkHouseScript(), "wentOutside"));
        return triggers;
    }

    @Override
    public ArrayList<Collectible> loadCollectibles() {
        ArrayList<Collectible> collectibles = new ArrayList<>();
        return collectibles;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("House"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
        
        //added house entering scripts    
        getMapTile(17, 19).setInteractScript(new EnterHouseScript());
        
        getMapTile(4, 26).setInteractScript(new EnterWalrusHouseScript());
        
        getMapTile(17, 4).setInteractScript(new EnterDinoHouseScript());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.START;
    }
}
