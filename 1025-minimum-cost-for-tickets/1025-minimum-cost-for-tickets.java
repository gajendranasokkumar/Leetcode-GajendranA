class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> memo = new HashMap<>();
        return findCost(days, 0, costs, memo);
    }

    private int findCost(int[] days, int i, int[] costs, Map<Integer, Integer> memo) {
        if (i >= days.length) 
            return 0;

        if (memo.containsKey(i)) 
            return memo.get(i);

        int oneDay = costs[0] + findCost(days, steps(days, i, days[i] + 1), costs, memo);
        int sevenDay = costs[1] + findCost(days, steps(days, i, days[i] + 7), costs, memo);
        int thirtyDay = costs[2] + findCost(days, steps(days, i, days[i] + 30), costs, memo);

        int minCost = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        memo.put(i, minCost);

        return minCost;
    }

    private int steps(int[] days, int i, int total) {
        while (i < days.length && days[i] < total) 
            i++;
        return i;
    }
}
