class Solution {
    List<Integer> cycleMember;
    int[] result; 
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indegree = new int[n];
        result = new int[n];
        Arrays.fill(result, -1);
        for(int i : edges) 
            if(i != -1)
                indegree[i]++;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
            if(indegree[i] == 0)
                q.add(i);
        boolean[] topovisited = new boolean[n];
        while(!q.isEmpty()) {
            int from = q.poll();
            topovisited[from] = true;
            int to = edges.get(from);
            if (--indegree[to] == 0) 
                q.add(to);
        }
        for(int i=0;i<n;i++) {
            if(!topovisited[i]) {
                cycleMember = new ArrayList<>();
                boolean[] visited = new boolean[n];
                int count = dfs(edges, visited, i);
                for(int mem : cycleMember) {
                    topovisited[mem] = true;
                    result[mem] = count;
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(result[i] == -1) {
                boolean[] visited = new boolean[n];
                result[i] = dfs(edges, visited, i);
            }
        }
        return result;
    }
    public int dfs(List<Integer> edges, boolean[] visited, int from) {
        if(result[from] != -1)
            return result[from];
        if(visited[from])
            return 0;
        int count = 0;
        visited[from] = true;
        cycleMember.add(from);
        count += 1 + dfs(edges, visited, edges.get(from));
        return result[from] = count;
    }
}