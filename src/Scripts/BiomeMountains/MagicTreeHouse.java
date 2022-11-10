package Scripts.BiomeMountains;

import Level.MapTile;
import Level.Script;
import Level.ScriptState;
import Level.TileType;
import Tilesets.MountainsTileset;
import Utils.Point;

public class MagicTreeHouse extends Script {

    protected MountainsTileset tileset = new MountainsTileset();
    protected MapTile[] initial;
    protected MapTile[] intoTreehouse;
    protected MapTile[] exitTreehouse;

    @Override
    protected void setup() {
        initial = tileset.getCoolMapTiles();
        intoTreehouse = new MapTile[initial.length/2];
        exitTreehouse = new MapTile[initial.length/2];
        for (int i = 0; i < initial.length; i++) {
            if (i < (initial.length/2)) {
                initial[i] = intoTreehouse[i];
            } else {
                initial[i] = exitTreehouse[i];
            }
        }
    }

    @Override
    protected void cleanup() {setFlag("magicTreeHouse");}

    @Override
    protected ScriptState execute() {
        if (!isFlagSet("magicTreeHouse")) {
            start();
            if (player.getCurrentWalkingYDirection().getVelocity() == -1) {
                enteringHouseState();
            } else if (player.getCurrentWalkingYDirection().getVelocity() == 1) {
                regularHouseState();
            }
            end();
        }
        return ScriptState.COMPLETED;
    }

    protected void regularHouseState() {
        for (MapTile mapTile : exitTreehouse) {
            Point tempPoint = mapTile.getLocation();
            map.setMapTile((int)tempPoint.x, (int)tempPoint.y, mapTile);
        }
    }
    
    protected void enteringHouseState() {
        for (MapTile mapTile : intoTreehouse) {
            Point tempPoint = mapTile.getLocation();
            map.setMapTile((int)tempPoint.x, (int)tempPoint.y, mapTile);
        }
    }
}
