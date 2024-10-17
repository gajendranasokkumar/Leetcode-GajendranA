class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> lis = new ArrayList<List<Integer>>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> p = new ArrayList<Integer>();
            for (int j = 0; j < graph[i].length; j++) {
                p.add(graph[i][j]);
            }
            lis.add(p);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            boolean visited[] = new boolean[n];
            boolean pathvisited[] = new boolean[n];
            if (!backtrack(i, visited, pathvisited, lis)) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }

    boolean backtrack(int node, boolean[] visited, boolean[] pathvisited, List<List<Integer>> lis) {
        visited[node] = true;
        pathvisited[node] = true;
        List<Integer> l = lis.get(node);
        for (int i : l) {
            if (!visited[i]) {
                if (backtrack(i, visited, pathvisited, lis)) {
                    return true;
                }
            } else if (pathvisited[i])
                return true;
        }
        pathvisited[node] = false;
        return false;
    }
}