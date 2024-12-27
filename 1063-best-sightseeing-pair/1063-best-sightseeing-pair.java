class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[][] dp = new int[2][values.length+1];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return run(values, 0, 0, dp);
    }
    public int run(int[] values, int idx, int count, int[][] dp) {
        if(idx >= values.length || count >= 2) 
            return (count == 2) ? 0 : Integer.MIN_VALUE;
        
        if(dp[count][idx] != -1)
            return dp[count][idx];

        int pick, notpick;
        pick = notpick = Integer.MIN_VALUE;
        if(count < 2) {
            pick = values[idx] + run(values, idx+1, count+1, dp);
            pick += (count == 0) ? idx : (-idx);
        } 
        notpick = run(values, idx+1, count, dp);
    
        return dp[count][idx] = Math.max(pick, notpick);
    }
}