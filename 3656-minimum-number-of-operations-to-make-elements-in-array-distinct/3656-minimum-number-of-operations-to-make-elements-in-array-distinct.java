class Solution {
    public int minimumOperations(int[] nums) {
        int[] fre=new int[101];
        int n=nums.length;
        boolean isDuplicate=false;
        for(int i=0;i<n;i++){
            fre[nums[i]]++;
            if(fre[nums[i]]>=2) isDuplicate=true;
        }
        if(!isDuplicate) return 0;
        int i=0,count=0;
        while(i+2<n){
            fre[nums[i]]--;
            fre[nums[i+1]]--;
            fre[nums[i+2]]--;
            count++;
            if(isDistinct(fre,n,nums)) return count;
            i+=3;
        }
        if(isDistinct(fre,n,nums)) return count;
        return count+1;
    }
    public boolean isDistinct(int[] fre,int n,int[] nums){
        boolean isDuplicate=false;
        for(int i=0;i<n;i++){
            if(fre[nums[i]]>=2) return false;
        }
        return true;
    }
}