class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Apply the difference array technique
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            if (l < n) {
                diff[l] += 1;
            }
            if (r + 1 < n) {
                diff[r + 1] -= 1;
            }
        }

        // Compute the prefix sum and check if each nums[i] can be reduced to zero
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
