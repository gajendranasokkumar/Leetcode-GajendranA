class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
            
        Map<Character, Integer> f = new HashMap<>();
        for(char i : t.toCharArray()) 
            f.put(i, f.getOrDefault(i, 0) + 1);
                
        Map<Character, Integer> map = new HashMap<>();
        int minlen = (int) 1e9, count = 0, total = f.size();
        int l = 0, r = 0;
        int start = 0, end = 0;

        while(r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            if(f.containsKey(c) && map.get(c).equals(f.get(c))) {
                count++;
            }

            while (count == total) {
                if ((r - l + 1) < minlen) {
                    minlen = r - l + 1;
                    start = l;
                    end = r;
                }
                char leftChar = s.charAt(l);
                if (f.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) < f.get(leftChar)) {
                        count--;
                    }
                }
                l++;
            }
            r++;
        }
    
        return minlen == (int) 1e9 ? "" : s.substring(start, end + 1);
    }
}