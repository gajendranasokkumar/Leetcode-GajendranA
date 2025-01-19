class Solution {
    int rows, cols;
    boolean[][] visited;
    int totalWater;

    public int trapRainWater(int[][] heightMap) {
        rows = heightMap.length;
        cols = heightMap[0].length;
        totalWater = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], height = cell[2];

            for (int k = 0; k < 4; k++) {
                int newX = x + dirX[k];
                int newY = y + dirY[k];

                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || visited[newX][newY]) {
                    continue;
                }

                totalWater += Math.max(0, height - heightMap[newX][newY]);

                pq.offer(new int[]{newX, newY, Math.max(height, heightMap[newX][newY])});
                visited[newX][newY] = true;
            }
        }

        return totalWater;
    }
}
