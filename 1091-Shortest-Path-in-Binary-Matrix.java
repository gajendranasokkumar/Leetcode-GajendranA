class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) 
            return -1;

        int[][] dist = new int[rows][cols];

        for (int[] i : dist)
            Arrays.fill(i, Integer.MAX_VALUE);

        int[][] directions = {{1, 0}, {0, 1}, {1, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        pq.add(new int[]{1, 0, 0});
        dist[0][0] = 1;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int x = current[1];
            int y = current[2];

            if (x == rows - 1 && y == cols - 1) 
                return currentDist;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 0 && currentDist + 1 < dist[newX][newY]) {
                    dist[newX][newY] = currentDist + 1;
                    pq.add(new int[]{dist[newX][newY], newX, newY});
                }
            }
        }
        return -1;
    }
}
