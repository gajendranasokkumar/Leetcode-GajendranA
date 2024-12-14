class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int l = 0, r = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }
}
