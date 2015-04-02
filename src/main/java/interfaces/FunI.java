package interfaces;

/**
 * Created by crespis on 4/1/2015.
 */
@FunctionalInterface
public interface FunI {

    int functionalMethod(int i);

    default int defaultMethod(int i) {
        return i*3;
    }

    static int staticMethod(int i) {
        return i*4;
    }
}
