class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> memo = new HashMap<>();

        return dfs(nums, -1, memo);
    }

    private List<Integer> dfs(int[] nums, int prevIdx, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(prevIdx)) return memo.get(prevIdx);

        List<Integer> best = new ArrayList<>();
        for (int i = prevIdx + 1; i < nums.length; i++) {
            if (prevIdx == -1 || nums[i] % nums[prevIdx] == 0) {
                List<Integer> current = dfs(nums, i, memo);
                if (current.size() > best.size()) {
                    best = current;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        if (prevIdx != -1) result.add(nums[prevIdx]);
        result.addAll(best);
        memo.put(prevIdx, result);
        return result;
    }
}
