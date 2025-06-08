class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = nums[i];
        return helper(nums, k, 1) || helper(arr, k, -1);
    }

    public boolean helper(int[] nums, int k, int fix) {
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            if(k == 0)
                break;
            if(nums[i] == fix) {
                nums[i] *= -1;
                nums[i+1] *= -1;
                k--;
            }
        }
        for(int i=1;i<n;i++)
            if(nums[i-1] != nums[i])
                return false;
        return true;
    }
}