class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {
                int minPath = Integer.MAX_VALUE;
                
                for (int nextCol = 0; nextCol < n; nextCol++) {
                    if (col != nextCol) {
                        minPath = Math.min(minPath, dp[row + 1][nextCol]);
                    }
                }
                
                dp[row][col] = matrix[row][col] + minPath;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp[0][i]);
        }

        return result;
    }
}
