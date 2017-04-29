package accepted.Q531_Q540;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class Q530 {

    public int getMinimumDifference(TreeNode root) {
        int[] min = new int[]{Integer.MAX_VALUE};
        helper(root, new ArrayList<>(), min);
        return min[0];
    }

    private void helper(TreeNode node, List<Integer> list, int[] min) {
        if (node == null) {
            return;
        }

        helper(node.left, list, min);

        if (list.size() > 0) {
            min[0] = Math.min(min[0], node.val - list.get(list.size() - 1));
        }
        list.add(node.val);

        helper(node.right, list, min);
    }
}
