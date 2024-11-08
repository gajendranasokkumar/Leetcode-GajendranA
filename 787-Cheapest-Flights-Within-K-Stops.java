class Pair {
    int node, dist;
    public Pair(int _node, int _dist) {
        node = _node;
        dist = _dist;
    }
}

class Three {
    int stops, node, dist;
    public Three(int _stops, int _node, int _dist) {
        stops = _stops;
        node = _node;
        dist = _dist;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());
        
        for(int i=0;i<flights.length;i++)
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        
        int[] distance = new int[n];
        for(int i=0;i<n;i++)
            distance[i] = (int)(1e9);

        Queue<Three> q = new LinkedList<>();
        q.add(new Three(0, src, 0));

        while(!q.isEmpty()) {
            Three peek = q.poll();
            int curstops = peek.stops;
            int curnode = peek.node;
            int curdist = peek.dist;

            for(Pair neighbour : adj.get(curnode)) {
                if(curdist + neighbour.dist < distance[neighbour.node] && curstops <= k) {
                    distance[neighbour.node] = curdist + neighbour.dist;
                    q.add(new Three(curstops+1, neighbour.node, distance[neighbour.node]));
                }
            }
        }


        return distance[dst] == (int)(1e9) ? -1 : distance[dst];
    }
}