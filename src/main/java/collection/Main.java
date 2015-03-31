package collection;

import java.util.ArrayList;

/**
 * Created by screspi on 3/30/15.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (Integer i : array) {
            System.out.println("iterating... " + i);
        }
        System.out.println(array.size());

        System.out.println("----------");

        array = new ArrayList<>(5);
        for (Integer i : array) {
            System.out.println("iterating... " + i);
        }
        System.out.println(array.size());

    }
}
