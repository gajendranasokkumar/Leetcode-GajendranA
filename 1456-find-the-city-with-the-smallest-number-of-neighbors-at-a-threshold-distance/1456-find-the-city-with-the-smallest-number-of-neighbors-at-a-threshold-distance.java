class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        
        int minCount = Integer.MAX_VALUE;
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            int count = dijkstra(adj, i, distanceThreshold, n);
            if (count <= minCount) {
                minCount = count;
                result = i;
            }
        }
        
        return result;
    }
    
    private int dijkstra(List<List<int[]>> adj, int start, int threshold, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        int count = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int from = current[0];
            int d = current[1];
            
            if (d > threshold) continue;
            
            for (int[] neighbor : adj.get(from)) {
                int to = neighbor[0], w = neighbor[1];
                if (dist[to] > d + w) {
                    dist[to] = d + w;
                    pq.offer(new int[]{to, dist[to]});
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != start && dist[i] <= threshold) {
                count++;
            }
        }
        
        return count;
    }
}
