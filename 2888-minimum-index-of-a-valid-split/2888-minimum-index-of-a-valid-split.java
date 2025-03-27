class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        
        // Step 1: Find the dominant element using Boyer-Moore Voting Algorithm
        int candidate = -1, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        
        // Step 2: Count total occurrences of the dominant element
        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }
        
        // Step 3: Find the minimum index where dominant element is valid in both parts
        int prefixCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == candidate) {
                prefixCount++;
            }
            
            int prefixSize = i + 1;
            int suffixSize = n - prefixSize;
            
            if (prefixCount * 2 > prefixSize && (totalCount - prefixCount) * 2 > suffixSize) {
                return i;
            }
        }
        
        return -1;
    }
}
