package collection;

import java.util.ArrayList;

/**
 * Created by screspi on 3/30/15.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        System.out.println(array.size());

        array = new ArrayList<>(5);
        System.out.println(array.size());

    }
}
