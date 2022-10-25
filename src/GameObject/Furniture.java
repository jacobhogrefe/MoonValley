package GameObject;
import java.awt.image.BufferedImage;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Level.MapEntity;
import Level.MapEntityStatus;
import Level.Player;
import Utils.Point;

//essentially a MapEntity that allows you to move it around when you interact with it
public class Furniture extends MapEntity {

	protected BufferedImage image;
	public MapEntityStatus mapEntityStatus = MapEntityStatus.ACTIVE;
	protected float x;
	protected float y;
	protected int furnitureNumber;
	protected boolean isTethered = false;
	protected float tetherStartX;
	protected float tetherStartY;

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

	public boolean isTethered() {
		return isTethered;
	}

	public void setTether(boolean isTethered, Player player) {
		if (isTethered) {
			this.isTethered = true;
			this.tetherStartX = player.getX();
			this.tetherStartY = player.getY();
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