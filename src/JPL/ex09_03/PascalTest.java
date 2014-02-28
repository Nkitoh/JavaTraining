package ex09_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalTest {

	@Test
	public void Pacal_6() {
		int[][] expectPascal = {
                { 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
        };
		Pascal actual = new Pascal(6);
		testPascal(actual.pascal,expectPascal);
		
	}
	
	@Test
	public void Pacal_12() {
		int[][] expectPascal = {
				{ 1 },
                { 1, 1 },
                { 1, 2, 1 },
                { 1, 3, 3, 1 },
                { 1, 4, 6, 4, 1 },
                { 1, 5, 10, 10, 5, 1 },
                { 1, 6, 15, 20, 15, 6, 1 },
                { 1, 7, 21, 35, 35, 21, 7, 1 },
                { 1, 8, 28, 56, 70, 56, 28, 8, 1 },
                { 1, 9, 36, 84, 126, 126, 84, 36, 9, 1 },
                { 1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1 },
                { 1, 11, 55, 165, 330, 462, 462, 330, 165, 55, 11, 1 },
        };
		Pascal actual = new Pascal(12);
		testPascal(actual.pascal,expectPascal);

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Pacal_m2(){
		Pascal actual = new Pascal(-2);
	}
	
	static void testPascal(int[][]actual, int[][]expected) {
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				assertEquals(actual[i][j], expected[i][j]);
			}
		}
	}

}
