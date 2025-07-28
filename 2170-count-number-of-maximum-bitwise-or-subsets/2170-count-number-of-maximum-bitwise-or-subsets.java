class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        
        int len = nums.length;
        int max=0;
        for(int i: nums)
            max = max | i;

        return check(nums, 0, max, 0);
    }

    public int check(int[] nums, int index, int max,  int current) {
        if (index == nums.length) {
            return current == max ? 1 : 0;
        } 
        
        int include = check(nums, index+1, max,current | nums[index]);
        int exclude = check(nums, index+1, max, current);

        return include + exclude;
    }
}