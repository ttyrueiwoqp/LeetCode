package accepted.Q361_Q370;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given two jugs with capacities x and y litres.
 * There is an infinite amount of water supply available.
 * You need to determine whether it is possible to measure exactly z
 * litres using these two jugs.
 * <p>
 * Operations allowed:
 * <p>
 * Fill any of the jugs completely.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely
 * full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 * <p>
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 * <p>
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
public class Q365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        } else if (z > x + y) {
            return false;
        }
        if (x > y) {
            return canMeasureWater(y, x, z);
        }

        Set<Long> set = new HashSet<>();
        long s = z, d = s % y;
        while (d != 0 && !set.contains(d)) {
            set.add(d);
            s += x;
            d = s % y;
        }
        return d == 0;
    }

    public boolean canMeasureWater2(int x, int y, int z) {
        return z == 0 || (z <= x + y && z % gcd(x, y) == 0);
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
