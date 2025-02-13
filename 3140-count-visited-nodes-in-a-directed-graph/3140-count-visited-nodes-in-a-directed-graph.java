import java.util.*;

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] notCycle = new int[n]; 
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            indegree[edges.get(i)]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            notCycle[node] = 1;
            int next = edges.get(node);
            if (--indegree[next] == 0) {
                q.add(next);
            }
        }

        for (int i = 0; i < n; i++) {
            if (notCycle[i] == 0 && !visited[i]) {
                int[] cnt = new int[1]; 
                dfs(i, dist, edges, visited, cnt);
            }
        }

        for (int i = 0; i < n; i++) {
            if (notCycle[i] == 1 && !visited[i]) {
                dfs2(i, dist, edges, visited);
            }
        }

        return dist;
    }

    private void dfs(int node, int[] dist, List<Integer> edges, boolean[] visited, int[] cnt) {
        if (visited[node]) return;
        visited[node] = true;
        cnt[0]++;
        dfs(edges.get(node), dist, edges, visited, cnt);
        dist[node] = cnt[0];
    }

    private int dfs2(int node, int[] dist, List<Integer> edges, boolean[] visited) {
        if (visited[node]) return dist[node];
        visited[node] = true;
        return dist[node] = dfs2(edges.get(node), dist, edges, visited) + 1;
    }
}
