package string;

public class Utils {

	public static String reverse(String input) {
		char[] array = input.toCharArray();
		int i = 0;
		int j = array.length - 1;
		for (; i < j; i++, j--) {
			array[i] = (char) (array[i] ^ array[j]);
			array[j] = (char) (array[j] ^ array[i]); // j ^ i ^ j
			array[i] = (char) (array[i] ^ array[j]); // i ^ j ^ j ^ i ^ j
		}
		
		return new String(array);
	}

    public static void main(String[] args) {
        // run with -ea
        String a = "asdf";
        String b = "asdf";

        assert a == b;
        assert a.equals(b);

        String c = new String("asdf");
        String d = new String("asdf");

        assert c != d;
        assert c.equals(d);

        assert a != d;
        assert a.equals(d);
    }

}
