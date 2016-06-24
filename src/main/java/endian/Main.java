package endian;

/**
 * Created by crespis on 6/24/2016.
 */
public class Main {

    private static int little2big(int i) {
        return (i&0xff)<<24 | (i&0xff00)<<8 | (i&0xff0000)>>8 | (i>>24)&0xff;
    }

    private static String padTo32(String input) {
        while (input.length() < 32) {
            input = "0" + input;
        }
        return input;
    }

    public static void main(String... args) {
        System.out.println(padTo32(Integer.toBinaryString(123456789)));
        System.out.println(padTo32(Integer.toBinaryString(little2big(123456789))));
    }
}
