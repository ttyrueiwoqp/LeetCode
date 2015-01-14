package accepted.Q071_Q080;

public class Q079 {

	public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    
                    if (hasNext(board, word, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean hasNext(char[][] board, String word, int x, int y, boolean[][] visited) {
        
        if (x < 0 || x >= board.length 
        || y < 0 || y >= board[x].length
        || board[x][y] != word.charAt(0)
        || visited[x][y]) {
            return false;
        }
        if (word.length() == 1) {
            return true;
        }
        String s = word.substring(1);
        
        visited[x][y] = true;
        boolean result = hasNext(board, s, x-1, y, visited) 
        || hasNext(board, s, x+1, y, visited) 
        || hasNext(board, s, x, y-1, visited) 
        || hasNext(board, s, x, y+1, visited);
        visited[x][y] = false;
        
        return result;
    }
	
}
