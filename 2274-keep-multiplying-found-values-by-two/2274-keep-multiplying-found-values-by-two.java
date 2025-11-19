class Solution {
    public boolean isInNums(int[] nums, int length, int target){
        for(int i=0;i<length;i++){
            if(nums[i] == target){
                return true;
            }
        }   
        return false;
    }
    public int findFinalValue(int[] nums, int original) {
        int length = nums.length;
        while(isInNums(nums,length,original)){
            original*=2;
        }
        return original;
    }
}