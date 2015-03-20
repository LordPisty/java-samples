package enums;

/**
 * Created by screspi on 3/19/15.
 */
public class Main {

    public static void main(String[] args) {
        // Enums type cannot be instantiated
        //WithIntValue test = new WithIntValue(4);

        WithIntValue.A.testAbstract();
        WithIntValue.B.testAbstract();
    }
}
