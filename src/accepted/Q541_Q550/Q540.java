package accepted.Q541_Q550;

/**
 * Given a sorted array consisting of only integers where every element appears twice except for one element
 * which appears once. Find this single element that appears only once.
 * <p>
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Q540 {
    public int singleNonDuplicate(int[] nums) {

        int i = 0, j = nums.length - 1;

        while (i < j) {

            int mid = i + (j - i) / 2;

            if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                if ((mid - i) % 2 == 0) {
                    j = mid;
                } else {
                    i = mid + 1;
                }

            } else if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                if ((mid - i) % 2 == 0) {
                    i = mid;
                } else {
                    j = mid - 1;
                }

            } else {
                return nums[mid];
            }

        }

        return nums[i];
    }
}
