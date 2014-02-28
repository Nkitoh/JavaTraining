package ex13_05;


public class InsertChar {

	static String every3Num(String num) {
		
		if (num == null)
			throw new IllegalArgumentException("引数が不正です");
		
		StringBuilder retNum = new StringBuilder();
		int i = 0;
		
		for(int j = num.length() - 1; j >= 0; j--) {
			i++;
			retNum.insert(0,num.charAt(j));
			if ((i % 3) == 0 && (j - 1 >= 0))
				retNum.insert(0,',');
		}
		
		return retNum.toString();
	}
}
