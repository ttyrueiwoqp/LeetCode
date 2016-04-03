package accepted.Q161_Q170;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 */
public class Q170 {

    Map<Integer, Integer> m = new HashMap<>();

    // Add the number to an internal data structure.
    public void add(int number) {
        Integer cnt = m.get(number);
        if (cnt == null) {
            m.put(number, 1);
        } else {
            m.put(number, cnt + 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            int i = e.getKey();
            int j = value - i;
            if (m.containsKey(j)) {
                if (i != j) {
                    return true;
                } else if (m.get(j) > 1) {
                    return true;
                }
            }
        }
        return false;
    }

}

class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}

// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
