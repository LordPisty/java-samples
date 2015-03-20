package bitset;

/**
 * Created by crespis on 3/20/2015.
 */
public class Main {

    public static void main(String[] args) {
        final BitSet bitset = new BitSet(10);
        bitset.set(3);
        bitset.set(7);

        System.out.println(bitset.toString());
    }
}
