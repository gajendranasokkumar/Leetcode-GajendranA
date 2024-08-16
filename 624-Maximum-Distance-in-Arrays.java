import java.util.*;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDistance = 0;

        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minVal));
            maxDistance = Math.max(maxDistance, Math.abs(maxVal - currentMin));

            if (currentMin < minVal) {
                minVal = currentMin;
                minIndex = i;
            }
            if (currentMax > maxVal) {
                maxVal = currentMax;
                maxIndex = i;
            }
        }

        return maxDistance;
    }
}
