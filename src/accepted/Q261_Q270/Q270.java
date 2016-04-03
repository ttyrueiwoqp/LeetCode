package accepted.Q261_Q270;

import org.junit.Test;
import util.TreeNode;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class Q270 {

    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        TreeNode res = root;

        double min = Math.abs(root.val - target);
        while (curr != null) {
            double diff = Math.abs(curr.val - target);
            if (min > diff) {
                min = diff;
                res = curr;
            }

            if (target == curr.val) {
                return curr.val;
            } else if (target < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return res.val;
    }

    @Test
    public void test() {
    }


    public int sln(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null) return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }
}
