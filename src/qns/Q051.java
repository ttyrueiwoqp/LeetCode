package qns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/23/2015.
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class Q051 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if (n < 4) {
			return res;
		}

		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			int j = 0;
			while (!isSafe(board, i, j)) {
				j++;
			}
		}


		return res;

	}

	private boolean isSafe(int[][] board, int i, int j) {
		return false;
	}
}
