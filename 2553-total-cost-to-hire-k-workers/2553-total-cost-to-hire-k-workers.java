class Solution {
    PriorityQueue<Integer> left, right;
    int i, j;

    public long totalCost(int[] costs, int k, int candidates) {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>();
        int n = costs.length;

        for (i = 0; i < candidates && i < n; i++) {
            left.add(costs[i]);
        }

        for (j = n - 1; j >= n - candidates && j >= i; j--) {
            right.add(costs[j]);
        }

        long result = 0;

        while (k-- > 0) {
            if (!left.isEmpty() && (right.isEmpty() || left.peek() <= right.peek())) {
                result += left.poll();
                if (i <= j) {
                    left.add(costs[i++]);
                }
            } else {
                result += right.poll();
                if (i <= j) {
                    right.add(costs[j--]);
                }
            }
        }

        return result;
    }
}
