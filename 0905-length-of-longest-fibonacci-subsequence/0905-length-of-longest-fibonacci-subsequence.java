import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        int[][] dp = new int[n][n];
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int prev = arr[i] - arr[j];
                if (prev < arr[j] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    dp[j][i] = dp[k][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][i] + 2);
                } else {
                    dp[j][i] = 0;
                }
            }
        }
        
        return maxLen >= 3 ? maxLen : 0;
    }
}
