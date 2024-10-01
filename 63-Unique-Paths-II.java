class Solution {
    public int move(int m, int n, int i, int j, int[][] dp, int[][] obs) { 
        if(i==m-1 && j==n-1)
            return obs[i][j] == 0 ? 1 : 0;
        if(i>=m || j>=n || obs[i][j]==1)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = move(m, n, i + 1, j, dp, obs) + move(m, n, i, j + 1, dp, obs);
        
        return dp[i][j];
    }
    public int uniquePaths(int m, int n, int[][] obs) {
        int[][] dp = new int[m][n];
        for(int o=0;o<m;o++)
            for(int p=0;p<n;p++)
                dp[o][p] = -1;
        return move(m, n, 0, 0, dp, obs);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        return uniquePaths(obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }
}