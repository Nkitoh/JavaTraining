package ex13_04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReadFile {
	
	
	public static void main(String[] args) throws Exception {
		ReadFile file = new ReadFile();
		file.TypeValue("BOOLEAN.txt");
	}
	
	public ArrayList<Object> TypeValue(String fileName)
			throws NumberFormatException, IOException, NotCorrectFormat {
		
		FileInputStream in = null;

		try {
			in = new FileInputStream(fileName);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		
		ArrayList<Object> retArr = new ArrayList<Object>();

		while ((line = br.readLine()) != null) {
			String[] sp = line.split(" ");

			if (sp.length != 2)
				throw new NotCorrectFormat();
			
			if (sp[0].equals("BOOLEAN"))
				retArr.add(Boolean.parseBoolean(sp[1]));
			else if (sp[0].equals("Byte"))
				retArr.add(Byte.parseByte(sp[1]));
			else if (sp[0].equals("Byte"))
				retArr.add(Byte.parseByte(sp[1]));
			else if (sp[0].equals("Short"))
				retArr.add(Short.parseShort(sp[1]));
			else if (sp[0].equals("Integer"))
				retArr.add(Integer.parseInt(sp[1]));
			else if (sp[0].equals("Long"))
				retArr.add(Long.parseLong(sp[1]));
			else if (sp[0].equals("Float"))
				retArr.add(Float.parseFloat(sp[1]));
			else if (sp[0].equals("Double"))
				retArr.add(Double.parseDouble(sp[1]));
			else
				throw new NotCorrectFormat();
		}
		
		for (Object elem: retArr)
			System.out.println(elem);

		br.close();
		
		return retArr;
	}

}
