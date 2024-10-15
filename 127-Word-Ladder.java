class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        int count = 1;
        q.add(beginWord);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int k = 0; k < n; k++) {
                StringBuilder s = new StringBuilder(q.poll());
                int len = s.length();

                for (int i = 0; i < len; i++) {
                    char originalChar = s.charAt(i);
                    for (int j = 0; j < 26; j++) {
                        s.setCharAt(i, (char) (j + 'a'));
                        String str = s.toString();
                        if (str.equals(endWord)) {
                            return ++count;
                        }
                        if (set.contains(str)) {
                            set.remove(str);
                            q.add(str);
                        }
                    }
                    s.setCharAt(i, originalChar);
                }
            }
            count++;
        }

        return 0;
    }
}