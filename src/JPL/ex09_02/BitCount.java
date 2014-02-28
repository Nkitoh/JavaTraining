package ex09_02;

public class BitCount {

	static int methodMyself(int val) {
		int count = 0;
		int Mask = 0x80000000;
		for (; val != 0; val <<= 1)
			if ((val & Mask) == 0x80000000)
				count++;
		return count;
	}

	// プログラミング言語Cを参照
	static int methodPLC(int x) {
		int b;

		for (b = 0; x != 0; x &= x - 1) {
			b++;
		}

		return b;
	}

	public static void main(String[] args) {
		int val = 0xffffffff;
		System.out.println(methodPLC(val));
		System.out.println(val);
	}
}
