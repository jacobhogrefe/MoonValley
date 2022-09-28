package Level;

import java.awt.Image;
import java.awt.image.BufferedImage;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.Rectangle;
import GameObject.Sprite;
import Utils.Point;

/* 
 * Basic collectable class that contains a few methods which draw the collectable, register
 * that it has been collected, if it has intersected with the player, and if
 * it has been collected before
 */

public class Collectable extends MapEntity {
    protected BufferedImage image;
    protected Rectangle bounds;
    protected Map map;
    protected Player player;
    protected MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
    protected float x;
    protected float y;

    public Collectable(String imageName, Point location) {
        super(location.x, location.y, new Frame(ImageLoader.load(imageName)));
        this.image = ImageLoader.load(imageName);
        this.bounds = new Rectangle(0,0, image.getWidth(), image.getHeight());
        this.x = location.x;
        this.y = location.y;
    }



	//checks if the collectable has intersected with the player
    public boolean intersectsWith() {
        return bounds.intersects(player);
    }

    //Adds the item to the inventory if the item hasn't been collected
    public void onCollection() {
        if (mapEntityStatus == MapEntityStatus.ACTIVE) {
            mapEntityStatus = MapEntityStatus.REMOVED;
            //inventory add code goes here
            System.out.println("Item has been collected!");
        }
    }

    //Sets the entity status of the collectable
    public MapEntityStatus getMapEntityStatus() {
        return mapEntityStatus;
    }
    //Sets and gets entity staus of the collectable
    public void setMapEntityStatus(MapEntityStatus mapEntityStatus) {
        this.mapEntityStatus = mapEntityStatus;
    }

    public void update(Player player) {
        super.update();
    }

    //Draws the item based on if it has been collected or not
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        if (!isHidden) {
            graphicsHandler.drawImage(image, Math.round(x), Math.round(y), image.getWidth(), image.getHeight());
        }
    }
    
}
