package accepted.Q541_Q550;

import util.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Q543 {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left, max);
        int rightDepth = helper(root.right, max);
        max[0] = Math.max(max[0], leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
