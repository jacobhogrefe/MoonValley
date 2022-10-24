package Screens;

import Game.Game;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.MushroomMap;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.moonValleyTitle;
import Maps.Biomes.BiomeMountains;
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
					this.options.add(new MapOption(new TitleScreenMap()));
					this.options.add(new MapOption(new moonValleyTitle()));
					this.options.add(new MapOption(new BiomeMountains()));
					//this.options.add(new MapOption(new TestMap()));
					this.options.add(new MapOption(new BiomeStart()));
					this.options.add(new MapOption(new MushroomMap()));
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
		this.options.add(new FillInventoryOption());
		this.options.add(new CancelOption());

	}
}
