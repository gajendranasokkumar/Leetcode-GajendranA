class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        return Math.min(run(cost, 0, memo), run(cost, 1, memo));
    }

    private int run(int[] cost, int i, int[] memo) {
        if (i >= cost.length) return 0; 
        if (memo[i] != -1) return memo[i];

        int pickOne = cost[i] + run(cost, i + 1, memo);
        int pickTwo = cost[i] + run(cost, i + 2, memo);

        memo[i] = Math.min(pickOne, pickTwo);
        return memo[i];
    }
}
