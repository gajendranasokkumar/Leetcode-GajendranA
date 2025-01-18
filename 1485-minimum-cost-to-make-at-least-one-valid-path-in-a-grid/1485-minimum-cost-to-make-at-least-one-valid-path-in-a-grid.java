class Solution {
    int[] dx = {0, 0, 1, -1}; // right, left, down, up
    int[] dy = {1, -1, 0, 0}; // right, left, down, up
    
    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Min cost to reach each cell
        int[][] cost = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        
        // PriorityQueue to always process min cost cells first
        // {cost, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        cost[0][0] = 0;
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int x = curr[1];
            int y = curr[2];
            
            // If we've found a better path already
            if(currCost > cost[x][y]) continue;
            
            // Try all 4 directions
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    // Calculate new cost: 0 if arrow points in our direction, 1 otherwise
                    int newCost = currCost + (grid[x][y] == i + 1 ? 0 : 1);
                    
                    if(newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }
        }
        
        return cost[rows-1][cols-1];
    }
}