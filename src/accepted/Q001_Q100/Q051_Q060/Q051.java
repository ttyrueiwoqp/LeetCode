package accepted.Q001_Q100.Q051_Q060;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LU-PC on 6/23/2015.
 * <p/>
 * The n-queens puzzle is the problem of placing n queens on an n�n chessboard
 * such that no two queens attack each other.
 * <p/>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p/>
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class Q051 {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		int[][] board = new int[n][n];
		solve(board, 0, res);
		return res;
	}

	private void solve(int[][] board, int i, List<List<String>> list) {

		for (int j = 0; j < board[i].length; j++) {
			if (isSafe(board, i, j)) {
				board[i][j] = 1;
				if (i == board.length - 1) {
					list.add(buildList(board));
				} else {
					solve(board, i + 1, list);
				}
				board[i][j] = 0;
			}
		}
	}

	private boolean isSafe(int[][] board, int m, int n) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][n] == 1) {
				return false;
			}
			int diff = Math.abs(i - m);
			if (diff == 0) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 1) {
						return false;
					}
				}
			} else {
				if (n - diff >= 0 && board[i][n - diff] == 1) {
					return false;
				}
				if (n + diff < board.length && board[i][n + diff] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private List<String> buildList(int[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j] == 1 ? "Q" : ".");
			}
			res.add(sb.toString());
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(solveNQueens(5));
	}
}
