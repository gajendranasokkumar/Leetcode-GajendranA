class Solution {
   public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return 0;
        int time = 0;
        int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;
            for(int k=0;k<size;k++) {
                int[] one = queue.poll();
                int row = one[0];
                int col = one[1];
                for(int i=0;i<4;i++) {
                    int r = row + direction[i][0];
                    int c = col + direction[i][1];
                    
                    if(r>=0 && r<rows && c<cols && c>=0 && grid[r][c] == 1)
                    {
                        grid[r][c] = 2;
                        fresh--;
                        queue.add(new int[]{r, c});
                        flag = true;
                    }
                }
            }
            if(flag) time++;
        }

        return fresh == 0 ? time : -1;
    }
}