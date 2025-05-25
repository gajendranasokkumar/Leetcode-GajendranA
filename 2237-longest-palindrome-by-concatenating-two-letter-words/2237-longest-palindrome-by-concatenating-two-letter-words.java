class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        boolean single = false;
        int count = 0;
        for(String s : words) {
            if(map.get(s) != 0) {
                map.put(s, map.get(s) - 1);
                String rev = rev(s);
                if(map.containsKey(rev) && map.get(rev) != 0) {
                    map.put(rev, map.get(rev) - 1);
                    count += 2;
                } else if(!single && isSame(s)) {
                    single = true;
                    count += 1;
                }
            }
        }
        return count * 2;
    }
    public String rev(String s) {
        return s.charAt(1)+""+s.charAt(0);
    }
    public boolean isSame(String s) {
        return s.charAt(0) == s.charAt(1);
    }
}