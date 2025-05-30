/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        int ans = -1; // or any sentinel value indicating "not found"
        while (root != null) {
            if (root.data == k) {
                return root.data;
            } else if (root.data < k) {
                ans = root.data; // possible answer
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
}
