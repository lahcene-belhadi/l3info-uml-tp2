
package digicode;

// lib
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;


public class Archive {

    /**
     * Archives the attempt
     * 
     * @param attempt - The int array representing the attempt
     */
    public void archive(int[] attempt) {

        this.createArchiveFile();
        Instant date = Instant.now();

        try {

            // Get the archive file
            FileWriter archive = new FileWriter("archive.txt", true);

            // Prepare the line to write in the file
            String strAttempt = new String();
            strAttempt += date + ": ";

            // Add all the digit to the line
            for (int digit: attempt) 
                if (digit >= 0)
                    strAttempt += digit;

            // Write the line into the file
            archive.write(strAttempt + '\n');

            archive.close();

        } catch (IOException exception) {

            System.out.println(exception);

        }

    }

    /**
     * Creates the archive file if it doesn't exist
     */
    private void createArchiveFile() {

        try {

            File archive = new File("archive.txt");

            archive.createNewFile();

        } catch (IOException exception) {

            System.out.println(exception);

        }

    }
    
}
