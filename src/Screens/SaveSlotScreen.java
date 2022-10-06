package Screens;

import java.io.IOException;

import Engine.GraphicsHandler;
import Game.ScreenCoordinator;
import SpriteFont.SpriteFont;

import java.awt.*;

public class SaveSlotScreen extends AbstractMenuScreen {
    protected static abstract class SlotOption extends Option {
        public int slot;

        public SlotOption(int slot) {
            this.slot = slot;
        }

        @Override
        public String getText() {
            return String.format("Slot %d", this.slot + 1);
        }

        public String getFilename() {
            return String.format("%d.save", this.slot);
        }
    }

    public static class SaveOption extends SlotOption {
        public SaveOption(int slot) {
            super(slot);
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            PlayLevelScreen playLevelScreen = parent.screenCoordinator.getPlayLevelScreen();
            
            playLevelScreen.flagManager.updateFrom(playLevelScreen.player);

            try {
                playLevelScreen.flagManager.saveToSlot(this.slot);
            } catch (IOException exception) {
                exception.printStackTrace();
                // TODO: warn user?
            }

            parent.screenCoordinator.pop(parent);
        }
    }

    public static class LoadOption extends SlotOption {
        public LoadOption(int slot) {
            super(slot);
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            PlayLevelScreen playLevelScreen = parent.screenCoordinator.getPlayLevelScreen();
            
            try {
                playLevelScreen.flagManager.loadFromSlot(this.slot);
            } catch (Exception exception) {
                exception.printStackTrace();
                // TODO: warn user?
            }

            playLevelScreen.flagManager.updateTo(playLevelScreen.player);

            parent.screenCoordinator.pop(parent);
        }
    }

    public SlotType type;
    public SpriteFont titleText;

    public static enum SlotType {
        SAVE, LOAD
    };

    public SaveSlotScreen(ScreenCoordinator coordinator, SlotType type) {
        super(coordinator);
        this.type = type;
    }

    @Override
    public void addOptions() {
        for (int i = 0; i < 3; i++) {
            switch (this.type) {
                case SAVE:
                    this.options.add(new SaveOption(i));
                    break;
                case LOAD:
                    this.options.add(new LoadOption(i));
                    break;
            }
        }

        this.options.add(new CancelOption());
    }

    @Override
    public void initialize() {
        titleText = new SpriteFont(this.type == SlotType.SAVE ? "SAVE TO SLOT" : "LOAD FROM SLOT", 10, 355, "Comic Sans", 30, Color.white);
        titleText.setOutlineColor(Color.black);
        titleText.setOutlineThickness(3);
        super.initialize();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        titleText.draw(graphicsHandler);
        super.draw(graphicsHandler);
    }
}
