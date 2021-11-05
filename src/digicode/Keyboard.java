
package digicode;

import java.util.Scanner;

// package
import digicode.interfaces.Delayed;


public class Keyboard extends Delayed {

    private String[] validDigits = {"0", "1", "2", "3", "4", 
                                    "5", "6", "7", "8", "9"};
    
    public Keyboard() {}

    /**
     * Waits for a key to being pressed and returns the value
     * 
     * @return The value the user had entered
     */
    public int getKeyPressed() {

        String input = "";
        Scanner scan = new Scanner(System.in);

        // Ask for a correct digit until timeout
        while (!this.timedOut) {

            System.out.println("Press a digit: ");
    
            input = scan.next();

            if (this.validInput(input))
                break;
    
        }

        return Integer.parseInt(input);

    }

    /**
     * Checks if the input is valid
     * 
     * @param input - The String input
     * @return
     */
    private boolean validInput(String input) {

        for (String digit: this.validDigits)
            if (digit == input && input.length() == 1)
                    return true;

        return false;

    }
    
}
