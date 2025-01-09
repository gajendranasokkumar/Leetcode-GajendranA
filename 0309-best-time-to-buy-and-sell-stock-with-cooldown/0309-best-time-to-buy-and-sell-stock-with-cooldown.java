class Solution {
    public int maxProfit(int[] prices) {
        // using recursion with memoization
        // tc: O(n*2)
        // sc: O(n) + O(n*2)
        int n = prices.length;
        int[][] dp = new int[n + 2][2];
        // dp size is n+2 as we can go to n+1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp);
    }

    private int solve(int ind, int canBuy, int[] prices, int[][] dp) {
        if (ind >= prices.length) {
            // we use >= as at n-1, we can have ind+2. = n+1.
            return 0;
        }
        if (dp[ind][canBuy] != -1) {
            return dp[ind][canBuy];
        }
        if (canBuy == 1) {
            int buy = -prices[ind] + solve(ind + 1, 0, prices, dp);
            int skip = 0 + solve(ind + 1, 1, prices, dp);
            return dp[ind][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[ind] + solve(ind + 2, 1, prices, dp);
            int skip = 0 + solve(ind + 1, 0, prices, dp);
            return dp[ind][canBuy] = Math.max(sell, skip);
        }
    }
}