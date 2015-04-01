package interfaces;

/**
 * Created by crespis on 4/1/2015.
 */
public interface Inter {

    // All method declarations in an interface, including default methods, are implicitly public

    // public abstract
    void doSomething(int i, int j);

    // jdk8: inherited + binary compatibility
    default int doDefault(int j) {
        return j;
    }

    // jdk8: utility
    static String utilityMethod() {
        return "I am a utility for everybody";
    }
}
