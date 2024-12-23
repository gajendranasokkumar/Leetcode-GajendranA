class Solution {
    public int numSquares(int n) {
        int maxSquareRoot = (int) Math.sqrt(n);
        int[] s = new int[maxSquareRoot];
        for(int i=0;i<maxSquareRoot;i++) 
            s[i] = (i+1) * (i+1);
        
        int[][] dp = new int[s.length][n+1];
        for(int i[] : dp)
            Arrays.fill(i, -1);

        int mincount = run(s, n, 0, dp);

        return mincount;
              
    }
    public int run(int[] s, int target, int i, int[][] dp) {
        if(i >= s.length || target < 0)
            return Integer.MAX_VALUE;
        
        if(target == 0) {
            return 0;
        }
        
        if(dp[i][target] != -1)
            return dp[i][target];

        int pick = (int)1e9;
        if(target >= s[i])
            pick = 1 + run(s, target-s[i], i, dp);

        int notpick = run(s, target, i+1, dp);

        return dp[i][target] = Math.min(pick, notpick);
    } 
}