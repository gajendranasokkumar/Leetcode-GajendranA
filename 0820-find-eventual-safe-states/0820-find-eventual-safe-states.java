class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int len = graph.length;
        for(int i=0;i<len;i++) {
            for(int j=0;j<graph[i].length;j++) {
                adj.putIfAbsent(graph[i][j], new ArrayList<Integer>());
                adj.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int[] indegree = new int[len];
        for(int i=0;i<len;i++) {
            if(adj.containsKey(i))
                for(int j: adj.get(i))
                    indegree[j]++;
        }

        for(int i=0;i<len;i++) 
            if(indegree[i] == 0)
                q.add(i);


        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            if(adj.containsKey(node))
                for (int neighbor : adj.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        q.offer(neighbor);
                    }
                }
        }

        Collections.sort(result);
        
        return result;
    }
}