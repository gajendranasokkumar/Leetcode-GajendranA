class Solution {
    public long calculateScore(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<26;i++) 
            map.put((char) ('a'+i), new ArrayList<>());

        long score = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            char mirror = (char) ('z' - (cur - 'a'));

            if (map.get(mirror).size() != 0) {
                score += i - map.get(mirror).get(map.get(mirror).size()-1);
                map.get(mirror).remove(map.get(mirror).size()-1);
                continue;
            }
            
            map.get(cur).add(i);
        }

        return score;
    }
}
