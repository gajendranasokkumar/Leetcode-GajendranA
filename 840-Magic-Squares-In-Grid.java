import java.util.Arrays;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int totrow = grid.length, totcol = grid[0].length;
        int count = 0;

        for (int i = 0; i < totrow - 2; i++) {
            for (int j = 0; j < totcol - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j) {
        if (grid[i + 1][j + 1] != 5) return false;

        boolean[] seen = new boolean[10]; 

        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                int val = grid[x][y];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]; 
        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2]; 
        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j]; 
        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1]; 
        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]; 
        int sum8 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j]; 

        return (sum1 == 15 && sum2 == 15 && sum3 == 15 &&
                sum4 == 15 && sum5 == 15 && sum6 == 15 &&
                sum7 == 15 && sum8 == 15);
    }
}
