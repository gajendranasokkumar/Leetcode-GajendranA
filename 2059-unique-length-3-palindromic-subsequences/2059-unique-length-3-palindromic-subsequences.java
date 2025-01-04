class Solution {
    public int countPalindromicSubsequence(String s) {
        int total = 0;
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if(firstIndex[ch] == - 1) {
                firstIndex[ch] = i;
            }
            lastIndex[ch] = i;
        }
        for(int i = 0; i < 26; i++) {
            if(firstIndex[i] == -1) continue;

            int start = firstIndex[i];
            int end = lastIndex[i];

            Set<Character> set = new HashSet<>();
            for(int j = start + 1; j < end; j++) {
                set.add(s.charAt(j));
            }
            total += set.size();
        }
        return total;
    }
}