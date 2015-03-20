package singleton;

/**
 * Created by screspi on 3/19/15.
 */
public class HolderSingleton {

    private HolderSingleton() {}

    private static class LazyHolder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
