package nested;

public class Outer {

	private int c = 0;
	
	public Outer(int a) {
		c = a;
	}
	
	static class NestedStatic {
		private void sayHello() {
			System.out.println("nested static");
			// System.out.println(c); NOT ALLOWED
		}
		
		private void queryOuter(final Outer outer) {
			System.out.println("nested static querying outer object: " + outer.c);
		}
	}
	
	class Inner {
		private void sayHello() {
			System.out.println("inner: " + c);
			c = -3;
			System.out.println("inner modified: " + c);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outer outer = new Outer(3);
		Inner inner = outer.new Inner();
		Inner innerAnonym = (new Outer(5)).new Inner();
		
		NestedStatic nestedStatic = new Outer.NestedStatic();
		
		inner.sayHello();
		innerAnonym.sayHello();
		
		nestedStatic.sayHello();
		nestedStatic.queryOuter(outer);
	}

}
