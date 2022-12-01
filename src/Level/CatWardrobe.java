
package Level;

import Engine.ImageLoader;
import GameObject.SpriteSheet;

//Used for equipping clothes on cat. the int "currentWardrobe" is used by the cat class to adjust coordinate son spritesheet to clothed sprites
//Setting wardrobeChange to "true" will cause PlaylevelScreen to reinitialize the player using the new wardrobe number


public class CatWardrobe{
	
	//Cowboy hat: currentWardrobe = 2
	
	public static int currentWardrobe = 0;
	public static boolean wardrobeChange = false;
	private static SpriteSheet spriteSheet = new SpriteSheet(ImageLoader.load("Cat.png"), 24, 24);

	public static SpriteSheet getSpriteSheet() {return spriteSheet;}

	public static void setSpriteSheet(SpriteSheet newSpriteSheet) {spriteSheet = newSpriteSheet;}

}