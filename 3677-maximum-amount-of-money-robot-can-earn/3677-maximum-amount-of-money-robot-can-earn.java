class Solution {
    public int move(int m, int n, int i, int j, int[][][] dp, int[][] coins, int robbersNeutralized) {
        if (i == m - 1 && j == n - 1) return coins[i][j] < 0 && robbersNeutralized < 2 ? 0 : coins[i][j];
        if (i >= m || j >= n) return Integer.MIN_VALUE;
        if (dp[i][j][robbersNeutralized] != -1) return dp[i][j][robbersNeutralized];

        int down = move(m, n, i + 1, j, dp, coins, robbersNeutralized);
        int right = move(m, n, i, j + 1, dp, coins, robbersNeutralized);
        int maxCoins = Math.max(down, right) + coins[i][j];

        if (coins[i][j] < 0 && robbersNeutralized < 2) {
            down = move(m, n, i + 1, j, dp, coins, robbersNeutralized + 1);
            right = move(m, n, i, j + 1, dp, coins, robbersNeutralized + 1);
            maxCoins = Math.max(maxCoins, Math.max(down, right));
        }

        return dp[i][j][robbersNeutralized] = maxCoins;
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        return move(m, n, 0, 0, dp, coins, 0);
    }
}
