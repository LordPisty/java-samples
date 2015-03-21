package bitset;

/**
 * Created by crespis on 3/20/2015.
 */
public class BitSet {

    private final int size;

    private int[] bits;

    public BitSet(final int size) {
        this.size = size;
        bits = new int[size/32 + ((size%32) > 0 ? 1 : 0)];
    }

    public void set(final int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        final int index = i / 32;
        final int offset = i % 32;

        bits[index] = bits[index] | (1 << offset);
    }

    public String get(final int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        final int index = i / 32;
        final int offset = i % 32;

        return String.valueOf(1 & (bits[index] >> offset));
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append(get(i));
        }

        return result.toString();
    }
}
