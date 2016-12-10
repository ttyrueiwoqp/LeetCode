package accepted.Q461_Q470;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all
 * array elements equal, where a move is incrementing a selected element by 1 or decrementing
 * a selected element by 1.
 * <p>
 * You may assume the array's length is at most 10,000.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Q462 {

    public int minMoves2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int median = select(nums, nums.length / 2);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - median);
        }
        return res;
    }

    private int select(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int p = partition(nums, left, right, nums[right]);
            if (p == k) {
                return nums[p];
            } else if (p < k) {
                left = p + 1;
            } else {
                right = p - 1;
            }
        }
        return 0;
    }

    private int partition(int[] nums, int left, int right, int pVal) {
        int p = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pVal) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, right, p);
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
