package ex13_03;

import java.util.ArrayList;
import java.util.List;

public class StringUtil3 {

	static String[] delimitedString(String from, char start, char end) {
		String[] retString = null;
		
		int startIndex = 0;
		boolean endPoint = true;
		
		List<String> list = new ArrayList<String>();
		int startPos;
		int endPos;
	
		while (endPoint) {
			startPos = from.indexOf(start, startIndex);
			endPos = from.indexOf(end, startIndex);

			if (startPos == -1) 
				endPoint = false;

			else if (endPos == -1) {
				list.add(from.substring(startPos));
				endPoint = false;
			} 
			
			else if (startPos > endPos)
				startIndex = startPos;
			
			else {
				list.add(from.substring(startPos, endPos + 1));
				startIndex = endPos + 1;
			}
		}
			if (list.size() != 0)
				retString = (String[]) list.toArray(new String[0]);
		return retString;
	}
}
