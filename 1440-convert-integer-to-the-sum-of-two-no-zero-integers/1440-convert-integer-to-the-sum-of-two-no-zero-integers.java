class Solution {
    // I used this function to check whether n1 and n2 are No-Zero integer or not. 
    public boolean isContainzero(int num1, int num2 ){
        if(num1 == 0 || num2==0)
            return true;
        while(num1 > 0) {
            if(num1 % 10 == 0)
                return true;
            num1 /= 10;
        }
         while(num2 > 0) {
            if(num2 % 10 == 0)
                return true;
            num2 /= 10;
        }
        return false;
        
}
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int n1;
        int n2;
        for(int i=1;i<=n;i++){
            n1=i;
            n2=n-i;
            boolean return_ = isContainzero(n1,n2);
            if(return_==true){
                isContainzero(n1,n2);
            }else{
                ans[0]=n1;
                ans[1]=n2;
                break;
            }
                   
        }
        return ans;
        
    }
}