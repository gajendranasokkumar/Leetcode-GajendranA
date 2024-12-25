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
        if(root == null)
            return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            Iterator<Node> iter = q.iterator();
            Node temp = iter.next();
            while(iter.hasNext()) {
                Node one = iter.next();
                temp.next = one;
                temp = temp.next;
            }
            while(n-- > 0) {
                Node k = q.poll();
                if(k.left != null)
                    q.add(k.left);
                if(k.right != null)
                    q.add(k.right);
            }
        }


        return root;
    }
}