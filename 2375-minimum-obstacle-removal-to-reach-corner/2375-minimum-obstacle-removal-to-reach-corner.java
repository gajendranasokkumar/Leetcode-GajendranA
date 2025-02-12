class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0] = 1;
        while(!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int i = cur[0];
            int j = cur[1];
            int stRemoved = cur[2];
            if(i == rows-1 && j == cols-1)
                return stRemoved;
            for(int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni < 0 || ni >= rows || nj < 0 || nj >= cols)
                    continue;
                if(visited[ni][nj] == 0) {
                    visited[ni][nj] = 1;
                    if(grid[ni][nj] == 0) {
                        q.addFirst(new int[]{ni, nj, stRemoved});
                    } else {
                        q.addLast(new int[]{ni, nj, stRemoved + 1});
                    }
                }
            }
        }

        return 0;
    }
}