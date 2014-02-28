package ex10_04;

public class BitCount {

	// Ex09_02
	static int methodMyself(int val) {
		int count = 0;
		int Mask = 0x80000000;
		// 元のfor文
		/*
		for (; val != 0; val <<= 1)
			if ((val & Mask) == 0x80000000)
				count++;
		*/

		// while文に直したもの。
		while (val != 0) {
			if ((val & Mask) == 0x80000000)
				count++;
			//System.out.println(Integer.toBinaryString(Mask));
			val <<= 1;
		}
		return count;
	}
}
