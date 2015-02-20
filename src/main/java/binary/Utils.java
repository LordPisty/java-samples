package binary;

public class Utils {

	public static int countBitsDifference(final int a, final int b) {
		int result = countOnes(a^b);
		return result;
	}
	
	public static int countOnes(int input) {
		int counter = 0;
		while (input != 0) {
			counter += (input & 1);
			input = input >> 1;	
		}
		return counter;
	}
	
	public static int countOnes2(int input) {
		int counter = 0;
		while( input != 0 ){
			input = input & (input - 1);
		    	counter++;
		}
		return counter;
	}
	
	public static boolean isPowerOf2(int input) {
		return input != 0 && (input & (input - 1)) == 0;
	}

}
