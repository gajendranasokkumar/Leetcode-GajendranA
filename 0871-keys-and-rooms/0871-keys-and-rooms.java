class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(rooms, 0, visited);
        for(boolean  i : visited)
            if(!i)
                return i;
        return true;
    }
    public static void dfs(List<List<Integer>> rooms, int from, boolean[] visited) {
        visited[from] = true; 
        for(int to : rooms.get(from)) {
            if(!visited[to])
                dfs(rooms, to, visited);
        }
    }
}