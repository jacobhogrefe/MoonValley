package Game;

import Engine.GameWindow;
import Engine.ScreenManager;

/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator class will dictate what the game does
 */
public class Game {
    protected static Game instance = null;
    protected static Object instanceLock = new Object();

    public static Game getRunningInstance() {
        return instance;
    }

    protected ScreenCoordinator screenCoordinator;
    
    public Game() {
        synchronized(instanceLock) {
            if (instance == null) {
                instance = this;
            } else {
                throw new IllegalStateException("There can only be one running instance of Game");
            }
        }

        GameWindow gameWindow = new GameWindow();
        gameWindow.startGame();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenCoordinator = new ScreenCoordinator();
        screenManager.setCurrentScreen(screenCoordinator);
    }

    public ScreenCoordinator getScreenCoordinator() {
        return screenCoordinator;
    }

    public static void main(String[] args) {
        new Game();
    }
}
