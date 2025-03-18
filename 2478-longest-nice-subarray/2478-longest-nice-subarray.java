class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, max = 0;
        int bitMask = 0;

        while (right < n) {
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left];
                left++;
            }

            bitMask |= nums[right];
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}
