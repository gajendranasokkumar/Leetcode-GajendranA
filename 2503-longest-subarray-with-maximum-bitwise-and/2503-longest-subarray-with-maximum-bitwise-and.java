class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        for (int num : nums) {
            if (num == max) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0; 
            }
        }

        return maxLength;
    }
}
