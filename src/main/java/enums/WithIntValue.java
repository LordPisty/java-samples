package enums;

import java.util.HashMap;
import java.util.Map;

public enum WithIntValue {

	A (0), B (1), C (3), D (4);
	
	private final int value;
	
	private static Map<Integer, WithIntValue> map = new HashMap<Integer, WithIntValue>();

    static {
        for (WithIntValue wEnum : WithIntValue.values()) {
            map.put(wEnum.value, wEnum);
        }
    }
	
	private WithIntValue(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public static WithIntValue getFromValue(int v) {
		return map.get(v);
	}
}
