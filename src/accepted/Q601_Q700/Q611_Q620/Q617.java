package accepted.Q601_Q700.Q611_Q620;

import util.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */
public class Q617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode res;

        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            res = new TreeNode(t2.val);
            res.left = mergeTrees(null, t2.left);
            res.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            res = new TreeNode(t1.val);
            res.left = mergeTrees(t1.left, null);
            res.right = mergeTrees(t1.right, null);
        } else {
            res = new TreeNode(t1.val + t2.val);
            res.left = mergeTrees(t1.left, t2.left);
            res.right = mergeTrees(t1.right, t2.right);
        }

        return res;
    }
}
