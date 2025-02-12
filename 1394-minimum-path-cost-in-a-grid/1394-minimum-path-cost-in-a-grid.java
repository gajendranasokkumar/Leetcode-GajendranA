class Solution {
    int rows, cols;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cols;i++) {
            min = Math.min(min, dfs(grid, moveCost, 0, i, dp));
        }
        return min;
    }
    public int dfs(int[][] grid, int[][] moveCost, int row, int col, int[][] dp) {
        if(row == rows-1)
            return grid[row][col];
        if(dp[row][col] != -1)
            return dp[row][col];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cols;i++) {
            int ans = grid[row][col] + moveCost[grid[row][col]][i] + dfs(grid, moveCost, row+1, i, dp);
            min = Math.min(min, ans);
        }
        return dp[row][col] = min;
    }
}