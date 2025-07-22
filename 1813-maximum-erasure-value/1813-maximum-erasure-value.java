class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        int n = nums.length;
        int sum = 0, max = 0;
        while(right < n) {
            if(set.contains(nums[right])) {
                while(nums[left] != nums[right] && left < right) {
                    sum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}