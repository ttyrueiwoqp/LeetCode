package accepted.Q401_Q500.Q411_Q420;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements
 * and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given.
 * A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class Q413 {

    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        int len = A.length;
        if (len < 3) {
            return res;
        }

        int prev = A[1] - A[0];
        int j = 0;

        for (int i = 2; i < len; i++) {
            int curr = A[i] - A[i - 1];
            if (curr == prev) {
                j++;
                res += j;
            } else {
                j = 0;
                prev = curr;
            }
        }

        return res;
    }
}
