class Solution {
    void dfs(ArrayList<Integer>[] adj,int[] ans,int i,int[] quiet){
        ans[i]=i;
        for(int k:adj[i]){
            if(ans[k]==-1){
                dfs(adj,ans,k,quiet);
            }
            if(quiet[ans[k]]<quiet[ans[i]]){
                ans[i]=ans[k];
            }
        }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
      
        int n=quiet.length;
        ArrayList<Integer>[] adj=new ArrayList[n];
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            ans[i]=-1;
        }
        for(int[] i :richer){
            adj[i[1]].add(i[0]);
        }
        for(int i=0;i<n;i++){
            if(ans[i]==-1){
                dfs(adj,ans,i,quiet);
            }
        }
        return ans;
    }
}