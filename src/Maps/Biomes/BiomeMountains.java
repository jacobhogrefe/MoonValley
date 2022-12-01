package Maps.Biomes;

import java.util.ArrayList;

import GameObject.Rectangle;
import Level.Collectible;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Mario;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.SmartMapTeleportScript;
import Scripts.BiomeMountains.EnterTreehouseScript;
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
public class BiomeMountains extends Map {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.GRAPPLING_HOOK;

    public BiomeMountains() {
        super("Biomes/mountains.txt", new MountainsTileset(),2);
    }

    @Override
    public Map createBorderingMap(Side edge) {
        switch (edge) {
            case LEFT:
                return Player.MapEntityManager.getSavedMap(4);
            case RIGHT:
                return null;
            case TOP:
                return null;
            case BOTTOM:
                return Player.MapEntityManager.getSavedMap(0);
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
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();
        Mario mario = new Mario(42, getMapTile(19,18).getLocation());
        mario.setInteractScript(new MarioScript());
        npcs.add(mario);
        return npcs;
    }

    // @Override
    // public ArrayList<Trigger> loadTriggers() {
    //     ArrayList<Trigger> triggers = super.loadTriggers();
    //     triggers.add(new Trigger(48*5,48*24, 48, 1, new MagicTreeHouse(), "magicTreeHouse"));
    //     return triggers;
    // }
    @Override
    public ArrayList<Trigger> loadTriggers() {
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
        return triggers;
    }

    @Override
    public ArrayList<Collectible> loadCollectibles() {
        ArrayList<Collectible> collectibles = new ArrayList<>();
        Collectible nintendoSwitch = new Collectible("nintendoSwitch.png", getMapTile(6,4).getLocation(), "Nintendo Switch", 13, false);
        Collectible ramen = new Collectible("ramen.png", getMapTile(22,17).getLocation(), "bowl of Ramen", 12, false);
        Collectible terminal = new Collectible("terminal.png", getMapTile(2,13).getLocation(), "Terminal", 11, false);
        Collectible yoshiCoin = new Collectible("yoshiCoin.png", getMapTile(22,1).getLocation(), "Yoshi Coin", 2, true);
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
    public void loadScripts() {
        getMapTile(5,23).setInteractScript(new EnterTreehouseScript());
    }

    @Override
    public MusicState getMusicState() {
        return MusicState.MOUNTAINS;
    }
}