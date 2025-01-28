class Solution {
    public static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static int rows, cols;
    public int longestIncreasingPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        int maxi = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                maxi = Math.max(maxi, dfs(grid, i, j, dp));
            }
        }
        return maxi+1;
    }
    public static int dfs(int[][] grid, int i, int j, int[][] dp) {
        if(dp[i][j] != -1) 
            return dp[i][j];
        int maxi = 0;
        for(int[] dir : direction) {
            int newx = i + dir[0];
            int newy = j + dir[1];
            if(newx < rows && newx >= 0 && newy < cols && newy >= 0 && grid[i][j] < grid[newx][newy])
                maxi = Math.max(maxi, 1 + dfs(grid, newx, newy, dp));
        } 
        return dp[i][j] = maxi;
    }
}