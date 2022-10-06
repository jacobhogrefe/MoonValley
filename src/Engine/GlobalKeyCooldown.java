package Engine;

import Utils.Stopwatch;

public class GlobalKeyCooldown {
    public static final KeyLocker GLOBAL_KEY_LOCKER = new KeyLocker();
    public Stopwatch stopwatch;
    public Key key;

    public GlobalKeyCooldown(Key key) {
        this.key = key;
        this.stopwatch = new Stopwatch();
        this.stopwatch.setWaitTime(0);
        this.stopwatch.reset();
    }

    public boolean isLocked() {
        if (this.stopwatch.isTimeUp() && !GLOBAL_KEY_LOCKER.isKeyLocked(this.key)) {
            return false;
        }

        return true;
    }

    public boolean isDown() {
        return Keyboard.isKeyDown(this.key);
    }

    public boolean isUp() {
        return Keyboard.isKeyUp(this.key);
    }

    /**
     * Try and start the lock timer, return true if we did, false if it was already going.
     * @return true
     */
    public boolean timeLock() {
        if (this.stopwatch.isTimeUp()) {
            this.stopwatch.setWaitTime(150);
            this.stopwatch.reset();
            return true;
        }

        return false;
    }

    /**
     * Check if the key is locked; if not, and it is down, "lock" the key (actually start the timer) and return true.
     * Else return false.
     * 
     * This can check if a key is pressed with a global cooldown.
     */
    public boolean onceDown() {
        return this.isDown() && this.timeLock();
    }

    /**
     * Cancel the cooldown if the key is up
     * @return true if the key was up, regardless of whether there was a cooldown or not
     */
    public boolean cancelIfUp() {
        if (this.isUp()) {
            this.stopwatch.setWaitTime(0); // end immediately
            this.stopwatch.reset();
            return true;
        } else {
            return false;
        }
    }

    public static class Keys {
        public static final GlobalKeyCooldown SPACE = new GlobalKeyCooldown(Key.SPACE);
        public static final GlobalKeyCooldown UP = new GlobalKeyCooldown(Key.UP);
        public static final GlobalKeyCooldown DOWN = new GlobalKeyCooldown(Key.DOWN);
    }
}
