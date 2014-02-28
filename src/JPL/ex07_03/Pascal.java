package ex07_03;

public class Pascal {
	int[][] pascal;

	//となる
	Pascal(int N) {
		if (N < 0)
			throw new IllegalArgumentException("N must be positive");
		
		pascal = new int[N][];

		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new int[i + 1];
			for (int j = 0; j < pascal[i].length; j++) {
				if (i <= 1) {
					pascal[i][j] = 1;
				} else if (i > 1) {
					if (j == 0 || j == i) {
						pascal[i][j] = 1;
					} else {
						pascal[i][j] = pascal[i - 1][j-1] + pascal[i - 1][j];

					}
				}
			}
		}
	}
	

	void printPascal() {
		for (int i = 0; i < pascal.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.printf(" %6d", pascal[i][j]);
			}
			System.out.printf("\n");
		}
	}

	public static void main(String[] args) {
		Pascal pascal = new Pascal(-2);
		pascal.printPascal();
	}
}
