package bufferedExamples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedAppendFile {

	public static void main(String[] args) {
		
		Path file = Paths.get("testFiles/output4.txt");
		Charset charset = Charset.forName("UTF-8");
		String s = "Lets add one more line at the end of the file";
		OpenOption[] options = new OpenOption[2];
		options[0] = APPEND;
		options[1] = WRITE;
		
		//Creates a BufferedWriter (java.io) in a more efficient way using Files from java.nio
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset,
				options)) {
			writer.newLine();
			writer.write(s, 0, s.length());
			writer.close();
			
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
