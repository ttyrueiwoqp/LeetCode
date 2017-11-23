package accepted.Q401_Q500.Q441_Q450;

import util.TreeNode;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 * <p>
 * Example:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * <p>
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 */
public class Q450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.val) {
            root = replaceWithMax(root);

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);

        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode replaceWithMax(TreeNode node) {
        if (node.right == null) {
            return node.left;
        }

        TreeNode max = node.left;
        if (max == null) {
            return node.right;
        }
        if (max.right == null) {
            max.right = node.right;
            return max;
        }

        TreeNode prev = max;
        while (max.right != null) {
            prev = max;
            max = max.right;
        }
        prev.right = max.left;
        max.left = node.left;
        max.right = node.right;

        return max;
    }
}
