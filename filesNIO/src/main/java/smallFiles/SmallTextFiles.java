package smallFiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SmallTextFiles {

    public static void main(String[] args) {
        Path input = Paths.get("testFiles/myFile.txt");
        Path output = Paths.get("testFiles/output2.txt");
        //List of string to store the lines of the file
        List<String> fileList;
        Charset charset;
        try {
            charset = Charset.forName("UTF-8");

            //Reading the whole file using java.nio
            fileList = Files.readAllLines(input);

            //Writing the whole array in a new file named output.txt using java.nio
            //The method write() ensures that the file is closed when all the bytes 
            //have been written and returns the path of written file.
            Files.write(output, fileList, charset);
        } catch (IOException io) {
            System.err.println(io);
        }
    }

}
