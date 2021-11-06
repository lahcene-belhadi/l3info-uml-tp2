
package digicode;


public class Database {

    /**
     * Checks if the code is valid
     * 
     * @param code - The code to check
     * @return Tells if the code is valid
     */
    public static boolean checkCode(int[] code) {

        int[] validCode = {1,2,3,4};

        return code == validCode;

    }

}
