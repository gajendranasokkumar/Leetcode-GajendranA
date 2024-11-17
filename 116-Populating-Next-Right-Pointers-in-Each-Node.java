/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            
            // Traverse nodes of the current level
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                
                // Connect the node to the next node in the queue (if not the last node)
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                }
                
                // Add the child nodes to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return root;  // Return the root node, now with next pointers connected
    }
}
