package accepted.Q201_Q300.Q291_Q300;

import util.TreeNode;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections.
 * The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * 1
 * \
 * 3
 * / \
 * 2   4
 * \
 * 5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * 2
 * \
 * 3
 * /
 * 2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class Q298 {

    public int longestConsecutive(TreeNode root) {
        return traverse(root, 0, null);
    }

    private int traverse(TreeNode node, int cnt, TreeNode parent) {
        if (node == null) {
            return cnt;
        }

        if (parent != null && node.val == parent.val + 1) {
            cnt = cnt + 1;
        } else {
            cnt = 1;
        }

        return Math.max(cnt, Math.max(traverse(node.left, cnt, node), traverse(node.right, cnt, node)));
    }

    private int max = 0;
    public int sln(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0, root.val);
        return max;
    }

    public void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }
}
