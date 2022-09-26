package Level;

import java.awt.image.BufferedImage;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Rectangle;
import GameObject.Sprite;
import Utils.Point;

/* 
 * Basic collectable class that contains a few methods which draw the collectable, register
 * that it has been collected, if it has intersected with the player, and if
 * it has been collected before
 */

public class Collectable extends Sprite {
    protected BufferedImage image;
    protected Rectangle bounds;
    protected Map map;
    protected Player player;
    protected boolean isHidden;
    protected float x;
    protected float y;

    public Collectable(String imageName, Point location) {
        super(ImageLoader.load(imageName), location.x, location.y);
        this.image = ImageLoader.load(imageName);
        this.bounds = new Rectangle(0,0, image.getWidth(), image.getHeight());
        this.x = location.x;
        this.y = location.y;
        this.isHidden = false;
    }

    //checks if the collectable has intersected with the player
    public boolean intersectsWith() {
        return bounds.intersects(player);
    }

    //Adds the item to the inventory if the item hasn't been collected
    public void onCollection() {
        if (!isHidden) {
            isHidden = true;
            //inventory add code goes here
            System.out.println("Item has been collected!");
        }
    }

    //Checks if the item has been collected
    public boolean isCollected() {
        return isHidden;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //Draws the item based on if it has been collected or not
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (!isHidden) {
            graphicsHandler.drawImage(image, Math.round(x), Math.round(y), image.getWidth(), image.getHeight());
        }
    }
    
}
