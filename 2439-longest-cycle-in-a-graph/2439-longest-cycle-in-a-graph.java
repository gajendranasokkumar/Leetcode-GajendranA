class Solution {
    private int maxCycle;
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        maxCycle = -1;
        boolean[] visited = new boolean[n];
        boolean[] inCurrentPath = new boolean[n];
        int[] pathLength = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(edges, i, 0, visited, inCurrentPath, pathLength);
            }
        }
        
        return maxCycle;
    }
    
    private void dfs(int[] edges, int curr, int length, boolean[] visited, boolean[] inCurrentPath, int[] pathLength) {
        if (curr == -1) {
            return;
        }
        
        if (inCurrentPath[curr]) {
            maxCycle = Math.max(maxCycle, length - pathLength[curr]);
            return;
        }
        
        if (visited[curr]) {
            return;
        }
        
        visited[curr] = true;
        inCurrentPath[curr] = true;
        pathLength[curr] = length;
        
        dfs(edges, edges[curr], length + 1, visited, inCurrentPath, pathLength);
        inCurrentPath[curr] = false;
    }
}