package accepted.Q401_Q500.Q421_Q430;

/**
 * Given a non-empty string containing an out-of-order English representation
 * of digits 0-9, output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 * <p>
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 * <p>
 * Output: "45"
 */
public class Q423 {

    public String originalDigits(String s) {

        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        int[] nums = new int[10];
        nums[0] = counts['z'];
        nums[2] = counts['w'];
        nums[4] = counts['u'];
        nums[6] = counts['x'];
        nums[8] = counts['g'];

        nums[1] = counts['o'] - nums[0] - nums[2] - nums[4];
        nums[3] = counts['r'] - nums[0] - nums[4];
        nums[5] = counts['f'] - nums[4];
        nums[7] = counts['s'] - nums[6];
        nums[9] = counts['i'] - nums[5] - nums[6] - nums[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
