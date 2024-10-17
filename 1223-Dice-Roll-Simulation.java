class Solution {
    int MOD = 1000000007;
    int[][][] dp;

    public int dieSimulator(int n, int[] rollMax) {
        dp = new int[n + 1][7][16];
        return check(n, 0, 0, rollMax);
    }

    public int check(int n, int last, int streak, int[] rollMax) {
        if (n == 0) return 1;
        if (dp[n][last][streak] != 0) return dp[n][last][streak];

        int sum = 0;

        for (int i = 1; i <= 6; i++) {
            if (i == last) {
                if (streak < rollMax[i - 1]) {
                    sum = (sum + check(n - 1, i, streak + 1, rollMax)) % MOD;
                }
            } else {
                sum = (sum + check(n - 1, i, 1, rollMax)) % MOD;
            }
        }

        dp[n][last][streak] = sum;
        return sum;
    }
}
