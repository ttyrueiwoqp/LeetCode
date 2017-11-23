package accepted.Q201_Q300.Q281_Q290;

import org.junit.Test;

/**
 * Created by FJ on 10/18/2015.
 * <p/>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p/>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p/>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p/>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 */
public class Q289 {

	public void gameOfLife(int[][] board) {

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				saveNextState(board, i, j);
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] >>= 1;
			}
		}

	}

	private void saveNextState(int[][] board, int i, int j) {

		int num = countNeighbors(board, i, j);

		if ((board[i][j] == 1 && (num == 2 || num == 3))
				|| board[i][j] == 0 && num == 3) {
			board[i][j] += 2;
		}
	}

	private int countNeighbors(int[][] board, int i, int j) {

		int cnt = 0;
		if (i > 0) {
			cnt += getOldStatus(board[i - 1][j]);
			if (j > 0) {
				cnt += getOldStatus(board[i - 1][j - 1]);
			}
			if (j < board[i].length - 1) {
				cnt += getOldStatus(board[i - 1][j + 1]);
			}
		}
		if (i < board.length - 1) {
			cnt += getOldStatus(board[i + 1][j]);
			if (j > 0) {
				cnt += getOldStatus(board[i + 1][j - 1]);
			}
			if (j < board[i].length - 1) {
				cnt += getOldStatus(board[i + 1][j + 1]);
			}
		}
		if (j > 0) {
			cnt += getOldStatus(board[i][j - 1]);
		}
		if (j < board[i].length - 1) {
			cnt += getOldStatus(board[i][j + 1]);
		}
		return cnt;
	}

	public int getOldStatus(int n) {
		return n & 1;
	}

	@Test
	public void test() {

	}

}
