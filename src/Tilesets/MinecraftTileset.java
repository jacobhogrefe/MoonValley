package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.Tileset;

public class MinecraftTileset extends Tileset {
    public MinecraftTileset() {
        super(ImageLoader.load("terrain.png"), 16, 16, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                Frame frame = new FrameBuilder(this.image.getSubimage(i * 16, j * 16, 16, 16))
                    .withScale(tileScale)
                    .build();
                
                MapTileBuilder tile = new MapTileBuilder(frame);

                mapTiles.add(tile);
            }
        }

        return mapTiles;
    }
    
}
