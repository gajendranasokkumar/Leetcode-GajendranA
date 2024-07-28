class Solution {
    public boolean canAliceWin(int[] nums) {
        int alice = 0, bob = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] <= 9)
                alice+=nums[i];
            else
                bob += nums[i];
        }

        boolean result = false;
        if(alice > bob)
        {
            result = true;
        }

        alice = 0; bob = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] <= 9)
                bob+=nums[i];
            else
                alice+=nums[i];
        }

        if(alice > bob || result)  
            return true;
        else
            return false;
    }
}