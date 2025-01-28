class Solution {
    public static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int rows, cols;
    public static final int MOD = 1_000_000_007; 

    public int countPaths(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] i : dp)
            Arrays.fill(i, -1);
        int maxi = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxi = (maxi + dfs(grid, i, j, dp)) % MOD;
            }
        }
        return maxi + (rows * cols) % MOD;
    }

    public static int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxi = 0;
        for (int[] dir : direction) {
            int newx = i + dir[0];
            int newy = j + dir[1];
            if (newx < rows && newx >= 0 && newy < cols && newy >= 0 && grid[i][j] < grid[newx][newy])
                maxi = (maxi + 1 + dfs(grid, newx, newy, dp)) % MOD;
        }
        return dp[i][j] = maxi;
    }
}
