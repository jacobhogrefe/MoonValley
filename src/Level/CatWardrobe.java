
package Level;

import Engine.ImageLoader;
import GameObject.SpriteSheet;

//Used for equipping clothes on cat. the int "currentWardrobe" is used by the cat class to adjust coordinate son spritesheet to clothed sprites
//Setting wardrobeChange to "true" will cause PlaylevelScreen to reinitialize the player using the new wardrobe number


public class CatWardrobe{
	
	//Cowboy hat: currentWardrobe = 2
	
	public static int currentWardrobe = 0;
	public static boolean wardrobeChange = false;
	private SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.load("Cat.png"), 24, 24);
	
	public CatWardrobe() {	
	}
	

	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

}