class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1)
            return word;
        int n = word.length();
        boolean[] found = new boolean[26];
        for(char c : word.toCharArray())
            found[c - 'a'] = true;

        int idx = 0;
        for(int i=25;i>=0;i--) 
            if(found[i]) {
                idx = i;
                break;
            }
        
        int len = n - numFriends + 1;
        String prev = "", curr = "";
        for(int i=0;i<n;i++) {
            if(word.charAt(i) - 'a' == idx) {
                curr = word.substring(i, Math.min(n, i+len));
                if(curr.compareTo(prev) >= 1) {
                    prev = curr;
                }
            } 
        }
        return prev;
    }
}