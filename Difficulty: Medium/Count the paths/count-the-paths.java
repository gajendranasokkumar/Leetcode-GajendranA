class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
    
        for (int[] edge : edges) 
            graph.get(edge[0]).add(edge[1]);
    
        Integer[] dp = new Integer[V];
        return dfs(src, dest, graph, dp);
    }
    
    private int dfs(int node, int dest, List<List<Integer>> graph, Integer[] dp) {
        if (node == dest) return 1;
        if (dp[node] != null) return dp[node];
    
        int count = 0;
        for (int next : graph.get(node)) 
            count += dfs(next, dest, graph, dp);
    
        dp[node] = count;
        return count;
    }

}