package sort;

import java.util.Arrays;

/**
 * Created by screspi on 3/30/15.
 */
public final class Radix {

    // LSD
    public static void sort( int[] a)
    {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[n];
        // m is max
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            System.out.println("radix: " + exp);
            int[] bucket = new int[10];

            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            System.out.println("bucket count");
            System.out.println(Arrays.toString(bucket));
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            System.out.println("bucket accumulator");
            System.out.println(Arrays.toString(bucket));
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            System.out.println("b " + Arrays.toString(b));
            for (i = 0; i < n; i++)
                a[i] = b[i];
            System.out.println("a " + Arrays.toString(a));
            exp *= 10;
        }
    }

    public static void main(String... args) {
        // input > 0
        int[] array = {14,25,12,27,13,26,16,29,29,11,12};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
