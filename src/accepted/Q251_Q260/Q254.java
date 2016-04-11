package accepted.Q251_Q260;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Examples:
 * input: 1
 * output:
 * []
 * input: 37
 * output:
 * []
 * input: 12
 * output:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * input: 32
 * output:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 */
public class Q254 {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 4){
            return res;
        }
        fill(res, new ArrayList<>(), -1, n);
        return res;
    }

    private void fill(List<List<Integer>> res, List<Integer> list, int st, int n) {
        if (st != -1) {
            list.add(n);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
        int limit = (int) Math.sqrt(n);
        st = Math.max(2, st);
        for (int i = st; i <= limit; i++) {
            if (n % i == 0) {
                list.add(i);
                fill(res, list, i, n / i);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> sln(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
