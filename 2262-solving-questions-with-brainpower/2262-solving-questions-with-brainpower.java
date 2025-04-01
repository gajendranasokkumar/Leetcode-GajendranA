class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return earnPoints(questions, 0, n, dp);
    }
    public long earnPoints(int[][] questions, int idx, int n, long[] dp) {
        if(idx >= n)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        long pick = questions[idx][0] + earnPoints(questions, idx+questions[idx][1]+1, n, dp);
        long notpick = earnPoints(questions, idx+1, n, dp);

        return dp[idx] = Math.max(pick, notpick);
    }
}