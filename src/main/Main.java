
package main;

// package
import digicode.Digicode;


public class Main {

    public static void main(String[] args) {

        Digicode digicode = new Digicode();

        System.out.println(digicode.getState());

        digicode.start();

        System.out.println(digicode.getState());

        digicode.reboot();

        System.out.println(digicode.getState());

        digicode.stop();

        System.out.println(digicode.getState());
    
    }

}
