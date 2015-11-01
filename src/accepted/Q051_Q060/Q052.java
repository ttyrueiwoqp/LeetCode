package accepted.Q051_Q060;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FJ on 11/1/2015.
 * <p/>
 * Follow up for N-Queens problem.
 * <p/>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class Q052 {

	public int totalNQueens(int n) {
		List<Integer> res = new ArrayList<>();
		int[][] board = new int[n][n];
		solve(board, 0, res);
		return res.size();
	}

	private void solve(int[][] board, int i, List<Integer> list) {

		for (int j = 0; j < board[i].length; j++) {
			if (isSafe(board, i, j)) {
				board[i][j] = 1;
				if (i == board.length - 1) {
					list.add(0);
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

	@Test
	public void test() {
		System.out.println(totalNQueens(5));
	}
}
