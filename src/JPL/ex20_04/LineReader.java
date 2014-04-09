package ex20_04;

import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class LineReader extends FilterReader{

	private boolean EOF;
	
	LineReader(Reader in) {
		super(in);
	}
	
	public String readLine() throws IOException
	{
		StringBuilder retString = new StringBuilder();
		
		if (EOF == true)
			return null;
		
		int c;
		while ((c = in.read()) != '\n') {
			retString.append((char)c);
			if (c == -1) {
				EOF = true;
				break;
			}
		}
		return retString.toString();
		
	}
	
	public static void main(String[] args) throws IOException
	{
		FileReader in = new FileReader("src/ex20_04/in.txt");
		LineReader inLine = new LineReader(in);
		
		String line;
		while ((line = inLine.readLine()) != null) 
			System.out.print(line);
		
		inLine.close();
	}
}
