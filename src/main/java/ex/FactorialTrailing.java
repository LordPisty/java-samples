package ex;

import java.math.BigInteger;

/**
 * Created by screspi on 3/21/15.
 */
public class FactorialTrailing {

    public static int trailingZeros(int i) {
        int result = 0;
        for (int j = 5; i / j > 0; j *= 5) {
            result += i/j;
        }
        return result;
    }

    public static BigInteger factorial(BigInteger i) {
        if (i.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        } else {
            return i.multiply(factorial(i.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("19")));
        System.out.println(trailingZeros(10));

        System.out.println(factorial(new BigInteger("125")));
        System.out.println(trailingZeros(125));

        System.out.println(factorial(new BigInteger("60")));
        System.out.println(trailingZeros(60));

    }


}
