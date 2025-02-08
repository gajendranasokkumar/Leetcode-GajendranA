class Solution {
    int rows, cols;
    boolean isSub = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        rows = grid1.length;
        cols = grid1[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid2[i][j] == 1) {
                    isSub = true;
                    dfs(grid1, grid2, i, j);
                    if(isSub)
                        count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if(i < 0 || i == rows || j < 0 || j == cols || grid2[i][j] == 0)
            return;
        if(grid2[i][j] != grid1[i][j])
            isSub = false;
        grid2[i][j] = 0;
        dfs(grid1, grid2, i+1, j);
        dfs(grid1, grid2, i, j+1);
        dfs(grid1, grid2, i-1, j);
        dfs(grid1, grid2, i, j-1);
    }
}