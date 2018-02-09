package accepted.Q501_Q600.Q541_Q550;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Example 1
 * Input:
 * 1
 * \
 * 2
 * / \
 * 3   4
 * <p>
 * Ouput:
 * [1, 3, 4, 2]
 * <p>
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 * Example 2
 * Input:
 * ____1_____
 * /          \
 * 2            3
 * / \          /
 * 4   5        6
 * / \      / \
 * 7   8    9  10
 * <p>
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 * <p>
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
public class Q545 {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> leftBd = new ArrayList<>();
        List<TreeNode> rightBd = new ArrayList<>();
        List<TreeNode> leaves = new ArrayList<>();

        TreeNode leftLeaf = root;
        TreeNode node = root.left;
        while (node != null) {
            leftBd.add(node);
            leftLeaf = node;
            node = node.left == null ? node.right : node.left;
        }

        TreeNode rightLeaf = root;
        node = root.right;
        while (node != null) {
            rightBd.add(node);
            rightLeaf = node;
            node = node.right == null ? node.left : node.right;
        }

        dfs(root, leaves, leftLeaf, rightLeaf);

        Collections.reverse(rightBd);

        List<Integer> res = new ArrayList<>();
        res.add(root.val);

        for (TreeNode n : leftBd) {
            res.add(n.val);
        }
        for (TreeNode n : leaves) {
            res.add(n.val);
        }
        for (TreeNode n : rightBd) {
            res.add(n.val);
        }

        return res;
    }

    private void dfs(TreeNode node, List<TreeNode> leaves, TreeNode leftLeaf, TreeNode rightLeaf) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && node != leftLeaf && node != rightLeaf) {
            leaves.add(node);
            return;
        }

        dfs(node.left, leaves, leftLeaf, rightLeaf);
        dfs(node.right, leaves, leftLeaf, rightLeaf);
    }
}
