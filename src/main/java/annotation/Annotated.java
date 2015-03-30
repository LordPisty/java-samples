package annotation;

/**
 * Created by screspi on 3/29/15.
 */
public class Annotated {
    @Test(info = "AWESOME")
    public void foo(final String myParam) {
        System.out.println("This is " + myParam);
    }

    @Test
    public void boo(final String myParam) {
        System.out.println("This is " + myParam);
    }
}

