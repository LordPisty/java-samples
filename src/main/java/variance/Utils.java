package variance;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	private static class A {
		private int value;
		private A(int a) {
			value = a;
		}
	}
	
	private static class B extends A {
		private int b;
		private B(int b) {
			super(b);
			this.b = b;
		}
	}
	
	private static class C extends B {
		private int c;
		private C(int c) {
			super(c);
			this.c = c;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// compiler error
		//printLength(new A[3]);
				
		printLength(new B[3]);
		
		// Exception in thread "main" java.lang.ArrayStoreException: variance.Utils$B
		// runtime check for assignment
		printLength(new C[3]);
		
		B[] test = new C[3];
		
		test[0] = new C(4);
		
		// Exception in thread "main" java.lang.ArrayStoreException: variance.Utils$B
		//test[1] = new B(5);
		
		// compiler error
		//test[2] = new A(3);
		
		//------------
		// variance generics
		List<String> aList = new ArrayList<String>();
		aList.add("test");
		List<? extends Object> covariantList = aList;
		List<? super String> contravariantList = aList;
		
		covariantList.get(0);
		// The method add(capture#2-of ? extends Object) in the type 
		// List<capture#2-of ? extends Object> is not applicable 
		// for the arguments (String)
		// covariantList.add(new String(" "));
		
		contravariantList.add(new String(" "));
		// Type mismatch: cannot convert from capture#3-of ? super String to String
		String s = (String) contravariantList.get(0);
		
	}
	
	public static void printLength(B[] array) {
		System.out.println(array.length);
		//array[0] = new B(5);
	}

}
