
package digicode;

// package
import utils.enums.Color;
import utils.enums.State;


public class Interface {

    private LED redLED;
    private LED greenLED;

    public Interface() {

        // Instanciate the LEDs
        this.redLED = new LED(Color.RED);
        this.greenLED = new LED(Color.GREEN);

        // The red LED is ON at the beginning of the process
        this.turnOnRedLED();

    }

    /**
     * Turns ON the red LED
     * 
     * @return Tells if the operation had succeed
     */
    public boolean turnOnRedLED() {

        if (this.redLED.getState() == State.OFF) {

            this.redLED.switchState();
            return true;

        }

        return false;

    }

    /**
     * Turns OFF the red LED
     * 
     * @return Tells if the operation had succeed
     */
    public boolean turnOffRedLED() {

        if (this.redLED.getState() == State.ON) {

            this.redLED.switchState();
            return true;

        }

        return false;

    }

    /**
     * Turns ON the green LED
     * 
     * @return Tells if the operation had succeed
     */
    public boolean turnOnGreenLED() {

        if (this.greenLED.getState() == State.OFF) {

            this.greenLED.switchState();
            return true;

        }

        return false;

    }

    /**
     * Turns OFF the green LED
     * 
     * @return Tells if the operation had succeed
     */
    public boolean turnOffGreenLED() {

        if (this.greenLED.getState() == State.ON) {

            this.greenLED.switchState();
            return true;

        }

        return false;

    }
    
}
