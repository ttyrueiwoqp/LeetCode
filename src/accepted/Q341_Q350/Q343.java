package accepted.Q341_Q350;

/**
 * Created by LU-PC on 4/19/2016.
 * <p>
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: you may assume that n is not less than 2.
 * <p>
 * Hint:
 * <p>
 * There is a simple O(n) solution to this problem.
 * You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 */
public class Q343 {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int cnt2 = (3 - n % 3) % 3;
        int cnt3 = (n - cnt2 * 2) / 3;
        return (int) Math.pow(3, cnt3) * (int) Math.pow(2, cnt2);
    }
}
