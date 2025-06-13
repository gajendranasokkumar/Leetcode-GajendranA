class Solution {
    public int kokoEat(int[] arr, int k) {
        int low = 1;
        int high = 0;
        
        for (int bananas : arr) {
            high = Math.max(high, bananas);
        }

        int answer = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(arr, k, mid)) {
                answer = mid; // try to minimize s
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canEatAll(int[] arr, int k, int s) {
        int hours = 0;
        for (int bananas : arr) {
            hours += (bananas + s - 1) / s; // same as ceil(bananas / s)
        }
        return hours <= k;
    }
}
