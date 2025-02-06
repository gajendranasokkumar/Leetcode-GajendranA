class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        int[][] stones = new int[rows][cols];
        for(int i=0;i<rows;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(stones[i], Integer.MAX_VALUE);
        }
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
        //     if(a[2] == b[2])
        //         return a[3] - b[3];
        //     return a[2] - b[2];
        // });
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            int di = arr[2];
            int st = arr[3];
            if(i == rows-1 && j == cols-1)
                return di;
            for(int[] dir : direction) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    if(grid[ni][nj] == 1 && st == k)
                        continue;
                    int cur_st = st + ((grid[ni][nj] == 1) ? 1 : 0);
                    if(cur_st <= k && (dist[ni][nj] > di+1 || stones[ni][nj] > cur_st)) {
                        q.add(new int[]{ni, nj, di+1, cur_st}); 
                        dist[ni][nj] = di + 1;
                        stones[ni][nj] = cur_st;
                    }                   
                }
            }
        } 
        return -1;
    }
}