package ex09_03;

public class Pascal {
	int[][] pascal;

	Pascal(int N) {
		
		if (N < 0)
			throw new IllegalArgumentException("N must be positive");
		
		pascal = new int[N][];
		
		for (int i = 0; i < pascal.length; i++) {
			pascal[i] = new int[i + 1];
			for (int j = 0; j < pascal[i].length; j++) {
				boolean edge = (i <= 1 || j == 0 || j == i);
				pascal[i][j] = edge ?  1 : pascal[i - 1][j-1] + pascal[i - 1][j] ;
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
