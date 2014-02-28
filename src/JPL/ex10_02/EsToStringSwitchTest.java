package ex10_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class EsToStringSwitchTest {

	@Test
	public void testEscapeN() {
		assertEquals(EsToStringSwitch.esToString("\n"), "\\n");
	}
	
	@Test
	public void testEscapeN2() {
		assertEquals(EsToStringSwitch.esToString("test\n"), "test\\n");
	}
	
	@Test
	public void testEscapeN3() {
		assertEquals(EsToStringSwitch.esToString("te\nst"), "te\\nst");
	}
	
	@Test
	public void testEscapeN4() {
		assertEquals(EsToStringSwitch.esToString("\ntest"), "\\ntest");
	}

	@Test
	public void testEscapeT() {
		assertEquals(EsToStringSwitch.esToString("\t"), "\\t");
	}

	@Test
	public void testEscapeB() {
		assertEquals(EsToStringSwitch.esToString("\b"), "\\b");
	}

	@Test
	public void testEscaperR() {
		assertEquals(EsToStringSwitch.esToString("\r"), "\\r");
	}

	@Test
	public void testEscapeF() {
		assertEquals(EsToStringSwitch.esToString("\f"), "\\f");
	}

	@Test
	public void testEscapeEn() {
		assertEquals(EsToStringSwitch.esToString("\\"), "\\\\");
	}
	
	@Test
	public void testEscapeQ() {
		assertEquals(EsToStringSwitch.esToString("\'"), "\\\'");
	}
	
	@Test
	public void testEscapeWQ() {
		assertEquals(EsToStringSwitch.esToString("\""), "\\\"");
	}

}
