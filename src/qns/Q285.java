package qns;

import util.TreeNode;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class Q285 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        return root;
    }

    public TreeNode sln(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val)
            root = root.right;
        if (root == null)
            return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null && left.val > p.val) ? left : root;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val >= p.val) {
            return predecessor(root.left, p);
        } else {
            TreeNode right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}
