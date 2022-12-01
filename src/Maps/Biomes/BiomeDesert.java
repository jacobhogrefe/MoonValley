package Maps.Biomes;

import java.util.ArrayList;
import GameObject.Rectangle;
import Level.Map;
import Level.MusicState;
import Level.NPC;
import Level.Player;
import Level.Trigger;
import NPCs.Cattle;
import NPCs.RanchOwner;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;
import Scripts.SmartMapTeleportScript;
import Scripts.DesertMap.EnterDesertHomeScript;
import Scripts.DesertMap.EnterSaloonScript;
import Scripts.DesertMap.OwnerScript;
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
public class BiomeDesert extends Map {
    public static final Item REQUIRED_ITEM = ItemRegistry.singleton.WATER_CANTEEN;
    public static final EnterSaloonScript enterSaloon = new EnterSaloonScript();
    public static final EnterDesertHomeScript enterDesertHome = new EnterDesertHomeScript();

    public BiomeDesert() {
        super("Biomes/desert.txt", new DesertTileset(),0);
    }
    
    @Override
    public void loadScripts() {  
        getMapTile(17, 25).setInteractScript(enterSaloon);
        getMapTile(18, 25).setInteractScript(enterSaloon);
        getMapTile(3, 26).setInteractScript(enterDesertHome);
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