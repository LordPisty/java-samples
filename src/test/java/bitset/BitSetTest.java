package bitset;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by crespis on 3/20/2015.
 */
public class BitSetTest {

    private BitSet instance;

    @Before
    public void setUp() throws Exception {
        instance = new BitSet(40);
    }

    @Test
    public void testBitSetGet() {
        instance.set(5);
        assertEquals("Result should match for set/get", "1", instance.get(5));
    }

    @Test
    public void testRepresentation() {
        instance.set(0);
        instance.set(10);
        assertEquals("Result should match representation length", 40, instance.toString().length());
        assertEquals("Result should match representation bit", '1', instance.toString().charAt(0));
        assertEquals("Result should match representation bit", '1', instance.toString().charAt(10));
    }
}
