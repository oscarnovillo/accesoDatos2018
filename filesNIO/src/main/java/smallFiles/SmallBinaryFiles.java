package smallFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SmallBinaryFiles {

    public static void main(String[] args) {
        Path input = Paths.get("testFiles/myFile.txt");
        Path output = Paths.get("testFiles/output.txt");
        //Array of bytes for storing all the bytes from the file
        byte[] fileArray;
        try {
            //Reading the whole file using java.nio
            fileArray = Files.readAllBytes(input);

            //Writing the whole array in a new file named output.txt using java.nio
            //The method write() ensures that the file is closed when all the bytes 
            //have been written and returns the path of written file.
            Files.write(output, fileArray);
        } catch (IOException io) {
            System.err.println(io);
        }
    }

}
