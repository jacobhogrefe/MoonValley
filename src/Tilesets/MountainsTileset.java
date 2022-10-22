package Tilesets;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.Tileset;

public class MountainsTileset extends Tileset {

    public MountainsTileset() {
        super(ImageLoader.load("mountainsTextures.png"), 16, 16, 3);
    }

    //change i variable to 5 once tileset is finished
    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Frame currentTileFrame = new FrameBuilder(getSubImage(i, j))
                .withScale(tileScale)
                .build();
                MapTileBuilder currentTile = new MapTileBuilder(currentTileFrame);
                mapTiles.add(currentTile);
            }
        }
        return mapTiles;
    }
    
}
