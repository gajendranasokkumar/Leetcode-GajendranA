class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        
        int left = 1, right = maxCandy; 
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplitCandies(candies, k, mid)) {
                result = mid;  
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public boolean canSplitCandies(int[] candies, long k, int split) {
        long total = 0;
        for (int candy : candies) {
            total += candy / split;
        }
        return total >= k;
    }
}
