class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int min = k;
        for(int num : nums) {
            set.add(num);
            if(num < k)
                return -1;
        }
        set.remove(k);
        return set.size();
    }
}