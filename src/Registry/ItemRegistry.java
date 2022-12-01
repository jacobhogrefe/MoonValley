package Registry;

import java.util.ArrayList;
import Engine.ImageLoader;
import java.awt.Image;

//for items that can be present in inventory

/**
 * All of the items in the game. Use ItemRegistry.singleton to access.
 */
public class ItemRegistry {
	public static final ItemRegistry singleton = new ItemRegistry();

	public ArrayList<Item> items = new ArrayList<>();

	public static class Item {
		public String name;
		public String description;
		public Image texture;
		public int furnitureNumber;
		
		// If you want your item to be placeable indoor/outdoors, set these true in
		// builder. Must make a FurnitureRegistry counterpart if either is true
		public boolean indoorPlacement = false;
		public boolean outdoorPlacement = false;

		public Item addToRegistry(ItemRegistry registry) {
			registry.items.add(this);

			return this;
		}

		public int getItemNumber() {
			return ItemRegistry.singleton.items.indexOf(this);
		}

		public static class Builder {
			protected Item item = new Item();

			public Item build() {
				return this.item;
			}

			public Builder withName(String name) {
				this.item.name = name;

				return this;
			}

			public Builder withDescription(String desc) {
				this.item.description = desc;

				return this;
			}

			public Builder withImage(Image image) {
				this.item.texture = image;

				return this;
			}

			public Builder withIndoorPlacement() {
				this.item.indoorPlacement = true;

				return this;
			}
			public Builder withOutdoorPlacement() {
				this.item.outdoorPlacement = true;

				return this;
			}
			
			//furniture must have a furniturenumber and be in the FurnitureRegistry
			public Builder withFurnitureNumber(int furnitureNumber) {
				this.item.furnitureNumber = furnitureNumber;
				
				return this;
			}

			public Builder withSubimage(int x, int y) {
				return this.withImage(ImageLoader.load("InventoryTileset.png").getSubimage(x, y, 16, 16)
						.getScaledInstance(48, 48, Image.SCALE_SMOOTH));
			}
		}

		@Override
		public String toString() {
			return "Item " + this.name;
		}
	}

	public Item EMPTY_SLOT = new Item.Builder() // 0
			.withName("Empty Slot")
			.withDescription("Just a plain old empty slot!")
			.withSubimage(17, 17)
			.build()
			.addToRegistry(this);

	public Item COWBOY_HAT = new Item.Builder() // 1
			.withName("Cowboy Hat")
			.withDescription("Ain't 'nuff room in this here valley for the two of us, partner...")
			.withSubimage(68 + 17 * 0, 0)
			.build()
			.addToRegistry(this);

	public Item YOSHI_COIN = new Item.Builder() // 2
			.withName("Yoshi Coin")
			.withDescription("A trademarked coin that we used anyways")
			.withSubimage(68 + 17 * 1, 0)
			.build()
			.addToRegistry(this);

	public Item WATER_CANTEEN = new Item.Builder() // 3
			.withName("Canteen")
			.withDescription("Good for holding water!")
			.withSubimage(68 + 17 * 2, 0)
			.build()
			.addToRegistry(this);

	public Item PUMPKIN = new Item.Builder() // 4
			.withName("Pumpkin")
			.withDescription("A very orange watermelon...")
			.withSubimage(68 + 17 * 3, 0)
			.build()
			.addToRegistry(this);

	public Item MAGNIFYING_GLASS = new Item.Builder() // 5
			.withName("Magnifying Glass")
			.withDescription("Wow! There's a whole 'nother tiny world down here!")
			.withSubimage(68 + 17 * 4, 0)
			.build()
			.addToRegistry(this);

	public Item GAS_MASK = new Item.Builder() // 6
			.withName("Gas Mask")
			.withDescription("Useful for cleaning the bathroom in Irma")
			.withSubimage(68 + 17 * 5, 0)
			.build()
			.addToRegistry(this);

	public Item GRAPPLING_HOOK = new Item.Builder() // 7
			.withName("Grappling Hook")
			.withDescription("It hurts to step on more than LEGOs...")
			.withSubimage(68 + 17 * 6, 0)
			.build()
			.addToRegistry(this);

	public Item BUG = new Item.Builder() // 8
			.withName("Pesky Insect")
			.withDescription("I break things!")
			.withSubimage(68 + 17 * 1, 17)
			.build()
			.addToRegistry(this);

	public Item JUKEBOX = new Item.Builder() // 9
			.withName("Retro Jukebox")
			.withDescription("A box containing jukes")
			.withSubimage(68 + 17 * 2, 17)
			.withIndoorPlacement()
			.withFurnitureNumber(0)
			.build()
			.addToRegistry(this);
	
	public Item ROSEBUSH = new Item.Builder() //10
			.withName("Rose Bush")
			.withDescription("A rose does not lose sleep because it was mocked by weeds.")
			.withSubimage(68 + 17 * 3, 17)
			.withOutdoorPlacement()
			.withFurnitureNumber(1)
			.build()
			.addToRegistry(this);

	public Item TERMINAL = new Item.Builder() // 11
			.withName("Terminal")
			.withDescription("Scary, but useful")
			.withSubimage(68 + 17 * 4, 17)
			.build()
			.addToRegistry(this);
	
	public Item RAMEN = new Item.Builder() // 12
			.withName("Ramen")
			.withDescription("A college student's fuel")
			.withSubimage(68 + 17 * 5, 17)
			.build()
			.addToRegistry(this);

	public Item NINTENDO_SWITCH = new Item.Builder() // 13
			.withName("Nintendo Switch")
			.withDescription("The better DS")
			.withSubimage(68 + 17 * 6, 17)
			.build()
			.addToRegistry(this);

	public Item TV_STAND = new Item.Builder() // 14
			.withName("TV Stand")
			.withDescription("Perfect for playing Moonvalley!")
			.withSubimage(68 + 17 * 7, 17)
			.withIndoorPlacement()
			.withFurnitureNumber(2)
			.build()
			.addToRegistry(this);
	public Item FUTON = new Item.Builder() // 15
			.withName("Futon")
			.withDescription("The best worst sleeping arrangement")
			.withSubimage(68 + 17 * 8, 17)
			.withIndoorPlacement()
			.withFurnitureNumber(3)
			.build()
			.addToRegistry(this);
	public Item DESK = new Item.Builder() // 16
			.withName("Desk")
			.withDescription("The best place to sleep before a test")
			.withSubimage(68 + 17 * 9, 17)
			.withIndoorPlacement()
			.withFurnitureNumber(4)
			.build()
			.addToRegistry(this);

	public Item HEADPHONES = new Item.Builder() // 17
			.withName("Headphones")
			.withDescription("Great for tuning out your student's crys")
			.withSubimage(68 + 17 * 1, 34)
			.build()
			.addToRegistry(this);
	
	public Item GLASSES = new Item.Builder() //18
			.withName("Glasses")
			.withDescription("Good if you like seeing")
			.withSubimage(68 + 17 * 7, 0)
			.build()
			.addToRegistry(this);
	
	public Item HAWAIIAN_SHIRT = new Item.Builder() //19
			.withName("Hawaiian Shirt")
			.withDescription("Pretty flowers!")
			.withSubimage(68 + 17 * 8, 0)
			.build()
			.addToRegistry(this);

	private ItemRegistry() {

	}
}
