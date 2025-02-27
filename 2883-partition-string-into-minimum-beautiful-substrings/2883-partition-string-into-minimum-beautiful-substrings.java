class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        int val = minLength(s, 0, s.length(), dp);
        return val >= (int)1e7 ? -1 : val;
    }
    public int minLength(String s, int idx, int n, int[] dp) {
        if(idx >= n)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        char c = s.charAt(idx);
        if(c == '0')
            return (int)1e7;
        int mini = Integer.MAX_VALUE;
        for(int i=idx;i<n;i++) {
            String sub = s.substring(idx, i+1);
            if(isPowerOfFive(sub)) 
                mini = Math.min(mini, 1 + minLength(s, i+1, n, dp));
        } 
        return dp[idx] = mini;
    }
    public boolean isPowerOfFive(String s) {
        int num = Integer.parseInt(s, 2);
        System.out.println(num);
        while(num % 5 == 0) 
            num /= 5;
        return num == 1;
    }
}