
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

        for (int i=0; i < 4; i++)
            if (code[i] != validCode[i])
                return false;

        return true;

    }

}
