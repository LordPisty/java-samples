package string;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("Strings should match: ", "onafets", Utils.reverse("stefano"));
	}

}
