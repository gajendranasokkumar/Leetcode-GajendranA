class Solution {
    int maxi = Integer.MIN_VALUE;
    public void run(char[][] matrix, int[][] dp, int i, int j) {
        if(i == matrix.length || j == matrix[0].length)
            return;
        if (i == 0 || j == 0) {
            return;
        }
        if (matrix[i][j] == '1') {
            int top = dp[i-1][j];
            int left = dp[i][j-1];
            int cross = dp[i-1][j-1];
            dp[i][j] = Math.min(top, Math.min(left, cross)) + 1;
            maxi = Math.max(maxi, dp[i][j]);
        } else {
            dp[i][j] = 0;
        }
        run(matrix, dp, i, j+1);
    }
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        for(int i=0;i<matrix[0].length;i++) {
            dp[0][i] = (matrix[0][i] == '1') ? 1 : 0;
            maxi = Math.max(dp[0][i], maxi);
        }
        for(int i=0;i<matrix.length;i++) {
            dp[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            maxi = Math.max(dp[i][0], maxi);
        }
        if(matrix.length > 1)
            for(int i=1;i<matrix.length;i++)
                run(matrix, dp, i, 1);

        return maxi * maxi;
    }
}