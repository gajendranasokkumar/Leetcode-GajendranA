class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < col; j += 2) {
                    if(j%2==0)
                        result.add(grid[i][j]);
                }
            } else {
                for (int j = col - 1; j >= 0; j --) {
                    if(j%2==1)
                        result.add(grid[i][j]);
                }
            }
        }

        return result;
    }
}
