class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegree = new int[n + 1];
        Arrays.fill(inDegree, -1);
        
        int bl1 = -1, bl2 = -1;
        
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            if (inDegree[v] == -1) {
                inDegree[v] = i;
            } else {
                bl1 = i;
                bl2 = inDegree[v];
                break;
            }
        }
        
        DisjointSet ds = new DisjointSet(n + 1);
        
        for (int i = 0; i < n; i++) {
            if (i == bl1) continue;
            
            int[] edge = edges[i];
            if (!ds.union(edge[0], edge[1])) {
                return bl1 == -1 ? edge : edges[bl2];
            }
        }
        
        return edges[bl1];
    }
}

class DisjointSet {
    static int[] parent;
    static int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    static int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    boolean union(int u, int v) {
        int ul_u = find(u);
        int ul_v = find(v);
        if (ul_u == ul_v) return false;

        if (size[ul_u] < size[ul_v]) {
            parent[ul_u] = ul_v;
            size[ul_v] += size[ul_u];
        } else {
            parent[ul_v] = ul_u;
            size[ul_u] += size[ul_v];
        }
        return true;
    }
}