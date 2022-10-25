package GameObject;

import java.awt.image.BufferedImage;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Point;

//essentially a MapEntity that allows you to move it around when you interact with it
//indoor/outdoor booleans control whether the item is placeable inside or inside (or are a reference for the class that controls that, anyways)
public class Furniture extends MapEntity {

	protected BufferedImage image;
	public MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
	protected float x;
	protected float y;
	protected int itemNumber;
	protected boolean isTethered = false;
	protected float tetherStartX;
	protected float tetherStartY;
	protected boolean indoorItem;
	protected boolean outdoorItem;

	public Furniture(String imageName, Point location, String nameOfItem, boolean indoorItem, boolean outdoorItem,
			int itemNumber) {
		super(location.x, location.y, new Frame(ImageLoader.load(imageName)));
		this.image = ImageLoader.load(imageName);
		this.x = location.x;
		this.y = location.y;
		this.itemNumber = itemNumber;
		this.indoorItem = indoorItem;
		this.outdoorItem = outdoorItem;

	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
	}

	public boolean isTethered() {
		return isTethered;
	}

	// Tethers the item to the player, will move along with them until tether is
	// unset (which I confusingly added to be a part of this method and will probably
	// never change)
	public void setTether(boolean isTethered, Player player) {
		if (isTethered) {
			this.isTethered = true;
		//	this.setX(player.getX());
		//	this.setY(player.getY());
		}

		if (!isTethered) {
			this.isTethered = false;
		}
	}

	public float getTetherStartX() {
		return tetherStartX;
	}

	public void setTetherStartX(float tetherStartX) {
		this.tetherStartX = tetherStartX;
	}

	public float getTetherStartY() {
		return tetherStartY;
	}

	public void setTetherStartY(float tetherStartY) {
		this.tetherStartY = tetherStartY;
	}

}