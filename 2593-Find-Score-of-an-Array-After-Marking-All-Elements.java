class Solution {
    public long findScore(int[] nums) {
        long sum = 0;
        int prev = -1;
        if(nums.length == 1)
            return nums[0];
            
        for(int i=0;i<nums.length;i++) {
            if(prev == -1) {
                if(nums[i] <= nums[i+1]) {
                    sum += nums[i];
                    nums[i] = -1;
                    nums[i+1] = -1;
                }
            }
            else if(prev == nums.length-2) {
                if(nums[prev] != -1 && nums[i] != -1 && nums[prev] >= nums[i]) {
                    sum += nums[i];
                    nums[prev] = -1;
                    nums[i] = -1;
                }
            }
            else if(nums[i] != -1 && ((nums[prev] >= nums[i] && nums[i] <= nums[i+1]) || (nums[prev] == -1 && nums[i] <= nums[i+1]))) {
                sum += nums[i];
                nums[prev] = -1;
                nums[i] = -1;
                nums[i+1] = -1;
            }
            prev = i;
        }
    
        prev = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prev == -1) {
                if (nums[i] != -1 && nums[i] <= nums[i-1]) { 
                    sum += nums[i];
                    nums[i] = -1;
                    nums[i - 1] = -1;
                }
            }
            else if (prev == 1) {
                if (nums[i] != -1 && nums[prev] != -1 && nums[prev] >= nums[i]) {
                    sum += nums[i];
                    nums[prev] = -1;
                    nums[i] = -1;
                }
            }
            else if (nums[i] != -1 && nums[prev] == -1 && nums[i] <= nums[i - 1]) {
                sum += nums[i];
                nums[i] = -1;
                nums[i - 1] = -1;
            }
            prev = i;
        }

        for(int i: nums) 
            if(i != -1)
                sum += i;
        

        System.out.println(Arrays.toString(nums));
        
        return sum;
    }
}