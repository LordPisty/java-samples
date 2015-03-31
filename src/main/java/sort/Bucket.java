package sort;

import java.util.Arrays;

/**
 * Created by screspi on 3/30/15.
 */
public final class Bucket {

    public static int[] sort(int[] input, int max) {
        int[] buckets = new int[max];

        for (int i : input) {
            buckets[i]++;
        }

        int[] result = new int[input.length];
        int counter = 0;
        for (int j = 0; j < buckets.length; j++) {
            for (int z = 1; z <= buckets[j]; z++) {
                result[counter++] = j;
            }
        }
        return result;
    }

    public static void main(String... args) {
        int[] array = {4,5,2,7,3,6,6,8,9,1,0};
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(sort(array,10)));
    }
}
