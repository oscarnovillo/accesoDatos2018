package filesOperations;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.*;

public class FilesOperations {

    public static void main(String[] args) {
        //Make sure there is a file "input.txt" and have a copy of it as it will be removed
        Path p1 = Paths.get("testFiles/myFile.txt");
        Path p2 = Paths.get("testFiles/myDirectory");
        Path p3 = Paths.get("testFiles/nonexisting");

        /*
		 * According to the following code and the values returned,
		 * consult the API to decide if !Files.exists(path) and Files.notExists(path)
		 * are equivalent 
         */
     
        System.out.println(Files.exists(p1)); // true
        System.out.println(Files.notExists(p1)); // false
        System.out.println(!Files.exists(p1)); // false

        System.out.println(Files.exists(p3)); // false
        System.out.println(Files.notExists(p3)); // true
        System.out.println(!Files.exists(p3)); // true

        /* Try the following code with p1. Expected results? */
        boolean isRegularExecutableFile = Files.isRegularFile(p1)
                & Files.isReadable(p1) & Files.isExecutable(p1);
        System.out.println(isRegularExecutableFile);

        try {
            // Deleting the file or directory. Pay attention to the exceptions

            Files.delete(p1);
            Files.delete(p2);
        } catch (NoSuchFileException x) {
            System.err.format("%s: This file doesn't exist \n", p1);
        } catch (DirectoryNotEmptyException x) {
            // If the directory is not empty it cannot be deleted
            System.err.format("%s directory is not empty%n", p1);
        } catch (IOException x) {
            // Any other problems as access restrictions
            System.err.println(x);
        }

        // Try to delete the directory p2. Does it work? And if the directory
        // is not empty? Try it
        /*
		 * What is the difference between the method delete(Path) just seen and the method
		 * deleteIfExists(Path)? Consult the API and try it
         */
        //Copying files and directories
        /* What does the option REPLACE_EXISTING do? Show it*/
        Path p5 = Paths.get("../copy2.txt");
        Path p6 = Paths.get("testFiles/copy.txt");

        try {
            Files.copy(p6, p5, REPLACE_EXISTING);
        } catch (FileAlreadyExistsException x) {
            System.err.println(x);
        } catch (IOException x) {
            System.err.println(x);
        }

        /*What does the following code do?*/
        Path p7 = Paths.get("../move.txt");
        Path p8 = Paths.get("testFiles/move.txt");
        try {
            Files.move(p8, p7, REPLACE_EXISTING);
        } catch (FileAlreadyExistsException x) {
            System.err.println(x);
        } catch (IOException x) {
            System.err.println(x);
        }

    }

}
