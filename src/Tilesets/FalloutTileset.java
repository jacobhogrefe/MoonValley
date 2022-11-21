package Tilesets;

import java.util.ArrayList;
import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class FalloutTileset extends Tileset {
    public FalloutTileset() {
        super(ImageLoader.load("WastelandTileset.png"), 16, 16, 3);
    }

    protected MapTileBuilder getTile(int i, int j) {
        Frame frame = new FrameBuilder(this.image.getSubimage(i * 16, j * 16, 16, 16))
            .withScale(tileScale)
            .build();
        
        MapTileBuilder tile = new MapTileBuilder(frame);

        return tile;
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        mapTiles.add(
            this.getTile(0, 0) // GROUND
        );

        mapTiles.add(
            this.getTile(1, 0) // MELTED HORIZONTAL FENCE
        );

        mapTiles.add(
            this.getTile(2, 0) // WASTE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(0, 1) // HORIZONTAL FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(1, 1) // TOP RIGHT CORNER FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(2, 1) // LEFT VERTICAL FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(0, 2) // BOTTOM LEFT CORNER FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(1, 2) // TOP RIGHT CORNER FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(2, 2) // RIGHT VERTICAL FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        mapTiles.add(
            this.getTile(0, 3) // BOTTOM RIGHT VERTICAL FENCE
                .withTileType(TileType.NOT_PASSABLE)
        );

        return mapTiles;
    }
    
}
