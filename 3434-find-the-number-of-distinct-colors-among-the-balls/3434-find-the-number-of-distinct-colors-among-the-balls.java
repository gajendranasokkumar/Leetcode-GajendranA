class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        int l = 0;

        Map<Integer, Integer> colors = new HashMap<>();  
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int[] query : queries) {
            int index = query[0], newColor = query[1];
            int oldColor = colors.getOrDefault(index, 0);

            if (oldColor != newColor) {
                if (oldColor != 0) {
                    freqMap.put(oldColor, freqMap.get(oldColor) - 1);
                    if (freqMap.get(oldColor) == 0) freqMap.remove(oldColor);
                }

                colors.put(index, newColor);
                freqMap.put(newColor, freqMap.getOrDefault(newColor, 0) + 1);
            }
            
            result[l++] = freqMap.size();
        }
        return result;
    }
}
