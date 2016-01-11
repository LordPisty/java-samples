package hiding;

/**
 * Created by crespis on 1/11/2016.
 */
public class B extends A {

    protected String a = "B";

    protected String b = "B";

    protected int c = 3;

    @Override
    public String getB() {
        return b;
    }

    @Override
    public String getC() {
        return super.c + c;
    }
}
