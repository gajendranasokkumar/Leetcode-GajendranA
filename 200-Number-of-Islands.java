class Solution {
    int rows;
    int cols;
    int islands = 0;
    
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int row = 0; row < rows; row++)
            check(grid, row);
        return islands;
    }

    public void check(final char[][] grid, int row) {
        final char[] finalRow = grid[row];
        for (int col = 0; col < cols; ++col)
            if (finalRow[col] == '1') {
                bfs(grid, row, col);
                ++islands;
            }
    }
    
    public void bfs(char[][] grid, int row, int col) {
        grid[row][col] = '*';
        if (row > 0 && grid[row - 1][col] == '1')
            bfs(grid, row - 1, col);
        if (row + 1 < rows && grid[row + 1][col] == '1')
            bfs(grid, row + 1, col);
        if (col > 0 && grid[row][col - 1] == '1')
            bfs(grid, row, col - 1);
        if (col + 1 < cols && grid[row][col + 1] == '1')
            bfs(grid, row, col + 1);
    }
}