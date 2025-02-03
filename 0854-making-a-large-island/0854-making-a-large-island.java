class DisjointSet {
    int[] parent, size;
    
    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }
    
    boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;
        
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int n = row * col;
        int maxi = 0;
        DisjointSet dsu = new DisjointSet(n);
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int u = (i * col) + j;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (ni >= 0 && ni < row && nj >= 0 && nj < col && grid[ni][nj] == 1) {
                            dsu.union(u, (ni * col) + nj);
                        }
                    }
                    int pa = dsu.find(u);
                    maxi = Math.max(maxi, dsu.size[pa]);
                }
            }
        }
        
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    st.clear();
                    int total = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (ni >= 0 && ni < row && nj >= 0 && nj < col && grid[ni][nj] == 1) {
                            st.add(dsu.find((ni * col) + nj));
                        }
                    }
                    for (int it : st) {
                        total += dsu.size[it];
                    }
                    maxi = Math.max(maxi, total + 1);
                }
            }
        }
        return maxi;
    }
}