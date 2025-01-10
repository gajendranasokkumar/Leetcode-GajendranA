class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] cols = new int[n][n];

        int i = 0;
        int j = 0;

        while (j < n) 
        {
            cols[j][i] = grid[i][j];
            i++;

            if (i >= n)
            {
                i = 0;
                j++;
            }
        }

        int ans = 0;
        i = 0;
        j = 0;

        while (i < n) 
        {
            if (Arrays.equals(grid[i], cols[j])) ans++;
            j++;

            if (j >= n) 
            {
                i++;
                j = 0;
            }
        }

        return ans;
    }
}