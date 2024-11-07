/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.*;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return run(node, new HashMap<>());
    }

    public Node run(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(run(neighbor, visited));
        }

        return clone;
    }
}
