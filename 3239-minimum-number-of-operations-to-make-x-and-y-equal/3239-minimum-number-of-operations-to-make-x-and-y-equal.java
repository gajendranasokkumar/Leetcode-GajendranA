class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(x);
        visited.add(x);
        int operations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                if (current == y) {
                    return operations;
                }
                
                if (current % 11 == 0) {
                    int next = current / 11;
                    if (!visited.contains(next) && next > 0) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                
                if (current % 5 == 0) {
                    int next = current / 5;
                    if (!visited.contains(next) && next > 0) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                
                if (!visited.contains(current - 1) && current - 1 > 0) {
                    queue.offer(current - 1);
                    visited.add(current - 1);
                }
                
                if (!visited.contains(current + 1) && current + 1 <= Math.max(x, y) * 2) {
                    queue.offer(current + 1);
                    visited.add(current + 1);
                }
            }
            operations++;
        }
        
        return -1; 
    }
}