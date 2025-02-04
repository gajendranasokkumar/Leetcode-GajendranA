class Solution {
    public int maxAscendingSum(int[] nums) {
        int i = 1, n = nums.length;
        int maxi = 0;
        int cur = nums[0];
        while(i < n) {
                maxi = Math.max(maxi, cur);
            if(nums[i-1] < nums[i])
            {
                cur += nums[i];
            } else {
                cur = nums[i];
            }
            i++;
        }
                maxi = Math.max(maxi, cur);
        return maxi;
    }
}