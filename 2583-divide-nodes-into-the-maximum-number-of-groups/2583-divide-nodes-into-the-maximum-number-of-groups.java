class Solution {
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        List<List<Integer>> components = new ArrayList<>();
        boolean[] componentVisited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (!componentVisited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, componentVisited, component, graph);
                components.add(component);
            }
        }
        
        int total = 0;
        for (List<Integer> component : components) {
            int maxGroups = -1;
            for (int start : component) {
                int groups = bfs(start, graph, n);
                maxGroups = Math.max(maxGroups, groups);
            }
            if (maxGroups == -1) return -1;
            total += maxGroups;
        }
        
        return total;
    }
    
    private void dfs(int node, boolean[] visited, List<Integer> component, Map<Integer, List<Integer>> graph) {
        visited[node] = true;
        component.add(node);
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, visited, component, graph);
            }
        }
    }
    
    private int bfs(int start, Map<Integer, List<Integer>> graph, int n) {
        int[] groups = new int[n + 1];
        Arrays.fill(groups, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        groups[start] = 1;
        int maxGroup = 1;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (groups[next] == -1) {
                    groups[next] = groups[curr] + 1;
                    maxGroup = Math.max(maxGroup, groups[next]);
                    queue.offer(next);
                } else if (Math.abs(groups[next] - groups[curr]) != 1) {
                    return -1;
                }
            }
        }
        
        return maxGroup;
    }
}