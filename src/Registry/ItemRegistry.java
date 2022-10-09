package Registry;

import java.util.ArrayList;
import Engine.ImageLoader;
import java.awt.Image;

public class ItemRegistry {
    public static final ItemRegistry singleton = new ItemRegistry();

    public ArrayList<Item> items = new ArrayList<>();

    public static class Item {
        public String name;
        public String description;
        public Image texture;

        public void addToRegistry(ItemRegistry registry) {
            registry.items.add(this);
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

            public Builder withSubimage(int x, int y) {
                return this.withImage(
                    ImageLoader.load("InventoryTileset.png")
                    .getSubimage(x, y, 16, 16)
                    .getScaledInstance(48, 48, Image.SCALE_SMOOTH)
                );
            }
        }
    }

    public ItemRegistry() {
        new Item.Builder() // 0
            .withName("Empty Slot")
            .withDescription("Just a plain old empty slot!")
            .withSubimage(17, 17)
            .build()
            .addToRegistry(this);
        
        new Item.Builder() // 1
            .withName("Cowboy Hat")
            .withDescription("Ain't 'nuff room in this here valley for the two of us, partner...")
            .withSubimage(68, 0)
            .build()
            .addToRegistry(this);
        
        new Item.Builder() // 2
            .withName("Yoshi Coin")
            .withDescription("A trademarked coin that we used anyways")
            .withSubimage(85, 0)
            .build()
            .addToRegistry(this);
    }
}
