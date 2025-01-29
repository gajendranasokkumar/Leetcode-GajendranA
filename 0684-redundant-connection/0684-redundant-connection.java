class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int v = edges.length;
        DisjointSet ds = new DisjointSet(v+1);
        int[] result = new int[2];
        for(int[] a : edges){
            if(!ds.union(a[0],a[1])){
                result = a;
            }
        }
        return result;
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