package accepted.Q101_Q200.Q121_Q130;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by LU-PC on 6/15/2015.
 * <p>
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Q130 {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}

		int[][] tracker = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O' && tracker[i][j] == 0) {
					tracker[i][j] = 1;
					flood(board, tracker, i, j);
				}
			}
		}
	}

	private void flood(char[][] board, int[][] tracker, int x, int y) {
		boolean isSurrounded = true;
		Deque<Integer> stackA = new ArrayDeque<>();
		Deque<Integer> stackB = new ArrayDeque<>();
		push(stackA, x, y);
		push(stackB, x, y);

		while (!stackA.isEmpty()) {
			int i = stackA.pop();
			int j = stackA.pop();

			if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
				isSurrounded = false;
			}

			if (i - 1 >= 0) {
				mark(board, tracker, i - 1, j, stackA, stackB);
			}
			if (j - 1 >= 0) {
				mark(board, tracker, i, j - 1, stackA, stackB);
			}
			if (i + 1 < board.length){
				mark(board, tracker, i + 1, j, stackA, stackB);
			}
			if (j + 1 < board[0].length) {
				mark(board, tracker, i, j + 1, stackA, stackB);
			}
		}

		if (isSurrounded) {
			while (!stackB.isEmpty()) {
				int m = stackB.pop();
				int n = stackB.pop();
				board[m][n] = 'X';
			}
		}
	}

	private void mark(char[][] board, int[][] tracker, int i, int j, Deque<Integer> stackA, Deque<Integer> stackB) {
		if (board[i][j] == 'O' && tracker[i][j] == 0) {
			tracker[i][j] = 1;
			push(stackA, i, j);
			push(stackB, i, j);
		}
	}

	private void push(Deque<Integer> stack, int i, int j) {
		stack.push(j);
		stack.push(i);
	}

	@Test
	public void test() {
		char[][] grid = {{'X', 'X', 'X', 'X'},
				{'X', 'O', 'O', 'X'},
				{'X', 'X', 'O', 'X'},
				{'X', 'O', 'X', 'X'}};
		solve(grid);
		for (char[] chars : grid) {
			for (char aChar : chars) {
				System.out.print(aChar);
			}
			System.out.println();
		}

	}
}
