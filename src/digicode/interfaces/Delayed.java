
package digicode.interfaces;

// lib
import java.lang.Thread;


public abstract class Delayed {
    
    protected int timeout;
    protected boolean timedOut;

    /**
     * Tells that the current object is timed out
     */
    public void timeout() {

        this.timedOut = true;
        System.out.println("TIMEOUT !");

    }

    /**
     * Starts the countdown of the object. At the end of the timer
     * set the object to timed out.
     */
    public void startCountdown() {

        try {

            Thread.sleep(this.timeout * 1000);

        } catch (Exception threadException) {
         
            System.out.println("Exception: " + threadException);
        
        }

        this.timeout();

    }

    /**
     * Tells if the current object is timed out
     * 
     * @return The timeout state of the current object
     */
    public boolean isTimedout() {

        return this.timedOut;

    }
    
}
