package bufferedExamples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReadFile {

	public static void main(String[] args) throws IOException{
		Path file= Paths.get("testFiles/myFile.txt");
		Charset charset = Charset.forName("UTF-8");
		BufferedReader reader=null;
		
		try{
			//Creates a BufferedReader (java.io) in a more efficient way using Files from java.nio
			reader = Files.newBufferedReader(file, charset);		
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}finally {
            if (reader != null) {
                reader.close();
            }
		}
	}

}
