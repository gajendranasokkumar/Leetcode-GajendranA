class Solution {
    public int minCost(int[] heights, int[] cost) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find range of heights
        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        int ans = Integer.MAX_VALUE;

        // Binary search on height
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;

            int cost1 = getCost(heights, cost, mid1);
            int cost2 = getCost(heights, cost, mid2);

            ans = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid2 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return ans;
    }

    // Helper to compute total cost for target height
    private int getCost(int[] heights, int[] cost, int target) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += Math.abs(heights[i] - target) * cost[i];
        }
        return total;
    }
}
