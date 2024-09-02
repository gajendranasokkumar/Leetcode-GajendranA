class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxLen=0, zeros=0;
        while(r < nums.length)
        {
            if(nums[r] == 0)
                zeros++;
            if(zeros > k){
                while(l <= r && nums[l] != 0)
                    l++;
                zeros--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}