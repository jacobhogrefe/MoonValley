package GameObject;

import java.awt.Image;
import java.awt.image.BufferedImage;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Point;

public class Furniture extends MapEntity {
	
	protected BufferedImage image;
	public MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
	protected float x;
	protected float y;
	protected int furnitureNumber;


    public Furniture(String imageName, Point location, String nameOfItem, int furnitureNumber) {
        super(location.x, location.y, new Frame(ImageLoader.load(imageName))); 
        this.image = ImageLoader.load(imageName);
        this.x = location.x;
        this.y = location.y;
        this.furnitureNumber = furnitureNumber;
    }
    
 
    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }



}