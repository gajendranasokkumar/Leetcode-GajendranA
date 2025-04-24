class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) 
            set.add(num);
        int totalDistinct = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left=0, right=0, n=nums.length;
        set.clear();
        while(right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.size() == totalDistinct) {
                count += n-right;
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }

            right++;
        }

        return count;
    }
}