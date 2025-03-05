class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int size1 = s1.length(), size2 = s2.length();
        int[][] dp = new int[size1+1][size2+1];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return delete(s1, s2, 0, 0, dp, size1, size2);
    }
    public int delete(String s1, String s2, int i, int j, int[][] dp, int size1, int size2) {
        if(i == size1 && j == size2)
            return 0;
        if(i >= size1) {
            int sum = 0;
            while(j < size2)
                sum += s2.charAt(j++);
            return sum;
        }
        if(j >= size2) {
            int sum = 0;
            while(i < size1)
                sum += s1.charAt(i++);
            return sum;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = delete(s1, s2, i+1, j+1, dp, size1, size2);
        int left = (int)s1.charAt(i) + delete(s1, s2, i+1, j, dp, size1, size2);
        int right = (int)s2.charAt(j) + delete(s1, s2, i, j+1, dp, size1, size2);
        return dp[i][j] = Math.min(left, right);
    }
}