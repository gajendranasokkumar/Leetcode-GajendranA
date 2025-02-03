class Solution {
    public char next(char c) {
        if(c == 'z')
            return 'a';
        return (char)(c+1);
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        if(len2 > len1)
            return false;
        while(i < len1 && j < len2) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            if(c1 == c2 || next(c1) == c2) {
                if(j == len2-1) 
                    return true;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}