class Solution {
    public long minimumSteps(String s) {
        int len = s.length();
        int countWhite = 0; 
        long swaps = 0; 
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                countWhite++;
            } else {
                swaps += countWhite;
            }
        }
        return swaps;
    }
}
