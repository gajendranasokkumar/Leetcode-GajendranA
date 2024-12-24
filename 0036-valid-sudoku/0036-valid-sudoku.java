class Solution {
    public int findGnum(int i, int j) {
        if(j <= 2) {
            if(i <= 2)
                return 1;
            else if(i <= 5)
                return 4;
            else
                return 7;
        } else if(j <= 5) {
            if(i <= 2)
                return 2;
            else if(i <= 5)
                return 5;
            else
                return 8;
        } else {
            if(i <= 2)
                return 3;
            else if(i <= 5)
                return 6;
            else
                return 9;
        }
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Character, HashSet<Integer>> col = new HashMap<>();
        Map<Character, HashSet<Integer>> grid = new HashMap<>();
        for (char i = '1'; i <= '9'; i++) {
            col.put(i, new HashSet<>());
            grid.put(i, new HashSet<>());
        }
        
        for(int i=0;i<9;i++) {
            Set<Character> set = new HashSet<>();
            char c;
            int gnum;
            for(int j=0;j<9;j++) {
                c = board[i][j];
                gnum = findGnum(i, j);

                if (c == '.')
                    continue;

                if(set.contains(c) || col.get(c).contains(j) || grid.get(c).contains(gnum))   
                    return false;
                
                set.add(c);
                col.get(c).add(j);
                grid.get(c).add(gnum);
            }
        }

        return true;
    }
}