class Solution {
    public void rotate(int[][] matrix) {
        int t;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i+1;j<matrix[0].length;j++)
            {
                t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for(int i=0;i<matrix.length;i++)
        {
            int left=0,right=matrix[0].length-1;
            while(left <= right)
            {
                t = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = t;
                left++;
                right--;
            }
        }
    }
}