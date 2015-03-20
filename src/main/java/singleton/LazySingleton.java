package singleton;

/**
 * Created by screspi on 3/19/15.
 */
public class LazySingleton {

    // need volatile to avoid broken read: thanks to volatile guarantees since java 1.5
    // write visible by reads
    private static volatile LazySingleton instance;

    private LazySingleton() {
        // not instantiable
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
