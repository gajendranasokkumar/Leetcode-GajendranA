/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOddLevel = false;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOddLevel) {
                    nodes.add(node);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            if (isOddLevel) {
                int left = 0, right = nodes.size() - 1;
                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            
            isOddLevel = !isOddLevel;
        }
        
        return root;
    }
}
