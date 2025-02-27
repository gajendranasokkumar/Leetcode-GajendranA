class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maximum(arr, 0, k, dp);
    }
    public int maximum(int[] arr, int idx, int k, int[] dp) {
        if (idx >= arr.length)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int maxi = 0, sofar = 0, maxElement = 0;
        for (int i = idx; i < Math.min(k + idx, arr.length); i++) {
            maxElement = Math.max(maxElement, arr[i]);
            sofar = (maxElement * (i - idx + 1)) + maximum(arr, i + 1, k, dp);
            maxi = Math.max(maxi, sofar);
        }
        return dp[idx] = maxi;
    }
}
