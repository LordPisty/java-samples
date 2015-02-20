package linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	private Node list;
	
	private Node singletonList;
	
	private Node doubleList;
	
	
	@Before
	public void setUp() throws Exception {
		list = new Node(0, new Node(1, new Node(2, new Node(3, null))));
		singletonList = new Node(3, null);
		doubleList = new Node(0, new Node(1, null));
	}

	@Test
	public void testNull() {
		assertEquals(null,Utils.reverse(null));
		assertEquals(null,Utils.reverse2(null));
		assertEquals(null,Utils.reverseRec(null));
		assertEquals(null,Utils.reverseTailRec(null, null));
	}
	
	@Test
	public void testSingleton() {
		assertEquals("Reverse should work properly:", "3", Utils.reverse(singletonList).toString());
	}
	
	@Test
	public void test() {
		assertEquals("Reverse should work properly:", "3210", Utils.reverse(list).toString());
	}
	
	@Test
	public void testDouble() {
		assertEquals("Reverse should work properly:", "10", Utils.reverse(doubleList).toString());
	}
	
	@Test
	public void testSingleton2() {
		assertEquals("Reverse should work properly:", "3", Utils.reverse2(singletonList).toString());
	}
	
	@Test
	public void test2() {
		assertEquals("Reverse should work properly:", "3210", Utils.reverse2(list).toString());
	}
	
	@Test
	public void testDouble2() {
		assertEquals("Reverse should work properly:", "10", Utils.reverse2(doubleList).toString());
	}
	
	@Test
	public void testSingletonRec() {
		assertEquals("Reverse should work properly:", "3", Utils.reverseRec(singletonList).toString());
	}
	
	@Test
	public void testRec() {
		assertEquals("Reverse should work properly:", "3210", Utils.reverseRec(list).toString());
	}
	
	@Test
	public void testDoubleRec() {
		assertEquals("Reverse should work properly:", "10", Utils.reverseRec(doubleList).toString());
	}
	
	@Test
	public void testSingletonTailRec() {
		assertEquals("Reverse should work properly:", "3", Utils.reverseTailRec(null, singletonList).toString());
	}
	
	@Test
	public void testTailRec() {
		assertEquals("Reverse should work properly:", "3210", Utils.reverseTailRec(null, list).toString());
	}
	
	@Test
	public void testDoubleTailRec() {
		assertEquals("Reverse should work properly:", "10", Utils.reverseTailRec(null, doubleList).toString());
	}

}
