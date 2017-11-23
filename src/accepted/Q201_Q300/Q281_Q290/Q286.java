package accepted.Q201_Q300.Q281_Q290;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
 * represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 * it should be filled with INF.
 * <p>
 * For example, given the 2D grid:
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class Q286 {

    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int INF = Integer.MAX_VALUE;

    public void wallsAndGates(int[][] rooms) {

        Deque<Integer> x = new ArrayDeque<>();
        Deque<Integer> y = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) {
                    x.addLast(i);
                    y.addLast(j);
                }
            }
        }

        while (!x.isEmpty()) {
            int i = x.poll();
            int j = y.poll();

            expand(rooms, i - 1, j, rooms[i][j], x, y);
            expand(rooms, i, j - 1, rooms[i][j], x, y);
            expand(rooms, i + 1, j, rooms[i][j], x, y);
            expand(rooms, i, j + 1, rooms[i][j], x, y);
        }
    }

    private void expand(int[][] rooms, int i, int j, int dist, Deque<Integer> x, Deque<Integer> y) {
        if (i < 0 || i >= rooms.length
                || j < 0 || j >= rooms[i].length
                || rooms[i][j] <= 0) {
            return;
        }

        if (rooms[i][j] == INF) {
            rooms[i][j] = dist + 1;
            x.addLast(i);
            y.addLast(j);
        }
    }

    @Test
    public void test() {
        int[][] a = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        wallsAndGates(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public void sln(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++)
            for (int j = 0; j < rooms[0].length; j++)
                if (rooms[i][j] == 0) helper(rooms, i, j, 0);
    }

    private void helper(int[][] rooms, int i, int j, int d) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
        rooms[i][j] = d;
        helper(rooms, i - 1, j, d + 1);
        helper(rooms, i + 1, j, d + 1);
        helper(rooms, i, j - 1, d + 1);
        helper(rooms, i, j + 1, d + 1);
    }

    public void sln2(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
}
