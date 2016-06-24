package circularArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by screspi on 3/21/15.
 */
public class CircularArray<T> implements Iterable<T>{

    private final T[] data;

    private int head = 0;

    public CircularArray(final int n) {
        data = (T[]) new Object[n];
    }

    private class CircularIterator implements Iterator<T> {

        final int head;

        int current = -1;

        CircularIterator(final int head) {
            this.head = head;
        }

        // fail fast: best-effort basis
        private void checkCurrentHead() {
            if (head != CircularArray.this.head) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            checkCurrentHead();
            return current < data.length - 1;
        }

        @Override
        public T next() {
            checkCurrentHead();
            return data[convert(++current)];
        }

        @Override
        public void remove() {
            checkCurrentHead();
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator(head);
    }

    private int convert(int idx) {
        while (idx < 0) {
            idx += data.length;
        }
        return (head + idx) % data.length;
    }

    public void rotateLeft(final int r) {
        head = (head + r) % data.length;
    }

    public void rotateRight(final int r) {
        head = (head - r + data.length) % data.length;
    }

    public T get(final int idx) {
        return data[convert(idx)];
    }

    public void set(final int idx, final T value) {
        data[convert(idx)] = value;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < data.length; i++) {
            result += get(i);
        }
        return result;
    }
}
