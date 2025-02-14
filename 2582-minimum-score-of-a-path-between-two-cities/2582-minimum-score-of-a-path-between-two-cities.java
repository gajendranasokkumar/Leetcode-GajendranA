class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int road[] :roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(new int[]{v, dist});
            map.get(v).add(new int[]{u, dist});
        }
        int[] arr = new int[]{ Integer.MAX_VALUE };
        boolean[] visited = new boolean[n+1];
        dfs(map, 1, arr, visited);
        return arr[0];
    }
    public void dfs(Map<Integer, List<int[]>> map, int from, int[] min, boolean[] visited) {
        if(visited[from])
            return;
        visited[from] = true;
        for(int[] to : map.get(from)) {
            min[0] = Math.min(min[0], to[1]);
            dfs(map, to[0], min, visited);
        }
    }
}