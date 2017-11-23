package accepted.Q501_Q600.Q511_Q520;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class Q515 {

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> m = new HashMap<>();
        int maxLevel = helper(root, m, 0);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < maxLevel; i++) {
            res.add(m.get(i));
        }
        return res;
    }

    private int helper(TreeNode node, Map<Integer, Integer> m, int level) {
        if (node == null) {
            return level;
        }

        Integer val = m.getOrDefault(level, Integer.MIN_VALUE);
        m.put(level, Math.max(val, node.val));

        return Math.max(helper(node.left, m, level + 1), helper(node.right, m, level + 1));
    }
}
