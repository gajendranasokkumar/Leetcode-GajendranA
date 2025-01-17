class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int xor = 0;
        for(int i=0;i<n;i++) 
            xor ^= derived[i];
        
        return xor == 0;




        // if/(derived.length == 1)
        //     return derived[0] == 0 ? true : false;
        // boolean one = false, zero = false;
        // if(derived[0] == 1) {
        //     int[] nums = new int[n];
        //     nums[0] = 0;
        //     zero = run(nums, 0, derived);

        //     nums[0] = 1;
        //     one = run(nums, 0, derived);
        // } else {
        //     int[] nums = new int[n];
        //     nums[0] = 0;
        //     zero = run(nums, 0, derived);

        //     nums[0] = 1;
        //     one = run(nums, 0, derived);
        // }
        // return one || zero;
    }
    public boolean run(int[] nums, int i, int[] derived) {
        int n = nums.length;
        if(i == n-1) {
            if(derived[i] == (nums[i] ^ nums[0]))
                return true;
            else
                return false;
        }
        if(derived[i] == 0) {
            nums[i+1] = nums[i];
        } else {
            nums[i+1] = nums[i] == 1 ? 0 : 1;
        }

        return run(nums, i+1, derived);
    }
}