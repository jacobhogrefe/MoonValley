package Level;

import Utils.Sound;

/**
 * A class designed to manage all the sounds within the game.
 * @author higgins!
 */
public class MusicManager {

    protected Player player;
    protected MusicState musicState, previousMusicState;
    protected Sound previousSound, currentSound, previousWalkingSound, walkingSound;

    //All sounds the different biomes
    protected Sound start = new Sound("biomeStart.wav", true);
    protected Sound startHome = new Sound("ariaMath.wav", true);
    protected Sound desert = new Sound("GhostRiders.wav", true);
    protected Sound desertHome = new Sound(null, true);
    protected Sound spooky = new Sound("BiomeSpookymusic.wav", true);
    protected Sound spookyHome = new Sound(null, true);
    protected Sound mushroom = new Sound("mushroom.wav", true);
    protected Sound mushroomHome = new Sound("mushroomHome.wav", true);
    protected Sound mountains = new Sound("mountainsBiome.wav", true);
    protected Sound mountainsHome = new Sound("steamGardens.wav", true);
    protected Sound saloon = new Sound("HippiesAndCowboys.wav",true);

    //If each biome would like a different walking sound add them here, and set the walking sound in the appropriate switch statement
    protected Sound grassWalking = new Sound("walkingGrass.wav", true);
    protected Sound stoneWalking = new Sound("walkingStone.wav", true);
    protected Sound woodWalking = new Sound("walkingWood.wav", true);
    protected Sound sandWalking = new Sound("sandWalking.wav", true);

    //Collectible sound effects are managed in here
    protected Sound keyCollectible = new Sound("keyCollectible.wav", false);
    protected Sound collectible = new Sound("collectible.wav", false);

    /**
     * MusicManager manages the current player walking sound and current music playing in each map. 
     * Sets the previous and current sounds to the same thing on creation (this makes it easier to 
     * check when the music state has changed).
     * @author higgins!
     */
    public MusicManager() {
        musicState = MusicState.START_HOME;
        previousSound = startHome;
        currentSound = startHome;
        previousWalkingSound = woodWalking;
        walkingSound = woodWalking;
    }

    /**
     * Updates the current music playing with the new musicState and then plays the appropriate music depending on the case. 
     * Pauses and restarts the previous music, and changes the player's walking sound.
     * @param musicState the musicState that the musicManager gets set to
     * @author higgins!
     */
    public void updateMusic(MusicState musicState) {
        previousSound.stop();
        player.getWalkingSound().stop();
        switch (musicState) {
            case DESERT:
                currentSound = desert;
                walkingSound = sandWalking;
                break;
            case DESERT_HOME:
                currentSound = desertHome;
                walkingSound = woodWalking;
                break;
            case MOUNTAINS:
                currentSound = mountains;
                walkingSound = stoneWalking;
                break;
            case MOUNTAINS_HOME:
                currentSound = mountainsHome;
                walkingSound = woodWalking;
                break;
            case MUSHROOM:
                currentSound = mushroom;
                walkingSound = grassWalking;
                break;
            case MUSHROOM_HOME:
                currentSound = mushroomHome;
                walkingSound = woodWalking;
                break;
            case SPOOKY:
                currentSound = spooky;
                walkingSound = grassWalking;
                break;
            case SPOOKY_HOME:
                currentSound = spookyHome;
                walkingSound = stoneWalking;
                break;
            case START:
                currentSound = start;
                walkingSound = grassWalking;
                break;
            case START_HOME:
                currentSound = startHome;
                walkingSound = woodWalking;
                break;
            case SALOON:
                currentSound = saloon;
                walkingSound = woodWalking;
                break;
            default:
                break;
        }
        currentSound.play();
        player.setWalkingSound(walkingSound);
        previousWalkingSound = walkingSound;
        previousSound = currentSound;
    }

    /**
     * Gets the current sound playing. Used in the collectible script to pause map music.
     * @author higgins!
     */
    public Sound getCurrentSound() {
        return currentSound;
    }

    /**
     * Sets the player to the {@code MusicManager} in order to change walking sounds.
     * @author higgins!
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the current walking sound.
     * @author higgins!
     */
    public Sound getWalkingSound() {
        return walkingSound;
    }

    /**
     * Gets the collectible sound in this class and sets it in the collectible script class.
     * @param isKeyCollectible Whether or not the collectible is important
     * @return Correct collectible sound
     * @author higgins!
     */
    public Sound getCollectibleSound(boolean isKeyCollectible) {
        return (isKeyCollectible) ? keyCollectible : collectible;
    }
}
