package Tilesets;

import java.awt.image.*;
import java.util.ArrayList;

import Utils.ImageUtils;

public abstract class OverlayTileset {
    protected BufferedImage image;
    public int tileWidth;
    public int tileHeight;
    public ArrayList<BufferedImage> tiles = new ArrayList<>();

    public OverlayTileset(BufferedImage image, int tileWidth, int tileHeight) {
        this.image = image;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.addTiles();
    }

    protected abstract void addTiles();

    public ArrayList<BufferedImage> overlay(BufferedImage bottom) {
        ArrayList<BufferedImage> newTiles = new ArrayList<>();

        for (BufferedImage top : this.tiles) {
            newTiles.add(ImageUtils.overlay(top, bottom));
        }
        
        return newTiles;
    }

    /*
     * Get a subimage, with no pixels between tiles
     */
    protected BufferedImage getSubimage0(int col, int row) {
        return this.image.getSubimage(col * tileWidth, row * tileHeight, tileWidth, tileHeight);
    }

    /*
     * Get a subimage, with one pixel between tiles
     */
    protected BufferedImage getSubimage1(int col, int row) {
        return this.image.getSubimage(col * tileWidth + col, row * tileHeight + row, tileWidth, tileHeight);
    }
}
