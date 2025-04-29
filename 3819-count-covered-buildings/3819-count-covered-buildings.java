
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        Map<Integer,List<int[]>> rowMap = new HashMap<>();
        Map<Integer,List<int[]>> colMap = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            int r = buildings[i][0], c = buildings[i][1];
            rowMap.computeIfAbsent(r, k->new ArrayList<>()).add(new int[]{c, i});
            colMap.computeIfAbsent(c, k->new ArrayList<>()).add(new int[]{r, i});
        }
        
        boolean[] left  = new boolean[m];
        boolean[] right = new boolean[m];
        boolean[] up    = new boolean[m];
        boolean[] down  = new boolean[m];
        
        for(List<int[]> list : rowMap.values()){
            list.sort(Comparator.comparingInt(a->a[0])); 
            int sz = list.size();
            for(int j = 0; j < sz; j++){
                int idx = list.get(j)[1];
                if(j > 0)       left[idx]  = true;
                if(j < sz - 1)  right[idx] = true;
            }
        }
        
        for(List<int[]> list : colMap.values()){
            list.sort(Comparator.comparingInt(a->a[0])); 
            int sz = list.size();
            for(int j = 0; j < sz; j++){
                int idx = list.get(j)[1];
                if(j > 0)       up[idx]   = true;
                if(j < sz - 1)  down[idx] = true;
            }
        }
        
        int count = 0;
        for(int i = 0; i < m; i++){
            if(left[i] && right[i] && up[i] && down[i]) 
                count++;
        }
        return count;
    }
}
