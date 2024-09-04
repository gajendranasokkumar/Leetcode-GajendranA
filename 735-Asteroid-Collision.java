class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] result = new int[asteroids.length];
        int top = -1;
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                result[++top] = asteroid;
            } else {
                while (top >= 0 && result[top] > 0 && result[top] < Math.abs(asteroid)) {
                    top--; 
                }
                
                if (top == -1 || result[top] < 0) {
                    result[++top] = asteroid; 
                } else if (result[top] == Math.abs(asteroid)) {
                    top--; 
                }
            }
        }
        
        return Arrays.copyOf(result, top + 1);
    }
}
