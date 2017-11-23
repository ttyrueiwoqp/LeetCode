package accepted.Q501_Q600.Q551_Q560;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks.
 * The bricks have the same height but different width. You want to draw a vertical line from the top
 * to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a
 * list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed.
 * You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case
 * the line will obviously cross no bricks.
 * <p>
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * Explanation:
 * <p>
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in
 * range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class Q554 {

    public int leastBricks(List<List<Integer>> wall) {
        int min = wall.size();
        Map<Integer, Integer> m = new HashMap<>();

        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                int count = m.getOrDefault(sum, wall.size()) - 1;
                min = Math.min(min, count);
                m.put(sum, count);
            }
        }

        return min;
    }
}
