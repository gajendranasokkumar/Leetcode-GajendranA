class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        long totalApples = 0;
        for (int a : apple)
            totalApples += a;

        Arrays.sort(capacity);

        int reqBox = 0;
        long totalCap = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {
            totalCap += capacity[i];
            reqBox++;
            if (totalCap >= totalApples)
                break;
        }

        return reqBox;
    }

}