class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] time : times) {
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Pair(k, 0));
        
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.v;
            int time = curr.w;
            
            if(time > distance[node]) continue;
            
            for(Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.v;
                int nextTime = time + neighbor.w;
                
                if(nextTime < distance[nextNode]) {
                    distance[nextNode] = nextTime;
                    pq.offer(new Pair(nextNode, nextTime));
                }
            }
        }
        
        int maxTime = 0;
        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, distance[i]);
        }
        
        return maxTime;
    }
}

class Pair {
    int v, w;
    public Pair(int _v, int _w) {
        v = _v;
        w = _w;
    }
}