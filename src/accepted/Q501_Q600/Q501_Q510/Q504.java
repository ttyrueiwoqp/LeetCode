package accepted.Q501_Q600.Q501_Q510;

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Q504 {

    public String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
