package ex20_10;

import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SentUtil {
	private HashMap<String, Integer> wordTable;
	private StreamTokenizer tFile;
	
	public SentUtil(FileReader file) {
		this.wordTable = new HashMap<String, Integer>();
		this.tFile = new StreamTokenizer(file);
	}
	public void numWords() throws IOException {
		
		int c;
		while ((c = tFile.nextToken()) != StreamTokenizer.TT_EOF) {
				String value = tFile.sval;
				count(value);
		}
		
	}
	
	public void count(String key) {
		if (key == null)
			return;
		
		if (wordTable.containsKey(key)) {
			int count = wordTable.get(key) + 1;
			wordTable.put(key, count);
		}
		else
			wordTable.put(key, 1);
	}

	public void print() throws IOException{
		Iterator<Map.Entry<String, Integer>> it = wordTable.entrySet().iterator();
		while (it.hasNext()) 
			System.out.println(it.next());
	}
	
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("src/ex20_10/in.txt");
			
			SentUtil test = new SentUtil(f);
			test.numWords();
			test.print();
			
			f.close();
		}catch (IOException e) {
			e.getMessage();
		}
		
		
	}
}
