package ch06_03;

import static org.junit.Assert.*;

import org.junit.Test;

import ch06_03.Verbose.How;

public class VerboseImplTest {

	@Test
	public void test() {
		VerboseImpl actual = new VerboseImpl();
		assertEquals(true,actual.getVerbosity().equals(VerboseImpl.How.valueOf("SILENT")));
		actual.setVerbosity(How.TERSE);
		assertEquals(true,actual.getVerbosity().equals(VerboseImpl.How.valueOf("TERSE")));
		actual.setVerbosity(How.NORMAL);
		assertEquals(true,actual.getVerbosity().equals(VerboseImpl.How.valueOf("NORMAL")));
		actual.setVerbosity(How.VERBOSE);
		assertEquals(true,actual.getVerbosity().equals(VerboseImpl.How.valueOf("VERBOSE")));
		
	}

}
