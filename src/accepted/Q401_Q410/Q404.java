package accepted.Q401_Q410;

import util.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Q404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isParentLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isParentLeft ? node.val : 0;
        }
        return helper(node.left, true) + helper(node.right, false);
    }
}
