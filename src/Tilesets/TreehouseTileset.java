package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class TreehouseTileset extends Tileset {

    public TreehouseTileset() {
        super(ImageLoader.load("treeHouseTiles.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
        mapTiles.add(buildTile(buildFrame(0,0)));
        mapTiles.add(buildImpassibleTile(buildFrame(0,1)));
        mapTiles.add(buildImpassibleTile(buildFrame(0,2)));
        mapTiles.add(buildImpassibleTile(buildFrame(0,3)));
        mapTiles.add(buildImpassibleTile(buildFrame(1,0)));
        mapTiles.add(buildTile(buildFrame(1,1)));
        mapTiles.add(buildTile(buildFrame(1,2)));
        mapTiles.add(buildImpassibleTile(buildFrame(1,3)));
        return mapTiles;
    }

    protected Frame buildFrame(int row, int col) {
        return new FrameBuilder(getSubImage(row, col))
                .withScale(tileScale)
                .build();
    }

    protected MapTileBuilder buildTile(Frame frame) {
        return new MapTileBuilder(frame);
    }

    protected MapTileBuilder buildImpassibleTile(Frame frame) {
        MapTileBuilder mapTile = buildTile(frame).withTileType(TileType.NOT_PASSABLE);
        return mapTile;
    }
}
