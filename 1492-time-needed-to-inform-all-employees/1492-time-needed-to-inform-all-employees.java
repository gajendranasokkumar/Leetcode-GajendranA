class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        int res= 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, manager, informTime, memo));
        }
        return res;
    }
    private int dfs(int node, int[] manager,int[] times, int[] memo) {
        if(node == -1) {
            return 0;
        }
        if(memo[node] != -1) {
            return memo[node];
        }
        return memo[node] = times[node] + dfs(manager[node], manager, times, memo);
    }
}