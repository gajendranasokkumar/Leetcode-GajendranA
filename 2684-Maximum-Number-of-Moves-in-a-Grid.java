class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] memo = new int[rows][cols];
        int maxi = 0;
        
        for (int i = 0; i < rows; i++) {
            maxi = Math.max(maxi, check(grid, i, 0, rows, cols, memo));
        }
        
        return maxi;
    }

    public int check(int[][] grid, int row, int col, int rows, int cols, int[][] memo) {
        if (col >= cols) return 0;
        if (memo[row][col] != 0) return memo[row][col];

        int maxSteps = 0;

        if (row - 1 >= 0 && col + 1 < cols && grid[row][col] < grid[row - 1][col + 1]) {
            maxSteps = Math.max(maxSteps, 1 + check(grid, row - 1, col + 1, rows, cols, memo));
        }

        if (col + 1 < cols && grid[row][col] < grid[row][col + 1]) {
            maxSteps = Math.max(maxSteps, 1 + check(grid, row, col + 1, rows, cols, memo));
        }

        if (row + 1 < rows && col + 1 < cols && grid[row][col] < grid[row + 1][col + 1]) {
            maxSteps = Math.max(maxSteps, 1 + check(grid, row + 1, col + 1, rows, cols, memo));
        }
        
        memo[row][col] = maxSteps;
        return maxSteps;
    }
}
