class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;

        // Build prefix sum
        int[] pos = new int[n];
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        int max = 0;

        // Case 1: go left first then right (l steps left, r steps right)
        for (int l = 0; l <= k; l++) {
            int left = startPos - l;
            int rem = k - 2 * l;
            if (rem < 0) continue;
            int right = startPos + rem;

            int i = lowerBound(pos, left);
            int j = upperBound(pos, right);
            max = Math.max(max, prefix[j] - prefix[i]);
        }

        // Case 2: go right first then left (r steps right, l steps left)
        for (int r = 0; r <= k; r++) {
            int right = startPos + r;
            int rem = k - 2 * r;
            if (rem < 0) continue;
            int left = startPos - rem;

            int i = lowerBound(pos, left);
            int j = upperBound(pos, right);
            max = Math.max(max, prefix[j] - prefix[i]);
        }

        return max;
    }

    // Find first index i such that arr[i] >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    // Find first index i such that arr[i] > target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
