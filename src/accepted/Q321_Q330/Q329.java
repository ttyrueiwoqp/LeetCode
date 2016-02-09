package accepted.Q321_Q330;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by FJ on 2/9/2016.
 * <p/>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p/>
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary
 * (i.e. wrap-around is not allowed).
 * <p/>
 * Example 1:
 * <p/>
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 * <p/>
 * Example 2:
 * <p/>
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Q329 {

	//Note: DFS & DP in Discussion is faster
	public int longestIncreasingPath(int[][] matrix) {

		if (matrix.length == 0) {
			return 0;
		}

		int[][] cntMatrix = new int[matrix.length][matrix[0].length];

		Deque<Integer> queueI = new ArrayDeque<>();
		Deque<Integer> queueJ = new ArrayDeque<>();
		Deque<Integer> queueCnt = new ArrayDeque<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (isHead(matrix, i, j)) {
					queueI.addLast(i);
					queueJ.addLast(j);
					queueCnt.addLast(1);
				}
			}
		}

		int cnt = 0;
		while (!queueI.isEmpty()) {
			int i = queueI.removeFirst();
			int j = queueJ.removeFirst();
			cnt = queueCnt.removeFirst();

			if (i > 0 && matrix[i - 1][j] > matrix[i][j]
					&& cnt + 1 > cntMatrix[i - 1][j]) {
				queueI.addLast(i - 1);
				queueJ.addLast(j);
				queueCnt.addLast(cnt + 1);
				cntMatrix[i - 1][j] = cnt + 1;
			}
			if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]
					&& cnt + 1 > cntMatrix[i + 1][j]) {
				queueI.addLast(i + 1);
				queueJ.addLast(j);
				queueCnt.addLast(cnt + 1);
				cntMatrix[i + 1][j] = cnt + 1;
			}
			if (j > 0 && matrix[i][j - 1] > matrix[i][j]
					&& cnt + 1 > cntMatrix[i][j - 1]) {
				queueI.addLast(i);
				queueJ.addLast(j - 1);
				queueCnt.addLast(cnt + 1);
				cntMatrix[i][j - 1] = cnt + 1;
			}
			if (j < matrix[i].length - 1 && matrix[i][j + 1] > matrix[i][j]
					&& cnt + 1 > cntMatrix[i][j + 1]) {
				queueI.addLast(i);
				queueJ.addLast(j + 1);
				queueCnt.addLast(cnt + 1);
				cntMatrix[i][j + 1] = cnt + 1;
			}
		}

		return cnt;
	}

	private boolean isHead(int[][] matrix, int i, int j) {
		if (i > 0 && matrix[i - 1][j] < matrix[i][j]) {
			return false;
		}
		if (i < matrix.length - 1 && matrix[i + 1][j] < matrix[i][j]) {
			return false;
		}
		if (j > 0 && matrix[i][j - 1] < matrix[i][j]) {
			return false;
		}
		if (j < matrix[i].length - 1 && matrix[i][j + 1] < matrix[i][j]) {
			return false;
		}
		return true;
	}

	@Test
	public void test() {

		int[][] a = {{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
				{19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
				{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
				{39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
				{40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
				{59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
				{60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
				{79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
				{80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
				{99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
				{100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
				{119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
				{120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
				{139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		System.out.println(longestIncreasingPath(a));

	}
}
