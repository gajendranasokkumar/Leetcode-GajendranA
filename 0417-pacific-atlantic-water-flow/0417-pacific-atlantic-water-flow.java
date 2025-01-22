class Solution {
    int rows, cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, pacificVisited, Integer.MIN_VALUE, 0, j);
            dfs(heights, atlanticVisited, Integer.MIN_VALUE, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int prev, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || heights[i][j] < prev) {
            return;
        }
        visited[i][j] = true;
        dfs(heights, visited, heights[i][j], i - 1, j);
        dfs(heights, visited, heights[i][j], i + 1, j);
        dfs(heights, visited, heights[i][j], i, j - 1);
        dfs(heights, visited, heights[i][j], i, j + 1);
    }
}
