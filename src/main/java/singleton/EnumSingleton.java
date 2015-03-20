package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by screspi on 3/19/15.
 */
public enum EnumSingleton implements Serializable {

    // safer for serialization!!!
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        return INSTANCE;
    }

    private Object writeReplace() throws ObjectStreamException {
        return "EnumSingletonSerialized";
    }
}