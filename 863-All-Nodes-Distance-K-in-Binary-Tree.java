/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        queue.add(root);
        TreeNode targetNode = null;
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node.val == target.val)
                targetNode = node;
            if(node.left != null)
            {
                parent.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null)
            {
                parent.put(node.right, node);
                queue.add(node.right);
            }
        }
        if(targetNode == null)
            return list;
        queue.clear();
        queue.offer(targetNode);
        visited.add(targetNode);
        int distance = 0;
        while(!queue.isEmpty())
        {
            if (distance == k) {
                for (TreeNode node : queue) {
                    list.add(node.val);
                }
                return list;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.add(node.right);
                }
                if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    queue.add(parent.get(node));
                }
            }
            distance++;
        }
        return list;
    }
}