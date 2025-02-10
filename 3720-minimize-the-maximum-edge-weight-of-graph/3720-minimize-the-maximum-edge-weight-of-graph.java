class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++)
            map.put(i, new ArrayList<>());
        int[] outdegree = new int[n];
        for(int[] edge : edges) {
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
            outdegree[edge[0]]++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        while(!q.isEmpty()) {
            int from = q.poll();
            if(visited[from])
                continue;
            visited[from] = true;
            for(int[] to : map.get(from))
                q.add(to[0]);
        }
        for(boolean isVisited : visited)
            if(!isVisited)
                return -1;
        visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{0,0});
        int min = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            if(visited[a[0]]) continue;
            visited[a[0]]=true;
            min = Math.max(min, a[1]);
            for(int[] e : map.get(a[0])){
                if(!visited[e[0]]){
                    pq.offer(new int[]{e[0],e[1]});
                }
            }
        }
        return min;
    }
}