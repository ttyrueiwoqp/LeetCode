package accepted.Q651_Q660;

import util.TreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int st, int end) {
        if (st >= end) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = st; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode res = new TreeNode(max);
        res.left = helper(nums, st, idx);
        res.right = helper(nums, idx + 1, end);
        return res;
    }
}
