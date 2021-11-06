
package digicode;

// package
import digicode.interfaces.Delayed;


public class Door extends Delayed {

    private boolean open;
    private boolean locked;

    public Door() {

        this.open = false;
        this.locked = true;

    }

    /**
     * Opens the door
     */
    public void open() {

        this.open = true;

    }

    /**
     * Closes the door
     */
    public void close() {

        this.open = false;
        
    }

    /**
     * Unlocks the door
     */
    public void unlock() {

        this.locked = false;

    }

    /**
     * Locks the door
     */
    public void lock() {
        
        this.locked = true;

    }

    /**
     * Tells if the door is open
     * 
     * @return The state of the door
     */
    public boolean isOpen() {

        return this.open;

    }

    /**
     * Tells if the door is locked
     * 
     * @return The state of the door's lock
     */
    public boolean isLocked() {

        return this.locked;

    }
    
}
