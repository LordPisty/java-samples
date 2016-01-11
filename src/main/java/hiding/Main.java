package hiding;

/**
 * Created by crespis on 1/11/2016.
 */
public class Main {

    public static void main(String... args) {
        A a = new A();
        B b = new B();

        System.out.println(a.getA());
        System.out.println(b.getA());
        System.out.println("-----");
        System.out.println(a.getB());
        System.out.println(b.getB());
        System.out.println("-----");
        System.out.println(a.getC());
        System.out.println(b.getC());
    }
}
