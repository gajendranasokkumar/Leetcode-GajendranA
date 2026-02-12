class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            Map<Character, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                char c = s.charAt(j);

                map.put(c, map.getOrDefault(c, 0) + 1);

                if (checkEquality(map)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public boolean checkEquality(Map<Character, Integer> map) {
        List<Integer> scoreList = new ArrayList<>(map.values());
        if(scoreList.size() == 0)
            return false;
        int first = scoreList.get(0);
        for(int value : scoreList) 
            if(value != first)
                return false;
        return true;
    }
}