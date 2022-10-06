package Game;

import java.util.ArrayDeque;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Game.GameState;
import Level.PlayerInventory;
import Screens.CreditsScreen;
import Screens.HouseScreen;
import Screens.ControlsScreen;
import Screens.MenuScreen;
import Screens.PauseScreen;
import Screens.PlayLevelScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	protected PlayLevelScreen playLevelScreen;

	// keep track of gameState so ScreenCoordinator knows which Screen to show
	protected GameState gameState;
	protected GameState previousGameState;
	

	public GameState getGameState() {
		return gameState;
	}

	// Other Screens can set the gameState of this class to force it to change the currentScreen
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void initialize() {
		// start game off with Menu Screen
		gameState = GameState.MENU;
	}

	@Override
	public void update() {
		do {
			// if previousGameState does not equal gameState, it means there was a change in gameState
			// this triggers ScreenCoordinator to bring up a new Screen based on what the gameState is
			if (previousGameState != gameState) {
				switch(gameState) {
					case MENU:
						currentScreen = new MenuScreen(this);
						break;
					case LEVEL:
						currentScreen = new PlayLevelScreen(this);
						break;
					case CREDITS:
						currentScreen = new CreditsScreen(this);
						break;
					case CONTROLS:
						currentScreen = new ControlsScreen(this);
						break;
				}

				if (gameState != GameState.STACK) {
					currentScreen.initialize();
				}
			}
			previousGameState = gameState;

			// call the update method for the currentScreen
			currentScreen.update();
		} while (previousGameState != gameState);
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		// call the draw method for the currentScreen
		currentScreen.draw(graphicsHandler);
	}

	public PlayLevelScreen getPlayLevelScreen() {
		return playLevelScreen;
	}

	/* RECURSIVE FUNCTIONALITY BELOW @author hle0 */

	protected static class StackFrame {
        public GameState state;
        public Screen screen;

        public StackFrame(GameState state, Screen screen) {
            this.state = state;
            this.screen = screen;
        }
    }
	
    protected ArrayDeque<StackFrame> stack = new ArrayDeque<>();

    public void push(Screen screen) {
        this.stack.push(new StackFrame(this.gameState, this.currentScreen));

        this.gameState = GameState.STACK;
        this.currentScreen = screen;
		this.currentScreen.initialize();
    }

    protected void drop() {
        StackFrame frame = this.stack.pop();

        this.gameState = frame.state;
        this.currentScreen = frame.screen;
    }

    public void pop(Screen screen) {
        if (this.currentScreen != screen) {
            System.err.println("Warning; tried to pop a screen that wasn't the top screen.");
            while (this.currentScreen != screen) {
                this.drop();
            }
        }
        
        this.drop();
    }
}
