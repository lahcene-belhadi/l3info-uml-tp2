
package main;

// package
import digicode.Digicode;
import digicode.Door;


public class Main {

    public static void main(String[] args) {

        Door door = new Door();

        while (true) {
            
            Digicode digicode = new Digicode(door);
            digicode.start();
            
        }

    }

}
