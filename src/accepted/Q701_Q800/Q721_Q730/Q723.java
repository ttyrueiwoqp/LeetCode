package accepted.Q701_Q800.Q721_Q730;

import org.junit.Test;

/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * <p>
 * Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent
 * different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty.
 * The given board represents the state of the game following the player's move. Now, you need to restore the board to
 * a stable state by crushing candies according to the following rules:
 * <p>
 * If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time
 * - these positions become empty.
 * After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these
 * candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
 * After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
 * If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
 * You need to perform the above rules until the board becomes stable, then return the current board.
 * <p>
 * Example 1:
 * Input:
 * board =
 * [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],
 * [710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
 * Output:
 * [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],
 * [610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
 * Explanation:
 * <p>
 * Note:
 * The length of board will be in the range [3, 50].
 * The length of board[i] will be in the range [3, 50].
 * Each board[i][j] will initially start as an integer in the range [1, 2000].
 */
public class Q723 {

    public int[][] candyCrush(int[][] board) {

        int[][] marked = new int[board.length][board[0].length];
        while (!crush(board, marked)) {
            drop(board, marked);
            marked = new int[board.length][board[0].length];
        }

        return board;
    }

    private boolean crush(int[][] board, int[][] marked) {
        boolean isStable = true;

        for (int i = 0; i < board.length; i++) {
            int p = 0, count = 1;

            for (int j = 1; j <= board[i].length; j++) {
                if (j < board[i].length && board[i][j] == board[i][p] && board[i][j] != 0) {
                    count++;

                } else {
                    if (count >= 3) {
                        isStable = false;
                        for (int k = j - 1; k >= p; k--) {
                            marked[i][k] = 1;
                        }
                    }
                    p = j;
                    count = 1;
                }
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            int p = 0, count = 1;

            for (int i = 1; i <= board.length; i++) {
                if (i < board.length && board[i][j] == board[p][j] && board[i][j] != 0) {
                    count++;

                } else {
                    if (count >= 3) {
                        isStable = false;
                        for (int k = i - 1; k >= p; k--) {
                            marked[k][j] = 1;
                        }
                    }
                    p = i;
                    count = 1;
                }
            }
        }

        return isStable;
    }


    private void drop(int[][] board, int[][] marked) {

        for (int j = 0; j < board[0].length; j++) {
            int p = board.length - 1;
            for (int i = board.length - 1; i >= 0; i--) {

                while (p >= 0 && marked[p][j] == 1) {
                    p--;
                }
                board[i][j] = (p >= 0) ? board[p][j] : 0;
                p--;
            }
        }
    }

    private void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void test() {
        int[][] board = new int[][]{
                {110, 5, 112, 113, 114}, {210, 211, 5, 213, 214}, {310, 311, 3, 313, 314}, {410, 411, 412, 5, 414},
                {5, 1, 512, 3, 3}, {610, 4, 1, 613, 614}, {710, 1, 2, 713, 714}, {810, 1, 2, 1, 1},
                {1, 1, 2, 2, 2}, {4, 1, 4, 4, 1014}};

        candyCrush(board);
    }

}
