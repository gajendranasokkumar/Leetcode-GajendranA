class Solution {
    public int compress(char[] chars) {
        int i=0, j=0;
        int n = chars.length;
        while(j < n) {
            int count = 1;
            char c = chars[j];
            while(++j < n && c == chars[j])
                count++;
            
            chars[i++] = c;
            if(count > 1)
                for(char num : Integer.toString(count).toCharArray())
                    chars[i++] = num; 
        }
        return i;
    }
}