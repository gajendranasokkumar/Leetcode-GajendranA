class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharFreq = new int[26];
        int[] tempCharFreq = new int[26];

        for (String word : words2) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
                maxCharFreq[ch - 'a'] = Math.max(maxCharFreq[ch - 'a'], tempCharFreq[ch - 'a']);
            }
        }

        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            Arrays.fill(tempCharFreq, 0);
            for (char ch : word.toCharArray()) {
                tempCharFreq[ch - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (maxCharFreq[i] > tempCharFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }
}