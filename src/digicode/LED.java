
package digicode;

// package
import utils.enums.State;
import utils.enums.Color;


public class LED {

    private State state;
    private Color color;

    public LED(Color color) {

        this.state = State.OFF;
        this.color = color;

    }

    /**
     * Turns ON or OFF the light depending on its current state
     */
    public void switchState() {

        if (this.getState() == State.OFF)
            this.state = state.ON;
        
        else 
            this.state = state.OFF;

    }

    /**
     * Tells the LED's state
     * 
     * @return The LED state
     */
    public State getState() {

        return this.state;

    }

}
