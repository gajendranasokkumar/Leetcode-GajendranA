class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int l=0,r=nums.length-1, count=0;
        while(l < r) {
            if(nums[l] + nums[r] == k) {
                count++;
                l++;
                r--;
            } else if(nums[l] + nums[r] <= k)
                l++;
            else
                r--;
        }

        return count;
    }
}