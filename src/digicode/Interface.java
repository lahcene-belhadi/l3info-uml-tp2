
package digicode;

// package
import utils.enums.Color;
import utils.enums.State;

// lib
import java.util.Scanner;


public class Interface {

    private LED redLED;
    private LED greenLED;
    private Keyboard keyboard;

    public Interface() {

        // Instanciate the LEDs
        this.redLED = new LED(Color.RED);
        this.greenLED = new LED(Color.GREEN);
        
        this.keyboard = new Keyboard(5);

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

    /**
     * Returns the interface's keyboard
     * 
     * @return The interface's keyboard
     */
    public Keyboard getKeyboard() {

        return this.keyboard;

    }

    /**
     * Allows the user to interact with the door
     * 
     * @param door - The door to interact with
     */
    public void doorInteraction(Door door) {

        Scanner scan = new Scanner(System.in);

        // Door opening procedure
        System.out.print("Press 1 to open the door: ");

        int input = scan.nextInt();

        while (input != 1) {

            System.out.print("Press 1 to open the door: ");

            input = scan.nextInt();

        }

        door.open();

        // Door closing procedure
        System.out.print("Press 0 to close the door: ");;

        input = scan.nextInt();

        while (input != 0) {

            System.out.print("Press 0 to close the door: ");;

            input = scan.nextInt();

        }

        door.close();

    }
    
}
