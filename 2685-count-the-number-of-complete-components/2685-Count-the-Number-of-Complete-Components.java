class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> components = new ArrayList<>();
        DisjointSet ds = new DisjointSet(n);
        int[] ed = new int[n];
        for(int[] edge : edges) {
            ed[edge[0]]++;
            ed[edge[1]]++;
            ds.union(edge[0], edge[1]);
        } 
        for(int i=0;i<n;i++)
            components.add(new ArrayList<>());
        for(int i=0;i<n;i++)
            components.get(ds.parent[i]).add(i);
        int count = 0;
        for(List<Integer> component : components) {
            if(component.size() == 0)   
                continue;
            int cnt = component.size() - 1;
            for(int i : component)
                if(ed[i] != cnt) {
                    cnt = -1;
                    break;
                }
            if(cnt != -1)
                count++;
        }
        return count;
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