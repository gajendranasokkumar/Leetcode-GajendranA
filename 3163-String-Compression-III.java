class Solution {
    public String compressedString(String word) {
        String result = "";
        for(int j=0;j<word.length();) {
            char c = word.charAt(j);
            int count = 0;
            while(j<word.length() && c == word.charAt(j)) {
                count++;
                j++;
            }
            if(count != 0) {
                int times = count / 9;
                int rem  = count % 9;
                while(times-- > 0) {
                    result += '9';
                    result += c;
                }
                
                if(rem != 0) {
                    result += (char)(rem + '0');
                    result += c;
                }
            }
        }
        // for(int i=0;i<26;i++) {
        //     char c = (char)(i + 97);
            // if(freq[i] != 0) {
            //     int times = freq[i] / 9;
            //     int rem  = freq[i] % 9;
            //     while(times-- > 0) {
            //         result += '9';
            //         result += c;
            //     }
                
            //     if(rem != 0) {
            //         result += (char)(rem + '0');
            //         result += c;
            //     }
            // }
        // }

        return result;
    }
}