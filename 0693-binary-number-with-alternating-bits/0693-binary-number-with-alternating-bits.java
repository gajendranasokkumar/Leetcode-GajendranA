class Solution {
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        char prev = str.charAt(0);
        int len = str.length();
        if(len == 1)
            return true;
        for(int i=1;i<len;i++) {
            char cur = str.charAt(i);
            if(prev == cur)
                return false;
            prev = cur;
        }

        return true;
    }
}