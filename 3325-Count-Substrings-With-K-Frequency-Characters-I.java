import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int start = 0; start < n; start++) {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            for (int end = start; end < n; end++) {
                char currentChar = s.charAt(end);
                freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
                
                if (freqMap.get(currentChar) >= k) {
                    result += (n - end);  
                    break; 
                }
            }
        }

        return result;
    }
}
