package singleton;

/**
 * Created by screspi on 3/19/15.
 */
public class LazySingleton {

    // need volatile to avoid broken read: thanks to volatile guarantees since java 1.5
    // write visible by reads:
    // The real problem is that Thread A may assign a memory space for instance before it is
    // finished constructing instance. Thread B will see that assignment and try to use it.
    // This results in Thread B failing because it is using a partially constructed version of instance.
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
