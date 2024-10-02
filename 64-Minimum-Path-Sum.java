class Solution {
    public int move(int[][] grid, int i, int j, int[][] dp) {
        if(i==0 && j==0)
            return grid[i][j];

        if(i<0 || j<0)
            return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        return dp[i][j] = grid[i][j] + Math.min(move(grid, i-1, j, dp), move(grid, i, j-1, dp));
    }
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                dp[i][j] = -1;
        return move(grid, grid.length-1, grid[0].length-1, dp);
    }
}