class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num : arr)
            set.add(num);
        int n = arr.length;
        int maxi = 0;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int len = 2 + maxCount(arr, arr[i], arr[j], set);
                maxi = Math.max(maxi, len);
            }
        }

        return maxi < 3 ? 0 : maxi;
    }
    public int maxCount(int[] arr, int prev1, int prev2, Set<Integer> set) {
        int next = prev1 + prev2;
        if(!set.contains(next))
            return 0;
        
        return 1 + maxCount(arr, prev2, next, set);
    }
}