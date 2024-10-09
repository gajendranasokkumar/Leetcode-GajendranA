class Solution {
    public int minAddToMakeValid(String s) {
        int open=0, mis=0;
        for(char i: s.toCharArray()) {
            if(i==')')
                if(open > 0)
                    open--;
                else
                    mis++;
            else
                open++;
        }

        if(open == 0 || mis == 0)    
            return Math.abs(open - mis);
        else
            return open+mis;
    }
}