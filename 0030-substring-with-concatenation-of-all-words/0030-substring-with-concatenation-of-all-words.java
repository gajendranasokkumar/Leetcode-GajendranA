class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int windowSize = wordLength * totalWords;
        
        if (s.length() < windowSize) {
            return result;
        }

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> currentFreq = new HashMap<>();
            int left = i;
            int count = 0;
            
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                
                if (wordFreq.containsKey(currentWord)) {
                    // Add to current frequency map
                    currentFreq.put(currentWord, currentFreq.getOrDefault(currentWord, 0) + 1);
                    count++;
                    
                    // Remove words from the left if we have too many
                    while (currentFreq.getOrDefault(currentWord, 0) > wordFreq.getOrDefault(currentWord, 0)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                    
                    // If we have found all words
                    if (count == totalWords) {
                        result.add(left);
                        // Remove leftmost word and continue
                        String leftWord = s.substring(left, left + wordLength);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        left += wordLength;
                        count--;
                    }
                } else {
                    // Reset if we encounter an invalid word
                    currentFreq.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }
        
        return result;
    }
}