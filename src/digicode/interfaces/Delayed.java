
package digicode.interfaces;


public abstract class Delayed {
    
    protected int timeout;
    protected boolean timedOut;

    public void timeout() {

        this.timedOut = true;

    }
    
}
