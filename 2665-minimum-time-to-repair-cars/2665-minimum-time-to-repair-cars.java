class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1, right = (long) ranks[0] * cars * cars, minTime = right;

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                minTime = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return minTime;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        int repaired = 0;
        for (int rank : ranks) {
            repaired += Math.sqrt(time / rank);
            if (repaired >= cars) 
                return true;
        }
        return false;
    }
}
