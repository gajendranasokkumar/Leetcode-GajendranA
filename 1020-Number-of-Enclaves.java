class Solution {
    int rows, cols;
    
    public int numEnclaves(int [][] board) {
        if (board == null || board.length == 0) return 0;
        
        rows = board.length;
        cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 1) dfs(board, i, 0);
            if (board[i][cols - 1] == 1) dfs(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 1) dfs(board, 0, j);
            if (board[rows - 1][j] == 1) dfs(board, rows - 1, j);
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1) {
                    // board[i][j] = 1;
                    count++;  
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 1) return;
        
        board[row][col] = 2;
        
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}