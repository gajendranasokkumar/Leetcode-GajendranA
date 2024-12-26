class Solution {
    public int helper(int[] nums, int target, int sum, int idx) {
        if (idx == nums.length)
            return sum == target ? 1 : 0;

        int pick = helper(nums, target, sum + nums[idx], idx + 1);
        int notpick = helper(nums, target, sum - nums[idx], idx + 1);
        
        return pick + notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
}