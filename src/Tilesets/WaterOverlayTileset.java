package Tilesets;

import java.awt.image.BufferedImage;

import Engine.ImageLoader;

public class WaterOverlayTileset extends OverlayTileset {
    public WaterOverlayTileset() {
        super(ImageLoader.load("WaterTiles.png"), 16, 16);
    }

    @Override
    public void addTiles() {
        this.tiles.add(this.getSubimage0(0, 0));
        this.tiles.add(this.getSubimage0(1, 0));
        this.tiles.add(this.getSubimage0(2, 0));
        this.tiles.add(this.getSubimage0(0, 1));
        this.tiles.add(this.getSubimage0(1, 1));
        this.tiles.add(this.getSubimage0(2, 1));
        this.tiles.add(this.getSubimage0(0, 2));
        this.tiles.add(this.getSubimage0(1, 2));
    }
}
