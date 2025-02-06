class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int val = nums[i] * nums[j];
                map.put(val, map.getOrDefault(val,0)+1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            int val = e.getValue();
            int tot = ((val-1) * val) / 2;
            count += tot * 8;
        }
        return count;
    }
}