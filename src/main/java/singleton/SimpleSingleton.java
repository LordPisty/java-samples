package singleton;

/**
 * Created by screspi on 3/19/15.
 */
public class SimpleSingleton {

    private static SimpleSingleton instance;

    private SimpleSingleton(){
        // not instantiable
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

}
