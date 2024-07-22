class Solution {
    public String reverseWords(String s) {
        String[] a = s.split(\ \);
        String ss = \\;
        int i;
        for(i=a.length-1;i>=0;i--)
        {
            if(a[i].length() != 0 )
                ss += a[i] + \ \;
        }
        return ss.trim();
    }
}