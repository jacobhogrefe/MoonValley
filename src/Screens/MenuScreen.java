package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This is the class for the main menu screen
public class MenuScreen extends AbstractMenuScreen {
    protected Map background;

    public static class PlayGameOption extends Option {
        @Override
        public String getText() {
            return "PLAY GAME";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.setGameState(GameState.LEVEL);
        }
    }

    public static class ControlsOption extends Option {
        @Override
        public String getText() {
            return "CONTROLS";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.setGameState(GameState.CONTROLS);
        }
    }

    public static class CreditsOption extends Option {
        @Override
        public String getText() {
            return "CREDITS";
        }

        @Override
        public void select(AbstractMenuScreen parent) {
            parent.screenCoordinator.setGameState(GameState.CREDITS);
        }
    }

    public MenuScreen(ScreenCoordinator screenCoordinator) {
        super(screenCoordinator);
    }
    
    @Override
    public void initialize() {
        background = new TitleScreenMap();
        background.setAdjustCamera(false);

        super.initialize();
    }

    @Override
    public void addOptions() {
        this.options.add(new PlayGameOption());
        this.options.add(new ControlsOption());
        this.options.add(new CreditsOption());
    }

    @Override
    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        super.update();
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        super.draw(graphicsHandler);    
    }
}
