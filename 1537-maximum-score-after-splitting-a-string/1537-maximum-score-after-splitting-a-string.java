class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] zeros = new int[n+1];
        int[] ones = new int[n+1];
        for(int i=1;i<=n;i++) 
            if(s.charAt(i-1) == '0')
                zeros[i] = zeros[i-1] + 1;
            else
                zeros[i] = zeros[i-1];
            
        for(int i=n-2;i>=0;i--) 
            if(s.charAt(i+1) == '1')
                ones[i] = ones[i+1] + 1;
            else
                ones[i] = ones[i+1];
            
        int maxi = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) 
            maxi = Math.max(maxi, zeros[i] + ones[i-1]);

        return maxi;
    }
}