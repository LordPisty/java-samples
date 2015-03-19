package calculator;

/**
 * Created by screspi on 3/19/15.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(subtract(9, 3));
        System.out.println(subtract(4, 8));

        System.out.println(multiply(9, 3));
        System.out.println(multiply(4, -8));
        System.out.println(multiply(-4, -8));

        System.out.println(divide(9, 3));
        System.out.println(divide(4, -2));
        System.out.println(divide(-8, -4));

    }

    public static int subtract(final int a, final int b) {
        return a + negate(b);
    }

    public static int multiply(final int a, final int b) {
        int result = 0;
        for (int i = abs(b); i > 0; i--) {
            result += a;
        }

        return b < 0 ? negate(result) : result;
    }

    public static int divide(final int a, final int b) {
        int result = 0;

        int absa = abs(a);
        int absb = abs(b);

        int temp = 0;

        while (temp + absb <= absa) {
            temp += absb;
            result++;
        }

        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            result = negate(result);
        }

        return result;
    }

    public static int negate(int c) {
        int result = 0;
        int d = c > 0 ? -1 : 1;
        while (c != 0) {
            result += d;
            c += d;
        }
        return result;
    }

    public static int abs(final int a) {
        return a < 0 ? negate(a) : a;
    }
}
