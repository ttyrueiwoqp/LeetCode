package accepted.Q501_Q510;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted
 * at that node (including the node itself). So what is the most frequent subtree sum value?
 * If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class Q508 {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, m, max);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == max[0]) {
                list.add(e.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int helper(TreeNode node, Map<Integer, Integer> m, int[] max) {
        if (node == null) {
            return 0;
        }

        int sum = helper(node.left, m, max) + helper(node.right, m, max) + node.val;
        int count = m.getOrDefault(sum, 0) + 1;
        m.put(sum, count);
        max[0] = Math.max(max[0], count);

        return sum;
    }
}
