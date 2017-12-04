package accepted.Q301_Q400.Q371_Q380;

/**
 * Design a Phone Directory which supports the following operations:
 * <p>
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 * Example:
 * <p>
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 * <p>
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 * <p>
 * // Assume it returns 1.
 * directory.get();
 * <p>
 * // The number 2 is available, so return true.
 * directory.check(2);
 * <p>
 * // It returns 2, the only number that is left.
 * directory.get();
 * <p>
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 * <p>
 * // Release number 2 back to the pool.
 * directory.release(2);
 * <p>
 * // Number 2 is available again, return true.
 * directory.check(2);
 */
public class Q379 {

    private int p;
    private int[] nums;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public Q379(int maxNumbers) {
        p = 0;
        nums = new int[maxNumbers];
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        int st = p;
        while (nums[p] != 0) {
            p++;
            if (p == nums.length) {
                p = 0;
            }
            if (p == st) {
                return -1;
            }
        }

        nums[p] = 1;
        return p;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return nums[number] == 0;
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        nums[number] = 0;
    }
}
