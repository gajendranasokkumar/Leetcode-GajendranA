class Solution {
    int rows, cols;
    
    public boolean containsCycle(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && dfs(grid, i, j, -1, -1, visited, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int i, int j, int prevI, int prevJ, boolean[][] visited, char origin) {
        if (visited[i][j]) 
            return true;

        visited[i][j] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];

            if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == origin) {
                if (ni != prevI || nj != prevJ) {
                    if (dfs(grid, ni, nj, i, j, visited, origin)) 
                        return true;
                }
            }
        }
        return false;
    }
}
