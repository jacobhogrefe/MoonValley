package Maps;

import java.util.ArrayList;
import java.util.function.Supplier;

import GameObject.Rectangle;
import Level.Map;
import Level.Tileset;
import Level.Trigger;
import Registry.ItemRegistry.Item;
import Scripts.SmartMapTeleportScript;
import Utils.Side;

/**
 * An extension of Map that "loops" at the edges - the player is teleported to
 * a new map when they reach the edge, with some caveats.
 */
public abstract class AbstractLoopingMap extends Map {
    public AbstractLoopingMap(String mapFileName, Tileset tileset) {
        super(mapFileName, tileset);
    }

    /**
     * Create the bordering map for a given map edge.
     * 
     * You can return null here if the edge has no map connected to it.
     * 
     * @param edge the side of this map the player is at
     * @return the new map to teleport to
     */
    public abstract Map createBorderingMap(Side edge);

    /**
     * Get the required item for a user to travel to a new map at the given edge.
     * You can return null if there is no required item.
     * 
     * @param edge the side of this map the player is at
     * @return the required item to let the player travel to the bordering map
     */
    public Item getRequiredItem(Side edge) {
        return null;
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

        return triggers;
    }
}