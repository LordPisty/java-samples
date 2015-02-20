package swap;

public class Utils {
	
	// given an unsigned char c, swap every two bits of it 
	public static void swap (char a) {
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(0xaa));
		System.out.println(Integer.toBinaryString(0x55));
		System.out.println(Integer.toBinaryString(((a & 0xaa) >> 1)));// | 
		System.out.println(Integer.toBinaryString(((a & 0x55) << 1)));
		System.out.println(Integer.toBinaryString(((a & 0xaa) >> 1) | ((a & 0x55) << 1)));// | 
	}
	
	public static void swap (int a, int b) {
		System.out.println("A: " + a + " B: " + b);
		
		a = b - a;
		b = b - a;
		a = a + b;
		
		System.out.println("A: " + a + " B: " + b);
	}
	
	public static void swapXOR (int a, int b) {
		System.out.println("A: " + a + " B: " + b);
		
		a = b ^ a;
		b = b ^ a;
		a = a ^ b;
		
		System.out.println("A: " + a + " B: " + b);
	}
}
