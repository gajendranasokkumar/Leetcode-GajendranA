class Solution {
    public int minMutation(String beginWord, String endWord, String[] wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 0));
        
        Set<String> st = new HashSet<>(Arrays.asList(wordList));
        st.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return -1;
    }
}

class Pair {
    String first;
    int second;
    
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}