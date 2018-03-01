package accepted.Q601_Q700.Q681_Q690;

import util.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output:
 * <p>
 * 2
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output:
 * <p>
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class Q687 {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        helper(root, root.val, max);

        return max[0];
    }

    private int helper(TreeNode node, int val, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left, node.val, max);
        int right = helper(node.right, node.val, max);

        max[0] = Math.max(max[0], left + right);

        return node.val == val ? Math.max(left, right) + 1 : 0;
    }
}
