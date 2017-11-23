package accepted.Q501_Q600.Q561_Q570;

import util.TreeNode;

/**
 * Given a binary tree, return the tilt of the whole tree.
 * <p>
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 * <p>
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * <p>
 * Example:
 * Input:
 * 1
 * /   \
 * 2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 * Note:
 * <p>
 * The sum of node values in any subtree won't exceed the range of 32-bit integer.
 * All the tilt values won't exceed the range of 32-bit integer.
 */
public class Q563 {

    public int findTilt(TreeNode root) {
        int[] res = new int[2];
        helper(root, res);
        return res[1];
    }

    private void helper(TreeNode node, int[] res) {
        if (node == null) {
            return;
        }

        helper(node.left, res);
        int sumLeft = res[0];
        int tilt = res[1];
        int sum = res[0];

        res[0] = 0;
        res[1] = 0;

        helper(node.right, res);
        sum += res[0] + node.val;
        tilt += res[1] + Math.abs(res[0] - sumLeft);

        res[0] = sum;
        res[1] = tilt;
    }
}
