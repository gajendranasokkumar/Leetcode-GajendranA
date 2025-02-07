class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());
        for(int i=0;i<n;i++) 
            if(manager[i] != -1)
                adj.get(manager[i]).add(i);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ headID, 0 });
        int result = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cur = q.poll();
                int from = cur[0];
                int time = cur[1];
                result = Math.max(time, result);
                for(int to : adj.get(from)) 
                    q.add(new int[]{ to, time + informTime[from] });
            }
        }
        return result;
    }
}