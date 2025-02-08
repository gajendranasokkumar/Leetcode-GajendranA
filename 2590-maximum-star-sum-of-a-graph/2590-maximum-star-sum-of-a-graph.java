class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = vals.length;
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            maxi = Math.max(maxi, findMax(i, adj, k, vals));
        return maxi != Integer.MIN_VALUE ? maxi : -1;
    }
    public int findMax(int from, List<List<Integer>> adj, int k, int[] vals) {
        int sum = vals[from];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int to : adj.get(from)) {
            if (vals[to] > 0) { 
                sum += vals[to];
                q.add(vals[to]);
                if (q.size() > k) {
                    sum -= q.poll(); 
                }
            }
        }
        return sum;
    }
}