package enums;

/**
 * Created by screspi on 3/19/15.
 */
public class Main {

    // enum provided methods:
    // instance
    // * compareTo()
    // * name()
    // * ordinal()
    // enum
    // * valueOf() - overloaded
    // * values()

    public static void main(String[] args) {
        // Enums type cannot be instantiated
        //WithIntValue test = new WithIntValue(4);

        WithIntValue.A.testAbstract();
        WithIntValue.B.testAbstract();
    }
}
