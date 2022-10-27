package Tilesets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
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
