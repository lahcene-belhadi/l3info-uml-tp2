
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

}
