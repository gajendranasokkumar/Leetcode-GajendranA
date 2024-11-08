class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int max = (int)Math.pow(2, maximumBit)-1;
        int xor = 0;
        for(int i=0;i<n;i++) {
            xor ^= nums[i];
            result[n - i - 1] = max ^ xor;
        }

        return result;
    }
}