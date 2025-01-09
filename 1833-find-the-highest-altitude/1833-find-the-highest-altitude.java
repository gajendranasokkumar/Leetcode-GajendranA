class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int maxAltitude = 0, sum = 0;

        for(int i = 0; i < n; i++){
             sum += gain[i];  // Add the current gain to sum
            maxAltitude = Math.max(maxAltitude, sum);  // Update max altitude if needed
        }
        return maxAltitude;
    }
}