class Solution {
    private int maxCycle;
    
    public int longestCycle(int[] edges) {
        int n = edges.length;
        maxCycle = -1;
        int[] visited = new int[n];
        boolean[] inPath = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(edges, i, 1, visited, inPath);
            }
        }
        
        return maxCycle;
    }
    
    private void dfs(int[] edges, int curr, int time, int[] visited, boolean[] inPath) {
        if (curr == -1) {
            return;
        }
        
        if (inPath[curr]) {
            maxCycle = Math.max(maxCycle, time - visited[curr]);
            return;
        }
        
        if (visited[curr] > 0) {
            return;
        }
        
        visited[curr] = time;
        inPath[curr] = true;
        
        dfs(edges, edges[curr], time + 1, visited, inPath);
        inPath[curr] = false;
    }
}