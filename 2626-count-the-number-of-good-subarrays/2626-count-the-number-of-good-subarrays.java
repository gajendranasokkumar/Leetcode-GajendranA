class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int l = 0;
        long total = 0;
        long pairs = 0;

        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int freq = map.getOrDefault(val, 0);
            pairs += freq; // because we are adding 1 more of `val`, it forms `freq` new pairs
            map.put(val, freq + 1);

            // shrink the window from the left as long as pairs >= k
            while (pairs >= k) {
                total += (n - r); // all subarrays [l...r], [l...r+1], ..., [l...n-1] are valid
                int leftVal = nums[l];
                int leftFreq = map.get(leftVal);
                pairs -= (leftFreq - 1); // removing one occurrence removes (freq - 1) pairs
                if (leftFreq == 1) {
                    map.remove(leftVal);
                } else {
                    map.put(leftVal, leftFreq - 1);
                }
                l++;
            }
        }

        return total;
    }
}
