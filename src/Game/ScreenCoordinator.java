package Game;

import java.util.ArrayDeque;

import Engine.DefaultScreen;
import Engine.GraphicsHandler;
import Engine.Screen;
import Screens.MenuScreen;
import Screens.PlayLevelScreen;

/*
 * Based on the current game state, this class determines which Screen should be shown
 * There can only be one "currentScreen", although screens can have "nested" screens
 */
public class ScreenCoordinator extends Screen {
	// currently shown Screen
	protected Screen currentScreen = new DefaultScreen();
	protected PlayLevelScreen playLevelScreen;
	public MenuScreen mainMenuScreen;

	@Override
	public void initialize() {
		// start game off with Menu Screen
		mainMenuScreen = new MenuScreen(this);
		mainMenuScreen.initialize();
		this.currentScreen = mainMenuScreen;
	}

	@Override
	public void update() {
		if(currentScreen != mainMenuScreen) {
			MenuScreen.MenuSound.pause();
		}
		currentScreen.update();
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
	
    protected ArrayDeque<Screen> stack = new ArrayDeque<>();

	/**
	 * "Enter" a new screen from a starting screen, with the ability to resume the old one later.
	 * @param screen the new screen to enter
	 */
    public void push(Screen screen) {
        this.stack.addLast(this.currentScreen);

        this.currentScreen = screen;
		this.currentScreen.initialize();

		if (this.currentScreen instanceof PlayLevelScreen) {
			this.playLevelScreen = (PlayLevelScreen) this.currentScreen;
		}

		this.debugPrintStack("push");
    }

	/**
	 * Drop down one frame.
	 * Be careful.
	 */
    protected void drop() {
        this.currentScreen = this.stack.removeLast();
    }

	/**
	 * Descend down the stack until reaching the desired Screen.
	 * e.g., goes from the controls menu to the pause menu to the playlevel.
	 */
	public void dropUntil(Screen screen) {
		while (this.currentScreen != screen) {
			this.drop();
		}

		this.debugPrintStack("dropUntil");
	}

	/**
	 * Exit a screen, going to the one before it. Warns if it is dropping more than one level (should not happen)
	 * @param screen the screen to get rid of.
	 */
    public void pop(Screen screen) {
        if (this.currentScreen != screen) {
            System.err.println("Warning; tried to pop a screen that wasn't the top screen.");
            this.dropUntil(screen);
        }
        
        this.drop();

		this.debugPrintStack("pop");
    }

	public void resumeLevel() {
		this.dropUntil(this.playLevelScreen);
	}

	public void exitToMenu() {
		this.dropUntil(this.mainMenuScreen);
	}

	private void debugPrintStack(String s) {
		boolean debug = false;

		if (!debug) { // debug output disabled
			return;
		}

		System.out.println(s);

		this.debugPrintStack();
	}

	private void debugPrintStack() {
		Object[] screens = this.stack.toArray();

		System.out.println("Screen stack contents:");

		for (int i = 0; i < this.stack.size(); i++) {
			System.out.printf("[%d] %s\n", i, screens[i].getClass().getName());
		}

		System.out.printf("[!!] %s\n", this.currentScreen.getClass().getName());
	}
}
