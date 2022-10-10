package Tilesets;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.awt.image.BufferedImage;

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
        ArrayList<MapTileBuilder> overlayed = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                BufferedImage image = this.image.getSubimage(i * 16, j * 16, 16, 16);

                Frame frame = new FrameBuilder(this.image.getSubimage(i * 16, j * 16, 16, 16))
                    .withScale(tileScale)
                    .build();
                
                MapTileBuilder tile = new MapTileBuilder(frame);

                mapTiles.add(tile);

                overlayed.addAll(Tilesets.WATER_OVERLAY_TILESET.overlay(image).stream()
                    .map(oImage -> {
                        Frame oFrame = new FrameBuilder(oImage)
                            .withScale(tileScale)
                            .build();
                        
                        return new MapTileBuilder(oFrame);
                    }).collect(Collectors.toUnmodifiableList())
                );
            }
        }

        mapTiles.addAll(overlayed);

        return mapTiles;
    }
    
}
