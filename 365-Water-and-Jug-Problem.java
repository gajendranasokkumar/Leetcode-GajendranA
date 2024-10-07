import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean check(int x, int y, int cur, int capacity, int target, Set<Integer> visited) {
        if (cur == target) 
            return true;
        if (cur < 0 || cur > capacity || visited.contains(cur))
            return false;
        
        visited.add(cur);  // Mark this state as visited
        
        // Try all possible moves
        return check(x, y, cur + x, capacity, target, visited) ||  // Fill jug x
               check(x, y, cur - x, capacity, target, visited) ||  // Empty jug x
               check(x, y, cur + y, capacity, target, visited) ||  // Fill jug y
               check(x, y, cur - y, capacity, target, visited);    // Empty jug y
    }

    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) 
            return false;  // Target is impossible to measure if it's larger than the total capacity
        Set<Integer> visited = new HashSet<>();
        return check(x, y, x, x + y, target, visited);
    }
}
