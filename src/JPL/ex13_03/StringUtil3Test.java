package ex13_03;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtil3Test {

	@Test
	public void test1() {
		int N = 1;
		String[] expectedStr = new String[N];
		expectedStr[0] = "<test>";
		String[] actualStr;
		
		String inputStr = "test test <test>";
		
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		for (int i = 0; i < expectedStr.length; i++)
			assertTrue(actualStr[i].equals(expectedStr[i]));
	}

	@Test
	public void test2() {
		int N = 2;
		String[] expectedStr = new String[N];
		expectedStr[0] = "<test>";
		expectedStr[1] = "<test>";
		
		String[] actualStr;
		
		String inputStr = "test test <test> <test>";
		
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		for (int i = 0; i < expectedStr.length; i++)
			assertTrue(actualStr[i].equals(expectedStr[i]));
	}

	@Test
	public void test_reverse() {
		int N = 3;
		String[] expectedStr = new String[N];
		expectedStr[0] = "<test>";
		expectedStr[1] = "<test>";
		expectedStr[2] = "<testaaa>";
		String[] actualStr;
		
		String inputStr = "test test <test> <test> ><testaaa>";
		
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		for (int i = 0; i < expectedStr.length; i++)
			assertTrue(actualStr[i].equals(expectedStr[i]));
	}
	
	@Test
	public void test_only_start() {
		int N = 1;
		String[] expectedStr = new String[N];
		expectedStr[0] = "<test";
		
		String[] actualStr;
		
		String inputStr = "test test <test";
		
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		for (int i = 0; i < expectedStr.length; i++)
			assertTrue(actualStr[i].equals(expectedStr[i]));
	}
	
	@Test
	public void test_only_start2() {
		int N = 2;
		String[] expectedStr = new String[N];
		expectedStr[0] = "<test>";
		expectedStr[1] = "<test";
		
		String[] actualStr;
		
		String inputStr = "test <test> <test";
		
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		for (int i = 0; i < expectedStr.length; i++)
			assertTrue(actualStr[i].equals(expectedStr[i]));
	}
	
	@Test
	public void test_non() {
		
		String inputStr = "test test test";
		String[] actualStr;
		actualStr = StringUtil3.delimitedString(inputStr, '<', '>');
		
		assertNull(actualStr);
	}

}
