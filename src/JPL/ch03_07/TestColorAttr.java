package ch03_07;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestColorAttr {

	@Test
	public void test_equals_same() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test1",new ScreenColor("red"));
		
		assertEquals(true, test1.equals(test2));
	}
	
	@Test
	public void test_equals_defferent_name() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test2",new ScreenColor("red"));
		
		assertEquals(false, test1.equals(test2));
	}
	
	@Test
	public void test_equals_defferent_color() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test1",new ScreenColor("blue"));
		
		assertEquals(false, test1.equals(test2));
	}
	
	@Test
	public void test_equals_defferent_both() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test2",new ScreenColor("blue"));
		
		assertEquals(false, test1.equals(test2));
	}

	@Test
	public void test_hashCode_same() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test1",new ScreenColor("red"));
		
		assertEquals(true, test1.hashCode() == test2.hashCode());
	}
	
	@Test
	public void test_hashCode_different() {
		ColorAttr test1 = new ColorAttr ("test1",new ScreenColor("red"));
		ColorAttr test2 = new ColorAttr ("test2",new ScreenColor("blue"));
		
		assertEquals(false, test1.hashCode() == test2.hashCode());
	}

}
