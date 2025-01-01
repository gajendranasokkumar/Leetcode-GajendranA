class WordDictionary {
    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.arr[index] == null) {
                temp.arr[index] = new Node();
            }
            temp = temp.arr[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int pos, Node node) {
        if (node == null)
            return false;
        if (pos == word.length())
            return node.isEnd;

        char c = word.charAt(pos);
        if (c == '.') {
            for (Node child : node.arr) {
                if (searchInNode(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            return searchInNode(word, pos + 1, node.arr[index]);
        }
    }
}

class Node {
    boolean isEnd;
    Node[] arr;

    Node() {
        isEnd = false;
        arr = new Node[26];
    }
}
