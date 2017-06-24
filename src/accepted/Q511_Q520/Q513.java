package accepted.Q511_Q520;

import util.TreeNode;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Output:
 * 1
 * Example 2:
 * Input:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * <p>
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class Q513 {

    public int findBottomLeftValue(TreeNode root) {
        int[] max = new int[]{-1, 0};
        helper(root, 0, max);
        return max[1];
    }

    private void helper(TreeNode node, int level, int[] max) {
        if (node == null) {
            return;
        }

        if (level > max[0]) {
            max[0] = level;
            max[1] = node.val;
        }

        helper(node.left, level + 1, max);
        helper(node.right, level + 1, max);
    }
}
