package Maps;

import java.util.ArrayList;
import java.util.function.Supplier;

import GameObject.Rectangle;
import Level.Map;
import Level.Tileset;
import Level.Trigger;
import Scripts.SmartMapTeleportScript;
import Utils.Side;

public abstract class AbstractLoopingMap extends Map {
    public AbstractLoopingMap(String mapFileName, Tileset tileset) {
        super(mapFileName, tileset);
    }

    public abstract Supplier<Map> getBorderingMap(Side edge);

    @Override
    protected ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = super.loadTriggers();

        for (Side edge : Side.values()) {
            Supplier<Map> borderingMap = this.getBorderingMap(edge);
            if (edge != null) {
                Rectangle bounds = edge.getBorderWithWidth(this.getIntersectRectangle(), 16);
                Trigger trigger = new Trigger(
                    (int) bounds.getX(),
                    (int) bounds.getY(),
                    bounds.getWidth(),
                    bounds.getHeight(),
                    new SmartMapTeleportScript(borderingMap, edge)
                );

                triggers.add(trigger);
            }
        }

        return triggers;
    }
}
