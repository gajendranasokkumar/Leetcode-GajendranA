class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows*cols);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<rows;i++) {
            int row = 1000 + i;
            for(int j=0;j<cols;j++) {
                int col = 500 + j;
                if(grid[i][j] == 1) {
                    if(map.containsKey(row)) {
                        int last = map.get(row).get(map.get(row).size()-1);
                        ds.union(last, (i*cols+j));
                    } 
                    if(map.containsKey(col)) {
                        int last = map.get(col).get(map.get(col).size()-1);
                        ds.union(last, (i*cols+j));
                    }
                    map.putIfAbsent(1000+i, new ArrayList<>());
                    map.putIfAbsent(500+j, new ArrayList<>());
                    map.get(1000+i).add(i*cols+j);
                    map.get(500+j).add(i*cols+j);
                }
            }
        }

        // System.out.println(Arrays.toString(ds.parent));
        int[] serverCount = new int[rows * cols];
        int totalCommunicatingServers = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int root = ds.find(i * cols + j);
                    serverCount[root]++;
                }
            }
        }

        for (int count : serverCount) {
            if (count > 1) {
                totalCommunicatingServers += count;
            }
        }

        return totalCommunicatingServers;
    }
}
class DisjointSet{
    static int[] parent;
    static int[] size;
    
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    
    static int find(int v){
        if(parent[v]==v) return v;
        return parent[v] = find(parent[v]);
    }
    
    boolean union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return false;
        
        if(size[ul_u]<size[ul_v]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
        return true;
    }
}


// class Solution {
//     public int countServers(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         int[] rowCount = new int[m];
//         int[] colCount = new int[n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 1) {
//                     rowCount[i]++;
//                     colCount[j]++;
//                 }
//             }
//         }
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }