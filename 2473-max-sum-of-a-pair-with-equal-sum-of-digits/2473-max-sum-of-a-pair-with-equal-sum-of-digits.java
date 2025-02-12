class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;

        int sumArr[] = new int[82];

        for (int n : nums) {
            int s = 0;
            int num = n;
            while (num > 0) {
                int dig = num % 10;
                s += dig;
                num /= 10;
            }

            if (sumArr[s] > 0)
                max = Math.max(max, sumArr[s] + n);

            sumArr[s] = Math.max(sumArr[s], n);
        }
        return max;
    }
}