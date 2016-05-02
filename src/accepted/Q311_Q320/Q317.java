package accepted.Q311_Q320;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lvfan on 3/27/2016.
 * <p>
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 * <p>
 * Show Company Tags
 * Show Tags
 * Show Similar Problems
 */
public class Q317 {

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        final int[] dir = new int[]{0, 1, 0, -1, 0};

        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        int numBuilding = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    numBuilding++;
                    int level = 1;
                    int[][] visited = new int[m][n];
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.offer(i);
                    queue.offer(j);

                    while (!queue.isEmpty()) {

                        int qSize = queue.size();
                        for (int k = 0; k < qSize; k+=2) {
                            int x = queue.poll();
                            int y = queue.poll();

                            for (int d = 0; d < 4; d++) {
                                int nbX = x + dir[d];
                                int nbY = y + dir[d + 1];

                                if (nbX >= 0 && nbX < m && nbY >= 0 && nbY < n
                                        && grid[nbX][nbY] == 0 && visited[nbX][nbY] == 0) {

                                    dist[nbX][nbY] += level;
                                    reach[nbX][nbY]++;

                                    visited[nbX][nbY] = 1;
                                    queue.offer(nbX);
                                    queue.offer(nbY);

                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numBuilding) {
                    min = Math.min(min, dist[i][j]);
                }
            }
        }

        return min == Integer.MIN_VALUE ? -1 : min;
    }

    // TODO: Subscribe again and check solution
    @Test
    public void test() {
        int[][] a = new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        };

        System.out.println(shortestDistance(a));
    }

    public int sln(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        final int[] shift = new int[]{0, 1, 0, -1, 0};

        int row = grid.length, col = grid[0].length;
        int[][] distance = new int[row][col];
        int[][] reach = new int[row][col];
        int buildingNum = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildingNum++;
                    Queue<int[]> myQueue = new LinkedList<int[]>();
                    myQueue.offer(new int[]{i, j});

                    boolean[][] isVisited = new boolean[row][col];
                    int level = 1;

                    while (!myQueue.isEmpty()) {
                        int qSize = myQueue.size();
                        for (int q = 0; q < qSize; q++) {
                            int[] curr = myQueue.poll();

                            for (int k = 0; k < 4; k++) {
                                int nextRow = curr[0] + shift[k];
                                int nextCol = curr[1] + shift[k + 1];

                                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col
                                        && grid[nextRow][nextCol] == 0 && !isVisited[nextRow][nextCol]) {
                                    //The shortest distance from [nextRow][nextCol] to this building
                                    // is 'level'.
                                    distance[nextRow][nextCol] += level;
                                    reach[nextRow][nextCol]++;

                                    isVisited[nextRow][nextCol] = true;
                                    myQueue.offer(new int[]{nextRow, nextCol});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }

        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;


    }
}
