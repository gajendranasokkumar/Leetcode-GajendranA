class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sortedString = new StringBuilder();
        
        while (!frequencyMap.isEmpty()) {
            int maxFrequency = Integer.MIN_VALUE;
            char maxChar = '\\0'; 
            
            for (Map.Entry<Character, Integer> e : frequencyMap.entrySet()) {
                if (e.getValue() > maxFrequency) {
                    maxFrequency = e.getValue();
                    maxChar = e.getKey();
                }
            }
            
            for (int i = 0; i < maxFrequency; i++) {
                sortedString.append(maxChar);
            }
            
            frequencyMap.remove(maxChar);
        }
        
        return sortedString.toString();
    }
}