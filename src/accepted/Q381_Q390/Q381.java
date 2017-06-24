package accepted.Q381_Q390;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being
 * returned is linearly related to the number of same value the collection contains.
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class Q381 {

    Random rand;
    Map<Integer, Set<Integer>> m;
    List<Integer> list;
    int endIdx;

    /**
     * Initialize your data structure here.
     */
    public Q381() {
        rand = new Random();
        m = new HashMap<>();
        list = new ArrayList<>();
        endIdx = -1;
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean res = false;

        endIdx++;
        if (endIdx == list.size()) {
            list.add(val);
        } else {
            list.set(endIdx, val);
        }

        Set<Integer> set = m.get(val);
        if (set == null) {
            set = new HashSet<>();
            m.put(val, set);
            res = true;
        }
        set.add(endIdx);

        return res;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        Set<Integer> set = m.get(val);
        if (set == null || set.isEmpty()) {
            return false;
        }

        int idx = set.iterator().next();
        set.remove(idx);

        int endVal = list.get(endIdx);
        list.set(idx, endVal);

        if (idx != endIdx) {
            Set<Integer> endSet = m.get(endVal);
            endSet.remove(endIdx);
            endSet.add(idx);
        }

        endIdx--;

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rand.nextInt(endIdx + 1));
    }
}
