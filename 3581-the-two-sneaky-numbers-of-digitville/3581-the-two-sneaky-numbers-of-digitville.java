class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] frequency = new int[n];
        int[] result = new int[2];
        int index = 0;

        for (int num : nums) {
            frequency[num]++;
        }

        for (int i = 0; i < n; i++) {
            if (frequency[i] == 2) {
                result[index++] = i;
            }
        }

        return result;
    }
}
