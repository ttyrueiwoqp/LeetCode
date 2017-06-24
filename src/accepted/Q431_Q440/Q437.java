package accepted.Q431_Q440;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class Q437 {

    public int pathSum(TreeNode root, int sum) {
        return helper(root, sum, new ArrayList<>());
    }

    public int helper(TreeNode node, int sum, List<Integer> sums) {
        if (node == null) {
            return 0;
        }

        int res = 0;
        sums.add(sum);

        for (int i = 0; i < sums.size(); i++) {
            int t = sums.get(i) - node.val;
            if (t == 0) {
                res++;
            }
            sums.set(i, t);
        }

        res += helper(node.left, sum, new ArrayList<>(sums));
        res += helper(node.right, sum, new ArrayList<>(sums));

        return res;
    }
}
