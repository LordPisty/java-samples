package weak;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.WeakHashMap;

/**
 * Created by crespis on 3/31/2015.
 */
// soft: can't prevent GC, collected when memory is really needed
// weak: can't prevent GC, collected at next GC
// pahntom: get => null, when create pass in ReferenceQueue ==> use phantom ref to check when obj is GCd (enqueued after GCd)
public class WeakMain {
    public static void main(String[] args) {
        SoftReference<Data> soft = new SoftReference<Data>(null);
        PhantomReference<Data> phantom = new PhantomReference<>(null, new ReferenceQueue<>());

        WeakHashMap<Data, String> map = new WeakHashMap<Data, String>();
        Data dataObj = new Data("foo");
        Data dataObj2 = new Data("buz");

        map.put(dataObj, dataObj.value);
        map.put(dataObj2, "random");

        System.out.println("Map contains dataObj ? " + map.containsKey(dataObj));
        System.out.println("Map contains dataObj2 ? " + map.containsKey(dataObj));

        // -- now make someDataObject elligible for garbage collection...
        dataObj = null;
        dataObj2 = null;

        for (int i = 0; i < 10000; i++) {
            if (map.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference on some object");
                // induce GC
                System.gc();
            } else {
                System.out.println("Objects have finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }
    }

    static class Data {
        private String value;
        Data(String value) {
            this.value = value;
        }
    }
}
