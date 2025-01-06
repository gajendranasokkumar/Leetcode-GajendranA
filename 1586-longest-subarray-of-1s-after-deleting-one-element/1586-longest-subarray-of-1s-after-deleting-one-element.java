class Solution {
    public int longestSubarray(int[] nums) {
        int i, j;
        i = j = 0;
        int maxi = -1;
        int n = nums.length;
        boolean skip = false;
        while(j < n) {
            if(nums[j] == 0)
            {
                if(!skip)
                    skip = true;
                else {
                    while(i < j && nums[i] != 0) 
                        i++;
                    i++;
                } 
            }

            maxi = Math.max(maxi, j-i);
            j++;
        }
        return maxi;
    }
}