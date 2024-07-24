class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> global = new HashSet<>();
        int i,j,k;
        Arrays.sort(nums);
        for(i=0;i<nums.length;i++)
        {
            int left = i+1;
            int right = nums.length - 1;
            while(left<right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0)
                {
                    global.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;
                }
                else if(sum > 0)
                {
                    right--;
                }
                else if(sum < 0)
                {
                    left++;
                }
            }
        }
        return new ArrayList<>(global);
    }
}