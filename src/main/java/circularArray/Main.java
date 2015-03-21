package circularArray;

/**
 * Created by screspi on 3/21/15.
 */
public class Main {

    public static void main(String[] args) {
        CircularArray<Integer> array = new CircularArray<Integer>(5);
        array.set(0,0);
        array.set(1,1);
        array.set(2,2);
        array.set(3,3);
        array.set(4,4);

        System.out.println(array.toString());
        array.rotateLeft(2);
        System.out.println(array.toString());
        System.out.println(array.get(0));
        System.out.println(array.get(-1));
        System.out.println(array.get(5));

        array.rotateRight(3);
        System.out.println(array.toString());
        System.out.println(array.get(0));
        System.out.println(array.get(-1));
        System.out.println(array.get(5));

    }
}
