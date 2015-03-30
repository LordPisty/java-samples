/**
 * Created by screspi on 3/21/15.
 */
public class Main {

    public static int flip(int bit) {
        return 1^bit;
    }

    public static void main(String[] args) {
        int a = 4;

        int b = -4;

        System.out.println((a >> 31) & 1);
        System.out.println((b >> 31) & 1);

        System.out.println(flip((a >> 31) & 1));
        System.out.println(flip((b >> 31) & 1));

    }
}
