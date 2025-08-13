class Solution {
    public boolean isPowerOfThree(int n) {
        boolean t = false;
        if(n<1)
        return false;
        if(n == 1)
        return true;
        while(n != 1)
        {
            if(n % 3 != 0)
            {
                t=false;
                break;
            }
            else
            {
                t = true;
            }
            n /= 3;
        }
        return t;
    }
}