class Solution {
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int res = 1;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, lisEndingAtIdx(arr, idx, memo));
        
        return res;
    }

    static int lisEndingAtIdx(int[] arr, int idx, int[] memo) {      
        if (memo[idx] != -1) 
            return memo[idx];
        
        if (idx == 0)
            return 1;

        int mx = 1;
        for (int prev = 0; prev < idx; prev++) {
            if (arr[prev] < arr[idx]) {
                mx = Math.max(mx, lisEndingAtIdx(arr, prev, memo) + 1);
            }
        }
        
        memo[idx] = mx;
        return mx;
    }
}
