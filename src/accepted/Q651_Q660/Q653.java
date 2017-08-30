package accepted.Q651_Q660;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 * <p>
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 9
 * <p>
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * Target = 28
 * <p>
 * Output: False
 */
public class Q653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        int i = 0, j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }
}
