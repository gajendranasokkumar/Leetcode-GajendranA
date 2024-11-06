class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length-1;) {
            if(nums[i] > nums[i+1]) {
                if(Integer.bitCount(nums[i]) == Integer.bitCount(nums[i+1])) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;

                    if(i > 0)
                        i--;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }
}