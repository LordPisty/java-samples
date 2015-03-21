package ex;

/**
 * Created by screspi on 3/21/15.
 */
public class MaxNoChecks {


    private static int flip(int i) {
        return 1^i;
    }

    // 1+ 0-
    private static int sign(int i) {
        return flip((i >> 31) & 1);
    }

    public static int maxWrong(int a, int b) {
        int k = sign(a-b);
        return k * a + flip(k) * b;
    }

    public static int max(int a, int b) {
        int c = a-b;

        int signa = sign(a);
        int signb = sign(b);
        int signc = sign(c);

        //different signs ==> possible overflow
        int usea = signa ^ signb;

        int k = usea * signa + flip(usea) * signc;

        return k * a + flip(k) * b;
    }

    public static void main(String[] args) {
        System.out.println(max(3,6));
        System.out.println(max(3,-6));
        System.out.println(max(-3,6));
        System.out.println(max(-3,-6));

        // problem with overflow
        System.out.println(maxWrong(Integer.MAX_VALUE - 1, -4));
        System.out.println(max(Integer.MAX_VALUE - 1, -4));
    }

}