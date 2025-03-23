class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int) (1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Pair>());
            
        for (int[] i : roads) {
            adj.get(i[0]).add(new Pair(i[1], i[2]));
            adj.get(i[1]).add(new Pair(i[0], i[2]));
        }
        
        long[] distance = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        q.add(new Pair(0, 0));
        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int curnode = p.v;
            long curdist = p.dist;
            
            for (Pair one : adj.get(curnode)) {
                long newDist = curdist + one.dist;
                
                if (newDist < distance[one.v]) {
                    distance[one.v] = newDist;
                    ways[one.v] = ways[curnode];
                    q.add(new Pair(one.v, newDist));
                } else if (newDist == distance[one.v]) {
                    ways[one.v] = (ways[one.v] + ways[curnode]) % MOD;
                }
            }
        }
        
        return (int) ways[n-1];
    }
}

class Pair {
    int v;
    long dist;
    
    public Pair(int _v, long _dist) { 
        v = _v;
        dist = _dist;
    }
}