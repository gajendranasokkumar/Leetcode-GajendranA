import java.util.*;

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[target + 1][nums.size()];
        for (int[] row : dp) {
            Arrays.fill(row, -2);
        }
        return findMax(nums, 0, target, dp);
    }

    private int findMax(List<Integer> nums, int idx, int target, int[][] dp) {
        if (target == 0) return 0;
        if (idx >= nums.size() || target < 0) return -1;

        if (dp[target][idx] != -2) return dp[target][idx];

        int pick = findMax(nums, idx + 1, target - nums.get(idx), dp);
        if (pick != -1) pick += 1;

        int notPick = findMax(nums, idx + 1, target, dp);

        return dp[target][idx] = Math.max(pick, notPick);
    }
}
