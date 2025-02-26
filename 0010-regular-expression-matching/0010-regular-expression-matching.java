class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, s.length() - 1, p.length() - 1);
    }

    public boolean isMatch(String s, String p, int i, int j) {
        if (i < 0 && j < 0) return true;

        if (i < 0) {
            while (j >= 0) {
                if (p.charAt(j) != '*') 
                    return false;
                j -= 2; // Skip '*' and the preceding character
            }
            return true;
        }

        if (j < 0) return false;

        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if (c2 == '*') {
            if (j == 0) 
                return false;

            char left = p.charAt(j - 1);
            boolean zeroOccurrences = isMatch(s, p, i, j - 2); 
            boolean oneOrMore = (left == '.' || c1 == left) && isMatch(s, p, i - 1, j); 

            return zeroOccurrences || oneOrMore;
        }

        if (c1 == c2 || c2 == '.') {
            return isMatch(s, p, i - 1, j - 1);
        }

        return false;
    }
}
