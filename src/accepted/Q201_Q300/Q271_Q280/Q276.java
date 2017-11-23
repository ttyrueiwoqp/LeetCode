package accepted.Q201_Q300.Q271_Q280;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note:
 * n and k are non-negative integers.
 */
public class Q276 {

    public int numWays(int n, int k) {

        if (n < 2 || k == 0) {
            return n * k;
        }

        int s = k, d = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int t = d;
            d = (k - 1) * (d + s);
            s = t;
        }

        return s + d;
    }

    public int sln(int n, int k) {
        if(n == 0) return 0;
        else if(n == 1) return k;
        int diffColorCounts = k*(k-1);
        int sameColorCounts = k;
        for(int i=2; i<n; i++) {
            int temp = diffColorCounts;
            diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
            sameColorCounts = temp;
        }
        return diffColorCounts + sameColorCounts;
    }
}
