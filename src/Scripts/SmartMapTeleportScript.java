package Scripts;

import java.util.OptionalDouble;
import java.util.function.Supplier;

import Level.Map;
import Utils.Side;

/**
 * A MapTeleportScript that teleports players to the correct location on the target map to emulate a continuous flow between maps.
 */
public class SmartMapTeleportScript extends MapTeleportScript {
    public Side side;

    public SmartMapTeleportScript(Supplier<Map> mapCreator, Side side) {
        super(mapCreator, OptionalDouble.empty(), OptionalDouble.empty());

        this.side = side;
    }
    
    @Override
    protected float getToX() {
        if (this.side.parallelToXAxis()) {
            // How far along the X axis has the player traveled?
            double traveledFraction = this.getPlayer().getX() / this.getMap().getWidthPixels();

            // Where does this fraction land on the new map?
            return (float) (this.toMap.getWidthPixels() * traveledFraction);
        } else {
            // either left or right border
            if (this.side == Side.LEFT) {
                // we'll pop out on the right on the other map
                return (float) (this.toMap.getWidthPixels() - this.getPlayer().getWidth());
            } else { // right side
                return (float) (this.getPlayer().getWidth());
            }
        }
    }

    @Override
    protected float getToY() {
        if (this.side.parallelToYAxis()) {
            // How far along the Y axis has the player traveled?
            double traveledFraction = this.getPlayer().getY() / this.getMap().getHeightPixels();

            // Where does this fraction land on the new map?
            return (float) (this.toMap.getHeightPixels() * traveledFraction);
        } else {
            // either top or bottom border
            if (this.side == Side.TOP) {
                // we'll pop out on the bottom on the other map
                return (float) (this.toMap.getHeightPixels() - this.getPlayer().getHeight());
            } else { // bottom side
                return (float) (this.getPlayer().getHeight());
            }
        }
    }
}
