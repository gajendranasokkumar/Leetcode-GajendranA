class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int num : nums) {
            minVal = Math.min(minVal, num - k);
            maxVal = Math.max(maxVal, num + k);
        }

        int[] events = new int[maxVal - minVal + 2];

        for (int num : nums) {
            events[num - k - minVal]++;
            events[num + k - minVal + 1]--;
        }

        int maxBeauty = 0;
        int currentBeauty = 0;

        for (int delta : events) {
            currentBeauty += delta;
            maxBeauty = Math.max(maxBeauty, currentBeauty);
        }

        return maxBeauty;
    }
}
