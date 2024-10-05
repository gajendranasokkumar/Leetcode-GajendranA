class Solution {
    public boolean run(int[] nums, int target, int i, int[][] dp) {
        if(target == 0) 
            return true;
        if(i < 0 || target < 0)
            return false;
        if(dp[i][target] != -1)
            return dp[i][target] == 1;
        boolean pick = run(nums, target-nums[i], i-1, dp);
        boolean notpick = run(nums, target, i-1, dp);
        dp[i][target] = (pick || notpick) ? 1 : 0;
        return dp[i][target] == 1;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i: nums)
            sum += i;
        if(sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[][] dp = new int[nums.length][target+1];
        for(int[] i: dp)
            Arrays.fill(i, -1);
        return run(nums, target, nums.length-1, dp);
    }
}