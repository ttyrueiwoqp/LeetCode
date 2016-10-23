package accepted.Q411_Q420;

/**
 * Given an 2D board, count how many different battleships are in it.
 * The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * <p>
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically.
 * In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is not a valid board - as battleships will always have a cell separating between them.
 * Your algorithm should not modify the value of the board.
 */
public class Q419 {

    public int countBattleships(char[][] board) {

        int res = 0;
        int w = board[0].length;
        int h = board.length;
        char[][] visited = new char[h][w];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && visited[i][j] == 0) {
                    dfs(board, visited, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(char[][] board, char[][] visited, int x, int y) {
        if (board[x][y] != 'X') {
            return;
        }

        visited[x][y] = 1;

        if (x < board.length - 1) {
            dfs(board, visited, x + 1, y);
        }
        if (y < board[0].length - 1) {
            dfs(board, visited, x, y + 1);
        }
    }
}
