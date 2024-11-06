class NumMatrix {
    public static  int[][] prefixSum;
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefixSum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = matrix[i][j];

                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }

                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefixSum[row2][col2];
    
        // Subtract the area above the rectangle if row1 > 0
        if (row1 > 0) {
            total -= prefixSum[row1 - 1][col2];
        }
        
        // Subtract the area to the left of the rectangle if col1 > 0
        if (col1 > 0) {
            total -= prefixSum[row2][col1 - 1];
        }
        
        // Add back the overlap area if both row1 > 0 and col1 > 0
        if (row1 > 0 && col1 > 0) {
            total += prefixSum[row1 - 1][col1 - 1];
        }
        
        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */