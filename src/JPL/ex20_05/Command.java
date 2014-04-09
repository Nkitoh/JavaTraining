package ex20_05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Command {

	static public void grep(String filename, CharSequence target) throws FileNotFoundException, IOException{
		FileReader in = new FileReader(filename);
		LineNumberReader inLine = new LineNumberReader(in);
		
		String readString;
		while ((readString = inLine.readLine()) != null) {
			if (readString.contains(target)) 
				System.out.println(inLine.getLineNumber() + ":" + readString);
		}
	}

	public static void main(String[] args) {
		try {
			grep("src/ex20_05/in.txt", "test");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	


