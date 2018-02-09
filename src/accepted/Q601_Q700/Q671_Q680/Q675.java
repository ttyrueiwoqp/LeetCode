package accepted.Q601_Q700.Q671_Q680;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
 * <p>
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * <p>
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
 * <p>
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 * <p>
 * Example 1:
 * Input:
 * [
 * [1,2,3],
 * [0,0,4],
 * [7,6,5]
 * ]
 * Output: 6
 * Example 2:
 * Input:
 * [
 * [1,2,3],
 * [0,0,0],
 * [7,6,5]
 * ]
 * Output: -1
 * Example 3:
 * Input:
 * [
 * [2,3,4],
 * [0,0,5],
 * [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 * Hint: size of the given matrix will not exceed 50x50.
 */
public class Q675 {

    public int cutOffTree(List<List<Integer>> forest) {
        TreeMap<Integer, int[]> m = new TreeMap<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int v = forest.get(i).get(j);
                if (v > 1) {
                    m.put(v, new int[]{i, j});
                }
            }
        }

        int res = 0;
        int[] start = new int[]{0, 0};
        for (Map.Entry<Integer, int[]> e : m.entrySet()) {
            int val = bfs(forest, start, e.getValue());
            if (val == -1) {
                return -1;
            }
            res += val;
            start = e.getValue();
        }

        return res;
    }

    private int bfs(List<List<Integer>> forest, int[] start, int[] end) {

        int[][] visited = new int[forest.size()][forest.get(0).size()];
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            int x = c[0], y = c[1], d = visited[x][y];
            if (x == end[0] && y == end[1]) {
                return d - 1;
            }

            if (x - 1 >= 0 && visited[x - 1][y] == 0 && forest.get(x - 1).get(y) != 0) {
                q.offer(new int[]{x - 1, y});
                visited[x - 1][y] = d + 1;
            }
            if (x + 1 < forest.size() && visited[x + 1][y] == 0 && forest.get(x + 1).get(y) != 0) {
                q.offer(new int[]{x + 1, y});
                visited[x + 1][y] = d + 1;
            }
            if (y - 1 >= 0 && visited[x][y - 1] == 0 && forest.get(x).get(y - 1) != 0) {
                q.offer(new int[]{x, y - 1});
                visited[x][y - 1] = d + 1;
            }
            if (y + 1 < forest.get(0).size() && visited[x][y + 1] == 0 && forest.get(x).get(y + 1) != 0) {
                q.offer(new int[]{x, y + 1});
                visited[x][y + 1] = d + 1;
            }
        }

        return -1;
    }

}
