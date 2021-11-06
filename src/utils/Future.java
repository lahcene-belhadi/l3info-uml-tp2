
package utils;

// package
import digicode.interfaces.Delayed;

// lib
import java.util.concurrent.CompletableFuture;


public class Future {

    /**
     * Wait for a CompletableFuture to complete
     * 
     * @param future - The future to wait for
     */
    public static void waitForCompletion(CompletableFuture future) {

        while(!future.isDone()) {}

    }

    /**
     * Wait for a CompletableFuture to complete in a certain amount of time
     * 
     * @param future - The future to wait for
     * @param delay - The Delayed object to check
     */
    public static void waitForCompletionTimeout(CompletableFuture future, 
                                                Delayed delay) {

        while(!future.isDone() && !delay.isTimedout()) {}
        
        // If timeout, cancel the future
        if (!future.isDone())
            future.cancel(true);

    }
    
}
