package qns;

import util.TreeNode;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 * <p>
 * For example:
 * Given a binary tree {1,2,3,4,5},
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * <p>
 * <p>
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * <p>
 * Here's an example:
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class Q156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        return root;
    }

    public TreeNode sln(TreeNode root) {

        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }

}
