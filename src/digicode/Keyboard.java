
package digicode;

// package
import digicode.interfaces.Delayed;

// lib
import java.util.Scanner;
import java.lang.System;


public class Keyboard extends Delayed {

    private int[] validDigits = {0, 1, 2, 3, 4, 
                                 5, 6, 7, 8, 9};
    
    public Keyboard(int timeout) {

        this.timeout = timeout;

    }

    /**
     * Waits for a key to being pressed and write the value in the code array of
     * Digicode
     * 
     * @param digicode - The Digicode that is running this method
     * @param index - The index of the code array (Digicode) we are writing in
     */
    public void getKeyPressed(Digicode digicode) {

        int input = -1;

        Scanner scan = new Scanner(System.in).useDelimiter("");

        // Ask for a correct digit until timeout
        while (!this.timedOut) {

            System.out.print("Press a digit: ");
    
            input = scan.nextInt();
            
            // TEST
            if (this.validInput(input))
                break;
            
            else {
                System.out.println("Invalid input");
            }
    
        }

        if (input >= 0)
            digicode.writeCode(input, digicode.getReceived());

    }

    /**
     * Checks if the input is valid
     * 
     * @param input - The input
     * @return
     */
    private boolean validInput(int input) {

        for (int digit: this.validDigits)
            if (digit == input)
                    return true;

        return false;

    }
    
}
