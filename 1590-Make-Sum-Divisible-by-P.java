import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        // Calculate total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Find the remainder of totalSum modulo p
        int rem = (int) (totalSum % p);
        if (rem == 0) {
            return 0;  // If total sum is divisible by p, no need to remove any subarray
        }

        // Use a HashMap to track the cumulative sum modulo p and its index
        HashMap<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1);  // Initialize with (0, -1) to handle cases where the subarray starts from index 0
        
        int minLen = nums.length;
        int currMod = 0;
        long prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Calculate prefix sum
            prefixSum += nums[i];
            
            // Current prefix sum modulo p
            currMod = (int) (prefixSum % p);
            
            // Normalize the remainder to always be positive
            currMod = (currMod + p) % p;
            
            // Find the value that, when subtracted from the current mod, will give the remainder rem
            int targetMod = (currMod - rem + p) % p;
            
            // If the targetMod has been seen before, we found a subarray whose removal would make sum % p == 0
            if (modMap.containsKey(targetMod)) {
                minLen = Math.min(minLen, i - modMap.get(targetMod));
            }
            
            // Update the map with the current mod and index
            modMap.put(currMod, i);
        }

        // If no valid subarray is found, return -1, otherwise return the length of the smallest subarray
        return minLen == nums.length ? -1 : minLen;
    }
}
