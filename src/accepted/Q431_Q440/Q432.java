package accepted.Q431_Q440;

import java.util.*;

/**
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1.
 * Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
 * If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class Q432 {

    Map<String, Integer> m;
    Map<Integer, Set<String>> v;
    LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public Q432() {
        m = new HashMap<>();
        v = new HashMap<>();
        list = new LinkedList<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int val = 0;

        if (!m.containsKey(key)) {
            m.put(key, val + 1);
        } else {
            val = m.get(key);
            m.put(key, val + 1);
            delete(key, val);
        }

        insert(key, val + 1);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!m.containsKey(key)) {
            return;
        }

        int val = m.get(key);
        delete(key, val);

        if (val == 1) {
            m.remove(key);
        } else {
            m.put(key, val - 1);
            insert(key, val - 1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (list.isEmpty()) {
            return "";
        }
        return v.get(list.getFirst()).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (list.isEmpty()) {
            return "";
        }
        return v.get(list.getLast()).iterator().next();
    }

    private void insert(String key, int val) {

        Set<String> set = v.get(val);
        if (set == null) {
            set = new HashSet<>();
            v.put(val, set);
        }
        set.add(key);

        if (list.isEmpty() || val > list.getFirst()) {
            list.addFirst(val);
        } else if (val < list.getLast()) {
            list.addLast(val);
        }

    }

    private void delete(String key, int val) {
        v.get(val).remove(key);

        if (v.get(val).isEmpty()) {
            if (val == list.getFirst()) {
                list.removeFirst();
            } else if (val == list.getLast()) {
                list.removeLast();
            }
        }
    }
}
