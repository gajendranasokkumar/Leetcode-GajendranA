class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int cnt = 1, temp = 1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1])
                temp++;
            else
                temp = 1;
            cnt = Math.max(cnt, temp);
        }
        temp = 1;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] < nums[i+1])
                temp++;
            else
                temp = 1;
            cnt = Math.max(cnt, temp);
        }
        return cnt;
    }
}