class Solution {
    public static Node root;
    public static List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        result = new ArrayList<>();

        for (String word : words) {
            insert(word);
        }

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (root.arr[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] board, int i, int j, Node temp) {
        char currentChar = board[i][j];

        if (currentChar == '#' || temp.arr[currentChar - 'a'] == null)
            return;

        temp = temp.arr[currentChar - 'a'];

        if (temp.isEnd) {
            result.add(temp.word);
            temp.isEnd = false; 
        }

        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, temp);
        if (j > 0) dfs(board, i, j - 1, temp);
        if (i < board.length - 1) dfs(board, i + 1, j, temp);
        if (j < board[0].length - 1) dfs(board, i, j + 1, temp);

        board[i][j] = currentChar;
    }

    public static void insert(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            if (temp.arr[c - 'a'] == null) {
                temp.arr[c - 'a'] = new Node();
            }
            temp = temp.arr[c - 'a'];
        }
        temp.isEnd = true;
        temp.word = word; 
    }
}

class Node {
    boolean isEnd;
    Node[] arr;
    String word;

    Node() {
        arr = new Node[26];
    }
}





