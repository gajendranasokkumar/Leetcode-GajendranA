class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if(p.length() > s.length()) return result;

        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char c : p.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c,0) + 1);
        }

        int matchCounter = charCountMap.size();

        int left = 0, right = 0;

        while(right < s.length()){
            char rightChar = s.charAt(right);

            if(charCountMap.containsKey(rightChar)){
                charCountMap.put(rightChar, charCountMap.get(rightChar) - 1);
                if(charCountMap.get(rightChar) == 0){
                    matchCounter--;
                }
            }
            right++;

            while(matchCounter == 0){
                char leftChar = s.charAt(left);

                if(right-left == p.length()){
                    result.add(left);
                }

                if(charCountMap.containsKey(leftChar)){
                    charCountMap.put(leftChar, charCountMap.get(leftChar) + 1);
                    if(charCountMap.get(leftChar) >0){
                        matchCounter++;
                    }
                }
                left++;
            }
        }
        return result;
    }
}