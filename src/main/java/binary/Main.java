package binary;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utils.countBitsDifference(12, 16);
		System.out.println(Integer.toString(-1, 2));
		System.out.println(Integer.toString(0, 2));
		System.out.println(Integer.toString(0^-1,2));
		
		System.out.println(Integer.toBinaryString(1 << 2));

        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(~0));

        System.out.println(Integer.toBinaryString(-4));

    }

}
