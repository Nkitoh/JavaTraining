package ex13_06;


public class InsertChar {

	static String everyNum(String num, char insertChar, int N) {
	
		if (num == null || N < 0 || num.length() < N)
			throw new IllegalArgumentException("引数が不正です");

		
		StringBuilder retNum = new StringBuilder();
		int i = 0;
		
		for(int j = num.length() - 1; j >= 0; j--) {
			i++;
			retNum.insert(0,num.charAt(j));
			if ((i % N) == 0 && (j - 1 >= 0))
				retNum.insert(0, insertChar);
		}
		
		return retNum.toString();
	}
}
