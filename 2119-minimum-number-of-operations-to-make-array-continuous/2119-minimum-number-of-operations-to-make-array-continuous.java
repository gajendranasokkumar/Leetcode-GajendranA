class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int uniqueCount = 0;
        
        int[] uniqueNums = new int[n];
        uniqueNums[uniqueCount++] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                uniqueNums[uniqueCount++] = nums[i];
            }
        }

        int maxContiguous = 0, left = 0;
        
        for (int right = 0; right < uniqueCount; right++) {
            while (uniqueNums[right] - uniqueNums[left] >= n) {
                left++;
            }
            maxContiguous = Math.max(maxContiguous, right - left + 1);
        }
        
        return n - maxContiguous;
    }
}