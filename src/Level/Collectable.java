package Level;

import java.awt.image.BufferedImage;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.Rectangle;
import Utils.Point;
import Scripts.TestMap.CollectableScript;

/* 
 * Basic collectable class that contains a few methods which draw the collectable, register
 * that it has been collected, if it has intersected with the player, and if
 * it has been collected before
 */

public class Collectable extends MapEntity {
    protected BufferedImage image;
    protected Rectangle bounds;
    protected MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
    protected float x;
    protected float y;
    protected CollectableScript collectableScript;

    public Collectable(String imageName, Point location, String nameOfItem) {
        super(location.x, location.y, new Frame(ImageLoader.load(imageName)));
        this.image = ImageLoader.load(imageName);
        this.bounds = new Rectangle(0,0, image.getWidth(), image.getHeight());
        this.x = location.x;
        this.y = location.y;
        this.collectableScript = new CollectableScript(nameOfItem);
    }

    //Gets the interact script of the collectable (just a simple text script)
    public CollectableScript getInteractScript() {
        return collectableScript; 
    }
    
    //Draws the item based on if it has been collected or not
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
    
}
