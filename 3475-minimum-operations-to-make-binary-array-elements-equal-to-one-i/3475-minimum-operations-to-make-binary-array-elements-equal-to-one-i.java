class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == 1) {
                continue;
            } else {
                cnt++; 
            }

            for (int j = i; j < i + 3; j++) {
                nums[j] = nums[j] == 1 ? 0 : 1;
            }
        }

        for (int i : nums) {
            if (i == 0) return -1; 
        }

        return cnt;
    }
}