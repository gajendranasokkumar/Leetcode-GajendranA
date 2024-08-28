// class Solution {
//     public int totalNQueens(int n) {
        
//     }
// }
class Solution {
    int result = 0;
    public boolean isSafe(char[][] board, int row, int col)
    {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    public List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public void placeQueens(int result, char[][] board, int n, int index)
    {
        if(index == n)
        {
            this.result++;
            System.out.println(result);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(board, i, index))
            {
                board[i][index] = 'Q';
                placeQueens(result, board, n, index+1);
                board[i][index] = '.';
            }
        }
    }
    public int totalNQueens(int n) {        
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        System.out.println(result);
        placeQueens(result, board, n, 0);
        return this.result;
    }
}