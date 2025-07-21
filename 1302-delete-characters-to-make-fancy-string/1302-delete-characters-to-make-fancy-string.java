class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3)
            return s;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int len = str.length();
            if (len >= 2 && str.charAt(len - 1) == ch && str.charAt(len - 2) == ch) {
                continue;
            }
            str.append(ch);
        }
        return str.toString();
    }
}

