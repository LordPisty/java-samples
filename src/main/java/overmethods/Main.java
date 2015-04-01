package overmethods;

/**
 * Created by crespis on 4/1/2015.
 */
public class Main {
    public static void main(String... args) {
        A.sayHello();
        B.sayHello();

        A b = new B();
        b.sayHello();

        B c = new B();
        c.sayHello();

    }
}
