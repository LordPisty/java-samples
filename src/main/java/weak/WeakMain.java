package weak;

import java.util.WeakHashMap;

/**
 * Created by crespis on 3/31/2015.
 */
public class WeakMain {
    public static void main(String[] args) {
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
