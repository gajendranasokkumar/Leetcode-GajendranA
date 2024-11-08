class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;

        int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0, 1});

        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int effort = current[0];
            int x = current[1];
            int y = current[2];
            int addtime = current[3];

            if (x == rows - 1 && y == cols - 1) {
                return effort;
            }

            for (int[] onedir : dir) {
                int newX = x + onedir[0];
                int newY = y + onedir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int waitTime = Math.max(moveTime[newX][newY] - effort, 0);
                    int newEffort = effort + addtime + waitTime;

                    if (newEffort < dist[newX][newY]) {
                        dist[newX][newY] = newEffort;
                        int val = addtime == 1 ? 2 : 1;
                        pq.add(new int[] { newEffort, newX, newY, val });
                    }
                }
            }
        }

        return -1;
    }
}
