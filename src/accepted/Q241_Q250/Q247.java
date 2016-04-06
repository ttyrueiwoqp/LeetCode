package accepted.Q241_Q250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 * <p>
 * Hint:
 * <p>
 * Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
 */
public class Q247 {

    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }

    public List<String> findStrobogrammatic(int n, int m) {

        List<String> res = new ArrayList<>();
        if (n < 1) {
            res.add("");
            return res;

        } else if (n == 1) {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;

        } else {
            List<String> n2 = findStrobogrammatic(n - 2, m);
            for (String s : n2) {
                if (n < m) {
                    res.add("0" + s + "0");
                }
                res.add("1" + s + "1");
                res.add("6" + s + "9");
                res.add("8" + s + "8");
                res.add("9" + s + "6");
            }
        }

        return res;
    }


    public List<String> sln(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        List<String> res = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }

        return res;
    }
}
