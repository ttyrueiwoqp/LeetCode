package accepted.Q501_Q600.Q591_Q600;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * <p>
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * <p>
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * Note:
 * <p>
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 */
public class Q593 {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int sqrSide = sqrDist(list.get(0), list.get(1));
        int sqrDiagonal = sqrDist(list.get(0), list.get(3));

        return sqrSide == sqrDist(list.get(1), list.get(3))
                && sqrSide == sqrDist(list.get(3), list.get(2))
                && sqrSide == sqrDist(list.get(2), list.get(0))
                && sqrDiagonal == sqrDist(list.get(1), list.get(2))
                && sqrSide != 0
                && sqrSide + sqrSide == sqrDiagonal;
    }

    private int sqrDist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}
