package Level;

import java.awt.image.BufferedImage;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.Rectangle;
import Utils.Point;
import Scripts.TestMap.CollectibleScript;


/* 
 * Basic collectible class that contains a few methods which draw the collectible, register
 * that it has been collected, if it has intersected with the player, and if
 * it has been collected before
 */

public class Collectible extends MapEntity {
    protected BufferedImage image;
    protected Rectangle bounds;
    protected MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
    protected float x;
    protected float y;
    protected CollectibleScript collectibleScript;
    protected int itemNumber;
    protected String nameOfItem;
    protected boolean isKeyCollectible;


    public Collectible(String imageName, Point location, String nameOfItem, int itemNumber, boolean isKeyCollectible) {
        super(location.x, location.y, new Frame(ImageLoader.load(imageName)));
        this.nameOfItem = nameOfItem;
        this.isKeyCollectible = isKeyCollectible;
        this.image = ImageLoader.load(imageName);
        this.bounds = new Rectangle(0,0, image.getWidth(), image.getHeight());
        this.x = location.x;
        this.y = location.y;
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

    public void setScriptMusicManager(MusicManager musicManager) {
        this.collectibleScript = new CollectibleScript(nameOfItem, isKeyCollectible, musicManager);
    }

	//Gets the interact script of the collectible (just a simple text script)
    public CollectibleScript getInteractScript() {
        return collectibleScript; 
    }
    

    
    //Draws the item based on if it has been collected or not
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }
    
}
