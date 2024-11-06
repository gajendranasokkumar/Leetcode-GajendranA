class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums.length-1;j++) {
                int fc = Integer.bitCount(nums[j]);
                int sc = Integer.bitCount(nums[j+1]);
                if(nums[j] > nums[j+1] && fc == sc) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1])
                return false;
        }


        return true;
    }
}