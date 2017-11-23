package accepted.Q501_Q600.Q551_Q560;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit integer
 * which has exactly the same digits existing in the integer n and is greater in value than n.
 * If no such positive 32-bit integer exists, you need to return -1.
 * <p>
 * Example 1:
 * Input: 12
 * Output: 21
 * Example 2:
 * Input: 21
 * Output: -1
 */
public class Q556 {

    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();

        for (int i = cs.length - 1; i > 0; i--) {
            if (cs[i] > cs[i - 1]) {
                int j = i;
                while (j < cs.length) {
                    if (cs[j] <= cs[i - 1]) {
                        break;
                    }
                    j++;
                }
                swap(cs, i - 1, j - 1);

                int k = 0;
                while (i + k < cs.length - 1 - k) {
                    swap(cs, i + k, cs.length - 1 - k);
                    k++;
                }

                long res = Long.parseLong(new String(cs));
                return res <= Integer.MAX_VALUE ? (int) res : -1;
            }
        }

        return -1;
    }

    private void swap(char[] cs, int a, int b) {
        char t = cs[a];
        cs[a] = cs[b];
        cs[b] = t;
    }
}
