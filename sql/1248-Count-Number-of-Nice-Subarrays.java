// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
        
//     }
// }
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  

        int sum = 0, count = 0;
        
        for (int num : nums) {
            if(num%2!=0)
                sum++;
            
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
