package Screens;

import Engine.*;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import Utils.Sound;

// This is the class for the main menu screen
public class MenuScreen extends AbstractMenuScreen {
    protected Map background = new TitleScreenMap();
    public static Sound MenuSound = new Sound("blueMoon.wav", true);

    public static class PlayGameOption extends Option {
        @Override
        public String getText() {
            return "PLAY GAME";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new PlayLevelScreen(parent.screenCoordinator));
        }
    }

    public static class ControlsOption extends Option {
        @Override
        public String getText() {
            return "CONTROLS";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new ControlsScreen(parent.screenCoordinator));
        }
    }

    public static class CreditsOption extends Option {
        @Override
        public String getText() {
            return "CREDITS";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.push(new CreditsScreen(parent.screenCoordinator));
        }
    }

    public static class QuitOption extends Option {
        @Override
        public String getText() {
            return "QUIT";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            System.exit(0);
        }
    }

    public MenuScreen(ScreenCoordinator screenCoordinator) {
        super(screenCoordinator);
    }

    @Override
    public void initialize() {
        background.setAdjustCamera(false);
        super.initialize();
    }

    @Override
    public void addOptions() {
        this.options.add(new PlayGameOption());
        this.options.add(new ControlsOption());
        this.options.add(new CreditsOption());
        this.options.add(new QuitOption());
    }

    @Override
    public void update() {
        // update background map (to play tile animations)
        MenuSound.play();
        background.update(null);
        super.update();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        super.draw(graphicsHandler);    
    }
}