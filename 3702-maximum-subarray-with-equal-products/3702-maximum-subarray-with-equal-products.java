class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        for(int i = 0; i < n; i++) {
            long product = nums[i];
            long currentGcd = nums[i]; 
            for(int j = i + 1; j < n; j++) {
                product = multiply(product, nums[j]);
                currentGcd = gcd(currentGcd, nums[j]);
                if (isProductEquivalent(i, j, nums)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    
    private boolean isProductEquivalent(int start, int end, int[] nums) {
        long product = 1;
        long currentGcd = nums[start];
        for(int i = start; i <= end; i++) {
            product = multiply(product, nums[i]);
            currentGcd = gcd(currentGcd, nums[i]);
        }        
        long lcm = nums[start];
        for(int i = start + 1; i <= end; i++) {
            lcm = (lcm * nums[i]) / gcd(lcm, nums[i]);
        }
        return product == lcm * currentGcd;
    }
    
    private long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    private long multiply(long a, long b) {
        return a * b;
    }
}