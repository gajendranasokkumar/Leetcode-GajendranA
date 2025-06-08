class Solution {
    int MOD = (int) (1e9 + 7);
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for(int i=1;i<n;i++)
            if(complexity[0] >= complexity[i])
                return 0;
        return fact(n - 1);
    }
    public int fact(int n) {
        long mul = 1;
        for(int i=n;i>0;i--)
            mul = (mul * i * 1L) % MOD;
        return (int)mul % MOD;
    }
}