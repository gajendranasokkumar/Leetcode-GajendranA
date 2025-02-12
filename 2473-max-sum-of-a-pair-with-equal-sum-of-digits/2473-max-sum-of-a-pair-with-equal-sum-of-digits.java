class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;

        int sumArr[] = new int[82];

        for (int n : nums) {
            int s = sum(n);
            
            if (sumArr[s] > 0)
                max = Math.max(max, sumArr[s] + n);

            sumArr[s] = Math.max(sumArr[s], n);
        }
        return max;
    }

    public int sum(int num) {
        int sum = 0;
        while (num > 0) {
            int dig = num % 10;
            sum += dig;
            num /= 10;
        }
        return sum;
    }
}