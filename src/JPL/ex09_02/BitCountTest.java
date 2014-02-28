package ex09_02;

import static org.junit.Assert.*;

import org.junit.Test;


public class BitCountTest {

	@Test
	public void testBitCount_7() {
		int val = Integer.parseInt("01111111", 2);
		int expected = 7;
		int actual;
		actual = BitCount.methodMyself(val);
		assertEquals(actual, expected);
	}
	
	@Test
	public void testBitCount_28() {
		int val = Integer.parseInt("1011111111111011111111101111111", 2);
		int expected = 28;
		int actual;
		actual = BitCount.methodMyself(val);
		assertEquals(actual, expected);
	}
	
	@Test
	public void testBitCount_31() {
		int val = Integer.parseInt("1111111111111111111111111111111", 2);
		int expected = 31;
		int actual;
		actual = BitCount.methodMyself(val);
		assertEquals(actual, expected);
	}
	
	@Test
	public void testBitCount_32() {
		int val = -1;
		int expected = 32;
		int actual;
		actual = BitCount.methodMyself(val);
		assertEquals(actual, expected);
	}

}
