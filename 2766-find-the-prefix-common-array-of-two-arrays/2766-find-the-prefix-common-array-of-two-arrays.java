class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] visited_a = new boolean[n+1];
        boolean[] visited_b = new boolean[n+1];
        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            int count = A[i] == B[i] ? 1 : 0;
            if(i > 0)
                count += result[i-1];
            if(visited_b[A[i]])
                count += 1;
            if(visited_a[B[i]])
                count += 1;
            result[i] = count;
            visited_a[A[i]] = true;
            visited_b[B[i]] = true;
        }
        return result;
    }
}