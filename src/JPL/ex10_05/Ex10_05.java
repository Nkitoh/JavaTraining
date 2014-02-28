package ex10_05;

public class Ex10_05 {

	static String interval(String orgStr ,int begin, int end) {
		if (begin < 0 || end < 0)
			throw new IllegalArgumentException("begin and end must be positive");
		if (end < begin)
			throw new IllegalArgumentException("end must bigger than begin");
		if (end > orgStr.length())
			throw new IllegalArgumentException("end must smaller than str length");
		
		StringBuffer retStr = new StringBuffer(end - begin);
		
		for(int i = begin; i <= end; i++)
			retStr.append(orgStr.charAt(i));
		
		return retStr.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(interval("abcdefg", 0, 0));
	}	
}
