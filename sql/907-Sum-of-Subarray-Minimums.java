class Solution {
    public static long helper(int[] piles, long k) {
        long totalhrs = 0;
        for (int i = 0; i < piles.length; i++) {
            totalhrs += (long)(piles[i] + k - 1) / k; // Correct ceiling division
        }
        return totalhrs;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        // for (int i = 0; i < piles.length; i++) {
        //     if (max < piles[i]) {
        //         max = piles[i];
        //     }
        // }

        int low = 1, high = (int)(1e9);
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long curhrs = helper(piles, mid);
            
            if (curhrs <= h) {
                result = mid; // Update the result to the current mid
                high = mid - 1; // Narrow the search range to the lower half
            } else {
                low = mid + 1; // Narrow the search range to the upper half
            }
        }
        return result;
    }
}

    