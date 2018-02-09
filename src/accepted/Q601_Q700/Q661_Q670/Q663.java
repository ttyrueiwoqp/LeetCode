package accepted.Q601_Q700.Q661_Q670;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 10 10
 * /  \
 * 2   3
 * <p>
 * Output: True
 * Explanation:
 * 5
 * /
 * 10
 * <p>
 * Sum: 15
 * <p>
 * 10
 * /  \
 * 2    3
 * <p>
 * Sum: 15
 * Example 2:
 * Input:
 * 1
 * / \
 * 2  10
 * /  \
 * 2   20
 * <p>
 * Output: False
 * Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
 * Note:
 * The range of tree node value is in the range of [-100000, 100000].
 * 1 <= n <= 10000
 */
public class Q663 {
    public boolean checkEqualTree(TreeNode root) {
        Set<Integer> sums = new HashSet<>();
        int left = dfs(root.left, sums);
        int right = dfs(root.right, sums);
        int total = root.val + left + right;
        return total % 2 == 0 && sums.contains(total / 2);
    }

    public int dfs(TreeNode node, Set<Integer> sums) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left, sums) + dfs(node.right, sums);
        sums.add(sum);
        return sum;
    }
}
