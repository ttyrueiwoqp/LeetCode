package accepted;

import java.util.Map;
import java.util.LinkedHashMap;

public class Q146 {

	private int capacity;
    private Map<Integer, Integer> map;

    public Q146(int c) {
      this.capacity = c;
      this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {

		private static final long serialVersionUID = 2673175136000849527L;

		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
      };
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        return map.get(key);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
	
}
