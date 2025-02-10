class Solution {
    public String clearDigits(String s) {
        int numcount = 0, charcount = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length();i++) {
            if(isDigit(sb.charAt(i)) && !isDigit(sb.charAt(i-1))) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i-=2;
            }
        }
        
        return sb.toString();
    }
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}