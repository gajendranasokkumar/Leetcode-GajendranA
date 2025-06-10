/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        return isDeadEndUtil(root, 1, Integer.MAX_VALUE);
    }

    private boolean isDeadEndUtil(Node node, int min, int max) {
        if (node == null) return false;

        // Dead end found
        if (min == max) return true;

        // Recurse for left and right subtrees
        return isDeadEndUtil(node.left, min, node.data - 1) ||
               isDeadEndUtil(node.right, node.data + 1, max);
    }
}
