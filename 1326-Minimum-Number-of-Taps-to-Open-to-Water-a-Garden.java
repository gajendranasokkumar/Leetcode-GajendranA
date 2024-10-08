import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int minTaps(int n, int[] ranges) {
        ArrayList<int[]> intervals = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            intervals.add(new int[]{left, right});
        }

        intervals.sort((a, b) -> a[0] - b[0]);

        int tapsOpen = 0, end = 0, farthest = 0, i = 0;

        while (i < intervals.size() && end < n) {
            while (i < intervals.size() && intervals.get(i)[0] <= end) {
                farthest = Math.max(farthest, intervals.get(i)[1]);
                i++;
            }
            
            if (end == farthest) {
                return -1;
            }

            end = farthest;
            tapsOpen++;
        }

        return end >= n ? tapsOpen : -1;
    }
}
