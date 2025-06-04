class Solution {
    int[][][] dp;

    int lcsOf3(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), o = s3.length();
        dp = new int[m + 1][n + 1][o + 1];
        for (int[][] mat : dp)
            for (int[] row : mat)
                java.util.Arrays.fill(row, -1);
        return lcsRec(s1, s2, s3, m, n, o);
    }

    int lcsRec(String s1, String s2, String s3, int m, int n, int o) {
        if (m == 0 || n == 0 || o == 0)
            return 0;

        if (dp[m][n][o] != -1)
            return dp[m][n][o];

        if (s1.charAt(m - 1) == s2.charAt(n - 1) && s2.charAt(n - 1) == s3.charAt(o - 1))
            return dp[m][n][o] = 1 + lcsRec(s1, s2, s3, m - 1, n - 1, o - 1);
        else
            return dp[m][n][o] = Math.max(lcsRec(s1, s2, s3, m - 1, n, o),
                                 Math.max(lcsRec(s1, s2, s3, m, n - 1, o),
                                          lcsRec(s1, s2, s3, m, n, o - 1)));
    }
}
