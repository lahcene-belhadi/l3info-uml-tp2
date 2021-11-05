
package digicode;

// package
import utils.enums.State;


public class Digicode {

    private int[] code = {-1, -1, -1, -1};
    private State state;

    public Digicode() {

        // Init the state of the system to OFF
        this.state = State.OFF;

    }

    /**
     * Turns ON the system
     */
    public void start() {

        this.state = State.ON;

    }

    /**
     * Turns OFF the system
     */
    public void stop() {

        this.state = State.OFF;

    }

    /**
     * Reboot the system
     */
    public void reboot() {

        // If the system is already off: Turns it ON
        if (this.getState() == State.OFF)
            this.start();
        
        // Otherwise: Turns OFF the system before turning it ON
        else {

            this.stop();
            this.start();

        }

    }

    /**
     * Returns the current state of the system
     * 
     * @return The state of the system
     */
    public State getState() {

        return this.state;

    }
    
}
