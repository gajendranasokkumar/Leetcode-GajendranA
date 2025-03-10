class Solution {
    int total = 0;
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        findArray(nums, 0);
        return total;
    }

    private void findArray(int[] nums, int start) {
        if (start > nums.length - 3) return;

        int diff = nums[start + 1] - nums[start];
        for (int end = start + 2; end < nums.length; end++) {
            if (nums[end] - nums[end - 1] == diff) {
                total++; 
            } else {
                break; 
            }
        }

        findArray(nums, start + 1); 
    }
}
