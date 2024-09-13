class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int[] dp = new int[len];
        int[] result = new int[queries.length];
        
        dp[0] = arr[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }

        for (int j = 0; j < queries.length; j++) {
            int left = queries[j][0];
            int right = queries[j][1];
            
            if (left == 0) {
                result[j] = dp[right]; 
            } else {
                result[j] = dp[right] ^ dp[left - 1];
            }
        }
        
        return result;
    }
}
