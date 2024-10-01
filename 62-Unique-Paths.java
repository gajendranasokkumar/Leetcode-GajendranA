class Solution {
    public int move(int m, int n, int i, int j, int[][] dp) { 
        if(i==m-1 && j==n-1)
            return 1;
        if(i>=m || j>=n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = move(m, n, i + 1, j, dp) + move(m, n, i, j + 1, dp);
        
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int o=0;o<m;o++)
            for(int p=0;p<n;p++)
                dp[o][p] = -1;
        return move(m, n, 0, 0, dp);
    }
}