class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if(n < 3)
            return s;
        int stri = 0;
        int i = 0;
        StringBuilder str = new StringBuilder();
        while(i < n) {
            char ch = s.charAt(i);
            if(stri-1 >= 0 && stri-2 >= 0 && str.charAt(stri-1) == str.charAt(stri-2) && str.charAt(stri-2) == ch) {
                i++;
                continue;
            } else {
                str.append(ch);
                i++;
                stri++;
            }
        }
        return str.toString();
    }
}