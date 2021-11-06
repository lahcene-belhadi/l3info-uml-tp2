
package digicode;

// package
import digicode.interfaces.Delayed;


public class Door extends Delayed {

    private boolean open;
    private boolean locked;

    public Door() {

        this.timeout = 20;
        this.open = false;
        this.locked = true;

    }

    /**
     * Opens the door
     */
    public void open() {

        this.open = true;
        System.out.println("\nThe door is open.\n");

    }

    /**
     * Closes the door
     */
    public void close() {

        this.open = false;
        System.out.println("\nThe door is closed.\n");
        
    }

    /**
     * Unlocks the door
     */
    public void unlock() {

        this.locked = false;
        System.out.println("\nThe door is unlocked.\n");

    }

    /**
     * Locks the door
     */
    public void lock() {

        // If the door is open after being timed out: ring the alarm
        if (this.isOpen()) 
            Alarm.ring();
        
        else {

            this.locked = true;
            System.out.println("\nThe door is locked.\n");
            
        }

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
