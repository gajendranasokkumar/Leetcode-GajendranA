class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); 
        pq.add(new int[]{0, 0});
        int mstCost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n) {
            int[] curr = pq.poll();
            int u = curr[0], weight = curr[1];

            if (visited[u]) 
                continue; 
            visited[u] = true; 
            mstCost += weight;
            edgesUsed++;

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{v, dist});
                }
            }
        }
        return mstCost;
    }
}