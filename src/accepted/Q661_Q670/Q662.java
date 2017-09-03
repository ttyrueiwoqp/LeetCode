package accepted.Q661_Q670;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree.
 * The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree,
 * but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most
 * non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * <p>
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class Q662 {

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> lefts = new ArrayList<>(); // left most nodes at each level;
        int[] res = new int[1]; // max width
        dfs(root, 1, 0, lefts, res);
        return res[0];
    }

    private void dfs(TreeNode node, int id, int depth, List<Integer> lefts, int[] res) {
        if (node == null) return;
        if (depth >= lefts.size()) lefts.add(id);   // add left most node
        res[0] = Integer.max(res[0], id + 1 - lefts.get(depth));
        dfs(node.left, id * 2, depth + 1, lefts, res);
        dfs(node.right, id * 2 + 1, depth + 1, lefts, res);
    }

}
