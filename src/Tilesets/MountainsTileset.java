package Tilesets;

import java.util.ArrayList;
import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.Rectangle;
import Level.MapTile;
import Level.TileType;
import Level.Tileset;

public class MountainsTileset extends Tileset {

    public MountainsTileset() {
        super(ImageLoader.load("mountainsTextures.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
        mapTiles.add(impassableBoundsTile(buildFrame(0, 0), new Rectangle(0f,0f, 3, 48)));
        mapTiles.add(buildTile(buildFrame(0, 1)));
        mapTiles.add(impassableBoundsTile(buildFrame(0, 2), new Rectangle(45f,0f, 3, 48)));
        mapTiles.add(impassableBoundsTile(buildFrame(0, 3), new Rectangle(24f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(0, 4), new Rectangle(0f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(1, 0), new Rectangle(0f, 24f, 24, 24)));
        mapTiles.add(buildTile(buildFrame(1, 1)));
        mapTiles.add(impassableBoundsTile(buildFrame(1, 2), new Rectangle(24f, 24f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(1, 3), new Rectangle(24f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(1, 4), new Rectangle(0f, 0f, 24, 24)));
        mapTiles.add(impassableTile(buildFrame(2, 0)));
        mapTiles.add(impassableTile(buildFrame(2, 1)));
        mapTiles.add(impassableTile(buildFrame(2, 2)));
        mapTiles.add(impassableBoundsTile(buildFrame(2, 3), new Rectangle(0f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(2, 4), new Rectangle(24f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(3, 0), new Rectangle(0f,0f, 48, 3)));
        mapTiles.add(buildTile(buildFrame(3, 1)));
        mapTiles.add(impassableBoundsTile(buildFrame(3, 2), new Rectangle(24f, 24f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(3, 3), new Rectangle(24f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(3, 4), new Rectangle(0f, 0f, 24, 24)));
        mapTiles.add(impassableBoundsTile(buildFrame(4, 0), new Rectangle(0f, 24f, 24, 24)));
        mapTiles.add(buildTile(buildFrame(4, 1)));
        mapTiles.add(buildTile(buildFrame(4, 2)));
        mapTiles.add(buildTile(buildFrame(4, 3)));
        mapTiles.add(buildTile(buildFrame(4, 4)));
        mapTiles.add(buildTile(buildFrame(5, 0)));
        mapTiles.add(buildTile(buildFrame(5, 1)));
        mapTiles.add(buildTile(buildFrame(5, 2)));
        mapTiles.add(buildTile(buildFrame(5, 3)));
        mapTiles.add(buildTile(buildFrame(5, 4)));

        mapTiles.add(doubleLayeredTile(6, 0, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 1, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 2, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 3, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 4, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(7, 0, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(7, 1, buildFrame(5, 4)));
        Frame[] lanternAnimation = new Frame[] {
            new FrameBuilder(getSubImage(7, 2), 200)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(7, 3), 200)
                .withScale(tileScale)
                .build(),
            new FrameBuilder(getSubImage(7, 4), 200)
                .withScale(tileScale)
                .build()
        };
        MapTileBuilder lantern = new MapTileBuilder(buildFrame(5,4))
            .withTopLayer(lanternAnimation)
            .withTileType(TileType.PASSABLE);
        mapTiles.add(lantern);
        MapTileBuilder tile = buildTile(buildFrame(6, 3));
        tile.withTileType(TileType.NOT_PASSABLE);
        mapTiles.add(tile);

        mapTiles.add(doubleLayeredTile(8, 0, buildFrame(5,4)));
        mapTiles.add(impassableTile(buildFrame(8,1)));
        mapTiles.add(doubleLayeredTile(8,2, buildFrame(5,4)));
        mapTiles.add(buildTile(buildFrame(8,3)));

        mapTiles.add(impassableTile(buildFrame(0, 1)));
        mapTiles.add(impassableTile(buildFrame(0, 4)));
        mapTiles.add(impassableTile(buildFrame(3, 1)));
        mapTiles.add(impassableTile(buildFrame(0, 0)));
        mapTiles.add(impassableTile(buildFrame(0, 2)));
        mapTiles.add(impassableTile(buildFrame(0, 3)));
        mapTiles.add(impassableTile(buildFrame(3, 0)));
        mapTiles.add(impassableTile(buildFrame(1, 1)));
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

    protected MapTileBuilder impassableTile(Frame frame) {
        return new MapTileBuilder(frame)
            .withTileType(TileType.NOT_PASSABLE);
    }

    protected MapTileBuilder passableTile(Frame frame) {
        return new MapTileBuilder(frame)
            .withTileType(TileType.PASSABLE);
    }

    protected MapTileBuilder impassableBoundsTile(Frame frame, Rectangle bounds) {
        return new MapTileBuilder(frame)
            .withTileType(TileType.NOT_PASSABLE)
            .withBounds(bounds);
    }
    
    protected MapTileBuilder doubleLayeredTile(int i, int j, Frame bottomLayer) {
        Frame topLayer = new FrameBuilder(getSubImage(i, j))
                .withScale(tileScale)
                .build();
        return new MapTileBuilder(bottomLayer)
            .withTopLayer(topLayer)
            .withTileType(TileType.PASSABLE);
    }

    public MapTile[] getCoolMapTiles() {
        MapTile[] mapTiles = new MapTile[] {
            //first half are for going up ladder
            passableTile(buildFrame(8,1)).build(5,23),
            passableTile(buildFrame(8,1)).build(5,22),
            passableTile(buildFrame(8,0)).build(5,21),
            passableTile(buildFrame(8,0)).build(6,21),
            passableTile(buildFrame(8,0)).build(7,21),
            passableTile(buildFrame(8,0)).build(8,21),
            passableTile(buildFrame(8,0)).build(9,21),
            impassableTile(buildFrame(6,4)).build(5,20),
            impassableTile(buildFrame(6,4)).build(6,20),
            impassableTile(buildFrame(7,1)).build(7,20),
            impassableTile(buildFrame(6,4)).build(8,20),
            impassableTile(buildFrame(6,4)).build(9,20),
            impassableTile(buildFrame(5,4)).build(4,21),
            impassableTile(buildFrame(5,4)).build(4,22),
            impassableTile(buildFrame(5,4)).build(6,22),
            impassableTile(buildFrame(5,4)).build(6,23),
            impassableTile(buildFrame(5,4)).build(8,22),
            impassableTile(buildFrame(5,4)).build(9,22),
            impassableTile(buildFrame(5,4)).build(10,21),
            impassableTile(buildFrame(5,0)).build(4,23),

            //second half for going down ladder
            impassableTile(buildFrame(8,1)).build(5,23),
            doubleLayeredTile(8, 2, buildFrame(5,4)).build(5,22),
            doubleLayeredTile(8, 0, buildFrame(5,4)).build(5,21),
            doubleLayeredTile(8, 0, buildFrame(5,4)).build(6,21),
            doubleLayeredTile(8, 0, buildFrame(5,4)).build(7,21),
            doubleLayeredTile(8, 0, buildFrame(5,4)).build(8,21),
            doubleLayeredTile(8, 0, buildFrame(5,4)).build(9,21),
            doubleLayeredTile(6, 4, buildFrame(5,4)).build(5,20),
            doubleLayeredTile(6, 4, buildFrame(5,4)).build(6,20),
            doubleLayeredTile(7, 1, buildFrame(5,4)).build(7,20),
            doubleLayeredTile(6, 4, buildFrame(5,4)).build(8,20),
            doubleLayeredTile(6, 4, buildFrame(5,4)).build(9,20),
            passableTile(buildFrame(5,4)).build(4,21),
            passableTile(buildFrame(5,4)).build(4,22),
            passableTile(buildFrame(5,4)).build(6,22),
            passableTile(buildFrame(5,4)).build(6,23),
            passableTile(buildFrame(5,4)).build(8,22),
            passableTile(buildFrame(5,4)).build(9,22),
            passableTile(buildFrame(5,4)).build(10,21),
            passableTile(buildFrame(5,0)).build(4,23)
        };
        return mapTiles;
    }
}
