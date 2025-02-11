class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer>[] rowmap = new ArrayList[k+1];
        ArrayList<Integer>[] colmap = new ArrayList[k+1];
        int[] rowdegree = new int[k+1];
        int[] coldegree = new int[k+1];
        for(int i=0;i<=k;i++) {
            rowmap[i] = new ArrayList<>();
            colmap[i] = new ArrayList<>();
        }
        for(int[] row : rowConditions) {
            rowmap[row[0]].add(row[1]);
            rowdegree[row[1]]++;
        }
        for(int[] col : colConditions) {
            colmap[col[0]].add(col[1]);
            coldegree[col[1]]++;
        }
        int[] roworder = toposort(rowmap, rowdegree, k+1);
        int[] colorder = toposort(colmap, coldegree, k+1);
        // System.out.println("row " + Arrays.toString(roworder));
        // System.out.println("col " + Arrays.toString(colorder));
        if(colorder[0] == Integer.MAX_VALUE || roworder[0] == Integer.MAX_VALUE)
            return new int[0][0];
        Map<Integer, Pair> index = new HashMap<>();
        int[][] matrix = new int[k][k];
        for(int i=0;i<k;i++) {
            matrix[0][i] = colorder[i];
            index.put(colorder[i], new Pair(0, i));
        }
        // for(int[] i : matrix)
        //     System.out.println(Arrays.toString(i));
        for(int i=1;i<k;i++) {
            Pair prev = index.get(roworder[i-1]);
            Pair cur = index.get(roworder[i]);
            matrix[cur.i][cur.j] = 0;
            int u = prev.i + 1;
            int v = cur.j;
            index.put(roworder[i], new Pair(u, v));
            matrix[u][v] = roworder[i];
        }
        // for(int[] i : matrix)
        //     System.out.println(Arrays.toString(i));
        return matrix;
    }
    public int[] toposort(ArrayList<Integer>[] map, int[] degree, int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<n;i++) {
            if(degree[i] == 0)
                q.add(i);
        }
        int[] order = new int[n-1];
        int idx = 0, size = n-1;
        while(!q.isEmpty()) {
            int from = q.poll();
            order[idx++] = from;
            size--;
            for(int to : map[from]) {
                if(--degree[to] == 0)
                    q.add(to);
            }
        }
        if(size != 0)
            return new int[]{Integer.MAX_VALUE};
        return order;
    }
}
class Pair {
    int i, j;
    Pair(int _i, int _j) {
        i = _i;
        j = _j;
    }
    public String toString() {
        return "["+i+","+j+"]";
    }
}