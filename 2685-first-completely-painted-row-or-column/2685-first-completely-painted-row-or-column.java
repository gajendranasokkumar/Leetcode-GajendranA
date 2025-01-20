class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++)
            map.put(arr[i], i);
        int rows = mat.length;
        int cols = mat[0].length;
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<rows;i++) {
            int maxi = Integer.MIN_VALUE;
            for(int j=0;j<cols;j++) 
                maxi = Math.max(maxi, map.get(mat[i][j]));
            mini = Math.min(mini, maxi);
        }
        for(int i=0;i<cols;i++) {
            int maxi = Integer.MIN_VALUE;
            for(int j=0;j<rows;j++) 
                maxi = Math.max(maxi, map.get(mat[j][i]));
            mini = Math.min(mini, maxi);
        }
        return mini;
    } 
}