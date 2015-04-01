package overmethods;

/**
 * Created by crespis on 4/1/2015.
 */
public class A {

    public static void sayHello() {
        System.out.println("A");
    }

    public int method(int c) {
        System.out.println(c);
        return c;
    }

    public int method(int c, int d) {
        System.out.println(c + " " + d);

        // compilation error
        // this(c);

        return c;
    }

    // compilation error
    //public void method(int a) {
    //  System.out.println(a);
    //}
}
