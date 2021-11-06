
package digicode;

// package
import utils.enums.State;
import utils.Future;

// lib
import java.lang.System;
import java.util.concurrent.CompletableFuture;
import java.lang.Runnable;


public class Digicode {

    private int[] code = {-1, -1, -1, -1};
    private int received;
    private State state;
    private Interface ui;
    private Keyboard keyboard;
    private Door door;

    public Digicode(Door door) {

        this.received = 0;

        // Init the state of the system to OFF
        this.state = State.OFF;
        
        this.ui = new Interface();

        this.keyboard = this.ui.getKeyboard();

        this.door = door;

    }

    /**
     * Turns ON the system
     */
    public void start() {

        this.state = State.ON;

        // Prepare the future tasks to run the countdown 
        // asynchronously
        Runnable countDown = () -> { this.keyboard.startCountdown(); };

        // Prepare to run the keyboard asynchronously
        Runnable asyncKeyboard = () -> { this.keyboard.getKeyPressed(this); };

        // Wait for the first key to be pressed
        CompletableFuture<Void> kb = CompletableFuture.runAsync(asyncKeyboard);

        // Wait until a key is pressed
        Future.waitForCompletion(kb);

        // Once a key had been pressed
        // turn on the green led
        this.ui.turnOnGreenLED();

        // Start the countdown
        CompletableFuture<Void> cd = CompletableFuture.runAsync(countDown);

        // Ask for a key press until the user had entered 4 digit while the
        // keyboard is still available
        while (this.received < 4 && !this.keyboard.isTimedout()) {

            kb = CompletableFuture.runAsync(asyncKeyboard);

            // Wait for the user to press a key while the keyboard is not timed
            // out
            Future.waitForCompletionTimeout(kb, this.keyboard);

        }

        // Archive the attempt
        Archive archive = new Archive();
        archive.archive(this.code);
        
        // If the user entered 4 digits
        if (this.received == 4) {

            this.ui.turnOffRedLED();

            // Check if the code is valid
            boolean valid = Database.checkCode(this.code);

            if (valid) 
                this.door.unlock();

            // Prepare the door's countdown
            Runnable doorCountdown = () -> { this.door.startCountdown(); };

            // Prepare the user's interaction with the door
            Runnable userInteraction = () -> { 

                this.ui.doorInteraction(this.door); 

            };

            // Start the door's countdown
            CompletableFuture<Void> doorCd = CompletableFuture.runAsync(
                doorCountdown
            );

            // Start the user's interaction with the door
            CompletableFuture<Void> doorInteract = CompletableFuture.runAsync(
                userInteraction
            );

            Future.waitForCompletionTimeout(doorInteract, this.door);
            
            // The user can open or close the door as many as he wants while
            // the timer is still running
            while (!doorCd.isDone()) {
                
                doorInteract = CompletableFuture.runAsync(userInteraction);

                Future.waitForCompletionTimeout(doorInteract, this.door);

            }

            doorInteract.cancel(true);

            // Lock the door at the end of the door timer
            this.door.lock();
        
            this.ui.turnOffGreenLED();
            this.ui.turnOnRedLED();


        } else {

            System.out.println("Not enough digits.");
            this.ui.turnOffGreenLED();
            this.ui.turnOnRedLED();

        }

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

    /**
     * Write the value into the code array at the index
     * 
     * @param value - The value to insert into the code array
     * @param index - The index to insert the value
     */
    public void writeCode(int value, int index) {

        this.code[index] = value;
        this.received++;

    }

    /**
     * Sets the keyboard pointer
     */
    public void setKeyboard(Keyboard keyboard) {

        this.keyboard = keyboard;

    }

    /**
     * Returns the number of digit received
     * 
     * @return The number of digit received
     */
    public int getReceived() {

        return this.received;

    }

    /**
     * Sets the digicode's door
     * 
     * @param door - The door reference
     */
    public void setDoor(Door door) {

        this.door = door;

    }

    // TEST
    public void displayCode() {

        for (int digit: this.code)
            System.out.print(digit + " ");

    }
    
}
