class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] delrow = {0, +1, 0, -1};
        int[] delcol = {-1, 0, +1, 0};
        int maxsum = 0;
        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && vis[i][j] == 0) {
                    int[] sum = new int[1]; // Array to track the sum by reference
                    dfs(i, j, delrow, delcol, grid, vis, sum);
                    maxsum = Math.max(maxsum, sum[0]); // Update maxsum
                }
            }
        }

        return maxsum;
    }

    private void dfs(int row, int col, int[] delrow, int[] delcol, int[][] grid, int[][] vis, int[] sum) {
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = 1;
        sum[0] += grid[row][col]; // Update the sum

        for (int i = 0; i < 4; i++) {
            int r = row + delrow[i];
            int c = col + delcol[i];
            if (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == 0 && grid[r][c] > 0) {
                dfs(r, c, delrow, delcol, grid, vis, sum);
            }
        }
    }
}