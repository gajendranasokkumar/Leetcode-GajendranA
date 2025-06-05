class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet ds = new DisjointSet(26);
        int n = s1.length();
        for(int i=0;i<n;i++) {
            int one = s1.charAt(i) - 'a';
            int two = s2.charAt(i) - 'a';
            ds.union(one, two);
        }
        String res = "";
        for(char c : baseStr.toCharArray()) {
            int num = ds.find(c - 'a');
            res += (char)(num + 'a');
        }

        return res;
    }
}

class DisjointSet{
    static int[] parent;
    static int[] size;
    
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        // Arrays.fill(size,1);
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = i;
        }
    }
    
    static int find(int v){
        if(parent[v]==v) return v;
        return parent[v] = find(parent[v]);
    }
    
    boolean union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return false;
        
        if(size[ul_u]>size[ul_v]){
            parent[ul_u]=ul_v;
            // size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            // size[ul_u]+=size[ul_v];
        }
        return true;
    }
}