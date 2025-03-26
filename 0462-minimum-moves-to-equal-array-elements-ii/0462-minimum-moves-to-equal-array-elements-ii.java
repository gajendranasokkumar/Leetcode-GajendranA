class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int mid=nums[n/2];
        int c=0;
        for(int i:nums){
            c+=Math.abs(i-mid);
        }
        return c;
    }
}