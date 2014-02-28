package ex13_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertCommaTest {

	@Test
	public void test1543729() {
		String expected = "1,543,729";
		String actual = InsertChar.everyNum("1543729", ',', 3);
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void test123() {
		String expected = "1;23";
		String actual = InsertChar.everyNum("123", ';', 2);
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void test12() {
		String expected = "12";
		String actual = InsertChar.everyNum("12", ';', 2);
		assertTrue(actual.equals(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFail1() {
		String actual = InsertChar.everyNum("12", ';', -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFail2() {
		String expected = "12";
		String actual = InsertChar.everyNum("12", ';', 3);
		assertTrue(actual.equals(expected));
	}

}
