package CIrcularArray;

import circularArray.CircularArray;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * Created by screspi on 3/21/15.
 */
public class CircularArrayTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    CircularArray<Integer> array;

    @Before
    public void setUp() throws Exception {
        array = new CircularArray<Integer>(5);
        array.set(0, 0);
        array.set(1, 1);
        array.set(2, 2);
        array.set(3, 3);
        array.set(4, 4);
    }

    @Test
    public void testRotations() {
        assertEquals(array.get(2), new Integer(2));
        array.rotateRight(1);
        assertEquals(array.get(2), new Integer(1));
        array.rotateLeft(2);
        assertEquals(array.get(2), new Integer(3));
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iterator = array.iterator();

        assertEquals(iterator.hasNext(), true);
        assertEquals(iterator.next(), new Integer(0));
    }

    @Test(expected=ConcurrentModificationException.class)
    public void testIteratorRotations() {
        Iterator<Integer> iterator = array.iterator();
        array.rotateLeft(3);
        iterator.hasNext();
    }

    @Test
    public void testIteratorRemove() {
        Iterator<Integer> iterator = array.iterator();
        exception.expect(UnsupportedOperationException.class);
        iterator.remove();
    }
}
