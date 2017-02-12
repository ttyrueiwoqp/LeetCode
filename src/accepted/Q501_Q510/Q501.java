package accepted.Q501_Q510;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 * 1
 * \
 * 2
 * /
 * 2
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class Q501 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = helper(root, m);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() == max) {
                list.add(e.getKey());
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public int helper(TreeNode node, Map<Integer, Integer> m) {
        if (node == null) {
            return 0;
        }

        int max = Math.max(helper(node.left, m), helper(node.right, m));

        Integer count = m.get(node.val);
        if (count == null) {
            count = 0;
        }
        m.put(node.val, count + 1);

        return Math.max(max, count + 1);
    }
}
