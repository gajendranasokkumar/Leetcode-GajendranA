// Memorization

public class Solution {
    public int deleteAndEarn(int[] nums) {
        // Create a map to store the frequency of each number
        Map<Integer, Integer> sums = new HashMap<>();
        int maxNum = 0;

        // Calculate the total points for each value
        for (int num : nums) {
            sums.put(num, sums.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }

        // Memoization map
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(maxNum, sums, memo);
    }

    // Recursive function with memoization
    private int dfs(int num, Map<Integer, Integer> sums, Map<Integer, Integer> memo) {
        if (num <= 0) return 0;

        // Check memoization cache
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        // Case 1: Skip current number
        int skip = dfs(num - 1, sums, memo);

        // Case 2: Take current number
        int take = sums.getOrDefault(num, 0) + (num - 1 >= 0 ? dfs(num - 2, sums, memo) : 0);

        // Get the maximum of taking or skipping the current number
        int result = Math.max(skip, take);

        // Store the result in the memoization map
        memo.put(num, result);

        return result;
    }
}