package accepted.Q301_Q400.Q341_Q350;

class TicTacToe {

    private int n;
    private Line[] rows;
    private Line[] cols;
    private Line[] diagonals;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new Line[n];
        cols = new Line[n];
        diagonals = new Line[2];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {

        rows[row] = update(rows[row], player);
        if (rows[row].occupied == n) {
            return player;
        }

        cols[col] = update(cols[col], player);
        if (cols[col].occupied == n) {
            return player;
        }

        if (row == col) {
            diagonals[0] = update(diagonals[0], player);
            if (diagonals[0].occupied == n) {
                return player;
            }
        }

        if (row + col == n - 1) {
            diagonals[1] = update(diagonals[1], player);
            if (diagonals[1].occupied == n) {
                return player;
            }
        }

        return 0;
    }

    private Line update(Line line, int player) {
        if (line == null) {
            line = new Line(player, 1);

        } else if (line.player == player) {
            line.occupied++;

        } else {
            line.player = 0;
        }

        return line;
    }
}

class Line {

    int player;
    int occupied;

    Line(int player, int occupied) {
        this.player = player;
        this.occupied = occupied;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
