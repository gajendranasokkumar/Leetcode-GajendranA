class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] unique = new int[n];
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            set.add(s.charAt(i));
            unique[i] = set.size();
        }

        Map<Character, int[]> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, new int[]{-1, -1});
        
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(map.get(c)[0] == -1)
                map.get(c)[0] = i;
            map.get(c)[1] = i;
        }

        int result = 0;

        for(Map.Entry<Character, int[]> entry : map.entrySet())  {
            int[] indices = entry.getValue();
            if(indices[1] - indices[0] >= 2) {
                Set<Character> between = new HashSet<>();
                for(int i = indices[0] + 1; i < indices[1]; i++) {
                    between.add(s.charAt(i));
                }
                result += between.size();
            }
        }

        return result;
    }
}
