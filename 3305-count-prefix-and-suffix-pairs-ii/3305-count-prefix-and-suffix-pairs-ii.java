class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        Trie trie = new Trie();
        long result = 0;
        for (String word : words) {
            result += trie.getPrefixLength(word);
            trie.insert(word);
        }
        return result;
    }
}

class Node {
    boolean isEnd;
    int wordCount;
    Node[] arr;

    Node() {
        isEnd = false;
        wordCount = 0;
        arr = new Node[26];
    }

    void makeEnd() {
        isEnd = true;
        wordCount++;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.arr[index] == null) {
                current.arr[index] = new Node();
            }
            current = current.arr[index];
        }
        current.makeEnd();
    }

    public int getPrefixLength(String word) {
        Node current = root;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            sb.append(c);

            if (current.arr[index] == null) {
                break;
            }

            current = current.arr[index];
            if (current.isEnd && word.endsWith(sb.toString())) {
                count += current.wordCount;
            }
        }

        return count;
    }
}
