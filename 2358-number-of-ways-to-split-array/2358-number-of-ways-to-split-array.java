class Solution {
    public int waysToSplitArray(int[] nums) {
        long right = 0;
        for(int i : nums)
            right += i;
        
        long left = 0;
        int count = 0;
        for(int i=0;i<nums.length-1;i++) {
            left += nums[i];
            right -= nums[i];
            if(left >= right)
                count++;
        }

        return count;
    }
}