class Solution {
    public static int helper(int[] nums, int total)
    {
        int count = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] + sum <= total)
                sum += nums[i];
            else
            {
                count++;
                sum = nums[i];
            }
        }

        return count;
    }

    public static int initfun(int[] nums, int n, int k)
    {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i=0;i<n;i++)
        {
            if(low < nums[i])
                low = nums[i];
            high += nums[i];
        }

        while(low <= high)
        {
            int mid = (low + high) / 2;
            int ans = helper(nums, mid);
            if(ans > k)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public int splitArray(int[] nums, int k) {
        return initfun(nums, nums.length, k);
    }
}