package Screens;

import Game.ScreenCoordinator;
import Level.CatWardrobe;
import Level.Map;
import Maps.BiomeSpookyHome;
import Maps.MushroomHomeMap;
import Maps.Biomes.BiomeDesert;
import Maps.Biomes.BiomeMountains;
import Maps.Biomes.BiomeShrooms;
import Maps.Biomes.BiomeSpooky;
import Maps.Biomes.BiomeStart;
import Registry.ItemRegistry;
import Registry.ItemRegistry.Item;

public class DebugMenuScreen extends AbstractMenuScreen {
	public static final boolean DEBUG_ENABLED = true;

	public static class SwitchMapOption extends Option {
		@Override
		public String getText() {
			return "switch maps";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			parent.screenCoordinator.push(new AbstractMenuScreen(parent.screenCoordinator) {
				class MapOption extends Option {
					Map map;

					public MapOption(Map map) {
						this.map = map;
					}

					@Override
					public String getText() {
						return this.map.getMapFileName();
					}

					@Override
					public void select(AbstractMenuScreen parent) {
						parent.screenCoordinator.getPlayLevelScreen().teleport(this.map, 0, 0);
						parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
					}
				}

				@Override
				public void addOptions() {
					// this.options.add(new MapOption(new TitleScreenMap()));
					// this.options.add(new MapOption(new moonValleyTitle()));
					this.options.add(new MapOption(new BiomeMountains()));
					//this.options.add(new MapOption(new TestMap()));
					this.options.add(new MapOption(new BiomeStart()));
					this.options.add(new MapOption(new BiomeShrooms()));
					this.options.add(new MapOption(new MushroomHomeMap()));
					this.options.add(new MapOption(new BiomeDesert()));
					this.options.add(new MapOption(new BiomeSpooky()));
					this.options.add(new MapOption(new BiomeSpookyHome()));
					this.options.add(new CancelOption());
				}
			});
		}
	}

	public static class GiveItemOption extends Option {
		@Override
		public String getText() {
			return "give item";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			parent.screenCoordinator.push(new AbstractMenuScreen(parent.screenCoordinator) {
				class ItemOption extends Option {
					Item item;

					public ItemOption(Item item) {
						this.item = item;
					}

					@Override
					public String getText() {
						return this.item.toString();
					}

					@Override
					public void select(AbstractMenuScreen parent) {
						parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(this.item);

						parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
					}
				}

				@Override
				public void addOptions() {
					for (Item item : ItemRegistry.singleton.items) {
						if (item != ItemRegistry.singleton.EMPTY_SLOT) {
							this.options.add(new ItemOption(item));
						}
					}

					this.options.add(new CancelOption());
				}
			});
		}

	}
	
	public static class GiveKeyItemsOption extends Option {
		@Override
		public String getText() {
			return "Give Key Items";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(ItemRegistry.singleton.GAS_MASK);
			parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(ItemRegistry.singleton.WATER_CANTEEN);
			parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(ItemRegistry.singleton.MAGNIFYING_GLASS);
			parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(ItemRegistry.singleton.PUMPKIN);
			parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory().addItem(ItemRegistry.singleton.GRAPPLING_HOOK);

			parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
			

		}

	}
	
	public static class ReturnFurnitureOption extends Option {
		@Override
		public String getText() {
			return "Return Furniture";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			
			Map.removefurniture = true;
			

		}

	}
	
	public static class EquipCowboyHatOption extends Option {
		@Override
		public String getText() {
			return "Equip Cowboy Hat";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			
			CatWardrobe.currentWardrobe = 2;
			CatWardrobe.wardrobeChange = true;

			parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
			

		}

	}
	
	public static class RemoveClothesOption extends Option {
		@Override
		public String getText() {
			return "Remove Clothes";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			
			CatWardrobe.currentWardrobe = 0;
			CatWardrobe.wardrobeChange = true;

			parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
			

		}

	}
	
	public static class CensorWalrusOption extends Option {
		@Override
		
		public String getText() {
			return "Censor Ugly Walrus";
		}
		
		public void select(AbstractMenuScreen parent) {
			PlayLevelScreen.shouldcensorwalrus = true;
		}
	}

	public static class FillInventoryOption extends Option {
		@Override
		public String getText() {
			return "Fill Inventory";
		}

		@Override
		public void select(AbstractMenuScreen parent) {
			parent.screenCoordinator.push(new AbstractMenuScreen(parent.screenCoordinator) {
				class ItemOption extends Option {
					Item item;

					public ItemOption(Item item) {
						this.item = item;
					}

					@Override
					public String getText() {
						return this.item.toString();
					}

					@Override
					public void select(AbstractMenuScreen parent) {
						for (int i = 0; i < 55; i++) {
							parent.screenCoordinator.getPlayLevelScreen().getPlayerInventory()

									.addItem(this.item);
						}

						parent.screenCoordinator.dropUntil(parent.screenCoordinator.getPlayLevelScreen());
					}
				}

				@Override
				public void addOptions() {
					for (Item item : ItemRegistry.singleton.items) {
						if (item != ItemRegistry.singleton.EMPTY_SLOT) {
							this.options.add(new ItemOption(item));
						}
					}

					this.options.add(new CancelOption());
				}
			});
		}

	}

	public DebugMenuScreen(ScreenCoordinator screenCoordinator) {
		super(screenCoordinator);
	}

	@Override
	public String getTitle() {
		return "Debug Menu";
	}

	@Override
	public void initialize() {
		if (!DEBUG_ENABLED) {
			this.screenCoordinator.pop(this);
		} else {
			super.initialize();
		}
	}

	@Override
	public void addOptions() {
		this.options.add(new SwitchMapOption());
		this.options.add(new GiveItemOption());
		this.options.add(new ReturnFurnitureOption());
		this.options.add(new FillInventoryOption());
		this.options.add(new CensorWalrusOption());
		this.options.add(new GiveKeyItemsOption());
		this.options.add(new EquipCowboyHatOption());
		this.options.add(new RemoveClothesOption());
		this.options.add(new CancelOption());

	}
}
