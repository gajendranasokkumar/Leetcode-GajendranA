class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        long sum = 0;
        long prev = nums[nums.length-1]+k;
        for(int i=nums.length-2;i>=0;i--){
            sum = nums[i] + k;
            long f= nums[i] - k;
            if(sum<prev){
                prev = sum;
                res++;
            }
            else {
                sum = prev;
                sum--;
                if(sum>=f){
                    res++;
                    prev = sum;
                }
            }
           
        }
        return res;
    }
}