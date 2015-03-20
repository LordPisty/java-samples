package enums;

import java.util.HashMap;
import java.util.Map;

public enum WithIntValue {

	A (0) {
        @Override
        public void testAbstract() {
            // A's implementation
            System.out.println("I'm " + this.name() + " - this.name()");
        }
    },

    B (1) {
        @Override
        public void testAbstract() {
            // B's implementation
            System.out.println("I'm " + this.toString() + " - this.toString()");
        }
    },

    C (3) {
        @Override
        public void testAbstract() {
            // C's implementation
        }
    },

    D (4) {
        @Override
        public void testAbstract() {
            // D's implementation
        }
    };
	
	private final int value;
	
	private static Map<Integer, WithIntValue> map = new HashMap<Integer, WithIntValue>();

    static {
        for (WithIntValue wEnum : WithIntValue.values()) {
            map.put(wEnum.value, wEnum);
        }
    }

    // Constructor must be private or package-protected / default
	WithIntValue(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public static WithIntValue getFromValue(int v) {
		return map.get(v);
	}

    public abstract void testAbstract();
}
