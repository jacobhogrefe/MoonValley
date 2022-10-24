package Level;

import Utils.Sound;

public class MusicManager {

    protected MusicState musicState, previousMusicState;
    protected Sound mainMenu = new Sound("blueMoon.wav", true);
    protected Sound start = new Sound("biomeStart.wav", true);
    protected Sound desert = new Sound(null, true);
    protected Sound spooky = new Sound(null, true);
    protected Sound toxic = new Sound(null, true);
    protected Sound mushroom = new Sound("mushroom.wav", true);
    protected Sound mountains = new Sound(null, true);
    protected Sound startHome = new Sound("ariaMath.wav", true);
    protected Sound desertHome = new Sound(null, true);
    protected Sound spookyHome = new Sound(null, true);
    protected Sound toxicHome = new Sound(null, true);
    protected Sound mushroomHome = new Sound("mushroomHome.wav", true);
    protected Sound mountainsHome = new Sound(null, true);
    protected Sound previousSound, currentSound;

    //sets the previous and current sounds to the same thing on creation (this makes it easier to check when the music state has changed)
    public MusicManager() {
        previousMusicState = MusicState.START;
        musicState = MusicState.START;
        previousSound = start;
        currentSound = start;
    }

    //checks if the current music state is different from the previous music state
    //will play the appropriate music depending on the case, and will pause and restart the previous music 
    public void updateMusic() {
        if (previousMusicState != musicState) {
            switch (musicState) {
                case DESERT:
                    currentSound = desert;
                    break;
                case DESERT_HOME:
                    currentSound = desertHome;
                    break;
                case MOUNTAINS:
                    currentSound = mountains;
                    break;
                case MOUNTAINS_HOME:
                    currentSound = mountainsHome;
                    break;
                case MUSHROOM:
                    currentSound = mushroom;
                    break;
                case MUSHROOM_HOME:
                    currentSound = mushroomHome;
                    break;
                case SPOOKY:
                    currentSound = spooky;
                    break;
                case SPOOKY_HOME:
                    currentSound = spookyHome;
                    break;
                case START:
                    currentSound = start;
                    break;
                case START_HOME:
                    currentSound = startHome;
                    break;
                case TOXIC:
                    currentSound = toxic;
                    break;
                case TOXIC_HOME:
                    currentSound = toxicHome;
                    break;
                default:
                    break;
            }
            previousSound.stop();
            currentSound.play();
            previousSound = currentSound;
            previousMusicState = musicState;
        }
    }

    //sets the music state to change the music
    public void setMusicState(MusicState musicState) {
        this.musicState = musicState;
    }

    //pauses the current music
    public Sound getCurrentSound() {
        return currentSound;
    }
}
