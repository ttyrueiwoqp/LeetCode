package accepted.Q301_Q400.Q371_Q380;

import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class Q378 {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        PriorityQueue<Elem> pq = new PriorityQueue<>(k, (o1, o2) -> o1.num - o2.num);
        for (int i = 0; i < k && i < matrix.length; i++) {
            pq.offer(new Elem(i, 0, matrix[i][0]));
        }

        for (int i = 0; i < k - 1 && !pq.isEmpty(); i++) {
            Elem elem = pq.poll();
            int col = elem.col + 1;
            if (col < matrix[0].length) {
                pq.offer(new Elem(elem.row, col, matrix[elem.row][col]));
            }
        }
        return pq.poll().num;
    }

    private class Elem {
        int row;
        int col;
        int num;

        Elem(int row, int col, int num) {
            this.row = row;
            this.col = col;
            this.num = num;
        }
    }
}
