class Solution {
    public boolean checkPowersOfThree(int n) {
        return power(n, 0, 0);
    }
    public boolean power(int n, int sum, int power) {
        if(sum > n)
            return false;
        if(sum == n)
            return true;
        if (Math.pow(3, power) > n - sum) 
            return false;
        boolean pick = power(n, sum + (int)Math.pow(3, power), power+1);
        boolean notpick = power(n, sum, power+1);
        return pick || notpick;
    }
}