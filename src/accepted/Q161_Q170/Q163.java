package accepted.Q161_Q170;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * <p>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Q163 {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {

        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            add(res, lower - 1, upper + 1);
            return res;
        }

        add(res, lower - 1, nums[0]);
        for (int i = 0; i < nums.length - 1; i++) {
            add(res, nums[i], nums[i + 1]);
        }
        add(res, nums[nums.length - 1], upper + 1);

        return res;
    }

    private void add(List<String> res, int a, int b) {
        String s = "";
        if (a + 1 < b) {
            s += (a + 1);
        }
        if (a + 1 < b - 1) {
            s += "->" + (b - 1);
        }

        if (!s.isEmpty()) {
            res.add(s);
        }
    }

    public List<String> sln(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, a[i] - 1));

            // now we need to find the next number
            next = a[i] + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}
