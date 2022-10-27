package Tilesets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.MapTile;
import Level.TileType;
import Level.Tileset;

public class MountainsTileset extends Tileset {

    public MountainsTileset() {
        super(ImageLoader.load("mountainsTextures.png"), 16, 16, 3);
    }

    //change i variable to 5 once tileset is finished
    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Frame currentFrame = new FrameBuilder(getSubImage(i, j))
                    .withScale(tileScale)
                    .build();
                MapTileBuilder tile = new MapTileBuilder(currentFrame);
                mapTiles.add(tile);
            }
        }
        mapTiles.add(doubleLayeredTile(6, 0, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 1, buildFrame(5, 4)));
        mapTiles.add(doubleLayeredTile(6, 2, buildFrame(5, 4)));
        mapTiles.add(buildTile(buildFrame(6, 3)));
        mapTiles.add(buildTile(buildFrame(6, 4)));
        mapTiles.add(buildTile(buildFrame(7, 0)));
        mapTiles.add(buildTile(buildFrame(7, 1)));
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
        MapTileBuilder lantern = new MapTileBuilder(buildFrame(6,4))
            .withTopLayer(lanternAnimation)
            .withTileType(TileType.PASSABLE);
        mapTiles.add(lantern);
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
    
    protected MapTileBuilder doubleLayeredTile(int i, int j, Frame bottomLayer) {
        Frame topLayer = new FrameBuilder(getSubImage(i, j))
                .withScale(tileScale)
                .build();
        return new MapTileBuilder(bottomLayer)
            .withTopLayer(topLayer)
            .withTileType(TileType.PASSABLE);
    }
}
