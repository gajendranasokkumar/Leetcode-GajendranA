class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        for(int i : restricted)
            set.add(i);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        dfs(adj, 0, set, visited);
        int count = 0;
        for(boolean i : visited)
            if(i) count++;
        return count;
    }
    public void dfs(List<List<Integer>> adj, int src, Set<Integer> set, boolean[] visited) {
        if(visited[src])
            return;
        visited[src] = true;
        for(int i : adj.get(src))
            if(!set.contains(i))
                dfs(adj, i, set, visited);
    }
}