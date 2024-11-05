class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans=0;

        for(int i=30;i>=0;i--){
            long holdle = (long)(Math.pow(2,i));
            
            long hold=(long)(Math.pow(2,i+1))-1;
            

            if(holdle <=left && hold>=right){
                ans=  ans^(1<<i);
                left-=holdle;
                right-=holdle;
            
            }
        }

        return ans;
    }
}