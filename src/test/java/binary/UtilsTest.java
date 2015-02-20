package binary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBitsDiff() {
		assertEquals("Result should match for 12 and 16", 3, Utils.countBitsDifference(12, 16));
	}
	
	@Test
	public void testCountOnes() {
		assertEquals("Result should match for 12", 2, Utils.countOnes(12));
	}
	
	@Test
	public void testCountOnes2() {
		assertEquals("Result should match for 13", 3, Utils.countOnes2(13));
	}
	
	@Test
	public void testisPower() {
		assertTrue("0 is not power of 2", !Utils.isPowerOf2(0));
	}

}
