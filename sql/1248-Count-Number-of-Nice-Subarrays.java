class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSumCount = new int[n + 1]; 
        prefixSumCount[0] = 1;

        int sum = 0, count = 0;
        
        for (int num : nums) {
            if (num % 2 != 0) {
                sum++;
            }
            
            if (sum >= k) {
                count += prefixSumCount[sum - k]; 
            }
            
            prefixSumCount[sum]++;
        }
        
        return count;
    }
}
