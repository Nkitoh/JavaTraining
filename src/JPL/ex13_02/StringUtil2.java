package ex13_02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil2 {
	
	static int countStr(String str, String findStr) {
		Pattern pat = Pattern.compile(findStr);
		Matcher matcher = pat.matcher(str);
		
		int count = 0;
		int countStr = 0;
		
		while (matcher.find(countStr)) {
			count++;
			countStr = matcher.end();
		}
		return count;

	}
	
}
