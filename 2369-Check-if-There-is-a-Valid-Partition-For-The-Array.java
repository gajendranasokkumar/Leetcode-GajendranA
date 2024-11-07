class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length]; 
        return partition(nums, 0, dp);
    }

    public boolean partition(int[] nums, int i, Boolean[] dp) {
        if (i == nums.length)
            return true;
        
        if (dp[i] != null) 
            return dp[i];
        
        if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            if (partition(nums, i + 2, dp)) 
                return dp[i] = true;
        }

        if (i + 2 < nums.length && ((nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) || 
                                    (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]))) {
            if (partition(nums, i + 3, dp)) 
                return dp[i] = true;
        }

        return dp[i] = false;
    }
}
