class Solution {
    public int countRowFlip(int[] row)
    {
        int left=0, right=row.length-1;
        int count=0;
        while(left<=right)
        {
            if(row[left++] != row[right--])
                count++;
        }
        return count;
    }

    public int countColFlip(int[][] col, int j)
    {
        int start=0, end=col.length-1;
        int count=0;
        while(start <= end)
        {
            if(col[start++][j] != col[end--][j])
                count++;
        }
        return count;
    }

    public int minFlips(int[][] grid) {
        int rowCount=0, colCount=0;
        for(int i=0;i<grid.length;i++)
        {
            rowCount += countRowFlip(grid[i]);
        }
        for(int j=0;j<grid[0].length;j++)
        {
            colCount += countColFlip(grid, j);
        }
        return Math.min(rowCount, colCount);
    }
}