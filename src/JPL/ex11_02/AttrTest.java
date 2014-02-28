package ex11_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class AttrTest {

	@Test
	public void testStringGetName() {
		Attr<String> attr = new Attr<String>("testName","testValue");
		
		assertTrue(attr.getName().equals("testName"));
	}
	
	public void testStringGetValue() {
		Attr<String> attr = new Attr<String>("testName","testValue");
		
		assertTrue(attr.getValue().equals("testValue"));
	}
	
	public void testStringSetValue() {
		Attr<String> attr = new Attr<String>("testName","testValue");
		
		String retTest = attr.setValue("testSetValue");
		assertTrue(retTest.equals("testValue"));
		assertTrue(attr.getValue().equals("testSetValue"));
	}

	@Test
	public void testIntegerGetName() {
		Attr<Integer> attr = new Attr<Integer>("testName",1701);
		
		assertTrue(attr.getName().equals("testName"));
	}
	
	public void testIntegerGetValue() {
		Attr<Integer> attr = new Attr<Integer>("testName",1701);
		
		assertTrue(attr.getValue()== 1701);
	}
	
	public void testIntegerSetValue() {
		Attr<Integer> attr = new Attr<Integer>("testName",1701);
		
		Integer retTest = attr.setValue(101);
		assertTrue(retTest ==1701);
		assertTrue(attr.getValue() == 101);
	}

	
}
