class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int[] i: dp)
            Arrays.fill(i, -1);

        return max(s, 0, n-1, dp);
    }

    public int max(String s, int i, int j, int[][] dp) {
        if(i >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j))
            return dp[i][j] = max(s, i+1, j-1, dp);
        
        int l = 1 + max(s, i+1, j, dp);
        int r = 1 + max(s, i, j-1, dp);

        return dp[i][j] = Math.min(l, r);
    }
}