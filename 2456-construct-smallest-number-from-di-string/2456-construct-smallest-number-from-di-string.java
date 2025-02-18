class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length() + 1;
        boolean[] used = new boolean[10];
        int[] nums = new int[n];

        if (backtrack(pattern, nums, used, 0)) {
            StringBuilder str = new StringBuilder();
            for (int num : nums) 
                str.append(num);
            return str.toString();
        }
        return "";
    }

    private boolean backtrack(String pattern, int[] nums, boolean[] used, int idx) {
        if (idx == nums.length) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            if (!used[i]) {
                if (idx == 0 || 
                    (pattern.charAt(idx - 1) == 'I' && nums[idx - 1] < i) || 
                    (pattern.charAt(idx - 1) == 'D' && nums[idx - 1] > i)) {

                    used[i] = true;
                    nums[idx] = i;

                    if (backtrack(pattern, nums, used, idx + 1)) {
                        return true;  
                    }

                    used[i] = false; 
                }
            }
        }
        return false;
    }
}
