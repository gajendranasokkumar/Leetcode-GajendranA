class Solution {
    int rows, cols;
    public int shortestBridge(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    if(found)   
                        q.add(new int[]{i, j});
                    else {
                        found = true;
                        dfs(grid, i, j);
                    }
                }
            }
        }
        int step = 0;
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for(int[] dir : direction) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if(ni < 0 || ni == rows || nj < 0 || nj == cols || grid[ni][nj] == 1)
                        continue;
                    if(grid[ni][nj] == 2)
                        return step;
                    grid[ni][nj] = 1;
                    q.add(new int[]{ni, nj});
                }
            }
            step++;
        }
        return step;
    }
    public void dfs(int[][] grid, int i, int j) {
        if(i < 0 || i == rows || j < 0 || j == cols || grid[i][j] == 0 || grid[i][j] == 2)
            return;
        grid[i][j] = 2;
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}