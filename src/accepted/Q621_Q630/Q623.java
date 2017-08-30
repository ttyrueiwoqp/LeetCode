package accepted.Q621_Q630;

import util.TreeNode;

/**
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given
 * depth d. The root node is at depth 1.
 * <p>
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree
 * nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left
 * subtree of the new left subtree root, its original right subtree should be the right subtree of the new right
 * subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the
 * new root of the whole original tree, and the original tree is the new root's left subtree.
 * <p>
 * Example 1:
 * Input:
 * A binary tree as following:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * Output:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * Example 2:
 * Input:
 * A binary tree as following:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * Output:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class Q623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        helper(root, v, d, 2);
        return root;
    }

    public void helper(TreeNode node, int v, int d, int next) {
        if (d == next) {
            TreeNode left = new TreeNode(v);
            left.left = node.left;
            node.left = left;

            TreeNode right = new TreeNode(v);
            right.right = node.right;
            node.right = right;
            return;
        }

        if (node.left != null) {
            helper(node.left, v, d, next + 1);
        }
        if (node.right != null) {
            helper(node.right, v, d, next + 1);
        }
    }
}
