class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        pq.add(new int[] {0, 0, grid[0][0]});
        grid[0][0] = -1;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int max = curr[2];

            for(int x = 0; x < 4; x++) {
                int i = r + dx[x];
                int j = c + dy[x];

                if(i == -1 || j == -1 || i == n || j == n || grid[i][j] == -1) continue;
                int val = grid[i][j];
                int maxi = Math.max(max, val);
                grid[i][j] = -1;

                if(i == n - 1 && j == n - 1) return maxi;
                pq.add(new int[] {i, j, maxi});
            }
        }
        return 0;
    }
}