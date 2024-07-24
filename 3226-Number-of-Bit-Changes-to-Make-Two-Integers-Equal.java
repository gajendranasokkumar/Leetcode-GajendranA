class Solution {
    public int minChanges(int n, int k) {
        char[] s1 = Integer.toBinaryString(n).toCharArray();
        char[] s2 = Integer.toBinaryString(k).toCharArray();
        int len = 0, count = 0;
        int klen = s2.length-1, nlen = s1.length-1;
        while (klen >= 0) {
            if (nlen >= 0 && s1[nlen] == '1' && s2[klen] == '0') {
                count++;
            } else if (nlen >= 0 && s1[nlen] == '0' && s2[klen] == '1') {
                return -1;
            } else if (nlen < 0 && s2[klen] == '1') {
                return -1;
            }
            nlen--;
            klen--;
        }

        while(nlen >= 0)
        {
            if(s1[nlen] == '1')
                count++;
            nlen--;
        }
        return count;
    }
}