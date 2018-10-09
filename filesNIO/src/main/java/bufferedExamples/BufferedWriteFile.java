package bufferedExamples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriteFile {

	public static void main(String[] args) {
		Path file= Paths.get("testFiles/output4.txt");
		Charset charset = Charset.forName("UTF-8");
		String[] s=new String[3];
		s[0]= "Writing the first line to the file";
		s[1]= "Now writing the second one";
		s[2]= "Writing one more line";
		//Creates a BufferedWriter (java.io) in a more efficient way using Files from java.nio
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (int i = 0; i < s.length; i++) {
				writer.write(s[i], 0, s[i].length());
				//Writes a newLine for carriage return and linefeed
				if (i<s.length-1) writer.newLine();
			}
		    writer.close();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}

}
