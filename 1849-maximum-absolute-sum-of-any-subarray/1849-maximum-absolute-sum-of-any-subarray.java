class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxi = 0;
        int mini = Integer.MAX_VALUE;
        int n = nums.length;
        int res1, res2;
        maxi = mini = res1 = res2 = nums[0];
        for(int i=1;i<n;i++) {
            maxi = Math.max(maxi + nums[i], nums[i]);
            res1 = Math.max(maxi, res1);
            mini = Math.min(mini + nums[i], nums[i]);
            res2 = Math.min(mini, res2);
        }
        return Math.max(Math.abs(res1), Math.abs(res2));
    }
}