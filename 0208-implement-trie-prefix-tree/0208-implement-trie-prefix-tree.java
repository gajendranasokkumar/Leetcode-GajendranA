class Node {
    boolean isEnd;
    Node[] arr;
    Node() {
        isEnd = false;
        arr = new Node[26];
    }
    void makeEnd() {
        isEnd = true;
    }
}

class Trie {
    public Node root;
    public String prev = "";

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        int n = word.length();
        for(int i=0;i<n;i++) {
            char c = word.charAt(i);
            if(temp.arr[c-'a'] == null) {
                temp.arr[c-'a'] = new Node();
            }
            temp = temp.arr[c-'a']; 
            if(i == n-1) 
                temp.makeEnd();
        } 

        prev = word;
    }
    
    public boolean search(String word) {
        Node temp = root;
        int n = word.length();
        for(int i=0;i<n;i++) {
            char c = word.charAt(i);
            if(temp.arr[c-'a'] == null) {
                return false;
            }
            temp = temp.arr[c-'a']; 
            if(i == n-1 && !temp.isEnd)
                return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        int n = prefix.length();
        for(int i=0;i<n;i++) {
            char c = prefix.charAt(i);
            if(temp.arr[c-'a'] == null) {
                return false;
            }
            temp = temp.arr[c-'a']; 
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */





