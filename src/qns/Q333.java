package qns;

import util.TreeNode;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
 * where largest means subtree with largest number of nodes in it.
 * <p>
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 * 10
 * / \
 * 5  15
 * / \   \
 * 1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 * Hint:
 * <p>
 * You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree,
 * which will result in O(nlogn) time complexity.
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class Q333 {

    public int largestBSTSubtree(TreeNode root) {

        return 0;
    }


}

class sln {
    class Result {
        int res;
        int min;
        int max;

        public Result(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result res = BSTSubstree(root);
        return Math.abs(res.res);
    }

    private Result BSTSubstree(TreeNode root) {
        if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = BSTSubstree(root.left);
        Result right = BSTSubstree(root.right);
        if (left.res < 0 || right.res < 0 || root.val < left.max || root.val > right.min) {
            return new Result(Math.max(Math.abs(left.res), Math.abs(right.res)) * -1, 0, 0);
        } else {
            return new Result(left.res + right.res + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
    }
}
