package accepted.Q531_Q540;

import util.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of
 * all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 */
public class Q538 {

    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }

        node.val += helper(node.right, sum);

        return helper(node.left, node.val);
    }
}
