package ex13_05;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertCommaTest {

	@Test
	public void test1543729() {
		String expected = "1,543,729";
		String actual = InsertChar.every3Num("1543729");
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void test123() {
		String expected = "123";
		String actual = InsertChar.every3Num("123");
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void test1234() {
		String expected = "1,234";
		String actual = InsertChar.every3Num("1234");
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void test12345() {
		String expected = "12,345";
		String actual = InsertChar.every3Num("12345");
		assertTrue(actual.equals(expected));
	}
	

	@Test
	public void test123456() {
		String expected = "123,456";
		String actual = InsertChar.every3Num("123456");
		assertTrue(actual.equals(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFail() {
		String test = null;
		InsertChar.every3Num(test);
	}
}
