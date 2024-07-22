class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int openBracket = 0;
        for(char ch: s.toCharArray()) {
            if( ch == '(') {
                openBracket++;
            }
            else if(ch == ')'){
                openBracket--;
            }
            max = Math.max(max, openBracket);
        }
        return max;
        
    }
}