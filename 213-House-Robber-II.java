class Solution {
    public int maxrob(int[] nums){
        int prev1 = 0, prev2=0;
        for(int num: nums){
            int temp = prev1;
            prev1 = Math.max(prev2+num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        int[] copy1 = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] copy2 = Arrays.copyOfRange(nums, 1, nums.length);
        int max = Math.max(maxrob(copy1), maxrob(copy2));
        return max;
    }
}