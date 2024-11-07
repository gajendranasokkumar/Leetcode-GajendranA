class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, ArrayList<Pair>> adj = new HashMap<>();
        
        for(int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dst = equations.get(i).get(1);
            double value = values[i];
            
            adj.putIfAbsent(src, new ArrayList<>());
            adj.putIfAbsent(dst, new ArrayList<>());
            
            adj.get(src).add(new Pair(dst, value));
            adj.get(dst).add(new Pair(src, 1.0 / value));
        }
        
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if(!adj.containsKey(start) || !adj.containsKey(end)) {
                result[i] = -1.0;
                continue;
            }
            
            if(start.equals(end)) {
                result[i] = 1.0;
                continue;
            }
            
            result[i] = dfs(start, end, adj, new HashSet<>(), 1.0);
        }
        
        return result;
    }
    
    private double dfs(String node, String target, Map<String, ArrayList<Pair>> adj, Set<String> visited, double product) {

        if(visited.contains(node)) 
            return -1.0;
        
        if(node.equals(target)) 
            return product;
        
        visited.add(node);
        
        for(Pair neighbor : adj.get(node)) {
            double result = dfs(neighbor.v, target, adj, visited, product * neighbor.dist);
            if(result != -1.0) 
                return result;
        }
        
        visited.remove(node);
        return -1.0;
    }
}

class Pair {
    String v;
    double dist;
    public Pair(String _v, double _dist) {
        v = _v;
        dist = _dist;
    }
    
    public String toString() {
        return \(\ + v + \, \ + dist + \)\;
    }
}