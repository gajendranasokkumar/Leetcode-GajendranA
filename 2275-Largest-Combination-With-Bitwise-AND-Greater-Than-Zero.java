class Solution {
    public int largestCombination(int[] candidates) {
        return check(candidates);
    }
    public int check(int[] nums) {
        int max = 0;
        for(int i=0;i<32;i++) { 
            int count=0;
            for(int num : nums) {
                if((num & (1 << i)) != 0)
                    count++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
} 