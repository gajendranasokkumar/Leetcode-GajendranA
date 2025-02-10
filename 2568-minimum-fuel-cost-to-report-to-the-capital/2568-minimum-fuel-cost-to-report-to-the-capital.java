class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        if (map.isEmpty()) 
            return 0;

        // Start DFS from the capital (0)
        return dfs(map, 0, -1, seats)[2]; 
    }

    public long[] dfs(Map<Integer, List<Integer>> map, int node, int parent, int seats) {
        long persons = 1; 
        long fuel = 0;
        long k_sets = 0;
        
        for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
            if (neighbor == parent) continue; 
            
            long[] res = dfs(map, neighbor, node, seats);
            persons += res[0];   
            k_sets += res[1];  
            fuel += res[2];   
        }
        
        if (node != 0) {
            long trips = (persons + seats - 1) / seats;  // Ceil(persons/seats)
            fuel += trips; 
        }

        return new long[]{persons, k_sets, fuel};
    }
}
