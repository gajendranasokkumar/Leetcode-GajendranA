class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int k = i-1; k >= 0; k--) {
                if (nums[k] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[k]);
                }
            }
            dp[i]+=1;
        }

        int highest = 1;
        for (int len : dp) {
            if (len > highest) {
                highest = len;
            }
        }

        return highest;
    }
}