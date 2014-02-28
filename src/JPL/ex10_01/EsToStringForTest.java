package ex10_01;

import static org.junit.Assert.*;

import org.junit.Test;


public class EsToStringForTest {

	@Test
	public void testEscapeN() {
		assertEquals(EsToStringFor.esToString("\n"), "\\n");
	}
	
	@Test
	public void testEscapeN2() {
		assertEquals(EsToStringFor.esToString("test\n"), "test\\n");
	}
	
	@Test
	public void testEscapeN3() {
		assertEquals(EsToStringFor.esToString("te\nst"), "te\\nst");
	}
	
	@Test
	public void testEscapeN4() {
		assertEquals(EsToStringFor.esToString("\ntest"), "\\ntest");
	}

	@Test
	public void testEscapeT() {
		assertEquals(EsToStringFor.esToString("\t"), "\\t");
	}

	@Test
	public void testEscapeB() {
		assertEquals(EsToStringFor.esToString("\b"), "\\b");
	}

	@Test
	public void testEscaperR() {
		assertEquals(EsToStringFor.esToString("\r"), "\\r");
	}

	@Test
	public void testEscapeF() {
		assertEquals(EsToStringFor.esToString("\f"), "\\f");
	}

	@Test
	public void testEscapeEn() {
		assertEquals(EsToStringFor.esToString("\\"), "\\\\");
	}
	
	@Test
	public void testEscapeQ() {
		assertEquals(EsToStringFor.esToString("\'"), "\\\'");
	}
	
	@Test
	public void testEscapeWQ() {
		assertEquals(EsToStringFor.esToString("\""), "\\\"");
	}

}
